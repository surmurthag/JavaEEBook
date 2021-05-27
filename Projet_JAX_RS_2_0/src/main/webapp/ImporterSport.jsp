<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Importer un sport</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/REST/Sports/ImportCSV" method="post">
		<p>Importer un sport au format CSV: nom;nombre de joueurs</p>
		<label for="csv">CSV:</label>
		<input type="text" name="csv" id="csv"/><br/>
		<input type="submit" value="Valider">
	</form>

</body>
</html>