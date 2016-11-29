<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
<%@ include file="cabecalho.jspf"%>
</head>

<body onContextMenu="return false" onDragStart="return false">
	<header>
		<%@ include file="nav_login.jspf"%>
	</header>

	<!-- Conteudo -->
	<section id="container">
		<p class="titulo">Crie uma conta no Twitter</p>

		<article id="container-login">
			<sf:form modelAttribute="criarContaModelo">
				<p>
					<sf:errors path="email"></sf:errors>
				</p>
				<p>
					<sf:input path="email" type="text" placeholder="Email" required="required" />
				</p>				
				<p>
					<sf:input path="nome" type="text" placeholder="Nome completo" required="required" />
				</p>
				<p>
					<sf:errors path="nome"></sf:errors>
				</p>
				<p>
					<sf:input path="username" type="text" placeholder="Nome de usuário" required="required" />
				</p>
				<p>
					<sf:errors path="username"></sf:errors>
				</p>
				<p>
					<sf:input path="password" type="password" placeholder="Senha" required="required" />
				</p>
				<p>
					<sf:errors path="password"></sf:errors>
				</p>
				<p>
					<i>* O nome de usuário não poderá ser alterado mais tarde!</i>
				</p>
				<p>
					<input type="submit" value="Criar conta" />
				</p>
			</sf:form>
		</article>
	</section>
</body>
</html>
