package br.senac.procuratio.modelo.dao.empresa;

import java.util.List;

import br.senac.procuratio.modelo.entidade.contato.Contato;
import br.senac.procuratio.modelo.entidade.empresa.Empresa;
import br.senac.procuratio.modelo.entidade.endereco.Endereco;

public interface EmpresaDAO {

	Empresa cadastrarEmpresa(Empresa empresa);

	void deletarEmpresa(Empresa empresa);
	
	void atualizarNomeEmpresa(Empresa empresa, String novoNome);
	
	void atualizarEnderecoEmpresa(Empresa empresa, Long id_enderecoo);

	void atualizarCnpjEmpresa(Empresa empresa, String novoCnpj);

	void atualizarContatoEmpresa(Empresa empresa, Long id_contato);
	
	boolean autenticarLogin (String cnpj, String senha_login);

	List<Empresa> recuperarEmpresas();

}