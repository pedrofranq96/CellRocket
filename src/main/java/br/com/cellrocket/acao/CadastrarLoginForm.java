package br.com.cellrocket.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cellrocket.interfaces.AcaoInterface;

public class CadastrarLoginForm implements AcaoInterface {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "forward:formCadastroLogin.jsp";
	}

}
