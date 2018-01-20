<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
		<td>Titulo</td>
		<td>Descrição</td>
		<td>Preço</td>
	</tr>
	${msg}
	<br/>
	<c:forEach items="${produtos}" var="produto">
	<tr>
		<td>${produto.title}</td>
		<td>${produto.description}</td>
		
		<td>
			<c:forEach items="${produto.prices}" var="preco">
				${preco.bookType} - ${preco.value}
			</c:forEach>
		</td>
		
		<td>
			<c:url value="/products/${produto.id}" var="linkDetalhar"/>
			<a href="${linkDetalhar}">
				Detalhar
			</a>
		</td>
	</tr>
	</c:forEach>
	
	
	</table>
</body>
</html>