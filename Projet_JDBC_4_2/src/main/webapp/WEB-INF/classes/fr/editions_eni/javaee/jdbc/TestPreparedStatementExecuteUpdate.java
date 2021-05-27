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
 * Servlet implementation class TestPreparedStatementExecuteUpdate
 */
@WebServlet("/TestPreparedStatementExecuteUpdate")
public class TestPreparedStatementExecuteUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestPreparedStatementExecuteUpdate() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Client nouveauClient = new Client("RICHARD", 
												"Thierry", 
												new Adresse("rue de la République", 35000, "RENNES"), 
												"monemail@mondomaine.fr");
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_bdd_jdbc");
			try(Connection cnx = dataSource.getConnection())
			{
				String sql = "insert into clients(nom, prenom, email, rue, code_postal, ville) values (?,?,?,?,?,?)";
				//Création de l'objet PreparedStatement en demandant à ce que la clé primaire soit retournée
				PreparedStatement pstmt = cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				//Affectation des valeurs
				pstmt.setString(1, nouveauClient.getNom());
				pstmt.setString(2, nouveauClient.getPrenom());
				pstmt.setString(3, nouveauClient.getEmail());
				pstmt.setString(4, nouveauClient.getAdresse().getRue());
				pstmt.setInt(5, nouveauClient.getAdresse().getCodePostal());
				pstmt.setString(6, nouveauClient.getAdresse().getVille());
				//Exécution de la requête
				int nombreLignesAffectees = pstmt.executeUpdate();
				if(nombreLignesAffectees==0)
				{
					//echec
				}
				else 
				{
					//succes (1 ligne insérée)
					ResultSet rsClePrimaire = pstmt.getGeneratedKeys();
					//traitement de ResultSet pour lire la clé primaire dans la première ligne et première colonne
				}
				pstmt.close();//ferme implicitement le dernier ResultSet ouvert
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
