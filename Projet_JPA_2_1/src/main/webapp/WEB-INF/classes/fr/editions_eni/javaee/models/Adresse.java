package fr.editions_eni.javaee.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Embeddable
//@Entity
//@Table(name="adresses")
public class Adresse implements Serializable {

	private static final long serialVersionUID = 1L;
	//VARIABLES MEMBRES
//	@Id
//	private int identifiant;
	@Column(length=255,nullable=false)
	private String rue;
	@Column(name="code_postal",nullable=false)
	private int codePostal;
	@Column(length=45,nullable=false)
	private String ville;
//	@OneToOne(mappedBy="adresse")
//	private Client client;
	
	//ACCESSEURS/MUTATEURS
//	public int getIdentifiant() {
//		return identifiant;
//	}
//	public void setIdentifiant(int identifiant) {
//		this.identifiant = identifiant;
//	}
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
	
//	public Client getClient() {
//		return client;
//	}
//	public void setClient(Client client) {
//		this.client = client;
//	}
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
