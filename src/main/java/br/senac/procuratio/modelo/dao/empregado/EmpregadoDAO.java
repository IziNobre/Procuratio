package br.senac.procuratio.modelo.dao.empregado;

import java.time.LocalDate;
import java.util.List;

import br.senac.procuratio.modelo.entidade.contato.Contato;
import br.senac.procuratio.modelo.entidade.empresa.Empresa;
import br.senac.procuratio.modelo.entidade.endereco.Endereco;
import br.senac.procuratio.modelo.entidade.funcao.Funcao;
import br.senac.procuratio.modelo.entidade.pessoa.dependente.Dependente;
import br.senac.procuratio.modelo.entidade.pessoa.empregado.Empregado;
import br.senac.procuratio.modelo.enumeracao.contrato.Contrato;
import br.senac.procuratio.modelo.enumeracao.escolaridade.Escolaridade;
import br.senac.procuratio.modelo.enumeracao.genero.Genero;

public interface EmpregadoDAO {

	Empregado cadastrarEmpregado(Empregado empregado);

	void deletarEmpregado(Empregado empregado);
 
 	void atualizarNomeEmpregado(Empregado emregado, String novoNome);
	
	void atualizarDataNascimentoEmpregado(Empregado empregado, LocalDate novaDataNascimento);

	void atualizarCpfEmpregado(Empregado empregado, String novoCpf);

	void atualizarGeneroEmpregado(Empregado empregado, Genero novoGenero);
	
	void atualizarEmpresaEmpregado(Empregado empregado, String cnpj_empresa);

	void atualizarPisEmpregado(Empregado empregado, String novoPis);
	
	void atualizarCtpsEmpregado(Empregado empregado, String novoCtps);
	
	void atualizarEnderecoEmpregado(Empregado empregado, Long id_endereco);
	
	void atualizarContatoEmpregado(Empregado empregado, Long id_contato);
	
	void atualizarEscolaridadeEmpregado(Empregado empregado, Escolaridade novaEscolaridade);
	
	void atualizarNomeMaeEmpregado(Empregado empregado, String novoNomeMae);	
		
	void atualizarDataAdmissaoEmpregado(Empregado empregado, LocalDate novaDataAdmissao);
	
	void atualizarTerminoContratoExperienciaEmpregado(Empregado empregado, LocalDate novoTerminoContratoExperiencia);
	
	void atualizarTipoContratoEmpregado(Empregado empregado, Contrato novoTipoContrato);
	
	void atualizarFuncaoEmpregado(Empregado empregado, Long id_Funcao);
	
	void atualizarSalarioEmpregado(Empregado empregado, float novoSalario);
	
	void atualizarDependenteEmpregado(Empregado empregado, Dependente novoDependente);	

	Empregado recuperarEmpregado(String Cpf);
	
	List<Empregado> recuperarEmpregadosAdmitidosOrdenadosPorNome();	

	List<Empregado> recuperarEmpregadosOrdenadosDataAdmissaoPorMesEAno(short mes, short ano);
	
	List<Empregado> recuperarEmpregadosOrdenadosDataAdmissaoPorAno(short ano);
		
	List<Empregado> recuperarEmpregadosOrdenadosFuncao(Long id_Funcao);
		
			
}
