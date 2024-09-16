package aplicacao.login_registro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aplicacao.login_registro.model.Endereco;

public interface EnderecoRepo extends JpaRepository<Endereco, Long>{
    
}
