package br.com.cellrocket.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cellrocket.dao.UsuarioDao;
import br.com.cellrocket.interfaces.AcaoInterface;
import br.com.cellrocket.model.Usuario;

public class CadastrarLogin implements AcaoInterface {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Acao cadastrar login");
		
		UsuarioDao usuarioDao = new UsuarioDao();
		
		Usuario usuario = new Usuario();
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		
		usuarioDao.cadastrarUsuario(usuario);
		
		return "forward:formLogin.jsp";
	}	
}
