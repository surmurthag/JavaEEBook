package fr.editions_eni.javaee.models;

import java.io.Serializable;
import java.util.List;

public class Sport implements Serializable {

	private static final long serialVersionUID = 1L;
	//VARIABLES MEMBRES
	private int identifiant;
	private String nom;
	private int nombreJoueurs;
	private List<Terrain> terrainsCompatibles;

	//ACCESSEURS/MUTATEURS
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
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
	public List<Terrain> getTerrainsCompatibles() {
		return terrainsCompatibles;
	}
	public void setTerrainsCompatibles(List<Terrain> terrainsCompatibles) {
		this.terrainsCompatibles = terrainsCompatibles;
	}
	
	//CONSTRUCTEURS
	public Sport() {
		
	}
	public Sport(String nom) {
		super();
		this.setNom(nom);
	}
	public Sport(String nom, int nombreJoueurs) {
		super();
		this.setNom(nom);
		this.setNombreJoueurs(nombreJoueurs);
	}	
}
