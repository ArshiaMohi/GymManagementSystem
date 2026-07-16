package com.arshia.gymmanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 20)
    @NotBlank
    private String firstName;
    @Size(max = 20)
    @NotBlank
    private String lastName;
    @Column(unique = true)
    private String phoneNumber;
    private String specialty;
}
