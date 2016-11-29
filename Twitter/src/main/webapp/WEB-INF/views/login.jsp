<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html> 
<html lang="pt-br"> 
	<head>
		<%@ include file="cabecalho.jspf" %>
	</head>

	<!-- Não permite arrastar e soltar imagens -->
	<body onContextMenu="return false" onDragStart="return false">
		<!-- Cabeçalho --> 
		<header> 	
			<%@ include file="nav_login.jspf" %>
		</header>  
		 
		<!-- Conteúdo -->
		<section id="container">	 
			<p class="titulo">Acesse sua conta no Twitter</p> 
						
			<article id="container-login">
				<form:form servletRelativeAction="/login">
					<p>
						<input type="text" name="username" placeholder="Nome de usuário" class="form-control input-sm"/> 
					</p>
					<p>
						<input type="password" name="password" placeholder="Senha" class="form-control input-sm"/> 
					</p>	
					<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>				
					<p><input type="submit" value="Entrar"></p>
					<p><a href="/Twitter"><input type="button" value="Inscreva-se"></a></p>
				</form:form>				
			</article> 
		</section>  	 
	</body>
</html>
