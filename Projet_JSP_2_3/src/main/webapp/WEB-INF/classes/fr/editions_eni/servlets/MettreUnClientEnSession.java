package fr.editions_eni.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.editions_eni.javaee.models.Adresse;
import fr.editions_eni.javaee.models.Client;

/**
 * Servlet implementation class MettreUnUtilisateurEnSession
 */
@WebServlet("/MettreUnClientEnSession")
public class MettreUnClientEnSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Cet exemple a pour objectif de mettre en évidence l'intérêt de l'EL par rapport au java dans une JSP
		
		//Création d'un client
		Client client = new Client("RICHARD", "Thierry", new Adresse("7 rue de la République", 35000, "RENNES"), null);
		//Client client = new Client("RICHARD", "Thierry", null, "sonemail@sondomaine.fr");
		
		//Placement du client en session
		request.getSession().setAttribute("unClient", client);
		
		//Délégation de l'affichage à une JSP
		RequestDispatcher rd = request.getRequestDispatcher("/JavaVersusEL.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
