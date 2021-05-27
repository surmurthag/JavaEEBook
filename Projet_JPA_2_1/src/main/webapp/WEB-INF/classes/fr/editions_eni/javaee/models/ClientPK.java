package fr.editions_eni.javaee.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


public class ClientPK implements Serializable{
	private static final long serialVersionUID = 1L;

	private String nom;
	private String prenom;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public ClientPK() {

	}
	public ClientPK(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	@Override
	public int hashCode() {
		return this.nom.hashCode()+this.prenom.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		boolean sontEgaux=false;
		if(obj!=null && obj instanceof ClientPK)
		{
			ClientPK autre = (ClientPK)obj;
			sontEgaux=this.getNom().equals(autre.getNom()) &&
					  this.getPrenom().equals(autre.getPrenom());
		}
		return sontEgaux;
	}
}
