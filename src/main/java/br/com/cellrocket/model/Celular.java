package br.com.cellrocket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Celular {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCelular;
	
	private String marca;
	
	private String modelo;
	
	private Long idUsuario;
	
	public Celular() {
	}

	public Celular(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}

	public Long getIdCelular() {
		return idCelular;
	}

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
}
