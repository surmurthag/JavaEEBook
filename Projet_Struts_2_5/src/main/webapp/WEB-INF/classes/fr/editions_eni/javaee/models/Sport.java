package fr.editions_eni.javaee.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;

//import javax.validation.constraints.Min;
//Import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

public class Sport implements Serializable {

	private static final long serialVersionUID = 1L;
	//VARIABLES MEMBRES
	private int identifiant;
	//@NotNull(message="Le nom est obligatoire")
	private String nom;
	//@Min(value=1, message="Le nombre de joueurs doit être compris entre 1 et 10")
	//@Min(value=1, message="{sport.erreur.nombreJoueurs}")
	private int nombreJoueurs;
	//@NotNull
	//@Size(min=1, message="Au moins un terrain doit être sélectionné")
	private List<Terrain> terrainsCompatibles = new ArrayList<Terrain>();

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
	@TypeConversion(converter="fr.editions_eni.converters.ListeTerrainsConverter")
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
	
	//METHODES
	@Override
	public boolean equals(Object obj) {
		boolean sontEgaux=false;
		if(obj!=null && obj instanceof Sport)
		{
			Sport autre = (Sport) obj;
			sontEgaux=this.nom!=null && this.nom.equalsIgnoreCase(autre.nom);
		}
		return sontEgaux;
	}
}
