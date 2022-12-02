package br.senac.procuratio.modelo.dao.contato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.senac.procuratio.modelo.entidade.contato.Contato;

	public class ContatoDAOImpl implements ContatoDAO {
		
		public Contato cadastrarContato(Contato contato) {
			
			Connection conexao = null;
			PreparedStatement insert = null;

			try {

				conexao = conectarBanco();
				insert = conexao.prepareStatement("INSERT INTO contato (telefone_contato, celular_contato, email_contato) VALUES (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

				insert.setString(1, contato.getTelefone());
				insert.setString(2, contato.getCelular());
				insert.setString(3, contato.getEmail());

				insert.execute();
				
				ResultSet chavePrimaria = insert.getGeneratedKeys();

				if (chavePrimaria.next())
					contato.setId(chavePrimaria.getLong(1));

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
			return contato;
		}
				
		public void editarContato(Contato contato){
			Connection conexao = null;
			PreparedStatement update = null;

			try {

				conexao = conectarBanco();
				update = conexao.prepareStatement("UPDATE contato SET telefone_contato = ?, celular_contato = ?, email_contato = ? WHERE id_contato = ?");

				update.setString(1, contato.getTelefone());
				update.setString(2, contato.getCelular());
				update.setString(3, contato.getEmail());
        update.setLong(4, contato.getId());
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
		
		public void deletarContato(Contato contato) {
    
			Long teste = contato.getId();
			System.out.println(teste);
			
			Connection conexao = null;
			PreparedStatement delete = null;

			try {

				conexao = conectarBanco();
				delete = conexao.prepareStatement("DELETE FROM contato WHERE id_contato = ?");

				delete.setLong(1, contato.getId());

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
		
		public Contato recuperarContatoEmpregado(String cpf_empregado){
			
			Connection conexao = null;
			PreparedStatement consulta = null;
			ResultSet resultado = null;
			Contato contato = null;

			try {

				conexao = conectarBanco();
				consulta = conexao.prepareStatement("SELECT e.id_contato, telefone_contato, celular_contato, email_contato "
						+ "FROM contato c join empregado e on c.id_contato = e.id_contato WHERE cpf_empregado = ?");

				consulta.setString(1, cpf_empregado);
	            resultado = consulta.executeQuery();
	            		
					while (resultado.next()) {

					Long id = resultado.getLong("id_contato");
					String telefone = resultado.getString("telefone_contato");
					String celular = resultado.getString("celular_contato");
					String email = resultado.getString("email_contato");
					
					contato = new Contato(id, telefone, celular, email);
					
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

			return contato
      }
      
      public List<Contato> recuperarContatosCadastrados() {
			
			Connection conexao = null;
			Statement consulta = null;
			ResultSet resultado = null;

			List<Contato> contatos = new ArrayList<Contato>();

			try {

				conexao = conectarBanco();
				consulta = conexao.createStatement();
				resultado = consulta.executeQuery("SELECT id_contato, telefone_contato, celular_contato, email_contato FROM contato");

				while (resultado.next()) {

					Long id = resultado.getLong("id_contato");	
					String telefone = resultado.getString("telefone_contato");
					String celular = resultado.getString("celular_contato");
					String email = resultado.getString("email_contato");
						
					contatos.add(new Contato(id, telefone, celular, email));

				}
			}catch (SQLException erro) {
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

			return contatos;
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
