package br.senac.procuratio.modelo.entidade.pessoa.dependente;

import java.time.LocalDate;

import br.senac.procuratio.modelo.entidade.pessoa.Pessoa;
import br.senac.procuratio.modelo.enumecao.Genero;
import br.senac.procuratio.modelo.enumeracao.grauParentesco.GrauParentesco;

public class Dependente extends Pessoa {
	
	private  GrauParentesco grauParentesco;
	
	
	public Dependente (String nome, LocalDate dataNascimento, String cpf, Genero genero, GrauParentesco grauParentesco) {
		super (nome, dataNascimento, cpf, genero);
		this.setGrauParentesco(grauParentesco);
		
		
	}


	public GrauParentesco getGrauParentesco() {
		return grauParentesco;
	}


	public void setGrauParenetesco(GrauParentesco grauParentesco) {
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
			return this.getNome().equals(dependente.getNome()) && this.getDataNascimento().equals(dependente.getDataNascimento()) && this.getCpf().equals(dependente.getCpf()) && this.getGenero().equals(dependente.getGenero()) && this.getGrauParentesco().equals(dependente.getGrauParentesco());
	}

}