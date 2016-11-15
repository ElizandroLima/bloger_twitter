<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html> 
<html lang="pt-br"> 
	<head>
		<%@ include file="cabecalho.jspf" %>
	</head>

	<body onContextMenu="return false" onDragStart="return false">
		<header> 	
			<%@ include file="nav_inicio.jspf" %>
		</header>  
		 
		<section id="container">	
			<p class="titulo">Novo Tweet</p> 
						
			<article id="container-login">
				<%-- SUBSTITUIR O DE BAIXO PELO COMENTADO QUE CONTÉM O CORRETO  
				<form:errors path="*" />
				<form:form modelAttribute="novoTweetModelo"> 
					<p><form:errors path="mensagem"></form:errors></p>
					<p>
						<form:label path="mensagem" class="campo-form">Meu Tweet:</form:label>
						<form:input path="mensagem" type="text" required="required" />
					</p>
					<p><input type="submit" value="Tweetar"></p> 
				</form:form> --%>	
				
				<form>  
					<p>						
						<textarea name="mensagem" rows="10" cols="80" required="required">Digite aqui seu Tweet!</textarea>
					</p>
					<p><input type="submit" value="Tweetar"></p> 
				</form>		
			</article> 
		</section>  		 
	</body>
</html>
