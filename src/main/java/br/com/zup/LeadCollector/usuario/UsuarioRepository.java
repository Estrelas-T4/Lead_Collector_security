package br.com.zup.LeadCollector.usuario;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends CrudRepository<Usuario, UUID> {

    Optional<Usuario> findByEmail(String email);

}
