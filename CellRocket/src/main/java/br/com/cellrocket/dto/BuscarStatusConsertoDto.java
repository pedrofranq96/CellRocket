package br.com.cellrocket.dto;

import java.util.ArrayList;
import java.util.List;
import br.com.cellrocket.model.Celular;
import br.com.cellrocket.model.ConsertoCelular;
import br.com.cellrocket.model.Usuario;

public class BuscarStatusConsertoDto {

	private Usuario usuario;
	
	private List<Celular> celulares = new ArrayList<Celular>();
	
	private List<ConsertoCelular> consertos = new ArrayList<ConsertoCelular>();
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Celular> getCelulares() {
		return celulares;
	}

	public void setCelulares(Celular celular) {
		this.celulares.add(celular);
	}

	public List<ConsertoCelular> getConsertos() {
		return consertos;
	}

	public void setConsertosCelulares(List<ConsertoCelular> consertosCelulares) {
		this.consertos = consertosCelulares;
	}	
}
