package fr.editions_eni.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.editions_eni.javaee.models.Surface;

/**
 * Servlet implementation class Connecter
 */
@WebServlet("/Connecter")
public class Connecter extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Cette méthode peut servir à authentifier l'utilisateur qui a saisi un login et un mot de passe
		//Dans le cadre de l'exemple, la personne est automatiquement authentifiee en tant qu'invité
		//On place en session cette information
		request.getSession().setAttribute("utilisateurConnecte", "Invité");
		//On redirige ensuite vers la page que l'utilisateur souhaitait accéder avant son authentification
		//Dans le cadre de l'exemple on le redirige vers la servlet ListeSportsDisponibles
		RequestDispatcher rd = request.getRequestDispatcher("/ListerSportsDisponibles");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
