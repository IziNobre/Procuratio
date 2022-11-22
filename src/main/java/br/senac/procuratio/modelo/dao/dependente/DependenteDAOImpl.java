package br.senac.procuratio.modelo.dao.dependente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.senac.procuratio.modelo.entidade.pessoa.dependente.Dependente;
import br.senac.procuratio.modelo.enumeracao.genero.Genero;
import br.senac.procuratio.modelo.enumeracao.grauParentesco.GrauParentesco;

public class DependenteDAOImpl implements DependenteDAO {

	public void cadastrarDependente(Dependente dependente, String cpfEmpregado) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO pessoa (nome_pessoa, data_nascimento_pessoa, cpf_pessoa, genero_pessoa) VALUES (?,?,?,?)");

			insert.setString(1, dependente.getNome());
			insert.setString(2, dependente.getDataNascimento().toString());
			insert.setString(3, dependente.getCpf());
			insert.setInt(4, dependente.getGenero().ordinal()+1);
			insert.execute();
			
			insert = conexao.prepareStatement("INSERT INTO dependente (cpf_dependente, grau_parentesco_dependente) VALUES (?,?)");
			insert.setString(1, dependente.getCpf());
			insert.setInt(2, dependente.getGrauParentesco().ordinal()+1);

			insert.execute();
			
			insert = conexao.prepareStatement("INSERT INTO empregado_tem_dependente (cpf_empregado, cpf_dependente) VALUES (?,?)");
			insert.setString(1, cpfEmpregado);
			insert.setString(2, dependente.getCpf());
			
			insert.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (insert != null)
					insert.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
		/*return dependente;
	**/}

	public List<Dependente> recuperarDependentesEmpregado(String cpfEmpregado) {
		

		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		
		List<Dependente> dependentes = new ArrayList<Dependente>();

		try {

			conexao = conectarBanco();
			consulta = conexao.prepareStatement("SELECT nome_pessoa, data_nascimento_pessoa, cpf_pessoa, genero_pessoa, grau_parentesco_dependente, cpf_empregado FROM pessoa p join dependente d on p.cpf_pessoa = d.cpf_dependente join empregado_tem_dependente etd on d.cpf_dependente = etd.cpf_dependente where cpf_empregado = ?");

			consulta.setString(1, cpfEmpregado);
            resultado = consulta.executeQuery();
            		
				while (resultado.next()) {

				String nome = resultado.getString("nome_pessoa");
				LocalDate dataNascimento = LocalDate.parse(resultado.getString("data_nascimento_pessoa"));
				String cpf = resultado.getString("cpf_pessoa");
				Genero genero = Genero.valueOf(resultado.getString("genero_pessoa"));
				GrauParentesco grauParentesco = GrauParentesco.valueOf(resultado.getString("grau_parentesco_dependente"));
				
				 dependentes.add(new Dependente(nome, dataNascimento, cpf, genero, grauParentesco));
			}

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (resultado != null)
					resultado.close();

				if (consulta != null)
					consulta.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}

		return dependentes;
	}

	public void deletarDependente(Dependente dependente) {
		
		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM dependente WHERE cpf_dependente = ?");
			delete.setString(1, dependente.getCpf());
			delete.execute();
			
			delete = conexao.prepareStatement("DELETE FROM pessoa WHERE cpf_pessoa = ?");
			delete.setString(1, dependente.getCpf());
			delete.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (delete != null)
					delete.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
	}

	public void editarNomeDependente(Dependente dependente, String novoNome) {
		
		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE pessoa SET nome_pessoa = ? WHERE cpf_pessoa = ?");
			
			update.setString(1, novoNome);
			update.setString(2, dependente.getCpf());

			update.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
	}
	
	public void editarDataNascimento(Dependente dependente, LocalDate novaDataNascimento) {
		
		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE pessoa SET data_nascimento_pessoa = ? WHERE cpf_pessoa = ?");
			
			update.setString(1, novaDataNascimento.toString());
			update.setString(2, dependente.getCpf());

			update.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
	}
	
	public void editarCpf(Dependente dependente, String novoCpf) {
		
		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE pessoa SET cpf_pessoa = ? WHERE cpf_pessoa = ?");
			
			update.setString(1, novoCpf);
			update.setString(2, dependente.getCpf());

			update.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
	}
	
	public void editarGenero(Dependente dependente, Genero novoGenero) {
		
		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE pessoa SET genero_pessoa = ? WHERE cpf_pessoa = ?");
			
			update.setInt(1, novoGenero.ordinal()+1);
			update.setString(2, dependente.getCpf());

			update.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
	}
	
	public void editarGrauParentesco(Dependente dependente, GrauParentesco novoGrauParentesco) {
		
		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE dependente SET grau_parentesco_dependente = ? WHERE cpf_dependente = ?");
			
			update.setInt(1, novoGrauParentesco.ordinal()+1);
			update.setString(2, dependente.getCpf());

			update.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
	}
	
	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/procuratio?user=root&password=root");
	}
}
	