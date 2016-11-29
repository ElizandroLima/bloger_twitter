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
					
		<section id="mensagens">	
			<p class="titulo">Busca de Amigos</p> 
			<c:forEach items="${retornoPesquisa}" var="u">
			<article id="mensagens-conteudo">
				<header>					
					<img class="usuario-imagem" src="./resources/uploads/${u.imagem}" alt="Foto do Perfil" />
					<form action="perfil-usuario" method="GET">
						<p>
							<input style="display: none;" type="text" name="codigoUsuario" value="${u.codigo}">
							<a href="perfil-usuario?codigoUsuario=${u.codigo}">${u.nome}</a>
						</p>
					</form> 
				</header>
				<div class="clear"></div>
			</article> 
			<div class="clear"></div>
			</c:forEach>
		</section>  
	</body>
</html>
