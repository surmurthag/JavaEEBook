package fr.editions_eni.javaee.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import fr.editions_eni.javaee.models.Adresse;
import fr.editions_eni.javaee.models.Client;

/**
 * Servlet implementation class TestSQLException
 */
@WebServlet("/TestSQLException")
public class TestSQLException extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSQLException() {
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
				String sql = "insert into messages(date_ecriture,message,identifiant_client) values (?,?,?);";
				PreparedStatement pstmt = cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				//Affectation des valeurs
				pstmt.setDate(1, new java.sql.Date(new Date().getTime()));
				pstmt.setString(2, "un message");
				pstmt.setInt(3, 999);//numéro d'un client n'existant pas
				//Exécution de la requête
				int nombreLignesAffectees = pstmt.executeUpdate();
				//...
				pstmt.close();//ferme implicitement le dernier ResultSet ouvert
			}
		}
		catch(NamingException e)
		{
			out.println("Une erreur est survenue lors de l'accès à la base de données:");
			out.println(e.getMessage());
			e.printStackTrace();
		}
		catch (SQLException e) {
			//test de la présence du nom de la clé étrangère dans le message
			if(e.getMessage().contains("FK_MESSAGES_CLIENTS"))
			{
				out.println("Le client n'existe pas");
			}
			else
			{
				out.println("Une erreur est survenue lors de l'accès à la base de données:");
				out.println(e.getMessage());
			}
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
