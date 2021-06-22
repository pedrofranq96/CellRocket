package br.com.cellrocket.dto;

import java.util.List;
import javax.validation.constraints.NotBlank;
import br.com.cellrocket.model.Celular;

public class NovoPedidoDto {
	
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cpf;
	
	private List<Celular> celulares;
	
	private Long idCelular;
	
	private String modelo;
	
	private String marca;
	
	@NotBlank
	private String descricao;
	
	@NotBlank
	private String valor;
		
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
	
	public List<Celular> getCelulares() {
		return celulares;
	}
	public void setCelulares(List<Celular> celulares) {
		this.celulares = celulares;
	}
	
	public Long getIdCelular() {
		return idCelular;
	}
	public void setIdCelular(Long idCelular) {
		this.idCelular = idCelular;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
}
