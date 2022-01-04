package br.com.zup.LeadCollector.usuario;

import br.com.zup.LeadCollector.usuario.dtos.CadastroUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

}
