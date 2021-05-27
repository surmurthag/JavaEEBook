package fr.editions_eni.javaee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LectureDUnCookie
 */
@WebServlet("/LectureDUnCookie")
public class LectureDUnCookie extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupération des cookies présents
    	Cookie[] cookies = request.getCookies();
		//S'il y a effectivement des cookies, il est possible de les lire
    	if(cookies != null)
		{
			for(Cookie cookie : cookies)
			{
				//Affichage du nom et de la valeur du cookie
				System.out.println("Cookie " + cookie.getName());
				System.out.println("=>Valeur : " + cookie.getValue());
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
