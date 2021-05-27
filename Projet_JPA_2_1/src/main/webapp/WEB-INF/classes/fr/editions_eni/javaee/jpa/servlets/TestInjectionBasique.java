package fr.editions_eni.javaee.jpa.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.editions_eni.javaee.models.Client;

/**
 * Servlet implementation class TestInjectionBasique
 */
@WebServlet("/TestInjectionBasique")
public class TestInjectionBasique extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
    private Client client;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestInjectionBasique() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response. getWriter();
		response.setContentType("text/plain");
		if(client!=null)
		{
			out.println("L'injection a fonctionné");
		}
		else
		{
			out.println("L'injection n'a pas fonctionné");
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
