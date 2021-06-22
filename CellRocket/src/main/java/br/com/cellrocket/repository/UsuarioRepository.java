package br.com.cellrocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cellrocket.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByCpf(String cpf);
}
