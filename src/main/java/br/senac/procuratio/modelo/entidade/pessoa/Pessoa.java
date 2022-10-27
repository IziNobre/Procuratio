package br.senac.procuratio.modelo.entidade.pessoa;

import java.time.LocalDate;

import br.senac.procuratio.modelo.enumecao.Genero;

public class Pessoa {

	private String nome;
	private LocalDate dataNascimento;
	private String cpf;
	private Genero genero;

	public Pessoa(String nome, LocalDate dataNascimento, String cpf, Genero genero) {

		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.genero = genero;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public boolean equals(Object objeto) {

		if (objeto == null)
			return false;

		if (this == objeto)
			return true;

		if (this.getClass() != objeto.getClass())
			return false;

		Pessoa pessoa = (Pessoa) objeto;

		return this.getNome().equals(pessoa.getNome()) && this.getDataNascimento().equals(pessoa.getDataNascimento())
				&& this.getCpf().equals(pessoa.getCpf()) && this.getGenero().equals(pessoa.getGenero());
	}
}