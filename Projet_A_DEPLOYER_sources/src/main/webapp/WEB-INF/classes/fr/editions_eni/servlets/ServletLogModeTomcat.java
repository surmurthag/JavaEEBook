package fr.editions_eni.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLogModeTomcat
 */
@WebServlet("/ServletLogModeTomcat")
public class ServletLogModeTomcat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//J'envoie des logs d'erreurs et d'informations
		Exception origineProbleme = new Exception("Exception à l'origine du problème");
    	this.log("Message d'erreur dû à un problème bloquant",origineProbleme);
    	this.log("Message d'information indiquant que l'on passe par ici");
    	
    	//Je transfère la requête vers la page d'accueil
    	RequestDispatcher rd = request.getRequestDispatcher("/index.html");
    	rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
