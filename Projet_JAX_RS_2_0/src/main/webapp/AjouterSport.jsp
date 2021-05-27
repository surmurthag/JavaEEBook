<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter un sport</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/REST/Sports" method="post">
		<p>Ajouter un sport</p>
		<label for="nom">Nom:</label>
		<input type="text" name="nom" id="nom"/><br/>
		<label for="nombreJoueurs">Nombre de joueurs:</label>
		<input type="text" name="nombreJoueurs" id="nombreJoueurs"/><br/>
		<input type="submit" value="Valider">
	</form>
</body>
</html>