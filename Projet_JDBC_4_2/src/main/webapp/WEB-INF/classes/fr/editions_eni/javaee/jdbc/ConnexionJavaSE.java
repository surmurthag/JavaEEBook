package fr.editions_eni.javaee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

public class ConnexionJavaSE {

	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost/bdd_jdbc";
		try {
			Connection cnx = DriverManager.getConnection(url, "utilisateur_eni", "Pa$$w0rd");
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
