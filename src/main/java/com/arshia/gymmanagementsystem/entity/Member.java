package com.arshia.gymmanagementsystem.entity;

import com.arshia.gymmanagementsystem.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
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
    @Column(unique = true)
    @Size(min = 10, max = 10)
    private String nationalCode;
    private LocalDate birthDate;
    @CreationTimestamp
    private LocalDateTime joinDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
    @OneToMany(mappedBy = "member")
    @Builder.Default
    private List<Membership> memberships = new ArrayList<>();

}
