<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cette page traite les erreurs</title>
</head>
<body>
	<h1>Une erreur est survenue</h1>
	<p>
		<%=exception.getClass().getName()%>
	</p>
	<p>
		<%=exception.getMessage()%>
	</p>
	<p>
		Veuillez cliquer sur ce lien pour continuer <a href="<%=request.getContextPath()%>/index.html">Cliquez ici</a>
	</p>
</body>
</html>