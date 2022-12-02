package br.senac.procuratio.modelo.dao.endereco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.senac.procuratio.modelo.entidade.endereco.Endereco;

public class EnderecoDAOImpl implements EnderecoDAO{
	
	public Endereco cadastrarEndereco(Endereco endereco) {
		Connection conexao = null;
		PreparedStatement insert = null;
		
		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO endereco (logradouro_endereco, numero_endereco, complemento_endereco, bairro_endereco, cidade_endereco, uf_endereco, cep_endereco) VALUES (?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

			insert.setString(1, endereco.getLogradouro());
			insert.setShort(2, endereco.getNumero());
			insert.setString(3, endereco.getComplemento());
			insert.setString(4, endereco.getBairro());
			insert.setString(5, endereco.getCidade());
			insert.setString(6, endereco.getUf());
			insert.setString(7, endereco.getCep());

			insert.execute();
			
			ResultSet chavePrimaria = insert.getGeneratedKeys();

			if (chavePrimaria.next())
				endereco.setId(chavePrimaria.getLong(1));

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
		return endereco;
	}
			
	
	public void editarEndereco(Endereco endereco) {
		
		 Connection conexao = null;
	     PreparedStatement update = null;
	     
	     try {
	         conexao = conectarBanco();
	         update = conexao.prepareStatement("UPDATE endereco SET logradouro_endereco = ?, numero_endereco = ?, complemento_endereco = ?, bairro_endereco = ?, cidade_endereco = ?, uf_endereco = ?, cep_endereco = ? WHERE id_endereco = ?");
	         update.setString(1, endereco.getLogradouro());
	         update.setShort(2, endereco.getNumero());
	         update.setString(3, endereco.getComplemento());
	         update.setString(4, endereco.getBairro());
	         update.setString(5, endereco.getCidade());
	         update.setString(6, endereco.getUf());
	         update.setString(7, endereco.getCep());
	         update.setLong(8, endereco.getId());
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

	public void deletarEndereco(Endereco endereco) {
		
		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM endereco WHERE id_endereco = ?");

			delete.setLong(1, endereco.getId());

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
	
	public Endereco recuperarEnderecoEmpresa(String cnpjEmpresa) {
		
		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Endereco endereco = null;

		try {

			conexao = conectarBanco();
			consulta = conexao.prepareStatement("SELECT d.id_endereco, logradouro_endereco, numero_endereco, complemento_endereco, bairro_endereco, cidade_endereco, uf_endereco, cep_endereco FROM endereco d join empresa e on d.id_endereco = e.id_endereco where cnpj_empresa = ?");

			consulta.setString(1, cnpjEmpresa);
            resultado = consulta.executeQuery();
            		
				while (resultado.next()) {

				long id = resultado.getLong("id_endereco");
				String logradouro = resultado.getString("logradouro_endereco");
				short numero = resultado.getShort("numero_endereco");
				String complemento = resultado.getString("complemento_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String uf = resultado.getString("uf_endereco");
				String cep = resultado.getString("cep_endereco");
				
				 endereco = new Endereco(id, logradouro, numero, complemento, bairro, cidade, uf, cep);
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
		return endereco;
	}
	
	public Endereco recuperarEnderecoEmpregado(String cpfEmpregado) {
		
		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Endereco endereco = null;

		try {

			conexao = conectarBanco();
			consulta = conexao.prepareStatement("SELECT d.id_endereco, logradouro_endereco, numero_endereco, complemento_endereco, bairro_endereco, cidade_endereco, uf_endereco, cep_endereco FROM endereco d join empregado e on d.id_endereco = e.id_endereco where cpf_empregado = ?");

			consulta.setString(1, cpfEmpregado);
            resultado = consulta.executeQuery();
            		
				while (resultado.next()) {

				long id = resultado.getLong("id_endereco");
				String logradouro = resultado.getString("logradouro_endereco");
				short numero = resultado.getShort("numero_endereco");
				String complemento = resultado.getString("complemento_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String uf = resultado.getString("uf_endereco");
				String cep = resultado.getString("cep_endereco");
				
				 endereco = new Endereco(id, logradouro, numero, complemento, bairro, cidade, uf, cep);
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
		return endereco;
	}
	
	private Connection conectarBanco() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block e.printStackTrace();
			}

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/procuratio?user=root&password=root");

	}
}
