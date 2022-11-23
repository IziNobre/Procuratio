package br.senac.procuratio.modelo.entidade.pessoa.dependente;

import java.time.LocalDate;

import br.senac.procuratio.modelo.entidade.pessoa.Pessoa;
import br.senac.procuratio.modelo.enumeracao.genero.Genero;
import br.senac.procuratio.modelo.enumeracao.parentesco.Parentesco;

public class Dependente extends Pessoa {

	
	private Parentesco parentesco;

	public Dependente(String nome, Parentesco parentesco) {
		super(nome);
		this.parentesco = parentesco;
		
	}
	public Dependente(String nome, LocalDate dataNascimento, String cpf, Genero genero, Parentesco Parentesco) {
		super(nome, dataNascimento, cpf, genero);
		this.parentesco = parentesco;
	}

	public Parentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}

	public boolean equals(Object objeto) {
		
		if(objeto == null)
			return false;
		
		if(this == objeto)
			return true;
		
		if(this.getClass() != objeto.getClass())
			return false;

		Dependente dependente = (Dependente) objeto;
		
		return this.getNome().equals(dependente.getNome()) && this.getDataNascimento().equals(dependente.getDataNascimento()) 
				&& this.getCpf().equals(dependente.getCpf()) && this.getGenero().equals(dependente.getGenero()) 
				&& this.getParentesco().equals(dependente.getParentesco());
	}

}
