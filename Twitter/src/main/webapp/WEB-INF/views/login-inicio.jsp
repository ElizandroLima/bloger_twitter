<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

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
				<sf:form modelAttribute="loginModelo">
					<p>
						<sf:input path="email" type="email" name="email" id="email" placeholder="Email" required="required" />
						<sf:errors path="email"></sf:errors>
					</p>
					<p>
						<sf:input path="senha" type="password" name="senha" id="senha" placeholder="Senha" required="required" />
						<sf:errors path="senha"></sf:errors>
					</p>					
					<p><input type="submit" value="Entrar"></p>
					<p><a href="criar-conta.jsp"><input type="button" value="Inscreva-se"></a></p>
				</sf:form>				
			</article> 
		</section>  	 
	</body>
</html>
