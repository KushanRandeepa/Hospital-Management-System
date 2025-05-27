package edu.icet.service;

import edu.icet.dto.SignupRequest;
import edu.icet.entity.UserEntity;
import edu.icet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    final PasswordEncoder passwordEncoder;
    final UserRepository repository;

    public void  createUser(UserEntity user){
        repository.save( new UserEntity(user.getUsername(),passwordEncoder.encode(user.getPassword())));
    }
}
