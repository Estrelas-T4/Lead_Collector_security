package br.com.zup.LeadCollector.config.security;

import br.com.zup.LeadCollector.usuario.Usuario;
import br.com.zup.LeadCollector.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioLoginService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);

        usuarioOptional.orElseThrow(() ->  new UsernameNotFoundException("Email ou Senha Incorreto"));
        Usuario usuario = usuarioOptional.get();

        return new UsuarioLogado(usuario.getId(), usuario.getEmail(), usuario.getSenha());
    }
}
