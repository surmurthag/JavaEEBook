<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="listeSports" required="true" type="java.util.List" %>
<%@ attribute name="retour" rtexprvalue="false" required="true" type="java.lang.String" 
	description="nom de la variable à valoriser avec le nombre de soprts" %>

<%@ variable name-from-attribute="retour" alias="nombreSports" variable-class="java.lang.Integer" scope="AT_END"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Liste des sports</h1>
<ul>
	<c:forEach items="${listeSports}" var="sport">
		<li>${sport}</li>
	</c:forEach>
	<c:set var="nombreSports" value="${listeSports.size()}"></c:set>
	<jsp:doBody></jsp:doBody>
</ul>