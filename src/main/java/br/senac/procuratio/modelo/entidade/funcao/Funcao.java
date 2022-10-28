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

    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (this == objeto)
            return true;
        if (this.getClass() != objeto.getClass())
            return false;
        Funcao funcao = (Funcao) objeto;
        return this.getNome().equals(funcao.getNome());
    }
}