package br.com.cellrocket.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import br.com.cellrocket.enums.Status;

@Entity
public class ConsertoCelular {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConserto;
	
	private String descricaoConserto;
	
	private LocalDate dataSaida;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private BigDecimal valor;
	
	private Long idCelular;
	
	private LocalDate dataEntrada = LocalDate.now();
	
	public ConsertoCelular() {
	}

	public Long getIdConserto() {
		return idConserto;
	}

	public String getDescricaoConserto() {
		return descricaoConserto;
	}

	public void setDescricaoConserto(String descricaoConserto) {
		this.descricaoConserto = descricaoConserto;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Long getIdCelular() {
		return idCelular;
	}

	public void setIdCelular(Long idCelular) {
		this.idCelular = idCelular;
	}
}
