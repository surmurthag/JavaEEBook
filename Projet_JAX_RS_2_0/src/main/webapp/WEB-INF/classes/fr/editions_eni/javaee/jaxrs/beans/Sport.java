package fr.editions_eni.javaee.jaxrs.beans;

import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="sport")
public class Sport 
{
	@Size(min=2,max=30)
	@FormParam("nom")
	private String nom;
	@FormParam("nombreJoueurs")
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
