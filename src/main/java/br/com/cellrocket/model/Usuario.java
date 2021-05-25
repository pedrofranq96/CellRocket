package br.com.cellrocket.model;

public class Usuario {
	
	private String login;
	
	private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean ehIgual(String login, String senha) {
		if(!this.getLogin().equals(login)) {
			return false;
		}
		
		if(!this.getSenha().equals(senha)) {
			return false;
		}
		
		return true;
	}
}
