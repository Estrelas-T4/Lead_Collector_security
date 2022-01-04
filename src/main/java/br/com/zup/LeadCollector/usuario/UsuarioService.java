package br.com.zup.LeadCollector.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public Usuario salvarUsuario(Usuario usuario){
        String senhaEscondida = encoder.encode(usuario.getSenha());

        usuario.setSenha(senhaEscondida);
        return usuarioRepository.save(usuario);
    }

}
