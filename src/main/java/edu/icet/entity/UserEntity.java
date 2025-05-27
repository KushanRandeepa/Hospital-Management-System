package edu.icet.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.management.relation.Role;
import java.util.Set;

@Data
@Entity

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //    private String email;
    private String password;

//    @ElementCollection(fetch = FetchType.EAGER)
//    @Enumerated(EnumType.STRING)
//    private Set<Role> roles;
}
