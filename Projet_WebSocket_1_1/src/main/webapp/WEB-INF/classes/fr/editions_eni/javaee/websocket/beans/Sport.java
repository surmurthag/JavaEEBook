package fr.editions_eni.javaee.websocket.beans;

public class Sport 
{
	private String nom;
	private int nombreJoueurs;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNombreJoueurs() {
		return nombreJoueurs;
	}

	public void setNombreJoueurs(int nombreJoueurs) {
		this.nombreJoueurs = nombreJoueurs;
	}

	public Sport(String nom) {
		super();
		this.nom = nom;
	}
	
	public Sport(String nom, int nombreJoueurs) {
		super();
		this.nom = nom;
		this.nombreJoueurs=nombreJoueurs;
	}
	
	public Sport() {
		
	}
	
	
}
