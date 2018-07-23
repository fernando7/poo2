package br.edu.ifg.poo2.repository;

import br.edu.ifg.poo2.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findByNomeContainingOrDescricaoContaining(String nome, String descricao);
}
