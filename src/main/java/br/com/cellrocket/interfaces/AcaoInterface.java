package br.com.cellrocket.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AcaoInterface {
	
	String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
