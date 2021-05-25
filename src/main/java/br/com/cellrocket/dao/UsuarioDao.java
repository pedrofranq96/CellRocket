package br.com.cellrocket.dao;

import java.util.ArrayList;
import java.util.List;
import br.com.cellrocket.model.Usuario;

public class UsuarioDao {
	
	private static List<Usuario> usuarios = new ArrayList<>();
	
	static {
		Usuario usuario = new Usuario();
		usuario.setLogin("admin");
		usuario.setSenha("123");
		
		usuarios.add(usuario);
	}
	
	public void cadastrarUsuario(Usuario usuario) {
		System.out.println("Cadastrar no dao");
		usuarios.add(usuario);
	}
	
	public Usuario validarUsuario(String login, String senha) {
		for(Usuario usuario : usuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		
		return null;
	}
}
