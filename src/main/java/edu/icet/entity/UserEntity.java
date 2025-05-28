package edu.icet.entity;

import edu.icet.dto.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();
}
