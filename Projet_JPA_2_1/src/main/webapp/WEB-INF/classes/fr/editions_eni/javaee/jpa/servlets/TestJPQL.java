package fr.editions_eni.javaee.jpa.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.editions_eni.javaee.jpa.utils.JPAUtil;
import fr.editions_eni.javaee.models.Client;
import fr.editions_eni.javaee.models.ClientLeger;
import fr.editions_eni.javaee.models.Message;

/**
 * Servlet implementation class SelectionnerClient
 */
@WebServlet("/TestJPQL")
public class TestJPQL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestJPQL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		EntityManager em = JPAUtil.getEntityManager();

		//SELECT SIMPLE
		//Query query = em.createQuery("SELECT c FROM Client c");
		//Query query = em.createQuery("FROM Client");

		//SELECT AVEC RESTRICTIONS
		//Query query = em.createQuery("SELECT c FROM Client c where c.nom='RICHARD'");
		//Query query = em.createQuery("FROM Client where nom='RICHARD'");
		//Query query = em.createQuery("SELECT c FROM Client c WHERE c.adresse.ville='rennes'");
		//Query query = em.createQuery("SELECT c FROM Client c WHERE c.identifiant BETWEEN 1 AND 100");
		//Requête retournant les clients dont l'email se termine par 3 caractère après le point. Le % représente 0 à n caractères et l'underscore représente exactement un caractère
		//Query query = em.createQuery("SELECT c FROM Client c WHERE c.email LIKE '%@%.___'");
		//Requête retournant les clients qui ont des messages
		//Query query = em.createQuery("SELECT c FROM Client c WHERE c.messages IS NOT EMPTY");
		//Query query = em.createQuery("SELECT c FROM Client c WHERE c.messages IS NOT EMPTY");
		
		
		//SELECT AVEC PARAMETRES
		//Query query = em.createQuery("SELECT c FROM Client c where c.nom=:nom");
		//query.setParameter("nom", "RICHARD");
		//Query query = em.createQuery("SELECT c FROM Client c where c.nom=?");
		//query.setParameter(0,"RICHARD");
		

		//SELECT AVEC PARAMETRES OBJETS
		//Message message = em.find(Message.class, 1);
		//Query query = em.createQuery("SELECT c FROM Client c WHERE ? MEMBER OF c.messages");
		//Query query = em.createQuery("SELECT c FROM Client c INNER JOIN c.messages m WHERE m=?");
		//query.setParameter(0, message);
		
		//SELECT AVEC SOUS REQUETE
		//Query query = em.createQuery("SELECT c FROM Client c where (SELECT COUNT(*) from c.messages)>0");
		//Query query = em.createQuery("SELECT c FROM Client c WHERE CURRENT_DATE < SOME (SELECT m.dateEcriture FROM c.messages m)");
		
		//SELECT AVEC JOINTURES
		//Query query = em.createQuery("SELECT c FROM Client c INNER JOIN c.messages m WHERE m.identifiant=1");
		//Query query = em.createQuery("SELECT c FROM Client c INNER JOIN FETCH c.messages m WHERE m.identifiant=1");
		
		//SELECT AGREGATS
		//Query query = em.createQuery("SELECT COUNT(c.prenom) FROM Client c");
		//Query query = em.createQuery("SELECT c.nom, COUNT(cc) as nbCarnets FROM Client c LEFT OUTER JOIN c.carnets cc GROUP BY c.nom");
		
		
		//Une requête avec une projection sur une entité
		/*Query query = em.createQuery("SELECT c FROM Client c");
		List<Client> clients = query.getResultList();
		for(Client client : clients)
		{
			out.println(client.getNom());
		}*/
		
		//Une requête avec une projection sur une valeur
		/*Query query = em.createQuery("SELECT COUNT(*) FROM Client");
		long nombreClients = (long)query.getSingleResult();
		out.println(nombreClients);*/
		
		//Une requête avec une projection complexe
		/*Query query = em.createQuery("SELECT c.nom, c.prenom FROM Client c");
		List<Object[]> nomsPrenoms = query.getResultList();
		for(Object[] nomPrenom : nomsPrenoms)
		{
			out.println(nomPrenom[0]+" "+nomPrenom[1]);
		}*/
		Query query = em.createQuery("SELECT new fr.editions_eni.javaee.models.ClientLeger(c.nom, c.prenom) FROM Client c");
		List<ClientLeger> clientsLegers = query.getResultList();
		for(ClientLeger clientLeger : clientsLegers)
		{
			out.println(clientLeger.getNom()+" "+clientLeger.getPrenom());
		}
		
		//EXEMPLE CRITERIA
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Client> requeteClients = cb.createQuery(Client.class);
		//Définition de la source d'informations
		Root<Client> sourceClients=requeteClients.from(Client.class);
		//Selection de tous les clients:
		CriteriaQuery<Client> cqTousLesClients = requeteClients.select(sourceClients);
		TypedQuery<Client> queryCriteria = em.createQuery(cqTousLesClients);
		List<Client> clients = queryCriteria.getResultList();
		out.println("Nombre total client : " + clients.size());
		//Selection des clients de nom RICHARD
		CriteriaQuery<Client> cqClientsRICHARD = requeteClients.select(sourceClients).where(cb.equal(sourceClients.get("nom"), "RICHARD"));
		TypedQuery<Client> queryCriteriaRICHARD = em.createQuery(cqClientsRICHARD);
		List<Client> clientsRICHARD = queryCriteriaRICHARD.getResultList();
		out.print("Nombre de clients RICHARD : " + clientsRICHARD.size());		
		
		em.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
