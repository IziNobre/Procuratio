package br.senac.procuratio.modelo.dao.funcao;

import java.util.List;

import br.senac.procuratio.modelo.entidade.funcao.Funcao;

public interface FuncaoDAO {
	
	Funcao cadastrarFuncao(Funcao funcao);
	
	void deletarFuncao(Funcao funcao);
	
	void editarNomeFuncao(Funcao funcao, String novoNome);
	
	List<Funcao> recuperarFuncoes();


}
