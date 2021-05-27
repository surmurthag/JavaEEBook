package fr.editions_eni.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.editions_eni.javaee.models.Client;

/**
 * Servlet implementation class CréationDUneSession
 */
@WebServlet("/CreationDUneSession")
public class CreationDUneSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/plain");
		
		//Création ou obtention de la session
		HttpSession session = request.getSession();
		pw.println("La session vient d'être créée :" + session.isNew());
		//Lecture des attributs présents :
		String nom = (String) session.getAttribute("nom");
		if(nom!=null)
		{
			pw.println("L'attribut nom = " + nom);
		}
		else
		{
			pw.println("L'attribut nom n'existe pas");
		}
		String prenom = (String) session.getAttribute("prenom");
		if(prenom!=null)
		{
			pw.println("L'attribut prénom = " + prenom);
		}
		else
		{
			pw.println("L'attribut prénom n'existe pas");
		}
		//Ecriture d'attributs :
		session.setAttribute("nom", "RICHARD");
		session.setAttribute("prenom", "Thierry");
		//Définition d'un lien présent dans la page
		String url = request.getContextPath()+"/chemin";
		//Réécriture du lien si le client n'accepte pas les cookies
		String urlEncode = response.encodeURL(url);
		pw.println(urlEncode);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
