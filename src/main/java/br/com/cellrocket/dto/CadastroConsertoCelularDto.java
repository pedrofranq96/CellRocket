package br.com.cellrocket.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import br.com.cellrocket.enums.Status;
import br.com.cellrocket.model.ConsertoCelular;

public class CadastroConsertoCelularDto {
	
	private String descricaoConserto;
	
	private BigDecimal valor;
	
	private Long idCelular;

	public String getDescricaoConserto() {
		return descricaoConserto;
	}

	public void setDescricaoConserto(String descricaoConserto) {
		this.descricaoConserto = descricaoConserto;
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

	public ConsertoCelular toConsertoCelular() {
		ConsertoCelular consertoCelular = new ConsertoCelular();
		consertoCelular.setDescricaoConserto(descricaoConserto);
		consertoCelular.setValor(valor);
		consertoCelular.setDataEntrada(LocalDate.now());
		consertoCelular.setStatus(Status.AGUARDANDO);
		consertoCelular.setIdCelular(idCelular);
		return consertoCelular;
	}
}
