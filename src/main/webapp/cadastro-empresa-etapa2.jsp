<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

    <meta charset="UTF-8" />
    <title>Procuratio</title>
  <style>
        <%@include file="/resources/css/procuratio.css"%>
    </style>


</head>

<body>

  <div class="cabecalho-procuratio">
        <span>Procuratio</span>  
        <div class="cabecalho-esquerda">
            <a href="<%=request.getContextPath() %>/  ">Home</a>
            <a href="<%=request.getContextPath() %>/ ">Minha area</a>
            <a href="<%=request.getContextPath() %>/  ">Contato</a>
            <img src="avatar.png" alt="Avatar" class="avatar">
        </div>
    </div>
    <main>
        <div class="centraliza-cadastro-empresa">

            <div class="container-cadastro-empresa">
                    <br>
                <div class="cabecalho-cadastro-empresa">
                    <a>Cadastro de Empresa</a>
                </div>
                    <br>
                <div class="cadastro-empresa-opcoes">
                    <a href="<%=request.getContextPath() %>/  ">Dados Cadastrais</a>
                    <a class="active" href="<%=request.getContextPath() %>/  ">Contato</a>
                    <a href="<%=request.getContextPath() %>/  ">Endereco</a>
                </div>
                    <br>            
                <div class="campos-preenchimento-empresa-contato">
                    <br><br><br><br>
                    <label for="telefonefixo">Telefone Fixo</label>
                    <input type="text">
                    <label for="telefonecelular">Telefone Celular</label>
                    <input type="text">
                    <label for="email">E-mail</label>
                    <input type="text">
                </div>
                    <br>
                <div>
                <button class="proximo">Próximo</button>
                <button class="voltar">Voltar</button>
                </div>
            </div>
        </div>
    </main>