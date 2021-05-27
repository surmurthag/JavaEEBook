<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
Cette page permet de comprendre 
le fonctionnement des éléments de script
--%>
    
<%!
  	//Déclarations des variables membres et des méthodes
  	private int compteur = 0;
 	
 	private void incrementer()
 	{
 		this.compteur++;
 	}
 	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exemples d'éléments de script</title>
</head>
<body>
	<%
		this.compteur=0;
		Random rd = new Random();
		int nombreAppels = rd.nextInt(21);
		for(int i=0;i<nombreAppels;i++)
		{
			this.incrementer();
		}
	%>
	
	<%
		if(this.compteur>10)
		{
	%>
		<p>Le compteur dépasse 10. Il vaut <%=compteur %></p>
	<%		
		}
		else
		{
	%>
		<p>Le compteur ne dépasse pas 10. Il vaut <%=compteur %></p>
	<%
		}
	%>
</body>
</html>