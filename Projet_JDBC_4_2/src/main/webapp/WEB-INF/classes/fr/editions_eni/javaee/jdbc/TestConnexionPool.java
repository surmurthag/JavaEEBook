package fr.editions_eni.javaee.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestConnexionPool
 */
@WebServlet("/TestConnexionPool")
public class TestConnexionPool extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_bdd_jdbc");
			out.println(dataSource.getClass().getName());
			Connection cnx = dataSource.getConnection();
			out.print("La connexion est " + (cnx.isClosed()?"fermée":"ouverte"));
			cnx.close();//La connexion n'est pas physiquement fermée, elle est replacée dans le pool de connexion
		} catch (NamingException|SQLException e) {
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
