<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exemple utilisation des JavaBean</title>
</head>
<body>
	<!-- 
		Déclaration du JavaBean de type Sport
		Il sera recherché en session avant une éventuelle création 
	-->
	<jsp:useBean 
	id="sportPrefere" 
	scope="session" 
	class="fr.editions_eni.javaee.models.Sport">
			<!-- Initialisation de la propriété nom en cas du création du JavaBean -->
<%-- 		<jsp:setProperty name="sportPrefere" property="nom" value="badminton"/> --%>
	</jsp:useBean>
		
		<!-- Application de la valeur squash à la propriété nom-->
<%-- 	<jsp:setProperty name="sportPrefere" property="nom" value="squash"/> --%>
	
	<!-- Application d'une valeur dynamique à la propriété nom -->
	<% 
	//...
	String variableSport="padel";
	//...
	%>
	<jsp:setProperty 
		name="sportPrefere" 
		property="nom" 
		value="<%=variableSport%>"/>
	
	<!-- Lecture et affichage de la propriété nom dans la réponse -->
	<jsp:getProperty name="sportPrefere" property="nom" />
</body>
</html>