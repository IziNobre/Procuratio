package br.senac.procuratio.modelo.entidade.pessoa.dependente;

import java.time.LocalDate;

import br.procuratio.modelo.entidade.pessoa.Pessoa;
import br.senac.procuratio.modelo.enumeracao.grauParentesco.GrauParentesco;

public class Dependente extends Pessoa {
	
	private  GrauParentesco grauParentesco;
	
	
	public Dependente (String nome, LocalDate dataNascimento, String cpf, Genero genero, GrauParentesco grauParentesco) {
		super (nome, dataNascimento, cpf, genero);
		this.grauParentesco = grauParentesco;
		
		
	}


	public GrauParentesco getGrauParenetesco() {
		return grauParentesco;
	}


	public void setGrauParenetesco(GrauParentesco grauParenetesco) {
		this.grauParentesco = grauParentesco;
	}
	
public boolean equals(Object objeto) {
		
		if(objeto == null)
			return false;
		
		if(this == objeto)
			return true;
		
		if(this.getClass() != objeto.getClass())
			return false;
		
		Dependente dependente = (Dependente) objeto;
			return this.getNome().equals(dependente.getNome()) && this.getDataNascimento().equals(dependente.getDataNascimento()) && this.getCpf().equals(empresa.getCpf()) && this.getGenero().equals(dependente.getGenero()) && this.getGrauParenetesco().equals(dependente.getGrauParenetesco());
	}

}