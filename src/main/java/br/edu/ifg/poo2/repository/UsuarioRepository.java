package br.edu.ifg.poo2.repository;

import br.edu.ifg.poo2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    Usuario findByEmailAndSenha(String email, String senha);
}
