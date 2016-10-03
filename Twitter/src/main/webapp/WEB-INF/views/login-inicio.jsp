<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<!DOCTYPE html> 
<html lang="pt-br"> 
	<head>
	<!-- Corrigir a exibicao do fragmento -->
		<jsp:include page="cabecalho.jspf" />
	</head>

	<!-- Não permite arrastar e soltar imagens -->
	<body onContextMenu="return false" onDragStart="return false">
		<!-- Cabeçalho -->
		<header> 	
			<nav id="menu-principal">
				<ul class="login-icone"> 
					<li>
						<img class="login-icone" src="./resources/css/imagens/icone_inicio.png" alt="Twitter" />
					</li>
				</ul> 					
			</nav>	 
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
					<p><a href="criar-conta.html"><input type="button" value="Inscreva-se"></a></p>
				</sf:form>				
			</article> 
		</section>  	 
	</body>
</html>
