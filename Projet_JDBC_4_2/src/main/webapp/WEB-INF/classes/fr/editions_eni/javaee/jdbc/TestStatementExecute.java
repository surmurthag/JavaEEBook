package fr.editions_eni.javaee.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * Servlet implementation class TestStatementExecute
 */
@WebServlet("/TestStatementExecute")
public class TestStatementExecute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestStatementExecute() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_bdd_jdbc");
			try(Connection cnx = dataSource.getConnection())
			{
				String sql = "select identifiant, nom, prenom from clients";
				Statement stmt = cnx.createStatement();
				boolean premierResultatEstUnResultSet = stmt.execute(sql);
				if(premierResultatEstUnResultSet)
				{
					out.println("traitement du résultat");
					ResultSet rs = stmt.getResultSet();
					//traitement du ResultSet
					//...
					//Dans l'exemple, la boucle while ne sera à rien
					//car la requête retourne un seul jeu de résultats
					while(stmt.getMoreResults())//ferme implicitement le ResultSet précédent
					{
						ResultSet rsComplementaire = stmt.getResultSet();
						//traitement du resultat complémentaire
						//...
					}
				}
				stmt.close();//ferme implicitement le dernier ResultSet ouvert
			}
		} catch (NamingException|SQLException e) {
			out.println("Une erreur est survenue lors de l'accès à la base de données:");
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
