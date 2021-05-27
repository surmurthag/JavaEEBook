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
 * Servlet implementation class TestSupprimerClient
 */
@WebServlet("/TestSupprimerClient")
public class TestSupprimerClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSupprimerClient() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		EntityManager em = JPAUtil.getEntityManager();
		try
		{
			Client client = em.find(Client.class, 1);
			if(client!=null)
			{
				out.println("Client trouvé");
				em.getTransaction().begin();
				em.remove(client);
				em.getTransaction().commit();
				out.println("Client supprimé");
			}
			else
			{
				out.println("Client inexistant");
			}
		}
		catch(Exception e)
		{
			if(em.getTransaction().isActive())
			{
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			out.println("Une erreur est survenue à la suppression:");
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
