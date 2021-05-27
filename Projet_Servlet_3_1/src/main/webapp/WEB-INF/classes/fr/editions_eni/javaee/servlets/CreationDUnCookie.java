package fr.editions_eni.javaee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreationDUnCookie
 */
@WebServlet("/CreationDUnCookie")
public class CreationDUnCookie extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Création d'un cookie
		Cookie cookie = new Cookie("cle", "valeur");

		//Définition des caractéristiques
		cookie.setVersion(1);
		cookie.setComment("coucou");
		//cookie.setDomain(".exemple.com");
		//cookie.setPath(request.getContextPath());
		cookie.setMaxAge(1000);
		//cookie.setSecure(true);
		cookie.setHttpOnly(true);
		
		//Ajout du cookie dans la réponse
		response.addCookie(cookie);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
