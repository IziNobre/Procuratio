package br.senac.procuratio.modelo.dao.endereco;

import br.senac.procuratio.modelo.entidade.endereco.Endereco;

public interface EnderecoDAO {
	
	Endereco cadastrarEndereco(Endereco endereco);
	
	void editarLogradouroEndereco(Endereco endereco, String novoLogradouro);
	
	void editarNumeroEndereco(Endereco endereco, short novoNumero);
	
	void editarComplementoEndereco(Endereco endereco, String novoComplemento);
	
	void editarBairroEndereco(Endereco endereco, String novoBairro);
	
	void editarCidadeEndereco(Endereco endereco, String novaCidade);
	
	void editarUfEndereco(Endereco endereco, String novaUf);
	
	void editarCepEndereco(Endereco endereco, String novoCep);
	
	void deletarEndereco(Endereco endereco);
	
	Endereco recuperarEnderecosEmpregado(String cpf_empregado);
	
}
