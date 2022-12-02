package br.senac.procuratio.modelo.dao.funcao;

import java.util.List;

import br.senac.procuratio.modelo.entidade.funcao.Funcao;

public interface FuncaoDAO {
	
	Funcao cadastrarFuncao(Funcao funcao, String cnpjEmpresa);
	
	void deletarFuncao(Funcao funcao);
	
	void editarFuncao(Funcao funcao);
	
	List<Funcao> recuperarFuncoes();


}
