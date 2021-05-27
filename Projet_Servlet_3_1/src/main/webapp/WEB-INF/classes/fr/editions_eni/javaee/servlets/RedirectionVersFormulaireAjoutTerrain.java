package fr.editions_eni.javaee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectionVersFormulaireAjoutTerrain
 */
@WebServlet("/Redirection")
public class RedirectionVersFormulaireAjoutTerrain extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		//response.setHeader("Location", request.getContextPath()+"/formulaireAjoutTerrain.html");
		response.sendRedirect(request.getContextPath()+"/formulaireAjoutTerrain.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
