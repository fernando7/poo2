package br.edu.ifg.poo2.dao;

import br.edu.ifg.poo2.model.Raca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RacaRepository extends JpaRepository<Raca, Long> {
}
