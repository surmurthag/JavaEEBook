<%@page import="fr.editions_eni.javaee.models.Sport"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="fr.editions_eni.javaee.models.Adresse"%>
<%@page import="fr.editions_eni.javaee.models.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
			//Création d'un client
			Client client = new Client("RICHARD", "Thierry", new Adresse("7 rue de la République", 35000, "RENNES"), null);
			//Client client = new Client("RICHARD", "Thierry", null, "sonemail@sondomaine.fr");
			
			//Placement du client en session
			request.getSession().setAttribute("unClient", client);
			
			//Création d'une liste de sports
			List<Sport> sports = new ArrayList<>();
			sports.add(new Sport("Badminton",2));
			sports.add(new Sport("Tennis",2));
			sports.add(new Sport("Padel",4));
	
			//Placement de la liste en attribut de requête
			request.setAttribute("sports", sports);
			
	%>
	
	<c:set target="${sessionScope.unClient}" property="email" value="sonemail@sondomaine.fr"></c:set>
	<c:out value="${sessionScope.unClient.email}" default="pas d'e-mail"></c:out>
	
	<br/>
	
	<c:if test="${empty sessionScopt.unClient.email}">
		L'e-mail est obligatoire
	</c:if>
	
	<br/>
	
	<c:choose>
		<c:when test="${empty sessionScope.unClient.nom}">
			Le nom n'est pas renseigné
		</c:when>
		<c:when test="${empty sessionScope.unClient.prenom}">
			Le prénom n'est pas renseigné
		</c:when>
		<c:when test="${empty sessionScope.unClient.email}">
			L'e-mail n'est pas renseigné
		</c:when>
		<c:otherwise>
			Tout est renseigné
		</c:otherwise>
	</c:choose>
	
	<br/>
	
	<c:forEach var="sport" items="${requestScope.sports}">
		Le sport ${sport.nom} se joue à ${sport.nombreJoueurs}<br/>
	</c:forEach>
	
	<br/>
	
	<c:set var="chaineDeSport" value="Badminton,Squash;Tennis"></c:set>
	<c:forTokens var="nomSport" items="${chaineDeSport}" delims=";,">
		Un Sport : ${nomSport}<br/>
	</c:forTokens>
	
	<br/>
	
	<c:url value="/index.html" var="urlReecrite" scope="page"></c:url>
	<c:out value="${pageScope.urlReecrite}"/>
	
</body>
</html>