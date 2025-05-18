package edu.icet.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Patient {
    private Integer id;
    private String name;
    private String nic;
    private String address;
    private String bloodGroup;
    private String category;
    private String gender;
    private String age;
    private String contact;
    private String note;
    private String allergies;
    private String email;
}
