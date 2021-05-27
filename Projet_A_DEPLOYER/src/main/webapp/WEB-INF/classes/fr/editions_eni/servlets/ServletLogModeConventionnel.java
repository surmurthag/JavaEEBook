package fr.editions_eni.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

/**
 * Servlet implementation class ServletLogModeConventionnel
 */
@WebServlet("/ServletLogModeConventionnel")
public class ServletLogModeConventionnel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//J'envoie des logs d'erreurs et d'informations
    	Log logger = LogFactory.getLog(ServletLogModeConventionnel.class);
    	logger.error("Message d'erreur dû à un problème bloquant");
    	logger.info("Message d'information indiquant que l'on passe par ici");
    	
    	//Je transfère la requête vers la page d'accueil
    	RequestDispatcher rd = request.getRequestDispatcher("/index.html");
    	rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
