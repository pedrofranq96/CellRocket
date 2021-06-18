package br.com.cellrocket.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	private String nome;
	private String cpf;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Celular> celulares = new ArrayList<Celular>();
	
	public Usuario() {
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Celular> getCelulares() {
		return celulares;
	}

	public void setCelulares(List<Celular> celulares) {
		this.celulares = celulares;
	}
}