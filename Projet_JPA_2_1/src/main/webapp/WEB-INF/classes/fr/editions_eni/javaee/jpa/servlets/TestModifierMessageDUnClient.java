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
import fr.editions_eni.javaee.models.Client;
import fr.editions_eni.javaee.models.Message;

/**
 * Servlet implementation class TestModifierMessageDUnClient
 */
@WebServlet("/TestModifierMessageDUnClient")
public class TestModifierMessageDUnClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestModifierMessageDUnClient() {
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
			Client client = em.find(Client.class, 3);
			if(client!=null)
			{
				out.println("Client trouvé");
				em.getTransaction().begin();
				Message message = client.getMessages().get(0);
				message.setMessage(message.getMessage()+".");
				em.getTransaction().commit();
				out.println("Message modifié");
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
			out.println("Une erreur est survenue :");
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
