package br.senac.procuratio.modelo.entidade.funcao;

public class Funcao {
	
    private String nome;

    public Funcao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Funcao funcao = (Funcao) obj;
        return this.getNome().equals(funcao.getNome());
    }
}