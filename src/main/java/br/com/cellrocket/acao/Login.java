package br.com.cellrocket.acao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cellrocket.dao.UsuarioDao;
import br.com.cellrocket.interfaces.AcaoInterface;

public class Login implements AcaoInterface {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		UsuarioDao usuarioDao = new UsuarioDao();
		var usuario = usuarioDao.validarUsuario(login, senha);
		
		if(usuario != null) {
			return "forward:bem-vindo.jsp";
		}else {
			return "redirect:entrada?acao=LoginForm";
		}
	}

}
