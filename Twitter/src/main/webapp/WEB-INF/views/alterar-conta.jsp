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
				<ul>
					<a href="inicio.html">
						<li>
							<img class="menu-icone" src="../css/imagens/icone_inicio.png" alt="Início" />
							<p class="menu-titulo">Início</p>
						</li>
					</a>
					<a href="meu-perfil.html">
						<li>
							<img class="menu-icone" src="../css/imagens/icone_perfil.png" alt="Meu Perfil" />
							<p class="menu-titulo">Meu Perfil</p>
						</li>
					</a>
					<li>
						<img class="menu-icone" src="../css/imagens/icone_buscar.png" alt="Buscar" />
						<p><input class="menu-input-buscar" type="text" placeholder="Buscar" /></p>
					</li>
					<li>
						<a href="alterar-conta.html"><img class="menu-icone" src="../css/imagens/icone_dados.png" alt="Alterar Meu Perfil" title="Alterar Meu Perfil" /></a>
					</li>
					<li>
						<a href="novo-tweet.html"><img class="menu-icone" src="../css/imagens/icone_mensagem.png" alt="Novo Tweet" title="Novo Tweet" /></a>
					</li>
				</ul> 					
			</nav>	 
		</header>  
		 
		<!-- Conteúdo -->		
		<section id="container">	
			<p class="titulo">Alterar meus dados pessoais</p> 
						
			<article id="container-login">
				<form action="#" method="POST" enctype="multipart/form-data">
					<p>
						<label for="nome-usuario" class="campo-form">Nome de usuário:</label>
						<input type="text" name="nome-usuario" id="nome-usuario" required="required" disabled="disabled" />
					</p>
					<p>
						<label for="nome" class="campo-form">Nome completo:</label>
						<input type="text" name="nome" id="nome" required="required" />
					</p>
					<p>
						<label for="email" class="campo-form">Email:</label>
						<input type="email" name="email" id="email" required="required" />
					</p>
					<p>
						<label for="senha" class="campo-form">Alterar senha:</label>
						<input type="password" name="senha" id="senha" required="required" />
					</p>
					<p>
						<label for="csenha" class="campo-form">Confirme sua senha:</label>
						<input type="password" name="csenha" id="csenha" required="required" />
					</p>
					<p>
						<label for="imagem" class="campo-form">Foto:</label>
						<input type="file" name="imagem" id=imagem accept="image/*">
					</p>
					<p><input type="submit" value="Inscreva-se"></p> 
				</form>				
			</article> 
		</section>  		 
	</body>
</html>
