package aplicacao.login_registro.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrarRequestDTO {
    
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String senha;
    private LocalDate dataNascimento;
    private String sexo;
    private String idioma;
    private LocalDateTime dataCriacao;
    private EnderecoDTO endereco;
}
