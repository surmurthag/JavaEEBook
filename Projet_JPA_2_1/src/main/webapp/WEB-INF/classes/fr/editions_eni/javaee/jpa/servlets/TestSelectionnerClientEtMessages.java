package fr.editions_eni.javaee.jpa.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class TestSelectionnerClientEtMessages
 */
@WebServlet("/TestSelectionnerClientEtMessages")
public class TestSelectionnerClientEtMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSelectionnerClientEtMessages() {
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
			//requête sql sélection client
			Client client = em.find(Client.class, 2);
			if(client!=null)
			{
				out.println("Client trouvé");
				//requête sql sélection messages
				List<Message> messages = client.getMessages();
				out.println("Nombre de messages : " + messages.size());
			}
			else
			{
				out.println("Client inexistant");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("Une erreur est survenue lors de la recherche du client :");
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
