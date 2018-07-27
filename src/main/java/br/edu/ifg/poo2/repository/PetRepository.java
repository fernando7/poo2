package br.edu.ifg.poo2.repository;

import br.edu.ifg.poo2.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByNomeContainingOrDescricaoContaining(String nome, String descricao);
}
