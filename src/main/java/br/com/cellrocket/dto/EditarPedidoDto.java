package br.com.cellrocket.dto;

public class EditarPedidoDto {
	
	private Long idConserto;
	private String status;
	private String descricao;
//	private String dataSaida;
	
	public Long getIdConserto() {
		return idConserto;
	}
	public void setIdConserto(Long idConserto) {
		this.idConserto = idConserto;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
//	public String getDataSaida() {
//		return dataSaida;
//	}
//	public void setDataSaida(String dataSaida) {
//		this.dataSaida = dataSaida;
//	}
}
