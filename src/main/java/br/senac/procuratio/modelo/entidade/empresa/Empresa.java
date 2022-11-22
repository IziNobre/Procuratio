package br.senac.procuratio.modelo.entidade.empresa;

import java.util.ArrayList;
import java.util.List;

import br.senac.procuratio.modelo.entidade.contato.Contato;
import br.senac.procuratio.modelo.entidade.endereco.Endereco;
import br.senac.procuratio.modelo.entidade.pessoa.empregado.Empregado;

public class Empresa {

	private String nome;
	private String cnpj;
	private String senhaLogin;
	private Endereco endereco;
	private Contato contato;
	private List<Empregado> empregados;
	
	public Empresa(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}
	public Empresa(String nome, String cnpj, String senhaLogin) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.senhaLogin = senhaLogin;
	}
	public Empresa(String nome, String cnpj, Endereco endereco, Contato contato) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.contato = contato; 
		empregados = new ArrayList <Empregado>();
	}
	public Empresa(String nome, String cnpj,  String senhaLogin, Endereco endereco, Contato contato) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.senhaLogin = senhaLogin;
		this.endereco = endereco;
		this.contato = contato; 
		empregados = new ArrayList <Empregado>();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public String getSenhaLogin() {
		return senhaLogin;
	}
	public void setSenhaLogin(String senhaLogin) {
		this.senhaLogin = senhaLogin;
	}
	public List<Empregado> getEmpregados() {
		return empregados;
	}
	public boolean adicionarEmpregado(Empregado empregado) {
		return empregados.add(empregado);
	}
	public boolean removerEmpregado(Empregado empregado) {
		return empregados.remove(empregado);
	}
	public boolean equals(Object objeto) {
		if(objeto == null)
			return false;
		
		if(this == objeto)
			return true;
		
		if(this.getClass() != objeto.getClass())
			return false;
		
		Empresa empresa = (Empresa) objeto;
		return this.getNome().equals(empresa.getNome()) && this.getEndereco().equals(empresa.getEndereco()) 
				&& this.getCnpj().equals(empresa.getCnpj()) && this.getContato().equals(empresa.getContato()) && 
				this.getSenhaLogin().equals(empresa.getSenhaLogin()) && this.getEmpregados().equals(empresa.getEmpregados());
			
	}
}
