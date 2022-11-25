package br.senac.procuratio.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.procuratio.modelo.dao.contato.ContatoDAO;
import br.senac.procuratio.modelo.dao.contato.ContatoDAOImpl;
import br.senac.procuratio.modelo.dao.dependente.DependenteDAO;
import br.senac.procuratio.modelo.dao.dependente.DependenteDAOImpl;
import br.senac.procuratio.modelo.dao.empregado.EmpregadoDAO;
import br.senac.procuratio.modelo.dao.empregado.EmpregadoDAOImpl;
import br.senac.procuratio.modelo.dao.empresa.EmpresaDAO;
import br.senac.procuratio.modelo.dao.empresa.EmpresaDAOImpl;
import br.senac.procuratio.modelo.dao.endereco.EnderecoDAO;
import br.senac.procuratio.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.procuratio.modelo.dao.funcao.FuncaoDAO;
import br.senac.procuratio.modelo.dao.funcao.FuncaoDAOImpl;
import br.senac.procuratio.modelo.entidade.contato.Contato;
import br.senac.procuratio.modelo.entidade.empresa.Empresa;
import br.senac.procuratio.modelo.entidade.endereco.Endereco;
import br.senac.procuratio.modelo.entidade.funcao.Funcao;
import br.senac.procuratio.modelo.entidade.pessoa.empregado.Empregado;
import br.senac.procuratio.modelo.enumeracao.contrato.Contrato;
import br.senac.procuratio.modelo.enumeracao.escolaridade.Escolaridade;
import br.senac.procuratio.modelo.enumeracao.genero.Genero;

@WebServlet("/")
public class Servlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private EmpresaDAO daoEmpresa;
	private ContatoDAO daoContato;
	private EnderecoDAO daoEndereco;

	public void init() {
		daoEmpresa = new EmpresaDAOImpl();
		daoContato = new ContatoDAOImpl();
		daoEndereco = new EnderecoDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		try {

			switch (action) {

/*			case "/login":
				mostrarFormularioLogin(request, response);
				autenticarLogin(request, response); //** Verificar se fica neste path
				novoLogin(request, response); //** Verificar se fica neste path e como será redirecionado ao cadastro de empresa
				
				break;
				
			case "/login-novo":
				
				novoLogin(request, response); //** Verificar se fica neste path e como será redirecionado ao cadastro de empresa
				
				break;	
			
			case "/painel-principal":

				listarFuncionalidades(request, response);
				break;
				
			case "/empresas":
				listarEmpresa(request, response);
								
				break;
*/				
			case "/empresas/novo":
				mostrarFormularioNovaEmpresa(request, response);
				
				break;
			
			case  "/empresas/inserir":
				cadastrarEmpresa(request, response); 
				
				break;
/*							
			case "/empresas/editar":
				mostrarFormularioEditarEmpresa(request, response);
				
				break;
				
			case "/empresas/atualizar":
				atualizarEmpresa(request, response);
				
				break;
				
			case "/empresas/deletar":
				deletarEmpresa(request, response);
				
				break;
			
				
			case "/painel-principal/colaboradores":
				listarEmpregados(request, response);
				deletarEmpregado(request, response); //** Verificar se fica neste path
			
				break;
					
				default:
				listarFuncionalidades(request, response);
				break;
*/			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
/*	
	private void mostrarFormularioLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-login.jsp");
		dispatcher.forward(request, response);
	}
	
	private boolean autenticarLogin(HttpServletRequest request, HttpServletResponse response) //**
			throws SQLException, IOException {

		String cnpj = request.getParameter("cnpj");
		String senhaLogin = request.getParameter("senha");
		daoEmpresa.verificarLoginSenhaNoBanco(new Empresa(cnpj, senhaLogin));
		response.sendRedirect("painel-principal"); //**
	}
		
	
	private void novoLogin(HttpServletRequest request, HttpServletResponse response) //**
			throws SQLException, IOException {

		String cnpj = request.getParameter("cnpj");
		String senhaLogin = request.getParameter("senha");
		daoEmpresa.autenticarLogin(new Empresa(cnpj, senhaLogin));
		response.sendRedirect("home"); //**
	}
	
	
	private void listarFuncionalidades(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("funcionalidades.jsp");
		dispatcher.forward(request, response);
	}


	private void listarEmpresa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		Empresa empresa = daoEmpresa.recuperarEmpresa();
		request.setAttribute("empresa", empresa);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar-empresa.jsp");
		dispatcher.forward(request, response);
	}

	private void deletarEmpresa(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String cnpj = request.getParameter("cnpj");
		Empresa empresa = daoEmpresa.recuperarEmpresa(new Empresa(cnpj));
		daoEmpresa.deletarEmpresa(empresa);
		response.sendRedirect("empresas");
	}
	
	private void mostrarFormularioEditarEmpresa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		String cnpj = request.getParameter("cnpj");
		Empresa empresa = daoEmpresa.recuperarEmpresa(new Empresa(cnpj));
		request.setAttribute("empresa", empresa);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-empresa.jsp");
		dispatcher.forward(request, response);
	}
	
	private void atualizarEmpresa(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		Empresa empresa; //**

		String nome = request.getParameter("nome");
		daoEmpresa.atualizarNomeEmpresa(new Empresa(nome));
		String cnpj = request.getParameter("cnpj");
		daoEmpresa.atualizarCnpjEmpresa(new Empresa(cnpj));
		
		long id = Long.parseLong(request.getParameter("id"));
		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String email = request.getParameter("email");
		daoEmpresa.atualizarContatoEmpresa(new Contato(id,telefone, celular, email));
		
		long id = Long.parseLong(request.getParameter("id"));
		String logradouro = request.getParameter("logradouro");
		short numero = Short.valueOf(request.getParameter("numero"));
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String uf = request.getParameter("uf");
		String cep = request.getParameter("cep");
		daoEmpresa.atualizarEnderecoEmpresa(new Endereco(id, logradouro, numero, complemento, bairro, cidade, uf, cep));
		
		response.sendRedirect("empresas");
	}
*/	
	private void mostrarFormularioNovaEmpresa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro-empresa.jsp");
		dispatcher.forward(request, response);
	}
	
	private void cadastrarEmpresa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String email = request.getParameter("email");
		Contato contato = daoContato.cadastrarContato(new Contato(telefone, celular, email));

		String logradouro = request.getParameter("logradouro");
		short numero = Short.valueOf(request.getParameter("numero"));
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String uf = request.getParameter("uf");
		String cep = request.getParameter("cep");
		Endereco endereco = daoEndereco.cadastrarEndereco(new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep));
		
		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		String senhaLogin = request.getParameter("senha");
		daoEmpresa.cadastrarEmpresa(new Empresa(nome, cnpj, senhaLogin, endereco, contato));
		
		response.sendRedirect("empresas");
	}
