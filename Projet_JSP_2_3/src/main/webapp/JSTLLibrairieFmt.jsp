<%@page import="java.util.Date"%>
<%@page import="javax.servlet.jsp.jstl.core.Config"%>
<%@page import="javax.servlet.jsp.jstl.fmt.LocalizationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Gestion de ressources</title>
</head>
<body>	
	<h2>
		Message utilisant l'attribut Accept-Language du navigateur <br/>
		${header["Accept-Language"]}
	</h2>
	<fmt:setBundle basename="ressources"/>
	<fmt:message key="msg_bonjour"/>
	
	<h2>Message en forçant la Locale à fr-FR</h2>	
	<fmt:setLocale value="fr-FR"/>
	<fmt:bundle basename="ressources" prefix="msg_">
		<fmt:message key="bonjour"/>
	</fmt:bundle>
	
	<h2>Message en forçant la Locale à en-US</h2>	
	<fmt:setLocale value="en-US"/>
	<fmt:setBundle basename="ressources" var="r"/>
	<fmt:message key="msg_bonjour" bundle="${r}"/>
	
	<h2>Message en forçant la Locale à en</h2>	
	<fmt:setLocale value="en"/>
	<fmt:setBundle basename="ressources"/>
	<fmt:message key="msg_bonjour"/>
	
	
	<h2>Message en forçant la Locale à ch</h2>	
	<fmt:setLocale value="ch"/>
	<fmt:setBundle basename="ressources"/>
	<fmt:message key="msg_bonjour"/>

	<h1>Forcer la Locale par défaut à en-US</h1>
<%
	Config.set(request.getServletContext(), Config.FMT_FALLBACK_LOCALE, "en-US");
%>

	<h2>Message en forçant la Locale à ch</h2>	
	<fmt:setLocale value="ch"/>
	<fmt:setBundle basename="ressources"/>
	<fmt:message key="msg_bonjour"/>

<%
	Config.remove(request.getServletContext(), Config.FMT_FALLBACK_LOCALE);
%>

	<h1>Message paramétré</h1>
	<fmt:setLocale value="${requestContext.locale.language}"/>
	<fmt:setBundle basename="ressources"/>
	<fmt:message key="msg_aurevoir">
		<fmt:param value="tout le monde"></fmt:param>
	</fmt:message>
	
	
	<h1>Gestion des dates</h1>
	
	<%
		pageContext.setAttribute("maintenant", new Date());
	%>
	<fmt:timeZone value="GMT+1">
		Maintenant à Paris : <fmt:formatDate value="${maintenant}" type="both" dateStyle="long"/>
	</fmt:timeZone>
	<br/>
	<fmt:timeZone value="America/New_York">
		Maintenant à New York : <fmt:formatDate value="${maintenant}" type="both" dateStyle="long"/>
	</fmt:timeZone>
	<br/>
	<fmt:setTimeZone value="Asia/Tokyo" var="fuseauTokyo" scope="request"/>
	Maintenant à Tokyo : <fmt:formatDate value="${maintenant}" type="both" dateStyle="long" timeZone="${fuseauTokyo}"/>
	
	
	<h1>Gestion des nombres</h1>
	
	<fmt:formatNumber
		value="1234.5678"
		type="number"
		maxFractionDigits="2"
		minIntegerDigits="3">
	</fmt:formatNumber>
	<br/>
	<fmt:formatNumber
		value="1234.5678"
		type="currency"
		currencyCode="GBP"
		currencySymbol="£"
		maxFractionDigits="2"
		minIntegerDigits="5">
	</fmt:formatNumber>
	<br/>
	<fmt:formatNumber
		value="1234.5678"
		type="percent">
	</fmt:formatNumber>
	<br/>
</body>
</html>