package br.com.cellrocket.dto;

import br.com.cellrocket.model.Celular;

public class CadastroCelularDto {

	private String marca;
	
	private String modelo;
	
	private Long idUsuario;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public Celular toCelular() {
		Celular celular = new Celular();
		celular.setMarca(marca);
		celular.setModelo(modelo);
		celular.setIdUsuario(idUsuario);
		return celular;
	}
}
