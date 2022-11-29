package br.senac.procuratio.modelo.dao.empresa;

import java.util.List;
import br.senac.procuratio.modelo.entidade.empresa.Empresa;

public interface EmpresaDAO {

	Empresa cadastrarEmpresa(Empresa empresa);

	void deletarEmpresa(Empresa empresa);
	
	List<Empresa> recuperarEmpresas();
	
	void editarEmpresa(Empresa empresa);
	
	boolean verificarLoginSenha(String cnpj, String senha);

	Empresa recuperarEmpresa(String cnpj);

}