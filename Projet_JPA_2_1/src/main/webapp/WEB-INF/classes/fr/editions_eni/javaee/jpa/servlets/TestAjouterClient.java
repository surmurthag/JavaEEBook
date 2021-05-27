package fr.editions_eni.javaee.jpa.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.editions_eni.javaee.jpa.utils.JPAUtil;
import fr.editions_eni.javaee.models.Adresse;
import fr.editions_eni.javaee.models.Client;

/**
 * Servlet implementation class AjouterClient
 */
@WebServlet("/TestAjouterClient")
public class TestAjouterClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestAjouterClient() {
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
