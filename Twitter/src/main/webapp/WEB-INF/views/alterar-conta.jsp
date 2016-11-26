<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html> 
<html lang="pt-br"> 
	<head>
		<%@ include file="cabecalho.jspf" %> 
	</head>

	<body onContextMenu="return false" onDragStart="return false">
		<header> 	
			<%@ include file="nav_inicio.jspf" %>
		</header>  
		 
		<section id="container">	
			<p class="titulo">Alterar meus dados pessoais</p> 
						
			<article id="container-login">
				<form:errors path="*" />
				<form:form modelAttribute="alterarContaModelo" enctype="multipart/form-data"> 
					<p><form:input path="usuario.codigo" type="hidden" /></p>
					<p><form:errors path="usuario.nomeUsuario"></form:errors></p>
					<p>
						<form:label path="usuario.nomeUsuario" class="campo-form">Nome de usuário:</form:label>
						<form:input path="usuario.nomeUsuario" type="text" readonly="true" />
					</p>
					<p><form:errors path="usuario.nome"></form:errors></p>
					<p>
						<form:label path="usuario.nome" class="campo-form">Nome completo:</form:label>
						<form:input path="usuario.nome" type="text" required="required" />
					</p>
					<p><form:errors path="usuario.email"></form:errors></p>
					<p>
						<form:label path="usuario.email" class="campo-form">Email:</form:label>
						<form:input path="usuario.email" type="email" required="required" />
					</p>
					<p><form:errors path="usuario.senha"></form:errors></p>
					<p>
						<form:label path="usuario.senha" class="campo-form">Alterar senha:</form:label>
						<form:input path="usuario.senha" type="password" required="required" />
					</p>
					<p><form:errors path="confirmacaoSenha"></form:errors></p>
					<p>
						<label for="confirmacaoSenha" class="campo-form">Confirme sua senha:</label>
						<input type="password" name="confirmacaoSenha" id="confirmacaoSenha" required="required" />
					</p>
					<p>
						<label for="imagem" class="campo-form">Foto:</label>
						<input id="imagem" name="imagem" type="file" accept="image/*" />
					</p>					
					<p><form:errors path="usuario.imagem"></form:errors></p>
					
					<p><input type="submit" value="Alterar conta"></p> 
				</form:form>				
			</article> 
		</section>  		 
	</body>
</html>
