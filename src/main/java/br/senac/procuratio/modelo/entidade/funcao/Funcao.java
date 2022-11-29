package br.senac.procuratio.modelo.entidade.funcao;

public class Funcao {

	private Long id;
	private String nome;
	private String cnpjEmpresa;

	public Funcao(Long id) {
		this.id = id;
	}
	public Funcao(String nome) {
	        
	    this.nome = nome;
	}
	
	public Funcao(String nome, String cnpjEmpresa) {
	        
	    this.nome = nome;
	    this.cnpjEmpresa = cnpjEmpresa;
	
	}
    public Funcao(Long id, String nome, String cnpjEmpresa) {
        
    	this.id = id;
    	this.nome = nome;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
	public String getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
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
        
        return this.getId() == funcao.getId() && this.getNome().equals(funcao.getNome()) && funcao.getCnpjEmpresa().equals(funcao.getCnpjEmpresa());
    }
	


}
