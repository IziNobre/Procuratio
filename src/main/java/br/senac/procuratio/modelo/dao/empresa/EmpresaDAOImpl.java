package br.senac.procuratio.modelo.dao.empresa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.senac.procuratio.modelo.entidade.contato.Contato;
import br.senac.procuratio.modelo.entidade.empresa.Empresa;
import br.senac.procuratio.modelo.entidade.endereco.Endereco;

public class EmpresaDAOImpl implements EmpresaDAO {

	public Empresa cadastrarEmpresa(Empresa empresa) {

		Connection conexao = null;
		PreparedStatement insert = null;

		
		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO empresa (nome_empresa, cnpj_empresa, senha_login_empresa, id_endereco, id_contato) VALUES (?,?,?,?,?)");

			insert.setString(1, empresa.getNome());
			insert.setString(2, empresa.getCnpj());
			insert.setString(3, empresa.getSenhaLogin());
			insert.setLong(4, empresa.getEndereco().getId());
			insert.setLong(5, empresa.getContato().getId());
			

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
		return empresa;
	}

	public void deletarEmpresa(Empresa empresa) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM empresa WHERE cnpj_empresa = ?");

			delete.setString(1, empresa.getCnpj());

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

	public void atualizarNomeEmpresa(Empresa empresa, String novoNome) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE empresa SET nome_empresa = ? WHERE cnpj_empresa = ?");

			update.setString(1, novoNome);
			update.setString(2, empresa.getCnpj());

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
	
		public void atualizarEnderecoEmpresa(Empresa empresa, Long id_endereco) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE empresa SET id_endereco = ? WHERE cnpj_empresa = ?");

            update.setLong(1, id_endereco);
			update.setString(2, empresa.getCnpj());

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

	public void atualizarCnpjEmpresa(Empresa empresa, String novoCnpj) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE empresa SET cnpj_empresa = ? WHERE cnpj_empresa = ?");

			update.setString(1, novoCnpj);
			update.setString(2, empresa.getCnpj());

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

	public void atualizarContatoEmpresa(Empresa Empresa, Long id_contato) {
		
		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE empresa SET id_contato = ? WHERE cnpj_empresa = ?");

            update.setLong(1, id_contato);
			update.setString(2, Empresa.getCnpj());

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

	public boolean verificarLoginSenha(String cnpj, String senha) {
		
		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		
		boolean consultaBanco = false;

		try {
			conexao = conectarBanco();
			consulta = conexao.prepareStatement("SELECT senha_login_empresa FROM empresa WHERE cnpj_empresa = ? and senha_login_empresa = ?");
			
			consulta.setString(1, cnpj);
			consulta.setString(2, senha);
			
			consulta.execute();
			
			resultado = consulta.getResultSet();
			consultaBanco = resultado.next();
			
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
		return consultaBanco;
		
	}
		
	public List<Empresa> recuperarEmpresas() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Empresa> empresas = new ArrayList<Empresa>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT nome_empresa, cnpj_empresa, logradouro_endereco, numero_endereco, complemento_endereco, bairro_endereco, cidade_endereco, uf_endereco, cep_endereco, telefone_contato, celular_contato, email_contato FROM empresa e inner join endereco en on e.id_endereco = en.id_endereco inner join contato c on e.id_contato = c.id_contato ORDER BY nome_empresa ASC");

			while (resultado.next()) {
				
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String email = resultado.getString("email_contato");
				Contato contato = new Contato(telefone, celular, email);

				String logradouro = resultado.getString("logradouro_endereco");
				Short numero = resultado.getShort("numero_endereco");
				String complemento = resultado.getString("complemento_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String uf = resultado.getString("uf_endereco");
				String cep = resultado.getString("cep_endereco");
				Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep);
				
				String nome = resultado.getString("nome_empresa");
				String cnpj = resultado.getString("cnpj_empresa");
				
				empresas.add(new Empresa(nome, cnpj, endereco, contato));
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
		
		return empresas;
	}

	public Empresa recuperarEmpresa(String cnpj) {

		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Empresa empresa = null;

		try {

			conexao = conectarBanco();
			consulta = conexao.prepareStatement("SELECT nome_empresa, cnpj_empresa, logradouro_endereco, numero_endereco, complemento_endereco, bairro_endereco, cidade_endereco, uf_endereco, cep_endereco, telefone_contato, celular_contato, email_contato FROM empresa e inner join endereco en on e.id_endereco = en.id_endereco inner join contato c on e.id_contato = c.id_contato WHERE e.cnpj_empresa = ?");
			
			consulta.setString(1, cnpj);
			resultado = consulta.executeQuery();

			while (resultado.next()) {
				
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String email = resultado.getString("email_contato");
				Contato contato = new Contato(telefone, celular, email);

				String logradouro = resultado.getString("logradouro_endereco");
				Short numero = resultado.getShort("numero_endereco");
				String complemento = resultado.getString("complemento_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String uf = resultado.getString("uf_endereco");
				String cep = resultado.getString("cep_endereco");
				Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep);
				
				String nome = resultado.getString("nome_empresa");
				String cnpj1 = resultado.getString("cnpj_empresa");
				
				empresa = new Empresa(nome, cnpj1, endereco, contato);
				
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
		return empresa;
		
	}
	
	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/procuratio?user=root&password=root");

	}

}