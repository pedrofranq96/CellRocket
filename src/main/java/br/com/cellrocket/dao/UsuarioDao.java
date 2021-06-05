package br.com.cellrocket.dao;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.cellrocket.model.Usuario;
import br.com.cellrocket.repository.UsuarioRepository;

public class UsuarioDao {
	
	@Autowired
	private UsuarioRepository repository;
	
	public void cadastrarUsuario(Usuario usuario) {
		repository.save(usuario);
	}
	
}
