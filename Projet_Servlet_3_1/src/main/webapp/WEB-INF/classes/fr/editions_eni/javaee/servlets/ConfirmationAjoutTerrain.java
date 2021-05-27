package fr.editions_eni.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.editions_eni.javaee.models.Terrain;

/**
 * Servlet implementation class ConfirmationAjoutTerrain
 */
@WebServlet(
		name="ConfirmationAjoutTerrain",
		value="/RecapitulatifNouveauTerrain")
public class ConfirmationAjoutTerrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmationAjoutTerrain() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lecture des attributs de la requête
		Terrain terrainAjoute = (Terrain)request.getAttribute("terrainAjoute");
		//Ecriture de la réponse
		//Les en-têtes
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		//Le corps
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("<title>Confirmation ajout d'un terrain</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("Affichage après délégation<br/>");
		pw.println("Confirmation ajout du terrain " + terrainAjoute.getCode());
		
		//Inclusion du pied de page
		RequestDispatcher rd = request.getRequestDispatcher("/piedDePage.html");
		rd.include(request, response);
		
		pw.println("</body>");
		pw.flush();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
