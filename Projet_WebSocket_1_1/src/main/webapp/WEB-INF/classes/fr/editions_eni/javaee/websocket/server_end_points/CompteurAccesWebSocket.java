package fr.editions_eni.javaee.websocket.server_end_points;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


//@ServerEndpoint(value="/acces/{page}", encoders=EncoderSport.class, decoders=DecoderSport.class)
@ServerEndpoint(value="/acces")
public class CompteurAccesWebSocket {
	
	private static final Set<Session> sessionsActives = Collections.synchronizedSet(new HashSet<Session>());
	
	private void avertir()
	{
		try {
			for(Session sessionActive:sessionsActives)
			{	
				System.out.println("avertissement d'une session");
				if(sessionActive.isOpen())
				{
					sessionActive.getBasicRemote().sendText(String.valueOf(sessionsActives.size()));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@OnMessage
	public void onMessage(String messageRecu, Session session)
	{
		System.out.println("le serveur a reçu le message suivant: "+ messageRecu);
		try {
			session.getBasicRemote().sendText(String.valueOf(sessionsActives.size()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//EXEMPLE ENCODEUR : L'appel de la méthode sendObject avec un sport en paramètre provoque l'usage de la classe EncoderSport
	/*
	@OnMessage
	public void onMessage(String messageRecu, Session session)
	{
		System.out.println("le serveur a reçu le message suivant: "+ messageRecu);
		try {
			Sport sport = new Sport("squash", 2);
			session.getBasicRemote().sendObject(sport);
		} catch (EncodeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	//EXEMPLE DECODEUR : Qu'une seule méthode annotée avec @OnMessage n'est possible sur une classe
	/*@OnMessage
	public void onMessage(Sport sport, Session session)
	{
		System.out.println("le serveur a reçu le sport suivant: "+ sport.getNom());
	}*/
	
	@OnError
	public void OnError(Throwable t, Session session)
	{
		
	}
	@OnClose
	public void onClose(Session session)
	{
		sessionsActives.remove(session);
		System.out.println("fermeture d'une session");
		this.avertir();
	}
	@OnOpen
	public void onOpen(Session session)
	{
		sessionsActives.add(session);
		System.out.println("ouverture d'une session");
		this.avertir();
	}
}
