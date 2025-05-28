package edu.icet.controller;


import edu.icet.dto.JwtResponse;
import edu.icet.dto.LoginRequest;
import edu.icet.dto.SignupRequest;

import edu.icet.security.JwtUtils;
import edu.icet.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {
    final AuthService authService;
    final JwtUtils jwtUtils;

    @PostMapping("/signup")
    public ResponseEntity<JwtResponse> createUser(@RequestBody SignupRequest signupRequest ){
        JwtResponse response = authService.createUser(signupRequest);
        if (response.getError()!=null) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(response);
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest){
        JwtResponse response = authService.login(loginRequest);
        if (response.getError()!=null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/done")
    public String done(){
        return "done";
    }
}