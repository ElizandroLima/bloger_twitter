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
					<p>
						<sf:input path="nomeUsuario" type="text" name="nomeUsuario" id="nomeUsuario" placeholder="Nome de usuário" required="required" />
						<sf:errors path="nomeUsuario"></sf:errors>
					</p>
					<p>
						<sf:input path="nome" type="text" name="nome" id="nome" placeholder="Nome completo" required="required" />
						<sf:errors path="nome"></sf:errors>
					</p>
					<p>
						<sf:input path="email" type="email" name="email" id="email" placeholder="Email" required="required" />
						<sf:errors path="email"></sf:errors>
					</p>
					<p>
						<sf:input path="senha" type="password" name="senha" id="senha" placeholder="Senha" required="required" />
						<sf:errors path="senha"></sf:errors>
					</p>
					<p>
						<input type="password" name="csenha" id="csenha" placeholder="Confirmar senha" required="required" />
					</p>
					
					<p><input type="submit" value="Inscreva-se"></p> 
				</sf:form>				
			</article> 
		</section>  	 
	</body>
</html>
