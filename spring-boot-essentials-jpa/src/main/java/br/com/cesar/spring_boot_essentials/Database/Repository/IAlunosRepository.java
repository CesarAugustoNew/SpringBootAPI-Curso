package br.com.cesar.spring_boot_essentials.Database.Repository;

import br.com.cesar.spring_boot_essentials.Database.Model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAlunosRepository extends JpaRepository<AlunosEntity, Integer> {

    Optional<AlunosEntity> findByEmail(String email);
}
