package aplicacao.login_registro.infra.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import aplicacao.login_registro.model.Usuario;
import aplicacao.login_registro.repository.UsuarioRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService{
    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));

        return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getSenha(), new ArrayList<>());
    }
    
}
