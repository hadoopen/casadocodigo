<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>




<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> Cadastro de Livros</title>
</head>
<body>
	<c:url value="/products" var="url"/>
	<!-- PC é de ProductController - action="${spring:mvcUrl('PC#save').build()}" -->
		<form:form action="${spring:mvcUrl('PC#save').build()}" method="post" commandName="product">
			<div>
				<label for="title">Título</label>
				<form:input path="title" id="title"/>
				<form:errors path="title"/>
			</div>
			<div>
				<label for="description">Descricão</label>
				<form:textarea path="description" rows="10" cols="20" 
					id="description"/>
				<form:errors path="description" />	
							
			</div>
			<div>
				<label for="numberOfPages">Número de Páginas</label>
				<form:input path="numberOfPages" id="numberOfPages"/>
				<form:errors path="numberOfPages"/>
			</div>
			
			<div >
				<c:forEach items="${types}" var="bookType" varStatus="status">
					<div>
						<label for="price_${bookType}">${bookType}</label>
						<input type="text" name="prices[${status.index}].value" 
							id="price_${bookType}"/>
							
							<input type="hidden"
								name="prices[${status.index}].bookType"
								value="${bookType}"/>
					</div>
				</c:forEach>
			</div>
						
			<div>
				<input type="submit" value="Enviar">
			</div>
		</form:form>
 
</body>
</html>