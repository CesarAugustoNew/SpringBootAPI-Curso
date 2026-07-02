package br.com.cesar.spring_boot_essentials.Service;


import br.com.cesar.spring_boot_essentials.Database.Model.ExerciciosEntity;
import br.com.cesar.spring_boot_essentials.Database.Repository.IExerciciosRepository;
import br.com.cesar.spring_boot_essentials.Dto.ExerciciosDto;
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

























