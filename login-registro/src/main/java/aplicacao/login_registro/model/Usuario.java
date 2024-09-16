package aplicacao.login_registro.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;  
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String cpf;
    private String telefone;
    private String senha;
    private LocalDate dataNascimento;
    private String sexo;
    private String idioma;
    private LocalDateTime dataCriacao;

     @OneToOne
    private Endereco endereco;

}
