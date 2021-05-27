<%@page import="fr.editions_eni.javaee.models.Sport"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="fr.editions_eni.javaee.models.Surface"%>
<%@page import="java.math.BigInteger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Présentation de la syntaxe de l'EL (Expression Language)</title>
</head>
<body>
	<jsp:useBean 
	id="sportPrefere" 
	scope="session" 
	class="fr.editions_eni.javaee.models.Sport">
			<!-- Initialisation de la propriété nom en cas du création du JavaBean -->
		<jsp:setProperty name="sportPrefere" property="nom" value="badminton"/>
	</jsp:useBean>
	
	${sportPrefere.nom}
	${sportPrefere.nom='coucou'}
	${sportPrefere.identifiant=10}
	${sportPrefere.nom}
	${sportPrefere.identifiant}
	${variable=15}
	${variable='coucou'}
	${variable.toUpperCase()}
	
	${paramValues["test"][0]}
	${paramValues.test[0]}
	
	<%
		String toto="ee";
	%>
	${toto}
	
	${v=(x,y)->x+y}
	${v(3,4)}
	
	<%
		pageContext.setAttribute("i", 12);
		pageContext.setAttribute("j", -13);
		BigInteger bi = BigInteger.valueOf(14);
		pageContext.setAttribute("k", bi);
		BigInteger bi2 = BigInteger.valueOf(-15);
		pageContext.setAttribute("l", bi2);
		pageContext.setAttribute("chaine1", "coucou");
		pageContext.setAttribute("var1", null);
		pageContext.setAttribute("var2", null);
		request.setAttribute("surface", Surface.PARQUET);
		List<Sport> sports = new ArrayList<>();
		sports.add(new Sport("squash",2));
		sports.add(new Sport("bad",10));
		pageContext.setAttribute("lesSports", sports);
	%>
	${printer.print('aaaaaa') }
	${-i}
	${-j}
	${-k}
	${-l}
	${chaine1+=" tout le monde"}
	${i=10;j=15}
	${i}
	${var1==var2}
	${requestScope.surface=='BETON' }
	${booleen=Integer.MAX_VALUE }
	${booleen }
	${maListe=[1,2,3]}
	${monSet={1,2,3}}
	${maMap={'a':1,'b':2,'c':3}}
	${listeMixte=[1,'un',['badminton','Tennis','Squash']]}
	${maMap.get('a') }
	${maMap['a'] }
	${monSet.toArray()[0]}
<%-- 	${maMap.value('a')} --%>
${pageScope.lesSports.stream().map(s->s.nom).toList()[0]}
${pageScope.lesSports.stream().sorted((s1,s2)->s1.nom.compareTo(s2.nom)).toList()[0].nom}
${pageScope.lesSports.stream().max((s1,s2)->s1.nombreJoueurs-s2.nombreJoueurs).get().nom}
	</body>
</html>