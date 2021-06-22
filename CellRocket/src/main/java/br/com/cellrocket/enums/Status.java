package br.com.cellrocket.enums;

public enum Status {
	
	AGUARDANDO("Aguardando"), CONSERTANDO("Consertando"), FINALIZADO("Finalizado"), ENTREGUE("Entregue");
	
	private String valor;
	
	Status(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}
