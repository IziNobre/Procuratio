package br.senac.procuratio.modelo.dao.contato;

import java.util.List;

import br.senac.procuratio.modelo.entidade.contato.Contato;

public interface ContatoDAO {

	Contato cadastrarContato(Contato contato);
	
	void editarContato(Contato contato);
	
	void deletarContato(Contato contato);
	
	Contato recuperarContatoEmpresa(String cnpjEmpresa);
	
	Contato recuperarContatoEmpregado(String cpfEmpregado);
		
	List<Contato> recuperarContatosCadastrados();
		
}
