package br.senac.procuratio.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
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

@WebServlet("/")
public class Servlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private EmpresaDAO daoEmpresa;
	private ContatoDAO daoContato;
	private EnderecoDAO daoEndereco;
	private FuncaoDAO daoFuncao;

	public void init() {
		daoEmpresa = new EmpresaDAOImpl();
		daoContato = new ContatoDAOImpl();
		daoEndereco = new EnderecoDAOImpl();
		daoFuncao = new FuncaoDAOImpl();
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
			
			case "/nova-empresa":
				mostrarFormularioNovaEmpresa(request, response);
				
				break;
			
			case  "/inserir-empresa":
				cadastrarEmpresa(request, response); 
				
				break;

			case "/minha-conta":
				listarEmpresa(request, response);
								
				break;
							
			case "/editar-empresa":
				mostrarFormularioEditarEmpresa(request, response);
				
				break;
			
			case "/atualizar-empresa":
				atualizarEmpresa(request, response);
				
				break;

			case "/deletar-empresa":
				deletarEmpresa(request, response);
				
				break;
				

			case "/funcao":
				listarFuncoes(request, response);
				
				break;
			
			case "/nova-funcao":
				mostrarFormularioNovaFuncao(request, response);
				
				break;
			
			case  "/inserir-funcao":
				cadastrarFuncao(request, response); 
				
				break;
			
			default:
				listarFuncionalidades(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}


	// EMPRESA 
	
	private void listarEmpresa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		String cnpj = request.getParameter("cnpj");
		Empresa empresa = daoEmpresa.recuperarEmpresa(cnpj);
		request.setAttribute("empresa", empresa);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar-empresa.jsp");
		dispatcher.forward(request, response);
	}

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
		
		response.sendRedirect("login");
	}
	
	private void mostrarFormularioEditarEmpresa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		String cnpj = request.getParameter("cnpj");
		Empresa empresa = daoEmpresa.recuperarEmpresa(cnpj);
		request.setAttribute("empresa", empresa);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro-empresa.jsp");
		dispatcher.forward(request, response);
	}
	
	private void atualizarEmpresa(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String email = request.getParameter("email");
		Contato contato = daoContato.editarContato(new Contato(telefone, celular, email));
		
		String logradouro = request.getParameter("logradouro");
		short numero = Short.valueOf(request.getParameter("numero"));
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String uf = request.getParameter("uf");
		String cep = request.getParameter("cep");
		Endereco endereco = daoEndereco.editarEndereco(new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep));

		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		String senhaLogin = request.getParameter("senha");
		daoEmpresa.editarEmpresa(new Empresa(nome, cnpj, senhaLogin, endereco, contato));

		response.sendRedirect("minha-conta");
	}
	
	private void listarFuncionalidades(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("funcionalidades-empresa.jsp");
		dispatcher.forward(request, response);
	}

	private void deletarEmpresa(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String cnpj = request.getParameter("cnpj");
		Empresa empresa = daoEmpresa.recuperarEmpresa(cnpj);
		daoEmpresa.deletarEmpresa(empresa);
		response.sendRedirect("home");
	}
	
	// FUNÇÕES	
	
		private void listarFuncoes(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			
			List<Funcao> funcoes  = daoFuncao.recuperarFuncoes();
			request.setAttribute("funcoes", funcoes);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listar-funcoes.jsp");
			dispatcher.forward(request, response);
		}

		private void mostrarFormularioNovaFuncao(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro-funcao.jsp");
			dispatcher.forward(request, response);
		}
		
		private void cadastrarFuncao(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException {
			
			String cnpj = request.getParameter("cnpj");
			Empresa empresa = daoEmpresa.recuperarEmpresa(cnpj);
			String nome = request.getParameter("nome-funcao");
			daoFuncao.cadastrarFuncao(new Funcao(empresa, nome));
			
			response.sendRedirect("funcao");
		}
}
