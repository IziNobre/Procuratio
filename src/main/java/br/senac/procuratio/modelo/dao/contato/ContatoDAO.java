package br.senac.procuratio.modelo.dao.contato;

import java.util.List;

import br.senac.procuratio.modelo.entidade.contato.Contato;

public interface ContatoDAO {

	Contato cadastrarContato(Contato contato);
	
	void editarTelefoneContato(Contato contato, String novoTelefone);
	
	void editarCelularContato(Contato contato, String novoCelular);
	
	void editarEmailContato(Contato contato, String novoEmail);
		
	void deletarContato(Contato contato);
	
	Contato recuperarContatoEmpregado(String cpf_empregado);
		
	List<Contato> recuperarContatosCadastrados();
		
}
