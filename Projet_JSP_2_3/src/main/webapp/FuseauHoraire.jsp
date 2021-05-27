<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		pageContext.setAttribute("timeZones", java.util.TimeZone.getAvailableIDs());
	%>
	<c:forEach var="timeZone" items="${pageScope.timeZones}">
		${timeZone}<br/>
	</c:forEach>
</body>
</html>