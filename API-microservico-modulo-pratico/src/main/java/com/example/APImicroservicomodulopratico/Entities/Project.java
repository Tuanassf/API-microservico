package com.example.APImicroservicomodulopratico.Entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.example.APImicroservicomodulopratico.Enum.Flag;
import com.example.APImicroservicomodulopratico.Enum.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id", nullable = false)
    private UUID id;

    @Column(name = "project_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "project_cost_center", nullable = false)
    private CostCenter costCenter;

    @ManyToOne
    @JoinColumn(name = "project_manager", nullable = false)
    private User manager;

    @Column(name = "project_start_date", nullable = false)
    private LocalDate starDate;

    @Column(name = "project_end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "project_status", nullable = false)
    @Enumerated (EnumType.STRING)
    private Status status;

    @Column(name = "project_flag", nullable = false)
    @Enumerated (EnumType.STRING)
    private Flag flag;

    @OneToMany(mappedBy = "project")
    private List<User> users;

    @OneToMany(mappedBy = "project")
    private List<CostCenter> costCenters;
    
}
