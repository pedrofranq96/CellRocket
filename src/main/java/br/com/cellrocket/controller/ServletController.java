package br.com.cellrocket.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.cellrocket.interfaces.AcaoInterface;

//@WebServlet(name = "/controller")
public class ServletController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		
		System.out.println(paramAcao);
		
		String nomeDaClasse = "br.com.cellrocket.acao." + paramAcao;
		
		AcaoInterface acao = null;
		try {
			Class classe = Class.forName(nomeDaClasse);
			acao = (AcaoInterface)classe.newInstance();
		}catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String nome = acao.executa(request, response);
		
		String[] retorno = nome.split(":");
		
		if(retorno[0].equals("forward")) {
			System.out.println(retorno[1]);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/View/" + retorno[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(retorno[1]);
		}
	}
}
