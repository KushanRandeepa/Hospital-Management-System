package edu.icet.controller;

import edu.icet.entity.UserEntity;
import edu.icet.security.JwtUtils;
import edu.icet.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class AuthController {
    final AuthService authService;
    final JwtUtils jwtUtils;

    @PostMapping("/signup")
    public void createUser(@RequestBody UserEntity userEntity){
          authService.createUser(userEntity);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserEntity userEntity){
        authService.createUser(userEntity);
        return jwtUtils.generateToken(userEntity.getUsername());
    }
    @GetMapping("/done")
    public String done(){
        return "done";
    }
}
