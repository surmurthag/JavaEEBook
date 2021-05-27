<%@page import="java.util.ArrayList"%>
<%@page import="fr.editions_eni.javaee.models.Sport"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mesTags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Utilisation des tags</title>
</head>
<body>
	<%
		List<String> sports = new ArrayList<>();
		sports.add("Badminton");
		sports.add("Squash");
		sports.add("Tennis");
		pageContext.setAttribute("sports", sports);
	%>
	<mesTags:Sports listeSports="${pageScope.sports}" retour="NB_SPORTS">
	</mesTags:Sports>
	nombre : ${NB_SPORTS}
</body>
</html>