<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
		<aside id="info">
			<section id="usuario">
				<div class="usuario-perfil">
					<img class="usuario-imagem" src="../css/imagens/imagem_perfil.png" alt="Foto do Perfil" />
					<p>Bianca de Lima</p>
				</div>
				<div class="usuario-numeros">
					<p>18.524</p>
					<p>Tweets</p>
				</div>
				<div class="usuario-numeros">
					<p>1.004</p>
					<p>Seguindo</p>
				</div>
				<div class="usuario-numeros">
					<p>4.541</p>
					<p>Seguidores</p>
				</div>				
			</section>
			 
			<div class="clear"></div>
			<section class="seguidores">
				<p class="titulo">Seguindo</p> 
				<div class="seguidores-info">
					<img class="usuario-imagem" src="../css/imagens/imagem_perfil.png" alt="Foto do Perfil" />
					<p>Carlos Alberto</p>
				</div>				
				<div class="clear"></div>
				<div class="seguidores-info">
					<img class="usuario-imagem" src="../css/imagens/imagem_perfil.png" alt="Foto do Perfil" />
					<p>Carlos Alberto</p>
				</div>			 
			</section>			
			
			<div class="clear"></div>
			
			<section class="seguidores">
				<p class="titulo">Seguidores</p> 
				<div class="seguidores-info">
					<img class="usuario-imagem" src="../css/imagens/imagem_perfil.png" alt="Foto do Perfil" />
					<p>Ana Maria</p>
				</div>				
				<div class="clear"></div> 			 
			</section>			 
		</aside>				
		<section id="mensagens">	
			<p class="titulo">Tweets</p> 
						
			<article id="mensagens-conteudo">
				<header>					
					<img class="usuario-imagem" src="../css/imagens/imagem_perfil.png" alt="Foto do Perfil" />
					<p>Carlos Alberto</p>
				</header>
				<div class="clear"></div>
				<p class="mensagens-texto">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce et lacinia diam, sit amet interdum neque. Donec a nisi nec dui semper hendrerit. Nunc eu porttitor elit, sed scelerisque nunc. Duis pulvinar sapien in turpis cursus maximus. Proin dapibus sollicitudin rhoncus. Nulla viverra ullamcorper ullamcorper. Suspendisse tincidunt accumsan facilisis.</p>				
				<div class="clear"></div>
				<footer>	
					<a href="#">
						<img class="mensagens-retweet" src="../css/imagens/icone_retweet.png" alt="Retwittar" title="Retwittar" />
					</a>			
				</footer>
			</article>
			<div class="clear"></div>
			
			<article id="mensagens-conteudo">
				<header>					
					<img class="usuario-imagem" src="../css/imagens/imagem_perfil.png" alt="Foto do Perfil" />
					<p>Carlos Alberto</p>
				</header>
				<div class="clear"></div>
				<p class="mensagens-texto">Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>				
				<div class="clear"></div>
				<footer>	
					<a href="#">
						<img class="mensagens-retweet" src="../css/imagens/icone_retweet.png" alt="Retwittar" title="Retwittar" />
					</a>			
				</footer>
			</article>
		</section>  	 
	</body>
</html>
