<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- Taglib para o JSTL dentro do HTML -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html> 
<html lang="pt-br"> 
	<c:import url="cabecalho.jsp"></c:import>

	<!-- Não permite arrastar e soltar imagens -->
	<body onContextMenu="return false" onDragStart="return false">
		<!-- Cabeçalho -->
		<header> 	
			<nav id="menu-principal">
				<ul class="login-icone"> 
					<li>
						<img class="login-icone" src="../css/imagens/icone_inicio.png" alt="Twitter" />
					</li>
				</ul> 					
			</nav>	 
		</header>  
		 
		<!-- Conteúdo -->
		<section id="container">	
			<p class="titulo">Acesse sua conta no Twitter</p> 
						
			<article id="container-login">
				<form:form action="/bem-vindo" method="POST">
					<p><input type="email" name="email" id="email" placeholder="Email" required="required" /></p>
					<p><input type="password" name="senha" id="senha" placeholder="Senha" required="required" /></p>
					
					<p><input type="submit" value="Entrar"></p>
					<p><a href="criar-conta.html"><input type="button" value="Inscreva-se"></a></p>
				</form:form>				
			</article> 
		</section>  	 
	</body>
</html>
