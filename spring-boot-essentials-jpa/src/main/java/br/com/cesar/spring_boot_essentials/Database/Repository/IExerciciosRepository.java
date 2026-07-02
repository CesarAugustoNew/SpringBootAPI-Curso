package br.com.cesar.spring_boot_essentials.Database.Repository;

import br.com.cesar.spring_boot_essentials.Database.Model.ExerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IExerciciosRepository extends JpaRepository<ExerciciosEntity, Integer> {

    List<ExerciciosEntity> findAllByGrupoMuscular(String grupoMuscular);
}
