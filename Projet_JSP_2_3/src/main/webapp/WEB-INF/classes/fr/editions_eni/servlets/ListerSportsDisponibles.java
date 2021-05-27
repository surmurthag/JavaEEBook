package fr.editions_eni.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.editions_eni.javaee.models.Sport;
import javafx.scene.effect.Light.Spot;

/**
 * Servlet implementation class ListerSportsDisponibles
 */
@WebServlet("/ListerSportsDisponibles")
public class ListerSportsDisponibles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Constitution de la liste de sport
    	//Normalement, ce code se trouve dans la couche d'accès aux données
    	List<Sport> sports = new ArrayList<>();
		sports.add(new Sport("Badminton", 2));
		sports.add(new Sport("Padel", 2));
		sports.add(new Sport("squash", 2));
		sports.add(new Sport("Tennis", 2));
		//Mise en place de cette liste en attribut de requêtes
		request.setAttribute("listeSports", sports);
		//Délégation de l'affichage à la JSP nommée AffichageSport
		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("AffichageSport");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
