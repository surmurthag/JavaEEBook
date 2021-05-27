<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<%-- 	<s:i18n name="global"> --%>
		<meta charset="UTF-8">
		<title><s:text name="sport.titre"></s:text></title>

<%-- 	</s:i18n> --%>

	<style>
		label
		{
			display:inline-block;
			width:150px;
			text-align:right;
			margin:5px;
		}
		.labelTop
		{
			vertical-align:top;
		}
		.zoneSaisie
		{
			width:150px;
		}
		input[type=submit]
		{
			margin-left:160px;
		} 
	</style>
</head>
<body>
	<s:i18n name="global">
		<div>
			<h1><s:text name="global.titre"></s:text></h1>
		</div>
	</s:i18n>
	<s:form action="/addSport" theme="simple">
		
		<s:label for="nom" value="%{getText('package.label.nom')}"/>
		<s:textfield id="nom"  name="nouveauSport.nom" cssClass="zoneSaisie"></s:textfield>
		
		<br/>
		
		<s:label for="terrains" value="%{getText('package.label.terrains')}" cssClass="labelTop"/>
		<s:select id="terrains" name="nouveauSport.terrainsCompatibles" list="#session['terrains']" listKey="code" listValue="code"  multiple="true" size="3"></s:select>
		
		<br/>
		
		<s:label for="nombreJoueurs" value="%{getText('package.label.nombreJoueurs')}"/>
		<s:textfield id="nombreJoueurs"  name="nouveauSport.nombreJoueurs" cssClass="zoneSaisie" ></s:textfield>
		<s:fielderror></s:fielderror>
		<s:actionerror/>
		<br/>
		<s:submit value="%{getText('package.bouton.valider')}"></s:submit>
	</s:form>	
</body>
</html>