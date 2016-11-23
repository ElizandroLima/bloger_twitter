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
					<img class="usuario-imagem" src="./resources/css/imagens/imagem_perfil.png" alt="Foto do Perfil" />
					<p>TESTE</p>
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
		</aside>	
					
		<section id="mensagens">	
			<p class="titulo">Busca de Amigos</p> 
			<!-- Inicio do for -->		
			<article id="mensagens-conteudo">
				<header>					
					<img class="usuario-imagem" src="css/imagens/imagem_perfil.png" alt="Foto do Perfil" />
					<p>
						<a href="#">Carlos Alberto</a>
					</p>
				</header>
				<div class="clear"></div>
			</article> 
			<div class="clear"></div>
			<!-- Fim do for -->
		</section>  
	</body>
</html>
