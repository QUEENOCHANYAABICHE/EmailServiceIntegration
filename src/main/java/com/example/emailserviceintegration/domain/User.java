package com.example.emailserviceintegration.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.)
    private Long id;

    private String name;

    private String email;

    private String password;

    private boolean isEnabled;

}
