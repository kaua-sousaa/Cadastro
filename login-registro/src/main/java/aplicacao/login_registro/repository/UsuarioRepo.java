package aplicacao.login_registro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aplicacao.login_registro.model.Usuario;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByEmail(String email);

}