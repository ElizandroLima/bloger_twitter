<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html> 
<html lang="pt-br"> 
	<head>
		<%@ include file="cabecalho.jspf" %>
	</head>

	<!-- Não permite arrastar e soltar imagens -->
	<body onContextMenu="return false" onDragStart="return false">
		<!-- Cabeçalho -->
		<header> 	
			<%@ include file="nav_inicio.jspf" %> 
		</header>  
		 
		<!-- Conteúdo -->
		<aside id="info">
			<section id="usuario">
				<div class="usuario-perfil">
					<img class="usuario-imagem" src="./resources/uploads/${usuarioModelo.imagem}" alt="Foto do Perfil" />
					<p>${usuarioModelo.nome}</p>
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
					<img class="usuario-imagem" src="./resources/uploads/imagem_perfil.png" alt="Foto do Perfil" />
					<p>Carlos Alberto</p>
				</div>				
				<div class="clear"></div>
				<div class="seguidores-info">
					<img class="usuario-imagem" src="./resources/uploads/imagem_perfil.png" alt="Foto do Perfil" />
					<p>Carlos Alberto</p>
				</div>			 
			</section>			
			
			<div class="clear"></div>
			
			<section class="seguidores">
				<p class="titulo">Seguidores</p> 
				<div class="seguidores-info">
					<img class="usuario-imagem" src="./resources/uploads/imagem_perfil.png" alt="Foto do Perfil" />
					<p>Ana Maria</p>
				</div>				
				<div class="clear"></div> 			 
			</section>			 
		</aside>	
					
		<section id="mensagens">	
			<p class="titulo">Meus Tweets</p> 
						
			<article id="mensagens-conteudo">
				<header>					
					<img class="usuario-imagem" src="./resources/uploads/imagem_perfil.png" alt="Foto do Perfil" />
					<p>Carlos Alberto</p>
				</header>
				<div class="clear"></div>
				<p class="mensagens-texto">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce et lacinia diam, sit amet interdum neque. Donec a nisi nec dui semper hendrerit. Nunc eu porttitor elit, sed scelerisque nunc. Duis pulvinar sapien in turpis cursus maximus. Proin dapibus sollicitudin rhoncus. Nulla viverra ullamcorper ullamcorper. Suspendisse tincidunt accumsan facilisis.</p>				
				<div class="clear"></div> 
			</article>
			<div class="clear"></div>  
		</section>  	 
	</body>
</html>
