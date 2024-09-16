package aplicacao.login_registro.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    
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
