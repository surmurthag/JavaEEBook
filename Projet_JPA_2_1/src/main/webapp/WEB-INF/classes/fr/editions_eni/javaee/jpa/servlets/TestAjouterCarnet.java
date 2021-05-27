package fr.editions_eni.javaee.jpa.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.editions_eni.javaee.jpa.utils.JPAUtil;
import fr.editions_eni.javaee.models.Carnet;
import fr.editions_eni.javaee.models.Client;
import fr.editions_eni.javaee.models.Sport;

/**
 * Servlet implementation class AjouterCarnet
 */
@WebServlet("/TestAjouterCarnet")
public class TestAjouterCarnet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestAjouterCarnet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mettreClientEnSession(request);
		
		//Création d'un nouveau contexte de persistance
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Sport sport = em.find(Sport.class, 1);
		//Utilisation du client dans un autre contexte qui l'a créé.
		Client clientDetache = (Client) request.getSession().getAttribute("clientAuthentifie");
		Client clientAttache = em.merge(clientDetache);
		Carnet carnet = new Carnet(sport,clientAttache , 10);
		em.persist(carnet);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * Simule une authentification d'un client
	 * @param request
	 */
	private void mettreClientEnSession(HttpServletRequest request) {
		EntityManager em = JPAUtil.getEntityManager();
		Client client = em.find(Client.class, 2);
		request.getSession().setAttribute("clientAuthentifie", client);
		em.close();//met l'entité client dans un état détaché
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
