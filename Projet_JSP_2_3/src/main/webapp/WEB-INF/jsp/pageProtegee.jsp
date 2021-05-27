<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="prefix" tagdir="/WEB-INF/tags" %>

<%!
@Override
public void jspInit()
{
	System.out.println(this.getInitParameter("auteur"));
	System.out.println("coucou from jspInit()");
}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Page protégée</title>
	</head>
	<body>
		<prefix:Bonjour/>
		Page protégée
		<%@ include file="../fragments/piedDePage.html" %>
	</body>
</html>