package edu.icet.service;

import edu.icet.dto.*;
import edu.icet.entity.PatientEntity;
import edu.icet.entity.UserEntity;
import edu.icet.repository.PatientRepository;
import edu.icet.repository.UserRepository;
import edu.icet.security.JwtUtils;
import edu.icet.security.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class AuthService {
    final ModelMapper mapper;
    final PasswordEncoder passwordEncoder;
    final UserRepository repository;
    final AuthenticationManager authenticationManager;
    final UserDetailsServiceImpl userDetailsService;
    final JwtUtils jwtUtils;
    final PatientRepository patientRepository;

    public JwtResponse createUser(SignupRequest signupRequest) {

        UserEntity user = mapper.map(signupRequest, UserEntity.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (repository.existsByUsername(user.getUsername()))
            return new JwtResponse(null, "Username already taken!", null);
        if (repository.existsByEmail(user.getEmail()))
            return new JwtResponse(null, "email already taken!", null);


        Set<Role> roles = new HashSet<>();
        if (signupRequest.getRole() == null || signupRequest.getRole().isEmpty()) {
            roles.add(Role.ROLE_PATIENT); // default role if none provided
        } else {
            try {
                roles.add(Role.valueOf("ROLE_" + signupRequest.getRole().toUpperCase()));
            } catch (IllegalArgumentException e) {
                return new JwtResponse(null, "Invalid role provided!", null);
            }
        }
        user.setRoles(roles);

        Role role = roles.iterator().next(); // since you allow only one role
        String prefix = getPrefixByRole(role); // PT, AD, etc.
        Integer count = repository.countByRolesContaining(role); // count existing users of this role
        String generatedId = String.format("%s%03d", prefix, count + 1);
        user.setCustomId(generatedId);

        if (prefix.equals("PT")) {
            PatientEntity patient = new PatientEntity();
            patient.setId(generatedId);
            patientRepository.save(patient);
        }
        repository.save(user);
        return new JwtResponse(null, null, "Useesrname Registed Succs!");

    }

    private String getPrefixByRole(Role role) {
        switch (role) {
            case ROLE_PATIENT:
                return "PT";
            case ROLE_ADMIN:
                return "AD";
            case ROLE_DOCTOR:
                return "DR";
            case ROLE_NURSE:
                return "NR";
            default:
                return "XX";
        }
    }

    public JwtResponse login(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            UserDetails userDetails =
                    new org.springframework.security.core.userdetails.User(
                            loginRequest.getUsername(), "",
                            userDetailsService.loadUserByUsername(loginRequest.getUsername()).getAuthorities());

            String token = jwtUtils.generateToken(userDetails);

            return new JwtResponse(token, null, "login Success");

        } catch (Exception e) {
            return new JwtResponse(null, "User not Found", null);
        }
    }
}
