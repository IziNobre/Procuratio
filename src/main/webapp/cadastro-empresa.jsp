<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>

<head>

<meta charset="UTF-8" />
<title>Procuratio</title>
<style>
<%@ include file="/resources/css/procuratio.css"%>
</style>

</head>

<body>

	<div class="cabecalho-procuratio">
		<span>Procuratio</span>
		<div class="cabecalho-esquerda">
			<a class="active" href="#home">Home</a> 
			<a href="#minha-area">Minha	Àrea</a> 
			<a href="#contato">Contato</a> 
			<img src="avatar.png" alt="Avatar" class="avatar">
		</div>
	</div>

	<main>
			<div class="container-cadastro-empresa">
				<br>
				<div class="cabecalho-cadastro-empresa">
					<a>Cadastro de Empresa</a>
				</div>
				<br>
				<div class="cadastro-empresa-opcoes">
					<a class="active" href="#dadoscadastrais">Dados Cadastrais</a> 
					<a href="#contato">Contato</a> 
					<a href="#endereco">Endereco</a>
				</div>
				<br>
				<div class="campos-preenchimento-empresa-dadoscadastrais">
					<br>
					<br>
					<br>
					<br> 
					
					<form method="post" action="inserir-empresa">
					
					<label for="nome-empresa">Nome Empresa</label> 
					<input type="text" id="nome-empresa" name="nome-empresa"> 
					<label for="CNPJ">CNPJ</label> 
					<input type="text" id="cnpj" name="cnpj">
					<label for="telefone-fixo">Telefone Fixo</label> 
					<input type="text" id="telefone-fixo" name="telefone-fixo"> 
					<label for="telefone-celular">Telefone Celular</label> 
					<input type="text" id="telefone celular" name="telefone-celular"> 
					<label for="email">E-mail</label> 
					<input type="text" id="email" name="email"> 
					<label for="logradouro">Logradouro</label> 
					<input type="text" id="logradouro" name="logradouro"> 
					<label for="numero">Numero</label> 
					<input type="text" id="numero"	name="numero"> 
					<label for="complemento">Complemento</label>
					<input type="text" id="complemento" name="complemento"> 
					<label for="CEP">CEP</label> 
					<input type="text" id="cep" name="cep">
					<label for="bairro">Bairro</label> 
					<input type="text" id="bairro" name="bairro"> 
					<label for="cidade">Cidade</label> 
					<input type="text" id="cidade" name="cidade"> 
					<label for="estadouf">Estado(UF)</label> 
					<input type="text" id="uf" name="uf">
				</div>
				
				<input type="submit" value="Cadastrar">
				
				</form>
</body>
</html>
>
