package br.com.cellrocket.dto;

import java.util.ArrayList;
import java.util.List;

public class ListaCelularesDto {
	
	private String marca;
	private String modelo;
	private List<ListaConsertosDto> consertos = new ArrayList<ListaConsertosDto>();
	
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
	
	public List<ListaConsertosDto> getConsertos() {
		return consertos;
	}
	public void setConsertos(List<ListaConsertosDto> consertos) {
		this.consertos = consertos;
	}

}