package br.com.cellrocket.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "celular")
public class Celular {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCelular;
	
	private String marca;
	
	private String modelo;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Usuario usuario;
	
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
