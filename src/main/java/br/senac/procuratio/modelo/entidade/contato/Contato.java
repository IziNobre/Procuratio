package br.senac.procuratio.modelo.entidade.contato;

public class Contato {
	private String telefoneResidencial;
	private String telefoneCelular;
	private String email;

	public Contato(String telefoneResidencial, String telefoneCelular, String email) {
		this.telefoneResidencial = telefoneResidencial;
		this.telefoneCelular = telefoneCelular;
		this.email = email;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public boolean equals(Object objeto) {
		if (objeto == null)
			return false;
		if (this == objeto)
			return true;
		if (this.getClass() != objeto.getClass())
			return false;
		
		Contato contato = (Contato) objeto;
		
		return this.getTelefoneResidencial().equals(contato.getTelefoneResidencial()) && this.getTelefoneCelular().equals(contato.getTelefoneCelular()) && this.getEmail().equals(contato.getEmail());
	}
}