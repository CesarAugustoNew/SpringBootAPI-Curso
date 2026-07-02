package br.com.cesar.spring_boot_essentials.Database.Repository;

import br.com.cesar.spring_boot_essentials.Database.Model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITreinosRepository extends JpaRepository<TreinosEntity, Integer> {
}
