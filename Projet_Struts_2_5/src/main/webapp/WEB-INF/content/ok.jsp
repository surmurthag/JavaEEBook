<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><s:text name="ok.titre"></s:text></title>
</head>
<body>
	<br/>
	<s:text name="package.label.nom"></s:text> <s:property value="nouveauSport.nom"/>
    <br/>
    <s:i18n name="global">
    	<s:text name="sport.terrainsAutorises"></s:text>
	</s:i18n>
    <c:forEach items="${nouveauSport.terrainsCompatibles}" var="terrain">
		<c:out value="${terrain.code}"></c:out>
	</c:forEach>
	<br/>
	<s:text name="package.label.nombreJoueurs"></s:text> <s:property value="nouveauSport.nombreJoueurs"/>
</body>
</html>