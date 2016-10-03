<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

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
				<sf:form modelAttribute="criarContaModelo">
					<p><sf:input path="nome-usuario" type="text" name="nome-usuario" id="nome-usuario" placeholder="Nome de usuário" required="required" /></p>
					<p><sf:input path="nome" type="text" name="nome" id="nome" placeholder="Nome completo" required="required" /></p>
					<p><sf:input path="email" type="email" name="email" id="email" placeholder="Email" required="required" /></p>
					<p><sf:input path="senha" type="password" name="senha" id="senha" placeholder="Senha" required="required" /></p>
					<p><sf:input path="csenha" type="password" name="csenha" id="csenha" placeholder="Confirmar senha" required="required" /></p>
					
					<p><input type="submit" value="Inscreva-se"></p> 
				</sf:form>				
			</article> 
		</section>  	 
	</body>
</html>
