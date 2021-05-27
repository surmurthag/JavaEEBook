package fr.editions_eni.javaee.models;

import java.io.Serializable;

public class Adresse implements Serializable {

	private static final long serialVersionUID = 1L;
	//VARIABLES MEMBRES
	private String rue;
	private int codePostal;
	private String ville;
	
	//ACCESSEURS/MUTATEURS
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	//CONSTRUCTEURS
	public Adresse() {

	}
	public Adresse(String rue, int codePostal, String ville) {
		super();
		this.setRue(rue); 
		this.setCodePostal(codePostal);
		this.setVille(ville);
	}
	
}
