package br.senac.procuratio.modelo.dao.funcao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.senac.procuratio.modelo.entidade.funcao.Funcao;

public class FuncaoDAOImpl implements FuncaoDAO {

	public Funcao cadastrarFuncao(Funcao funcao, String cnpjEmpresa) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO funcao (nome_funcao, cnpj_empresa) VALUES (?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
	
			insert.setString(1, funcao.getNome());

			insert.execute();
			
			ResultSet chavePrimaria = insert.getGeneratedKeys();

			if (chavePrimaria.next())
				funcao.setId(chavePrimaria.getLong(1));

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

		return funcao;
	}

	public void deletarFuncao(Funcao funcao) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM funcao WHERE nome_funcao = ?");

			delete.setString(1, funcao.getNome());

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

	public void editarNomeFuncao(Funcao funcao, String novoNome) {
		Long teste = funcao.getId();
		System.out.println(teste);

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE funcao SET nome_funcao = ? WHERE nome_funcao = ?");

			update.setString(1, novoNome);
			update.setString(2, funcao.getNome());
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

	public List<Funcao> recuperarFuncoes() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Funcao> funcoes = new ArrayList<Funcao>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM funcao ORDER BY nome_funcao ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_funcao");

				funcoes.add(new Funcao(nome));
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

		return funcoes;
	}
	
	public List<Funcao> recuperarFuncaoPesquisandoNome(String nome) {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Funcao> funcoes = new ArrayList<Funcao>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM funcao WHERE nome_funcao = ? ORDER BY nome_funcao ASC");

			while (resultado.next()) {

				String nome1 = resultado.getString("nome_funcao");

				funcoes.add(new Funcao(nome1));
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

		return funcoes;
	}

	private Connection conectarBanco() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block e.printStackTrace();
	}

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/procuratio?user=root&password=root");

	}
}
