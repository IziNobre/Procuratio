package br.senac.procuratio.modelo.dao.empregado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.senac.procuratio.modelo.entidade.contato.Contato;
import br.senac.procuratio.modelo.entidade.endereco.Endereco;
import br.senac.procuratio.modelo.entidade.funcao.Funcao;
import br.senac.procuratio.modelo.entidade.pessoa.dependente.Dependente;
import br.senac.procuratio.modelo.entidade.pessoa.empregado.Empregado;
import br.senac.procuratio.modelo.enumeracao.contrato.Contrato;
import br.senac.procuratio.modelo.enumeracao.escolaridade.Escolaridade;
import br.senac.procuratio.modelo.enumeracao.genero.Genero;

public class EmpregadoDAOImpl implements EmpregadoDAO {

	public Empregado cadastrarEmpregado(Empregado empregado) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO pessoa (nome_pessoa, data_nascimento_pessoa, cpf_pessoa, genero_pessoa) VALUES (?,?,?,?)");

			insert.setString(1, empregado.getNome());
			insert.setString(2, empregado.getDataNascimento().toString());
			insert.setString(3, empregado.getCpf());
			insert.setInt(4, empregado.getGenero().ordinal() + 1);

			insert.execute();

			insert = conexao.prepareStatement("INSERT INTO empregado (cpf_empregado, pis_empregado, ctps_empregado, id_endereco, id_contato, escolaridade_empregado, nome_mae_empregado, data_admissao_empregado, termino_experiencia_empregado, tipo_contrato_empregado, id_funcao, salario_empregado, cnpj_empresa) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");

			insert.setString(1, empregado.getCpf());
			insert.setString(2, empregado.getPis());
			insert.setString(3, empregado.getCtps());
			insert.setLong(4, empregado.getEndereco().getId());
			insert.setLong(5, empregado.getContato().getId());
			insert.setInt(6, empregado.getEscolaridade().ordinal() + 1);
			insert.setString(7, empregado.getNomeMae());
			insert.setString(8, empregado.getDataAdmissao().toString());
			insert.setString(9, empregado.getTerminoContratoExperiencia().toString());
			insert.setInt(10, empregado.getTipoContrato().ordinal() + 1);
			insert.setLong(11, empregado.getFuncao().getId());
			insert.setFloat(12, empregado.getSalario());
			insert.setString(13, empregado.getEmpresa().getCnpj());

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

