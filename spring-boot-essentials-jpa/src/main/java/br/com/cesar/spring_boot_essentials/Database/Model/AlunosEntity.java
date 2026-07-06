package br.com.cesar.spring_boot_essentials.Database.Model;


import jakarta.persistence.*;
import lombok.*;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "alunos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AlunosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "avaliacao_fisica_id")
    private AvaliacoesFisicasEntity avaliacoesFisicas;

    @OneToMany(mappedBy = "aluno")
    private Set<TreinosEntity> treinos = new HashSet<>();
}
