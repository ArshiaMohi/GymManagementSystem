package com.arshia.gymmanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 20)
    @NotBlank
    private String name;
    private Integer durationInDays;
    private BigDecimal price;
    private String description;
    @OneToMany(mappedBy = "plan")
    @Builder.Default
    private List<Membership> memberships = new ArrayList<>();
}