		return empregado;
	}

	public void deletarEmpregado(Empregado empregado) {
		
		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco(); 
			delete = conexao.prepareStatement("DELETE FROM empregado WHERE cpf_empregado = ?");

			delete.setString(1, empregado.getCpf());

			delete.execute();
			
			delete = conexao.prepareStatement("DELETE FROM pessoa WHERE cpf_pessoa = ?");

			delete.setString(1, empregado.getCpf());

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

	public void atualizarNomeEmpregado(Empregado empregado, String novoNome) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco(); 
			update = conexao.prepareStatement("UPDATE pessoa SET nome_pessoa = ? WHERE cpf_pessoa = ?");

			update.setString(1, novoNome); 
			update.setString(2, empregado.getCpf());

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
		
	public void atualizarDataNascimentoEmpregado(Empregado empregado, LocalDate novaDataNascimento) {

			Connection conexao = null; 
			PreparedStatement update = null;

			try {

				conexao = conectarBanco(); 
				update = conexao.prepareStatement("UPDATE pessoa SET data_nascimento_pessoa = ? WHERE cpf_pessoa = ?");

				update.setString(1, novaDataNascimento.toString());
				update.setString(2,empregado.getCpf());

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

		public void atualizarCpfEmpregado(Empregado empregado, String novoCpf) {

			Connection conexao = null; 
			PreparedStatement update = null;

			try {

				conexao = conectarBanco(); 
				update = conexao.prepareStatement("UPDATE pessoa SET cpf_pessoa = ? WHERE cpf_pessoa = ?");

				update.setString(1, novoCpf); 
				update.setString(2, empregado.getCpf());

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

		public void atualizarGeneroEmpregado(Empregado empregado, Genero novoGenero){

			Connection conexao = null; 
			PreparedStatement update = null;
	
			try {

				conexao = conectarBanco(); 
				update = conexao.prepareStatement("UPDATE pessoa SET genero_pessoa = ? WHERE cpf_pessoa = ?");

				update.setInt(1, novoGenero.ordinal()+1); 
				update.setString(2,empregado.getCpf());

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

		public void atualizarEmpresaEmpregado(Empregado empregado, String cnpj_empresa) {

			Connection conexao = null; 
			PreparedStatement update = null;

			try {

				conexao = conectarBanco(); 
				update = conexao.prepareStatement("UPDATE empregado SET cnpj_empresa = ? WHERE cpf_empregado = ?");

				update.setString(1, cnpj_empresa);
				update.setString(2,empregado.getCpf());

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

		public void atualizarPisEmpregado(Empregado empregado, String novoPis) {

			Connection conexao = null; PreparedStatement update = null;

			try {

				conexao = conectarBanco(); 
				update = conexao.prepareStatement("UPDATE empregado SET pis_empregado = ? WHERE cpf_empregado = ?");
	
				update.setString(1, novoPis); 
				update.setString(2, empregado.getCpf());

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

		public void atualizarCtpsEmpregado(Empregado empregado, String novoCtps) {
 
			Connection conexao = null; 
			PreparedStatement update = null;

			try {

				conexao = conectarBanco(); 
				update = conexao. prepareStatement("UPDATE empregado SET ctps_empregado = ? WHERE cpf_empregado = ?");

				update.setString(1, novoCtps); 
				update.setString(2, empregado.getCpf());

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

		public void atualizarEnderecoEmpregado(Empregado empregado, Long id_endereco) {

			Connection conexao = null; 
			PreparedStatement update = null;

			try {

				conexao = conectarBanco(); 
				update = conexao.prepareStatement("UPDATE empregado SET id_endereco = ? WHERE cpf_empregado = ?");
	
				update.setLong(1, id_endereco); 
				update.setString(2,empregado.getCpf());

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

		public void atualizarContatoEmpregado(Empregado empregado, Long id_contato) {
	
			Connection conexao = null; 
			PreparedStatement update = null;
	
			try {

				conexao = conectarBanco(); 
				update = conexao.prepareStatement("UPDATE empregado SET id_contato = ? WHERE cpf_empregado = ?");

				update.setLong(1, id_contato); 
				update.setString(2,empregado.getCpf());

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

		public void atualizarEscolaridadeEmpregado(Empregado empregado, Escolaridade novaEscolaridade) {

			Connection conexao = null; 
			PreparedStatement update = null;

			try {

				conexao = conectarBanco(); 
				update = conexao.prepareStatement("UPDATE empregado SET escolaridade_empregado = ? WHERE cpf_empregado = ?");

				update.setInt(1, novaEscolaridade.ordinal()+ 1); 
				update.setString(2,empregado.getCpf());
	
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

		public void atualizarNomeMaeEmpregado(Empregado empregado, String novoNomeMae) {

			Connection conexao = null; 
			PreparedStatement update = null;

			try {

				conexao = conectarBanco(); update = conexao.prepareStatement("UPDATE empregado SET nome_mae_empregado = ? WHERE cpf_empregado = ?");
	
				update.setString(1, novoNomeMae); 
				update.setString(2, empregado.getCpf());
	
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
	
		public void atualizarDataAdmissaoEmpregado(Empregado empregado, LocalDate novaDataAdmissao) {

			Connection conexao = null; 
			PreparedStatement update = null;

			try {

				conexao = conectarBanco();
				update = conexao.prepareStatement("UPDATE empregado SET data_admissao_empregado = ? WHERE cpf_empregado = ?");
	
				update.setString(1, novaDataAdmissao.toString()); 
				update.setString(2,empregado.getCpf());

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

		public void atualizarTerminoContratoExperienciaEmpregado(Empregado empregado, LocalDate novoTerminoContratoExperiencia) {

			Connection conexao = null; 
			PreparedStatement update = null;

			try {

				conexao = conectarBanco(); 
				update = conexao.prepareStatement("UPDATE empregado SET termino_experiencia_empregado = ? WHERE cpf_empregado = ?");

				update.setString(1, novoTerminoContratoExperiencia.toString());
				update.setString(2, empregado.getCpf());

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

		public void atualizarTipoContratoEmpregado(Empregado empregado, Contrato novoTipoContrato) {

			Connection conexao = null; 
			PreparedStatement update = null;
	
			try {

				conexao = conectarBanco(); 
				update = conexao.prepareStatement("UPDATE empregado SET tipo_contrato_empregado = ? WHERE cpf_empregado = ?");

				update.setInt(1, novoTipoContrato.ordinal());
				update.setString(2,empregado.getCpf());

				update.execute();

			} catch (SQLException erro) { 
				erro.printStackTrace(); 
				}


			try {

				if (update != null) 
					update.close();
	
				if (conexao != null) 
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace(); 
			} 
		} 

	public void atualizarFuncaoEmpregado(Empregado empregado, Long id_Funcao){

		Connection conexao = null; 
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE empregado SET id_funcao = ? WHERE cpf_empregado = ?");
	
			update.setLong(1, id_Funcao); 
			update.setString(2,empregado.getCpf());
	
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

	public void atualizarSalarioEmpregado(Empregado empregado, float novoSalario){

		Connection conexao = null; 
		PreparedStatement update = null;

		try {

			conexao = conectarBanco(); 
			update = conexao.prepareStatement("UPDATE empregado SET salario_empregado = ? WHERE cpf_empregado = ?");

			update.setFloat(1, novoSalario);
			update.setString(2, empregado.getCpf());

			update.execute();

		} catch (SQLException erro) { erro.printStackTrace(); }

		finally {

			try {

				if (update != null) update.close();

				if (conexao != null) conexao.close();

			} catch (SQLException erro) {
	
				erro.printStackTrace(); 
			} 
		} 
	}

	public void atualizarDependenteEmpregado(Empregado empregado, Dependente novoDependente) {

		Connection conexao = null; 
		PreparedStatement update = null;

		try {

			conexao = conectarBanco(); 
			update = conexao.prepareStatement("UPDATE empregado_tem_dependente SET cpf_dependente = ? WHERE cpf_empregado = ?");

			update.setString(1, novoDependente.getCpf()); 
			update.setString(2, empregado.getCpf());

			update.execute();

		} catch (SQLException erro) { 
			erro.printStackTrace(); 
			}
	

		try {

			if (update != null) 
				update.close();

			if (conexao != null) 
				conexao.close();

		} catch (SQLException erro) {

			erro.printStackTrace(); 
			} 
		} 

	public Empregado recuperarEmpregado(String Cpf) {

		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Empregado empregado = null;

		try {

			conexao = conectarBanco();
			consulta = conexao.prepareStatement("SELECT  nome_pessoa, cpf_pessoa, data_nascimento_pessoa, genero_pessoa, "
							+ "pis_empregado, ctps_empregado, escolaridade_empregado, nome_mae_empregado, data_admissao_empregado, termino_experiencia_empregado, "
							+ "tipo_contrato_empregado, salario_empregado, nome_funcao, telefone_contato, celular_contato, email_contato, "
							+ "logradouro_endereco, numero_endereco, complemento_endereco, bairro_endereco, cidade_endereco, uf_endereco, cep_endereco "
							+ "FROM pessoa p inner join empregado e on p.cpf_pessoa = e.cpf_empregado "
							+ "inner join contato c on e.id_contato = c.id_contato "
							+ "inner join endereco a on a.id_endereco = e.id_endereco "
							+ "inner join funcao f on e.id_funcao = f.id_funcao "
							+ "WHERE e.cpf_empregado = ?");

			consulta.setString(1, Cpf);
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

				String nome = resultado.getString("nome_pessoa");
				String cpf = resultado.getString("cpf_pessoa");
				LocalDate dataNascimento = LocalDate.parse(resultado.getString("data_nascimento_pessoa"));
				Genero genero = Genero.valueOf(resultado.getString("genero_pessoa"));
				String pis = resultado.getString("pis_empregado");
				String ctps = resultado.getString("ctps_empregado");
				Escolaridade escolaridade = Escolaridade.valueOf(resultado.getString("escolaridade_empregado"));
				String nomeMae = resultado.getString("nome_mae_empregado");
				LocalDate dataAdmissao = LocalDate.parse(resultado.getString("data_admissao_empregado"));
				LocalDate terminoContratoExperiencia = LocalDate.parse(resultado.getString("termino_experiencia_empregado"));
				Contrato tipoContrato = Contrato.valueOf(resultado.getString("tipo_contrato_empregado"));
				Funcao funcao = new Funcao(resultado.getString("nome_funcao"));
				Float salario = resultado.getFloat("salario_empregado");
				
				empregado = new Empregado(nome, dataNascimento, cpf, genero, pis, ctps, endereco, contato, escolaridade,
						nomeMae, dataAdmissao, terminoContratoExperiencia, tipoContrato, funcao, salario);
				
				
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

		return empregado;
	}

	public List<Empregado>recuperarEmpregadosAdmitidosOrdenadosPorNome() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Empregado> empregados = new ArrayList<Empregado>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT nome_pessoa, cpf_pessoa, nome_funcao, data_admissao_empregado FROM pessoa p"
					+ " inner join empregado e on p.cpf_pessoa = e.cpf_empregado inner join funcao f on e.id_funcao = f.id_funcao GROUP BY nome_pessoa ORDER BY nome_pessoa ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_pessoa");
				String cpf = resultado.getString("cpf_pessoa");
				Funcao funcao = new Funcao(resultado.getString("nome_funcao"));
				LocalDate dataAdmissao = LocalDate.parse(resultado.getString("data_admissao_empregado"));

				empregados.add(new Empregado(nome, cpf, funcao, dataAdmissao));

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

		return empregados;
	}

	public List<Empregado>recuperarEmpregadosOrdenadosDataAdmissaoPorMesEAno(short mes, short ano) {
		
		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
	
		List<Empregado> empregados = new ArrayList<Empregado>();

		try {
			
			conexao = conectarBanco();
			consulta = conexao.prepareStatement("SELECT cpf_pessoa, nome_pessoa, nome_funcao, data_admissao_empregado FROM pessoa p "
					+ "inner join empregado e on p.cpf_pessoa = e.cpf_empregado "
					+ "inner join funcao f on e.id_funcao = f.id_funcao "
					+ "WHERE month(data_admissao_empregado) = ? and year(data_admissao_empregado) = ? ORDER BY year(data_admissao_empregado) and month(data_admissao_empregado)");
	 
			consulta.setShort(1, mes);
			consulta.setShort(2,  ano);
			resultado = consulta.executeQuery();
			
			while (resultado.next()) {

				String nome = resultado.getString("nome_pessoa"); 
				String cpf = resultado.getString("cpf_pessoa"); 
				Funcao funcao = new Funcao(resultado.getString("nome_funcao")); 
				LocalDate dataAdmissao =LocalDate.parse(resultado.getString("data_admissao_empregado"));

				empregados.add(new Empregado(nome, cpf, funcao, dataAdmissao)); }

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
		
	return empregados; 
	
	}

	public List<Empregado> recuperarEmpregadosOrdenadosDataAdmissaoPorAno(short ano) {

		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
	
		List<Empregado> empregados = new ArrayList<Empregado>();

		try {

			conexao = conectarBanco();
			consulta = conexao.prepareStatement("SELECT cpf_pessoa, nome_pessoa, nome_funcao, data_admissao_empregado "
					+ "FROM pessoa p inner join empregado e on p.cpf_pessoa = e.cpf_empregado inner join funcao f on e.id_funcao = f.id_funcao "
					+ "WHERE year(data_admissao_empregado) = ? ORDER BY year(data_admissao_empregado) ASC");

			consulta.setShort(1,  ano);
			resultado = consulta.executeQuery();
			
			while (resultado.next()) {

				String nome = resultado.getString("nome_pessoa"); 
				String cpf =resultado.getString("cpf_pessoa"); 
				Funcao funcao = new Funcao(resultado.getString("nome_funcao")); 
				LocalDate dataAdmissao = LocalDate.parse(resultado.getString("data_admissao_empregado"));
				
				empregados.add(new Empregado(nome, cpf, funcao, dataAdmissao)); }

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

		return empregados; 
	}
	
	public List<Empregado> recuperarEmpregadosOrdenadosFuncao(Long id_Funcao) {
		
		Connection conexao = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
	
		List<Empregado> empregados = new ArrayList<Empregado>();


		try {

			conexao = conectarBanco();
			consulta = conexao.prepareStatement("SELECT cpf_pessoa, nome_pessoa, nome_funcao, data_admissao_empregado FROM pessoa p inner join empregado e on p.cpf_pessoa = e.cpf_empregado inner join funcao f on e.id_funcao = f.id_funcao WHERE e.id_funcao = ? ORDER BY nome_pessoa ASC");

			consulta.setLong(1,  id_Funcao);
			resultado = consulta.executeQuery();
			
			while (resultado.next()) {

				String nome = resultado.getString("nome_pessoa"); 
				String cpf = resultado.getString("cpf_pessoa");
				Funcao funcao = new Funcao(resultado.getString("nome_funcao"));
				LocalDate dataAdmissao = LocalDate.parse(resultado.getString("data_admissao_empregado"));
	
				empregados.add(new Empregado(nome, cpf, funcao, dataAdmissao)); }
	
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
		return empregados; 
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/procuratio?user=root&password=root");
	}	

}
