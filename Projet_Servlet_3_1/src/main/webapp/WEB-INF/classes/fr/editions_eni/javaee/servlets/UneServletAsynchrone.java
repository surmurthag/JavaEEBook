package fr.editions_eni.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UneServletAsynchrone
 */
@WebServlet(value="/UneServletAsynchrone", asyncSupported=true)
public class UneServletAsynchrone extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Le traitement qui suit va se faire de façon asynchrone");
		//Obtention d'un contexte asynchrone afin de faire des traitements en tâche de fond
		final AsyncContext contexteAsynchrone = request.startAsync();
		//Lancement du traitement asynchrone avec la méthode start
		contexteAsynchrone.start(new Runnable() {
			@Override
			public void run() {
				//Cette méthode doit contenir le traitement à réaliser de manière asynchrone
				HttpServletRequest request = (HttpServletRequest) contexteAsynchrone.getRequest();
				HttpServletResponse response = (HttpServletResponse) contexteAsynchrone.getResponse();
				
				System.out.println("     Début de la réalisation du traitement asynchrone qui dure un certain temps");
				try {
					Thread.sleep(3000);
					response.setStatus(HttpServletResponse.SC_OK);
					response.setContentType("text/plain");
					PrintWriter pw = response.getWriter();
					pw.println("Traitement asynchrone");
					pw.close();
				} catch (InterruptedException | IOException e) {
					e.printStackTrace();
				}
				System.out.println("     Fin du traitement asynchrone");
				//Notification de la fin du traitement en appelant la méthode complete
				//La réponse est alors renvoyée au client
				contexteAsynchrone.complete();
			}
		});
		System.out.println("Fin du traitement de la requête, un traitement asynchrone a été lancé");
		System.out.println("Le thread est déjà prêt à traiter une autre requête client");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
