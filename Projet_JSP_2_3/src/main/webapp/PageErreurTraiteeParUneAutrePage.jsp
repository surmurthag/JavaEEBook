<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./PageTraitantLesErreurs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cette page provoque une erreur</title>
</head>
<body>
	<p>Une erreur non gérée par un try/catch est levée :</p>
	<%
		String chaine = null;
		//out.flush();//permet de simuler qu'un début de réponse a déjà été renvoyé au client
		out.write(chaine.toUpperCase());
	%>
</body>
</html>