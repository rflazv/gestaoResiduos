package br.com.fiap.gestao_residuos.repository;

import br.com.fiap.gestao_residuos.model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckRepository extends JpaRepository<Truck, Long> {
}
