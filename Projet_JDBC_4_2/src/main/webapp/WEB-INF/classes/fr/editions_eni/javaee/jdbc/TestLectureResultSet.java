package fr.editions_eni.javaee.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import fr.editions_eni.javaee.models.Client;

/**
 * Servlet implementation class TestLectureResultSet
 */
@WebServlet("/TestLectureResultSet")
public class TestLectureResultSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestLectureResultSet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//Creation d'une liste de clients
		List<Client> listeClients = new ArrayList<Client>();
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_bdd_jdbc");
			try(Connection cnx = dataSource.getConnection())
			{
				String sql = "select identifiant, nom, prenom from clients";
				Statement stmt = cnx.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next())
				{
					Client c = new Client();
					//2 solutions de lecture:
					//c.setIdentifiant(rs.getInt("identifiant"));
					c.setIdentifiant(rs.getInt(1));
					c.setNom(rs.getString(2));
					//Le prénom peut être null:
					String prenom = rs.getString(3);
					if(rs.wasNull())
					{
						prenom="Pas de prénom";
					}
					c.setPrenom(prenom);
					//Ajout du client à la liste
					listeClients.add(c);
				}
				stmt.close();//ferme implicitement le dernier ResultSet ouvert
				//Utilisation de la liste listeClients
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
