<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html> 
<html lang="pt-br"> 
	<head>
		<%@ include file="cabecalho.jspf" %>
	</head>

	<body onContextMenu="return false" onDragStart="return false">
		<header> 	
			<%@ include file="nav_login.jspf" %>
		</header> 
		 
		<!-- Conteudo -->
		<section id="container">	
			<p class="titulo">Crie uma conta no Twitter</p> 
						
			<article id="container-login">
				<form:errors path="*" />
				<form:form modelAttribute="criarContaModelo">
					<p><form:errors path="usuario.nomeUsuario"></form:errors></p>
					<p>
						<form:input path="usuario.nomeUsuario" type="text" placeholder="Nome de usuário" required="required" />
					</p>
					<p><form:errors path="usuario.nome"></form:errors></p>
					<p>
						<form:input path="usuario.nome" type="text" placeholder="Nome completo" required="required" />
					</p>
					<p><form:errors path="usuario.email"></form:errors></p>
					<p>
						<form:input path="usuario.email" type="email" placeholder="Email" required="required" />
					</p>
					<p><form:errors path="usuario.senha"></form:errors></p>
					<p>
						<form:input path="usuario.senha" type="password" placeholder="Senha" required="required" />
					</p>
					<p><form:errors path="confirmacaoSenha"></form:errors></p>
					<p>
						<input type="password" name="confirmacaoSenha" id="confirmacaoSenha" placeholder="Confirmar senha" required="required" />
					</p>
					<p><i>* O nome de usuário não poderá ser alterado mais tarde!</i></p>
					
					<p><input type="submit" value="Criar conta" /></p> 
				</form:form>				
			</article> 
		</section>  	 
	</body>
</html>
