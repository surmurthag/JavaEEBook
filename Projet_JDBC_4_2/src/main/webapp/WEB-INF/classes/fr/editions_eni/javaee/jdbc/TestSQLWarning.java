package fr.editions_eni.javaee.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

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
 * Servlet implementation class TestSQLWarning
 */
@WebServlet("/TestSQLWarning")
public class TestSQLWarning extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSQLWarning() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Context context;
		try 
		{
			context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_bdd_jdbc");
			try(Connection cnx = dataSource.getConnection())
			{
				out.print("La connexion est " + (cnx.isClosed()?"fermée":"ouverte"));
				Statement stmt = cnx.createStatement();
				int nbLignesAffectees = stmt.executeUpdate("insert into TESTS values('une valeur trop longue pour le champ, elle va être coupée')");
				out.println(nbLignesAffectees + " ligne(s) créée(s)");
				SQLWarning avertissement = stmt.getWarnings();
				if(avertissement!=null)
				{
					out.print("Avertissement : "+avertissement.getMessage());
					while((avertissement = avertissement.getNextWarning()) !=null)
					{
						out.print("Avertissement : "+avertissement.getMessage());
					}
				}
			} catch (SQLException e) {
				out.println("Une erreur est survenue lors de la l'utilisation de la base de données:");
				out.println(e.getClass().getName());
				out.println(e.getMessage());
				e.printStackTrace();
			}
		} 
		catch (NamingException e1) {
			e1.printStackTrace();
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
