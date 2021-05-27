package fr.editions_eni.javaee.jpa.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.editions_eni.javaee.jpa.utils.JPAUtil;
import fr.editions_eni.javaee.models.Adresse;
import fr.editions_eni.javaee.models.Client;
import fr.editions_eni.javaee.models.Sport;
import fr.editions_eni.javaee.models.Surface;
import fr.editions_eni.javaee.models.Terrain;

/**
 * Servlet implementation class TestAjouterSportEtTerrain
 */
@WebServlet("/TestAjouterSportEtTerrain")
public class TestAjouterSportEtTerrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestAjouterSportEtTerrain() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		//Sport sport = new Sport("Badminton", 2);
		//sport.getTerrainsCompatibles().add(new Terrain("T1",Surface.BETON));
		Terrain terrain = new Terrain("T4",Surface.PARQUET);
		terrain.getSportsAutorises().add(new Sport("Squashhh",2));
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		try
		{
			em.persist(terrain);
			em.getTransaction().commit();
			out.println("Ajout effectué avec succès");
		}
		catch(Exception e)
		{
			em.getTransaction().rollback();
			e.printStackTrace();
			out.println("Une erreur est survenue lors de l'ajout :");
			out.println(e.getMessage());
		}
		em.close();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
