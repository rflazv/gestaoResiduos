package br.com.fiap.gestao_residuos.repository;

import br.com.fiap.gestao_residuos.model.Bin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BinRepository extends JpaRepository<Bin, Long> {
}
