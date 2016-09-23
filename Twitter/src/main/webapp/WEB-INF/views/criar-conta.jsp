<!DOCTYPE html> 
<html lang="pt-br"> 
	<head> 
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1"> 
		<meta name="MobileOptimized" content="320">
		<meta name="HandheldFriendly" content="True">
		<meta name="description" content="Twitter">
		<meta name="keywords" content="Twitter">
		<meta http-equiv="refresh" content="300"> <!-- Auto-refresh -->
		
		<title>.:Twitter:.</title>
		<link rel="icon" href="../css/imagens/icone_twitter.png" />	
		<link rel="stylesheet" type="text/css" href="../css/estilo.css" />    
	</head> 

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
			<p class="titulo">Crie uma conta no Twitter</p> 
						
			<article id="container-login">
				<form action="#" method="POST">
					<p><input type="text" name="nome-usuario" id="nome-usuario" placeholder="Nome de usuário" required="required" /></p>
					<p><input type="text" name="nome" id="nome" placeholder="Nome completo" required="required" /></p>
					<p><input type="email" name="email" id="email" placeholder="Email" required="required" /></p>
					<p><input type="password" name="senha" id="senha" placeholder="Senha" required="required" /></p>
					<p><input type="password" name="csenha" id="csenha" placeholder="Confirmar senha" required="required" /></p>
					
					<p><input type="submit" value="Inscreva-se"></p> 
				</form>				
			</article> 
		</section>  	 
	</body>
</html>
