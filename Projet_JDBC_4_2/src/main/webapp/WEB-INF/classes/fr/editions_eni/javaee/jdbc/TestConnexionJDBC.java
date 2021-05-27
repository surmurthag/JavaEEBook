package fr.editions_eni.javaee.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestConnexionJDBC
 */
@WebServlet("/TestConnexionJDBC")
public class TestConnexionJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestConnexionJDBC() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		String url ="jdbc:mysql://localhost/bdd_jdbc";
		try 
		{
			//Chargement du pilote en environnement Java EE
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection cnx = DriverManager.getConnection(url, "utilisateur_eni", "Pa$$w0rd");
			out.print("La connexion est " + (cnx.isClosed()?"fermée":"ouverte"));
			cnx.close();
		} 
		catch (SQLException e) 
		{
			out.println("Une erreur est survenue lors de la connection:");
			out.println(e.getMessage());
			e.printStackTrace();
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
