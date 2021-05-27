package fr.editions_eni.javaee.models;

import java.io.Serializable;

public class Carnet implements Serializable {

	private static final long serialVersionUID = 1L;
	//VARIABLES MEMBRES
	private Sport sport;
	private Client client;
	private int nombreEntrees;
	
	//ACCESSEURS/MUTATEURS
	public Sport getSport() {
		return sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getNombreEntrees() {
		return nombreEntrees;
	}
	public void setNombreEntrees(int nombreEntrees) {
		this.nombreEntrees = nombreEntrees;
	}
	
	//CONSTRUCTEURS
	public Carnet() {
		
	}
	public Carnet(Sport sport, Client client, int nombreEntrees) {
		super();
		this.setSport(sport);
		this.setClient(client);
		this.setNombreEntrees(nombreEntrees);
	}
	
	
}
