<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html> 
<html lang="pt-br"> 
	<head>
		<%@ include file="cabecalho.jspf" %>
	</head>

	<!-- N�o permite arrastar e soltar imagens -->
	<body onContextMenu="return false" onDragStart="return false">
		<!-- Cabe�alho --> 
		<header> 	
			<%@ include file="nav_login.jspf" %>
		</header>  
		 
		<!-- Conte�do -->
		<section id="container">	 
			<p class="titulo">Acesso Negado!</p> 
						
			<article id="container-login"> 
				<img src="./resources/css/imagens/icone_acesso_negado.png" alt="Acesso Negado" />
				<p>A p�gina que voc� est� tentando acessar possui acesso restrito! Efetue login para acess�-la!</p>
			</article> 
		</section>  	 
	</body>
</html>
