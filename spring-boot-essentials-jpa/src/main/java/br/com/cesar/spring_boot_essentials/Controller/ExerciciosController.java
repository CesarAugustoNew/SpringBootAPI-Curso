package br.com.cesar.spring_boot_essentials.Controller;

import br.com.cesar.spring_boot_essentials.Database.Model.ExerciciosEntity;
import br.com.cesar.spring_boot_essentials.Dto.ExerciciosDto;
import br.com.cesar.spring_boot_essentials.Service.ExerciciosServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/exercicios")
@RequiredArgsConstructor
@Validated
public class ExerciciosController {

    private final ExerciciosServices exerciciosServices;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciciosEntity> findAll(){
        return exerciciosServices.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveExercicios(@Valid @RequestBody ExerciciosDto exerciciosDto){
        exerciciosServices.save(exerciciosDto);
    }

    @GetMapping("/grupos/{grupoMuscular}")
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciciosEntity> getExerciciosByGrupoMuscular(@PathVariable String grupoMuscular){
        return  exerciciosServices.getExerciciosByGrupoMuscular(grupoMuscular);
    }

}

