<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
			<p class="titulo">Acesso Negado!</p> 
						
			<article id="container-login"> 
				<img src="./resources/css/imagens/icone_acesso_negado.png" alt="Acesso Negado" />
				<p>A página que você está tentando acessar possui acesso restrito! Efetue login para acessá-la!</p>
			</article> 
		</section>  	 
	</body>
</html>
