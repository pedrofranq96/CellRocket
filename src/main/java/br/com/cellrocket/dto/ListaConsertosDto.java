package br.com.cellrocket.dto;

import java.time.LocalDate;

public class ListaConsertosDto {

	private Long idConserto;
	private String descricaoConserto;
	private String status;
	private LocalDate dataEntrada;
	
	public Long getIdConserto() {
		return idConserto;
	}
	public void setIdConserto(Long idConserto) {
		this.idConserto = idConserto;
	}
	
	public String getDescricaoConserto() {
		return descricaoConserto;
	}
	public void setDescricaoConserto(String descricaoConserto) {
		this.descricaoConserto = descricaoConserto;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
}
