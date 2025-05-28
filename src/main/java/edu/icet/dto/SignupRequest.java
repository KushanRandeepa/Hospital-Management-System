package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

    private String username;
    private String email;
    private String password;
    private Set<String> roles;
}
//{
//        "username":"p1",
//        "email":"d@",
//        "password":"24",
//        "role":"PATIENT"
//        }