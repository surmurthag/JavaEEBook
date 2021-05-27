<%@page import="fr.editions_eni.javaee.models.Sport"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des sports</title>
</head>
<body>
	<jsp:include page="/WEB-INF/fragments/entete.jsp">
		<jsp:param value="PageAffichantLesSports" name="origine"/>
	</jsp:include>
	<p>Voici une liste déroulante affichant les sports</p>
	
	<%
		List<Sport> sports = (List<Sport>)request.getAttribute("listeSports");
	%>
	
	
	<%
		if(sports!=null)
		{
	%>
			<select>
				<% 
					for(Sport sport:sports)
					{
				%>
						<option><%=sport.getNom()%></option>
				<%
					}
				%>
			</select>
	<%
		}
		else
		{
	%>
			<P>Pas de sport disponible</p>
	<%
		}
	%>
	
	<%@include file="../fragments/piedDePage.html" %>
</body>
</html>