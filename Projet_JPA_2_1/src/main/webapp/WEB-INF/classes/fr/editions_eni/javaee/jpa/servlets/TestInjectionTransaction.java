package fr.editions_eni.javaee.jpa.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.editions_eni.javaee.jpa.dal.DAO;
import fr.editions_eni.javaee.jpa.utils.Transactional;
import fr.editions_eni.javaee.models.Adresse;
import fr.editions_eni.javaee.models.Client;

/**
 * Servlet implementation class TestInjectionTransaction
 */
@WebServlet("/TestInjectionTransaction")
public class TestInjectionTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	private DAO dao;
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public TestInjectionTransaction() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao.enregister(new Client("Injection","Depdendances", new Adresse("CDI", 35000, "Java EE"),"cdi@javaee.com","secret"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
