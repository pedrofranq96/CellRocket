package br.com.cellrocket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Funcionario {
	
	@JsonIgnoreProperties(ignoreUnknown = false)
	
    @JsonProperty("idFuncionario")
	private Long idFuncionario;
	
    @JsonProperty("nome")
	private String nome;
	
    @JsonProperty("sobrenome")
	private String sobrenome;
    
    @JsonProperty("cargo")
	private String cargo;

    @JsonProperty("idFuncionario")
	public Long getIdFuncionario() {
		return idFuncionario;
	}

    @JsonProperty("idFuncionario")
	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

    @JsonProperty("nome")
	public String getNome() {
		return nome;
	}

    @JsonProperty("nome")
	public void setNome(String nome) {
		this.nome = nome;
	}

    @JsonProperty("sobrenome")
	public String getSobrenome() {
		return sobrenome;
	}

    @JsonProperty("sobrenome")
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
    
    @JsonProperty("cargo")
	public String getCargo() {
		return cargo;
	}

    @JsonProperty("cargo")
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
