package aplicacao.login_registro.services;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import aplicacao.login_registro.dto.LoginRequestDTO;
import aplicacao.login_registro.dto.RegistrarRequestDTO;
import aplicacao.login_registro.dto.ResponseDTO;
import aplicacao.login_registro.infra.security.TokenService;
import aplicacao.login_registro.model.Endereco;
import aplicacao.login_registro.model.Usuario;
import aplicacao.login_registro.repository.EnderecoRepo;
import aplicacao.login_registro.repository.UsuarioRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UsuarioRepo usuarioRepo;
    private final EnderecoRepo enderecoRepo;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public ResponseDTO login(LoginRequestDTO loginRequestDTO){
        Usuario usuario = usuarioRepo.findByEmail(loginRequestDTO.email()).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

        if (!passwordEncoder.matches(loginRequestDTO.senha(), usuario.getSenha())){
            throw new RuntimeException("Credencias invalidas");
        }

        String token = tokenService.generateToken(usuario);
        return new ResponseDTO(usuario.getNome(), token);
    }

    @Transactional
    public ResponseDTO criarUsuario(RegistrarRequestDTO registrarRequestDTO) {
        if (usuarioRepo.findByEmail(registrarRequestDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Usuario duplicado");
        }

        Usuario novoUsuario = new Usuario();
        Endereco endereco = modelMapper.map(registrarRequestDTO.getEndereco(), Endereco.class);
        enderecoRepo.save(endereco);

        novoUsuario.setNome(registrarRequestDTO.getNome());
        novoUsuario.setEmail(registrarRequestDTO.getEmail());
        novoUsuario.setCpf(registrarRequestDTO.getCpf());
        novoUsuario.setTelefone(registrarRequestDTO.getTelefone());
        novoUsuario.setSenha(passwordEncoder.encode(registrarRequestDTO.getSenha()));
        novoUsuario.setDataNascimento(registrarRequestDTO.getDataNascimento());
        novoUsuario.setSexo(registrarRequestDTO.getSexo());
        
        novoUsuario.setIdioma(registrarRequestDTO.getIdioma());
        novoUsuario.setDataCriacao(LocalDateTime.now());
        novoUsuario.setEndereco(endereco);
        usuarioRepo.save(novoUsuario);

        String token = tokenService.generateToken(novoUsuario);
        return new ResponseDTO(registrarRequestDTO.getNome(), token);
    }
}
