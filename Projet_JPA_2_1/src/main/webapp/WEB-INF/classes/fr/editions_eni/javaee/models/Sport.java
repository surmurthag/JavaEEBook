package fr.editions_eni.javaee.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="sports",
      uniqueConstraints = @UniqueConstraint(name="uq_sports_nom",columnNames="nom")
)
public class Sport implements Serializable {

	private static final long serialVersionUID = 1L;
	//VARIABLES MEMBRES
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int identifiant;
	@Column(length=45,nullable=false)
	private String nom;
	@Column(name="nombre_joueurs",nullable=false)
	private int nombreJoueurs;
	@ManyToMany(mappedBy="sportsAutorises",cascade=CascadeType.ALL)
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
		this.terrainsCompatibles=new ArrayList<Terrain>();
	}	
}