/*	
	private void listarEmpregados(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<Empregado> empregado = daoEmpregado.recuperarEmpregadosAdmitidosOrdenadosPorNome();
		request.setAttribute("empregados", empregado);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar-empregados.jsp");
		dispatcher.forward(request, response);
	}

	private void deletarEmpregado(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String cpf = request.getParameter("cpf");
		Empregado empregado = daoEmpregado.recuperarEmpregado(new Empregado(cpf));
		daoEmpregado.deletarEmpregado(empregado);
		response.sendRedirect("colaboradores");
	}
	
	private void mostrarFormularioEditarEmpregado(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		String cpf = request.getParameter("cpf");
		Empregado empregado = daoEmpregado.recuperarEmpregado(new Empregado(cpf));
		request.setAttribute("empregado", empregado);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-empregado.jsp");
		dispatcher.forward(request, response);
	}
	
	private void atualizarEmpregado(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		Empregado empregado;
		
		long id = Long.parseLong(request.getParameter("id"));
		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String email = request.getParameter("email");
		daoEmpregado.atualizarContatoEmpregado(new Contato(id,telefone, celular, email));
		
		long id = Long.parseLong(request.getParameter("id"));
		String logradouro = request.getParameter("logradouro");
		short numero = Short.valueOf(request.getParameter("numero"));
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String uf = request.getParameter("uf");
		String cep = request.getParameter("cep");
		daoEmpregado.atualizarEnderecoEmpregado(new Endereco(id, logradouro, numero, complemento, bairro, cidade, uf, cep));

		String nome = request.getParameter("nome_pessoa");
		String cpf = request.getParameter("cpf_pessoa");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("data_nascimento_pessoa"));
		Genero genero = Genero.valueOf(request.getParameter("genero_pessoa"));
		String pis = request.getParameter("pis_empregado");
		String ctps = request.getParameter("ctps_empregado");
		Escolaridade escolaridade = Escolaridade.valueOf(request.getParameter("escolaridade_empregado"));
		String nomeMae = request.getParameter("nome_mae_empregado");
		LocalDate dataAdmissao = LocalDate.parse(request.getParameter("data_admissao_empregado"));
		LocalDate terminoContratoExperiencia = LocalDate.parse(request.getParameter("termino_experiencia_empregado"));
		Contrato tipoContrato = Contrato.valueOf(request.getParameter("tipo_contrato_empregado"));
		Funcao funcao = new Funcao(request.getParameter("nome_funcao"));
		Float salario = Float.valueOf(request.getParameter("salario_empregado"));
		
		empregado = new Empregado(nome, dataNascimento, cpf, genero, pis, ctps, endereco, contato, escolaridade,
				nomeMae, dataAdmissao, terminoContratoExperiencia, tipoContrato, funcao, salario);
		
		
		response.sendRedirect("colaboradores");
	}
		
	
	private void mostrarFormularioNovoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-contato.jsp");
		dispatcher.forward(request, response);
	}
	
	private void inserirContato(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String email = request.getParameter("email");
		daoContato.cadastrarContato(new Contato(telefone, celular, email));
		response.sendRedirect("listar");
	}
	private void deletarContato(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		Contato contato = daoContato.deletarContato(new Contato(id));
		daoContato.deletarContato(contato);
		response.sendRedirect("listar");
	}
	private void mostrarFormularioEditarContato(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		Contato contato = daoContato.recuperarContatoEmpregado(new Contato(id));
		request.setAttribute("contato", contato);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-contato.jsp");
		dispatcher.forward(request, response);
	}
	private void atualizarContato(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		String telefone = request.getParameter("telefone");
		daoContato.atualizarTelefone(new Contato(id,telefone));
		
		String celular = request.getParameter("celular");
		daoContato.atualizarCelular(new Contato(id, celular));
		
		String email = request.getParameter("email");
		daoContato.atualizarEmail(new Contato(id, email));
		
		response.sendRedirect("listar");
	}
*/
	

}
