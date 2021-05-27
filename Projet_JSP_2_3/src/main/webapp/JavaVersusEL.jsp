<%@page import="fr.editions_eni.javaee.models.Adresse"%>
<%@page import="fr.editions_eni.javaee.models.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java versus EL</title>
</head>
<body>
	<h1>Affichage du client en utilisant Java</h1>
	<%
		Client client = (Client)session.getAttribute("unClient");
		if(client!=null)
		{
	%>
			Nom: <%=client.getNom()%><br/>
			Prénom: <%=client.getPrenom()%><br/>
			E-mail: <%=client.getEmail()!=null?client.getEmail():""%><br/>
			<%
				if(client.getAdresse()!=null)
				{
					Adresse adresse = client.getAdresse();
			%>
					Rue: <%=adresse.getRue()%><br/>
					CodePostal: <%=adresse.getCodePostal()%><br/>
					Ville: <%=adresse.getVille() %><br/>
			<%
				}
			%>
	<%
		}
	%>
	
	
	<h1>Affichage du client en utilisant l'EL</h1>
	Nom: ${sessionScope.unClient.nom }<br/>
	Prénom: ${sessionScope.unClient.prenom }<br/>
	E-mail: ${sessionScope.unClient.email }<br/>
	Rue: ${sessionScope.unClient.adresse.rue }<br/>
	CodePostal: ${sessionScope.unClient.adresse.codePostal }<br/>
	Ville: ${sessionScope.unClient.adresse.ville }<br/>
	
</body>
</html>