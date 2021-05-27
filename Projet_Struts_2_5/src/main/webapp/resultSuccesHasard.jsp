<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Un sport choisi au hasard</title>
</head>
<body>
	Le sport choisi au hasard est ${unSport} (lecture avec EL)
	<br/>
	Le sport choisi au hasard est <s:property value="unSport"/> (lecture avec OGNL)
	<br/>
	Cette page est affichée en lien avec le paramétrage défini au niveau de l'annotation @Action.
</body>
</html>