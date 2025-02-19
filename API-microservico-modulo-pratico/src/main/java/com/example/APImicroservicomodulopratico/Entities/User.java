package com.example.APImicroservicomodulopratico.Entities;

import java.util.UUID;

import com.example.APImicroservicomodulopratico.Enum.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private UUID id;

    @Column(name = "user_role", nullable = false)
    @Enumerated (EnumType.STRING)
    private Role role;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "user_registration_number", nullable = false)
    private String registrationNumber;

    @Column(name = "user_isActive", nullable = false)
    private Boolean isActive;

    @Column(name = "user_birth_date", nullable = false)
    private String birthDate;

}
