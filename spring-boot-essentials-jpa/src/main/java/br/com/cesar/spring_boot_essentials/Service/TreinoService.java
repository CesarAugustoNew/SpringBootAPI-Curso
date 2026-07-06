package br.com.cesar.spring_boot_essentials.Service;


import br.com.cesar.spring_boot_essentials.Database.Model.AlunosEntity;
import br.com.cesar.spring_boot_essentials.Database.Model.ExerciciosEntity;
import br.com.cesar.spring_boot_essentials.Database.Model.TreinosEntity;
import br.com.cesar.spring_boot_essentials.Database.Repository.IAlunosRepository;
import br.com.cesar.spring_boot_essentials.Database.Repository.IExerciciosRepository;
import br.com.cesar.spring_boot_essentials.Database.Repository.ITreinosRepository;
import br.com.cesar.spring_boot_essentials.Dto.TreinoDto;
import br.com.cesar.spring_boot_essentials.Exception.BadRequestException;
import br.com.cesar.spring_boot_essentials.Exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TreinoService {
    private final IAlunosRepository alunosRepository;
    private final IExerciciosRepository exerciciosRepository;
    private final ITreinosRepository treinosRepository;

    public  void criarTreino(TreinoDto treinoDto) throws NotFoundException {

        Set<ExerciciosEntity> exercicios = new HashSet<>();

        AlunosEntity aluno = alunosRepository.findById(treinoDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        TreinosEntity treino = treinosRepository.findByNomeAndAlunoId(treinoDto.getNome(), treinoDto.getAlunoId())
                .orElse(null);

        if (treino != null){
            throw new BadRequestException("Já existe um treino com esse nome para esse aluno");
        }

        for (Integer exercicioId : treinoDto.getExerciciosId()) {
            ExerciciosEntity exercicio = exerciciosRepository.findById(exercicioId)
                    .orElseThrow(() -> new NotFoundException ("Exercicio não encontrado"));

            exercicios.add(exercicio);

        }

        treino = TreinosEntity.builder()
                .nome(treinoDto.getNome())
                .aluno(aluno)
                .exercicios(exercicios)
                .build();

        treinosRepository.save(treino);

    }



}


