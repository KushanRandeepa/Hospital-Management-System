package edu.icet.controller;

import edu.icet.dto.JwtResponse;
import edu.icet.dto.LoginRequest;
import edu.icet.dto.SignupRequest;
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
    public String createUser(@RequestBody SignupRequest signupRequest ){
       return authService.createUser(signupRequest);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest loginRequest){
        return  authService.login(loginRequest);
    }

    @GetMapping("/done")
    public String done(){
        return "done";
    }
}
//{
//        "username":"randeepa",
//        "password":"24",
//        "email":"kr@gmail.com"
//        }