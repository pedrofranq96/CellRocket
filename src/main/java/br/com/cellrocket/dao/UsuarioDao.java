package br.com.cellrocket.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import br.com.cellrocket.model.Usuario;
import br.com.cellrocket.repository.UsuarioRepository;

@Repository
public class UsuarioDao {
	
	@Autowired
	private UsuarioRepository repository;
	
	public void cadastrarUsuario(Usuario usuario) {
		repository.save(usuario);
	}
	
	public Usuario buscarUsuarioCpf(String cpf) {
		Usuario usuario = repository.findByCpf(cpf);
		if(usuario != null) {
			return usuario;
		}
		return null;
	}
}
