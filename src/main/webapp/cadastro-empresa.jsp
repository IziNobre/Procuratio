<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Procuratio</title>
        <style>
            <%@ include file="/resources/css/procuratioNovo.css"%>
        </style>
    </head>
    <body>
        <form method="post" action="inserir-empresa">
            <header>
                <div class="simboloP">  P  </div>
                <div class="logo">PROCURATIO</div>
                <div class="opcoes">
                    <a href="home">Home</a>
                </div>
                <div class="opcoes">
                    <a href="painelPrincipal">Painel Principal</a>
                </div>
                <div class="opcoes">
                    <a href="blog">Blog</a>
                </div>
                <div class="opcoes">
                    <a href="ajuda">Ajuda</a>
                </div>
                <div>
                <button class="btn-minhaConta">Minha Conta</button>
                </div>
            </header>
            <section class="containerCroudEmpresas">
                <div class="caminhoCroudEmpresas">
                    <p>Painel principal / Empresas / Novo Cadastro</p>
                </div>
                <div class="cadastroEmpresaCard">
                    <div class="novoCadastroEmpresa">
                        <p>Novo Cadastro Empresa</p>
                    </div>
                    <div class="cadastroEmpresaCardBody">
                        <div class="cadastroEmpresaCardField">
                            <label for="nomeEmpresa">Nome da Empresa</label>
                            <input type="text" id="nomeEmpresa" name="nome" placeholder="Digite nome Empresa">
                        </div>
                        <div class="cadastroEmpresaCardField">
                            <label for="cnpj">CNPJ</label>
                            <input type="text" id="cnpj" name="cnpj" placeholder="Digite CNPJ">
                        </div>
                        <div class="cadastroEmpresaCardField">
                            <label for="senha">Senha de Login</label>
                            <input type="text" id="senha" name="senha" placeholder="Digite sua senha">
                        </div>
                        <div>
                        </div>
                        <div class="cadastroEmpresaCardContact">
                            <div class="cadastroEmpresaCardField">
                                <label for="telefoneFixo">Telefone Fixo</label>
                                <input type="text" id="telefoneFixo" name="telefone" placeholder="Digite telefone fixo">
                            </div>
                            <div class="cadastroEmpresaCardField">
                                <label for="email">E-mail</label>
                                <input type="text" id="email" name="email" placeholder="Digite o E-mail">
                            </div>
                            <div class="cadastroEmpresaCardField">
                                <label for="telefoneCelular">Telefone Celular</label>
                                <input type="text" id="telefoneCelular" name="celular" placeholder="Digite telefone celular">
                            </div>
                        </div>
                        <div>
                        </div>
                        <div class="cadastroEmpresaCardAddress">
                            <div class="cadastroEmpresaCardField">
                                <label for="logradouro">Logradouro</label>
                                <input type="text" id="logradouro" name="logradouro" placeholder="Digite o endereço">
                            </div>
                            <div class="cadastroEmpresaCardField">
                                <div class="cadastroEmpresaCardAddress">
                                    <div class="cadastroEmpresaCardField">
                                        <label for="numero">Número</label>
                                        <input type="text" id="numero" name="numero" placeholder="Digite o número">
                                    </div>
                                    <div class="cadastroEmpresaCardField">
                                        <label for="complemento">Complemento</label>
                                        <input type="text" id="complemento" name="complemento" placeholder="Digite o complemento">
                                    </div>
                                </div>
                            </div>
                            <div class="cadastroEmpresaCardField">
                                <div class="cadastroEmpresaCardAddress">
                                    <div class="cadastroEmpresaCardField">
                                        <label for="bairro">Bairro</label>
                                        <input type="text" id="bairro" name="bairro" placeholder="Digite o bairro">
                                    </div>
                                       <div class="cadastroEmpresaCardField">
                                        <label for="cidade">Cidade</label>
                                        <input type="text" id="cidade" name="cidade" placeholder="Digite a cidade">
                                    </div>
                                </div>
                            </div>
                            <div class="cadastroEmpresaCardField">
                                <div class="cadastroEmpresaCardAddress">
                                    <div class="cadastroEmpresaCardField">
                                        <label for="uf">UF</label>
                                        <input type="text" id="uf" name="uf" placeholder="Digite a UF">
                                    </div>
                                    <div class="cadastroEmpresaCardField">
                                        <label for="cep">CEP</label>
                                        <input type="text" id="cep" name="cep" placeholder="Digite o CEP">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="cadastroEmpresaCardButtons">
                            <button type="reset" value="Cancelar" onclick="javascript: location.href = '../procuratio/login.jsp'" class="btn-cancelar">Cancelar</button>
                            <button type="submit" value="Cadastrar" class="btn-cadastrarEmpresa" >Cadastrar</button>
                        </div>
                    </div>
                </div>
                 <div>
                    <div class="opcoesCadastroEmpresaEsquerda">
                        <div class="row">
                            <div class="col-25">
                                <label for="nomeEmpresa">Nome da Empresa</label>
                            </div>
                            <div class="col-75">
                                <input type="text" id="nomeEmpresa" name="nomeEmpresa" placeholder="Digite nome Empresa">
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-25">
                                <label for="telefoneFixo">Telefone Fixo</label>
                            </div>
                            <div class="col-75">
                                <input type="text" id="telefoneFixo" name="telefoneFixo" placeholder="Digite telefone fixo">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-25">
                                <label for="telefoneCelular">Telefone Celular</label>
                            </div>
                            <div class="col-75">
                                <input type="text" id="telefoneCelular" name="telefoneCelular" placeholder="Digite telefone celular">
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-25">
                                <label for="endereco">Endereço</label>
                        </div>
                            <div class="col-75">
                                <input type="text" id="endereco" name="endereco" placeholder="Digite o endereço">
                            </div>
                        </div>
                        <div class="opcoesCadastroEmpresaCepBairro">
                        <div class="row">
                            <div class="col-25">
                                <label for="cep">CEP</label>
                            </div>
                            <div class="col-75">
                                <input type="text" id="cep" name="cep" placeholder="Digite o CEP">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-25">
                                <label for="bairro">Bairro</label>
                            </div>
                            <div class="col-75">
                                <input type="text" id="bairro" name="bairro" placeholder="Digite o bairro">
                            </div>
                        </div>
                        </div>
                    </div>
                    <div class="opcoesCadastroEmpresaDireita">
                        <div class="row">
                            <div class="col-25">
                                <label for="cnpj">CNPJ</label>
                            </div>
                            <div class="col-75">
                                <input type="text" id="cnpj" name="cnpj" placeholder="Digite CNPJ">
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-25">
                                <label for="email">E-mail</label>
                            </div>
                            <div class="col-75">
                                <input type="text" id="email" name="email" placeholder="Digite o E-mail">
                            </div>
                        </div>
                        <br><br><br><br><br>
                        <div class="opcoesCadastroEmpresaNumeroComplemento">
                        <div class="row">
                            <div class="col-25">
                                <label for="numero">Número</label>
                            </div>
                            <div class="col-75">
                                <input type="text" id="numero" name="numero" placeholder="Digite o número">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-25">
                                <label for="complemento">Complemento</label>
                            </div>
                            <div class="col-75">
                                <input type="text" id="complemento" name="complemento" placeholder="Digite o complemento">
                            </div>
                        </div>
                        </div>
                        <div class="opcoesCadastroEmpresaUfCidade">
                        <div class="row">
                            <div class="col-25">
                                <label for="uf">UF</label>
                            </div>
                            <div class="col-75">
                                <input type="text" id="uf" name="uf" placeholder="Digite a UF">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-25">
                                <label for="cidade">Cidade</label>
                            </div>
                            <div class="col-75">
                                <input type="text" id="cidade" name="cidade" placeholder="Digite a cidade">
                            </div>
                        </div>
                        </div>
                        <br>
                            <button type="reset" value="Cancelar" class="btn-cancelar">Cancelar</button>
                            <button type="submit" value="Cadastrar" class="btn-cadastrarEmpresa" >Cadastrar </button>
                    </div>
                </div> 
            </section>
        </form>
        <footer>
        Desenvolvido por javaMinds ©
        </footer>
    </body>
</html>