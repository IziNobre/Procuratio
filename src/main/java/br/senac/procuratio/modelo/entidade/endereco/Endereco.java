package br.senac.procuratio.modelo.entidade.endereco;

public class Endereco {
	
	private Long id;
	private String logradouro;
	private short numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;	
	private String cep;
	
	
	public Endereco(Long id) {
		
		this.id = id;
	}	
	
	public Endereco (String logradouro, short numero, String complemento, String bairro, String cidade, String uf, String cep) {

		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
				
	}
	
	public Endereco (Long id, String logradouro, short numero, String complemento, String bairro, String cidade, String uf, String cep) {

		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;		
		this.cep = cep;
	}

	public Endereco(String logradouro) {
		this.logradouro = logradouro;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro () {
		return logradouro;
	}
	public void setLogradouro (String logradouro) {
		this.logradouro = logradouro;
	}
	public short getNumero() {
		return numero;
	}
	public void setNumero (short numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento (String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro (String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade (String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep (String cep) {
		this.cep = cep;
	}
	public String getUf() {
		return uf;
	}
	public void setUf (String uf) {
		this.uf = uf;
	}
	public boolean equals (Object objeto) {

		if (objeto == null)
			return false;

		if (this == objeto)
			return true;

		if (this.getClass() != objeto.getClass())
			return false;

		Endereco endereco = (Endereco) objeto;

		return this.getId() == endereco.getId() && this.getLogradouro().equals(endereco.getLogradouro()) 
				&& this.getNumero() == endereco.getNumero() && this.getComplemento().equals (endereco.getComplemento()) && this.getBairro().equals (endereco.getBairro()) && this.getCep().equals (endereco.getCep()) && this.getCidade().equals (endereco.getCidade()) && this.getUf().equals (endereco.getUf()); 

	}

}
