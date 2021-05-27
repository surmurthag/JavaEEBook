package fr.editions_eni.javaee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestionDesErreurs
 */
@WebServlet("/GestionDesErreurs")
public class GestionDesErreurs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"Erreur grave");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
