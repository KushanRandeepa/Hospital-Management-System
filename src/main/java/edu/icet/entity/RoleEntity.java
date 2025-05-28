package edu.icet.entity;

import edu.icet.dto.Role;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Enumerated(EnumType.STRING)
        private Role name;
    }


