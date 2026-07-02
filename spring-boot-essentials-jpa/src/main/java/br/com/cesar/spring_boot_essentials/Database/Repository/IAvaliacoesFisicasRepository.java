package br.com.cesar.spring_boot_essentials.Database.Repository;

import br.com.cesar.spring_boot_essentials.Database.Model.AvaliacoesFisicasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAvaliacoesFisicasRepository extends JpaRepository<AvaliacoesFisicasEntity, Integer> {
}
