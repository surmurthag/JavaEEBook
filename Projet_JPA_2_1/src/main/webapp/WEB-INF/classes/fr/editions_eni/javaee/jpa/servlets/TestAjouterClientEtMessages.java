package fr.editions_eni.javaee.jpa.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.editions_eni.javaee.jpa.utils.JPAUtil;
import fr.editions_eni.javaee.models.Adresse;
import fr.editions_eni.javaee.models.Client;
import fr.editions_eni.javaee.models.Message;

/**
 * Servlet implementation class TestAjouterClientEtMessages
 */
@WebServlet("/TestAjouterClientEtMessages")
public class TestAjouterClientEtMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestAjouterClientEtMessages() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		Client client = new Client("RICHARD", "Thierry", new Adresse("7, rue de la république",35000,"RENNES"), "monemail@mondomaine.com","mdp");
		client.setLangue("fr"); 
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		try
		{
			client.getMessages().add(new Message("premier message", new Date()));
			client.getMessages().add(new Message("second message", new Date()));
			em.persist(client);
			em.getTransaction().commit();
			out.println("Ajout effectué avec succès");
		}
		catch(Exception e)
		{
			em.getTransaction().rollback();
			e.printStackTrace();
			out.println("Une erreur est survenue lors de l'ajout :");
			out.println(e.getMessage());
		}
		em.close();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
