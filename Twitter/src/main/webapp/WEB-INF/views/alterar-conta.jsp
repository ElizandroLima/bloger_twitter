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
					<p><form:input path="codigo" type="hidden" /></p>
					
					<p><form:errors path="username"></form:errors></p>
					<p>
						<form:label path="username" class="campo-form">Nome de usuário:</form:label>
						<form:input path="username" type="text" readonly="true" />
					</p>
					<p><form:errors path="nome"></form:errors></p>
					<p>
						<form:label path="nome" class="campo-form">Nome completo:</form:label>
						<form:input path="nome" type="text" required="required" />
					</p>
					<p><form:errors path="email"></form:errors></p>
					<p>
						<form:label path="email" class="campo-form">Email:</form:label>
						<form:input path="email" type="email" required="required" />
					</p>
					<p><form:errors path="password"></form:errors></p>
					<p>
						<form:label path="password" class="campo-form">Alterar password:</form:label>
						<form:input path="password" type="password" required="required" />
					</p>
					<p>
						<label for="imagemPerfil" class="campo-form">Foto:</label>
						<input name="imagemPerfil" id="imagemPerfil" type="file" accept="image/*" />
					</p>					
					<p><form:errors path="imagem"></form:errors></p>
					
					<p><input type="submit" value="Alterar conta"></p> 
				</form:form>				
			</article> 
		</section>  		  
	</body>
</html>
