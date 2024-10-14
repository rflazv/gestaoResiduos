package br.com.fiap.gestao_residuos.repository;

import br.com.fiap.gestao_residuos.model.CollectionSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionScheduleRepository extends JpaRepository<CollectionSchedule, Long> {
}
