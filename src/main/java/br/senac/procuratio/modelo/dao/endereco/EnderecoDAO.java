package br.senac.procuratio.modelo.dao.endereco;

import br.senac.procuratio.modelo.entidade.endereco.Endereco;

public interface EnderecoDAO {
	
	Endereco cadastrarEndereco(Endereco endereco);
	
	void editarEndereco(Endereco endereco);
	
	void deletarEndereco(Endereco endereco);
	
	Endereco recuperarEnderecoEmpresa(String cnpjEmpresa);
	
	Endereco recuperarEnderecoEmpregado(String cpfEmpregado);
	
}
