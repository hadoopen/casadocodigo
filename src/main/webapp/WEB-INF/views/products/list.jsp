<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="cdc"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>


 <cdc:page title="Listagem de Produtos">
 
	<sec:authorize access="isAuthenticated()">

	<sec:authentication property="principal" var="user" />
		<div>
			<spring:message code="users.welcome" arguments="${user.name}" />
		</div>
	</sec:authorize>
	
   <sec:authorize access="hasRole('ROLE_ADMIN')">
	   <c:url value="/products/form" var="formLink" />
	   <a href="${formLink}"/>
	   	Cadastrar novo Produto
	   </a>
   </sec:authorize>
   
 
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
  
  
  </cdc:page>