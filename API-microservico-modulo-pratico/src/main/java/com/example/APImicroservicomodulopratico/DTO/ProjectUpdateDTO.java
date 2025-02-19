package com.example.APImicroservicomodulopratico.DTO;

import java.time.LocalDate;
import java.util.UUID;

import com.example.APImicroservicomodulopratico.Entities.Project;
import com.example.APImicroservicomodulopratico.Entities.User;
import com.example.APImicroservicomodulopratico.Enum.Flag;
import com.example.APImicroservicomodulopratico.Enum.Status;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectUpdateDTO {
    
    @Size(min = 3, max = 100)
    private String name;

    //Valida;ões a fazer: se for trocar o gerente, verificar se o novo tbm é GERENTE.
    private UUID project_manager;

    private Status status;

    private Flag flag;

    private LocalDate endDate;

    public Project toEntityUpdateProject(Project project, User manager){
        return Project.builder()
                .id(project.getId())
                .name(this.name)
                .manager(manager)
                .status(this.status)
                .flag(this.flag)
                .endDate(this.endDate)
                .build();
    }
}
