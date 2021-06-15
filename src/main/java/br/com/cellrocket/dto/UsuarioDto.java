package br.com.cellrocket.dto;

import java.util.ArrayList;
import java.util.List;
import br.com.cellrocket.model.Celular;

public class UsuarioDto {
	
	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	private List<Celular> celulares = new ArrayList<Celular>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Celular> getCelulares() {
		return celulares;
	}
	public void setCelulares(List<Celular> celulares) {
		this.celulares = celulares;
	}
}
