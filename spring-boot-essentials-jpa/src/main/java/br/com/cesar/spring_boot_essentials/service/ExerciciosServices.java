package br.com.cesar.spring_boot_essentials.service;


import br.com.cesar.spring_boot_essentials.database.model.ExerciciosEntity;
import br.com.cesar.spring_boot_essentials.database.repository.IExerciciosRepository;
import br.com.cesar.spring_boot_essentials.dto.ExerciciosDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciciosServices {
    private final IExerciciosRepository exerciciosRepository;

    public List<ExerciciosEntity> findAll(){
        return exerciciosRepository.findAll();
    }

    public void save(ExerciciosDto exerciciosDto) {
        ExerciciosEntity exercicio = ExerciciosEntity.builder()
                .nome(exerciciosDto.getNome())
                .grupoMuscular(exerciciosDto.getGrupoMuscular())
                .build();

        exerciciosRepository.save(exercicio);
    }

    public List<ExerciciosEntity> getExerciciosByGrupoMuscular(String grupoMuscular){
        return exerciciosRepository.findAllByGrupoMuscular(grupoMuscular);
    }

}

























