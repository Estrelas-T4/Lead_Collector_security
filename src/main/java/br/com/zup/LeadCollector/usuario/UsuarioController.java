package br.com.zup.LeadCollector.usuario;

import br.com.zup.LeadCollector.config.security.UsuarioLogado;
import br.com.zup.LeadCollector.usuario.dtos.CadastroUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarUsuario(@RequestBody CadastroUsuarioDTO cadastroUsuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setEmail(cadastroUsuarioDTO.getEmail());
        usuario.setSenha(cadastroUsuarioDTO.getSenha());

        usuarioService.salvarUsuario(usuario);
    }

    @PutMapping()
    public void atualizarUsuario(@RequestBody CadastroUsuarioDTO cadastroUsuarioDTO, Authentication authentication){
        UsuarioLogado usuarioLogado = (UsuarioLogado) authentication.getPrincipal();

        Usuario usuario = new Usuario();
        usuario.setEmail(cadastroUsuarioDTO.getEmail());
        usuario.setSenha(cadastroUsuarioDTO.getSenha());

        usuarioService.atualizarUsuario(usuario, usuarioLogado.getId());
    }
}
