package aplicacao.login_registro.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicacao.login_registro.dto.UsuarioDTO;
import aplicacao.login_registro.model.Endereco;
import aplicacao.login_registro.model.Usuario;
import aplicacao.login_registro.repository.EnderecoRepo;
import aplicacao.login_registro.repository.UsuarioRepo;

@Service
public class CadastroService {
    
    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private EnderecoRepo enderecoRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Usuario criarUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        Endereco endereco = modelMapper.map(usuarioDTO.getEndereco(), Endereco.class);
        enderecoRepo.save(endereco);

        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setTelefone(usuarioDTO.getTelefone());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setDataNascimento(usuarioDTO.getDataNascimento());
        usuario.setSexo(usuarioDTO.getSexo());
        usuario.setIdioma(usuarioDTO.getIdioma());
        usuario.setDataCriacao(usuarioDTO.getDataCriacao());
        usuario.setEndereco(endereco);

        usuarioRepo.save(usuario);
        return usuario;
    }
}
