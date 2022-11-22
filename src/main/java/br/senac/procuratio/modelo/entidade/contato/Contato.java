package br.senac.procuratio.modelo.entidade.contato;

public class Contato {

	private Long id;
	private String telefone;
	private String celular;
	private String email;

	public Contato(Long id) {

		this.id = id;
		
	}
	public Contato(String telefone, String celular, String email) {
		
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
	}

	public Contato(Long id, String telefone, String celular, String email) {

		this.id = id;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
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

		return this.getId() == contato.getId() && this.getTelefone().equals(contato.getTelefone())
				&& this.getCelular().equals(contato.getCelular())
				&& this.getEmail().equals(contato.getEmail());
	}

}
