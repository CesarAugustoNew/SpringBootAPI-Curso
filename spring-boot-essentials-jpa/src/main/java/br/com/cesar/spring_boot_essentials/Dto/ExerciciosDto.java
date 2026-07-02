package br.com.cesar.spring_boot_essentials.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ExerciciosDto {
    @NotBlank
    private String nome;
    @NotBlank
    private String grupoMuscular;

}
