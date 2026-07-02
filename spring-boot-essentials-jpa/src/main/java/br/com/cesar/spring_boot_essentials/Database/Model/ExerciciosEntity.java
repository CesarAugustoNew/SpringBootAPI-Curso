package br.com.cesar.spring_boot_essentials.Database.Model;


import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "exercicios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExerciciosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;
    @Column(name = "grupo_muscular", nullable = false)
    private String grupoMuscular;
}
