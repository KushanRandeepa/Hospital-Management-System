package edu.icet.service;

import edu.icet.dto.*;
import edu.icet.entity.UserEntity;
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

    public JwtResponse createUser(SignupRequest signupRequest) {

        UserEntity user = mapper.map(signupRequest, UserEntity.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (repository.existsByUsername(user.getUsername()))
            return new JwtResponse (null, "Username already taken!",null);
        if (repository.existsByEmail(user.getEmail()))
            return new JwtResponse (null, "email already taken!", null);



        Set<Role> roles = new HashSet<>();
        if (signupRequest.getRoles() == null || signupRequest.getRoles().isEmpty()) {
            roles.add(Role.ROLE_PATIENT); // default role
        } else {
            signupRequest.getRoles().forEach(roleStr -> {
                try {
                    roles.add(Role.valueOf("ROLE_"+roleStr.toUpperCase()));
                } catch (IllegalArgumentException e) {
                    // handle invalid role string or ignore
                }
            });
        }
        user.setRoles(roles);



        repository.save(user);
        return new JwtResponse (null, null, "Useesrname Registed Succs!");

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

            return new JwtResponse(token, null,"login Success");

        } catch (Exception e) {
            return new JwtResponse(null, "User not Found",null);
        }
    }
}
