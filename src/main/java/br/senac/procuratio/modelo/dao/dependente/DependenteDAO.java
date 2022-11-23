package br.senac.procuratio.modelo.dao.dependente;

import java.time.LocalDate;
import java.util.List;

import br.senac.procuratio.modelo.entidade.pessoa.dependente.Dependente;
import br.senac.procuratio.modelo.enumeracao.genero.Genero;
import br.senac.procuratio.modelo.enumeracao.parentesco.Parentesco;

public interface DependenteDAO {
	
	void cadastrarDependente(Dependente dependente, String cpfEmpregado);
	
	void deletarDependente(Dependente dependente);
	
	void editarNomeDependente(Dependente dependente, String novoNome);
	
	void editarDataNascimento(Dependente dependente, LocalDate novaDataNascimento);
	
	void editarCpf(Dependente dependente, String novoCpf);
	
	void editarGenero(Dependente dependente, Genero novoGenero);
	
	void editarParentesco(Dependente dependente, Parentesco novoParentesco);
	
	List<Dependente> recuperarDependentesEmpregado(String cpf_empregado);
	

}
