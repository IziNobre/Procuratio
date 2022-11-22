package br.senac.procuratio.modelo.entidade.pessoa.empregado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.senac.procuratio.modelo.entidade.contato.Contato;
import br.senac.procuratio.modelo.entidade.empresa.Empresa;
import br.senac.procuratio.modelo.entidade.endereco.Endereco;
import br.senac.procuratio.modelo.entidade.funcao.Funcao;
import br.senac.procuratio.modelo.entidade.pessoa.Pessoa;
import br.senac.procuratio.modelo.entidade.pessoa.dependente.Dependente;
import br.senac.procuratio.modelo.enumeracao.contrato.Contrato;
import br.senac.procuratio.modelo.enumeracao.escolaridade.Escolaridade;
import br.senac.procuratio.modelo.enumeracao.genero.Genero;

public class Empregado extends Pessoa {

	private Empresa empresa;
	private String pis;
	private String ctps;
	private Endereco endereco;
	private Contato contato;
	private Escolaridade escolaridade;
	private String nomeMae;	
	private LocalDate dataAdmissao;
	private LocalDate terminoContratoExperiencia;
	private Contrato tipoContrato;
	private Funcao funcao;
	private float salario;
	private List<Dependente> dependentes;


	public Empregado(String nome, String cpf, Funcao funcao, LocalDate dataAdmissao) {
		super (nome, cpf);
		this.funcao = funcao;
		this.dataAdmissao = dataAdmissao;		
		dependentes = new ArrayList<Dependente>();
	}
	public Empregado(String nome, LocalDate dataNascimento, String cpf, Genero genero, String pis, String ctps, Endereco endereco, Contato contato, Escolaridade escolaridade, String nomeMae, LocalDate dataAdmissao, LocalDate terminoContratoExperiencia, Contrato tipoContrato, Funcao funcao, float salario) {
		
		super(nome, dataNascimento, cpf, genero);
		this.pis = pis;
		this.ctps = ctps;
		this.endereco = endereco;
		this.contato = contato;
		this.escolaridade = escolaridade;
		this.nomeMae = nomeMae;		
		this.dataAdmissao = dataAdmissao;
		this.terminoContratoExperiencia = terminoContratoExperiencia;
		this.tipoContrato = tipoContrato;
		this.funcao = funcao;
		this.salario = salario;
		dependentes = new ArrayList<Dependente>();
	}
	public Empregado(String nome, LocalDate dataNascimento, String cpf, Genero genero, Empresa empresa, String pis, String ctps, Endereco endereco, Contato contato, Escolaridade escolaridade, String nomeMae, LocalDate dataAdmissao, LocalDate terminoContratoExperiencia, Contrato tipoContrato, Funcao funcao, float salario) {
		
		super(nome, dataNascimento, cpf, genero);
		this.empresa = empresa;
		this.pis = pis;
		this.ctps = ctps;
		this.endereco = endereco;
		this.contato = contato;
		this.escolaridade = escolaridade;
		this.nomeMae = nomeMae;		
		this.dataAdmissao = dataAdmissao;
		this.terminoContratoExperiencia = terminoContratoExperiencia;
		this.tipoContrato = tipoContrato;
		this.funcao = funcao;
		this.salario = salario;
		dependentes = new ArrayList<Dependente>();
	}

	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public String getPis() {
		return pis;
	}
	public void setPis(String pis) {
		this.pis = pis;
	}
	public String getCtps() {
		return ctps;
	}
	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public Escolaridade getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}	
	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public LocalDate getTerminoContratoExperiencia() {
		return terminoContratoExperiencia;
	}
	public void setTerminoContratoExperiencia(LocalDate terminoContratoExperiencia) {
		this.terminoContratoExperiencia = terminoContratoExperiencia;
	}
	public Contrato getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(Contrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public Funcao getFuncao() {
		return funcao;
	}
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public List<Dependente> getDependentes() {
		return dependentes;
	}
	public boolean equals(Object objeto) {
		if (objeto == null)
			return false;
		
		if (this == objeto)
			return true;
		
		if (this.getClass() != objeto.getClass())
			return false;

		Empregado empregado = (Empregado) objeto;

		return this.getNome().equals(empregado.getNome()) && this.getDataNascimento().equals(empregado.getDataNascimento()) 
				&& this.getCpf().equals(empregado.getCpf()) && this.getGenero().equals(empregado.getGenero())
				&& this.getEmpresa().equals(empregado.getEmpresa()) && this.getPis().equals(empregado.getPis()) 
				&& this.getCtps().equals(empregado.getCtps()) && this.getEndereco().equals(empregado.getEndereco()) 
				&& this.getContato().equals(empregado.getContato()) && this.getEscolaridade().equals(empregado.getEscolaridade()) 
				&& this.getNomeMae().equals(empregado.getNomeMae()) && this.getDataAdmissao().equals(empregado.getDataAdmissao()) 
				&& this.getTerminoContratoExperiencia().equals(empregado.getTerminoContratoExperiencia())
				&& this.getTipoContrato().equals(empregado.getTipoContrato()) && this.getFuncao().equals(empregado.getFuncao()) 
				&& this.getSalario() == empregado.getSalario() && this.getDependentes().equals(empregado.getDependentes());
	}
}
