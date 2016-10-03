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
