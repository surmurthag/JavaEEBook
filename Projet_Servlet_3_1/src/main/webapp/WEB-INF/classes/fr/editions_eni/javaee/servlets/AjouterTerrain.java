package fr.editions_eni.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.editions_eni.javaee.models.Sport;
import fr.editions_eni.javaee.models.Surface;
import fr.editions_eni.javaee.models.Terrain;

/**
 * Servlet implementation class AjouterTerrain
 */
@WebServlet("/AjouterTerrain")
public class AjouterTerrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//Lecture des informations de la requête
		String codeTerrain = request.getParameter("codeTerrain");
		String[] sportsAutorises = request.getParameterValues("sportsAutorises");
		
		//Réalisation du traitement métier (Normalement déporté dans les classes du projet)
		Terrain terrainAjoute = new Terrain(codeTerrain, Surface.BETON);
		//System.out.println("Code du terrain :" + codeTerrain);
		for(String codeSport:sportsAutorises)
		{
			//System.out.println("Code sport autorisé :" + codeSport);
			Sport sport = new Sport();
			sport.setIdentifiant(Integer.parseInt(codeSport));
			terrainAjoute.getSportsAutorises().add(sport);
			//...
		}
		
		//Ecriture de la réponse
		//Les en-têtes
//		response.setStatus(HttpServletResponse.SC_OK);
//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
		//Le corps
//		PrintWriter pw = response.getWriter();
//		pw.println("<!DOCTYPE html>");
//		pw.println("<html>");
//		pw.println("<head>");
//		pw.println("<meta charset=\"UTF-8\">");
//		pw.println("<title>Confirmation ajout d'un terrain</title>");
//		pw.println("</head>");
//		pw.println("<body>");
//		pw.println("Confirmation ajout du terrain " + terrainAjoute.getCode());
//		pw.println("</body>");
//		pw.flush();
//		pw.close();
		
		//Ajout d'informations complémentaires pour la ressource s'occupant de l'affichage
		request.setAttribute("terrainAjoute", terrainAjoute);
		//Délégation du traitement à une autre ressource (Servlet/JSP)
//		RequestDispatcher rd = request.getRequestDispatcher("/RecapitulatifNouveauTerrain");
//		rd.forward(request, response);
		//ou
		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("ConfirmationAjoutTerrain");
		rd.forward(request, response);
	}
}
