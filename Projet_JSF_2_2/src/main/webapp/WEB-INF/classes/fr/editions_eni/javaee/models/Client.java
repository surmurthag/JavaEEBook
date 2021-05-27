package fr.editions_eni.javaee.models;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Client  implements Serializable {

	private static final long serialVersionUID = 1L;
	//VARIABLES MEMBRES
	private int identifiant;
	private String nom;
	private String prenom;
	private Adresse adresse;
	private String email;
	private String motDePasse;
	private String langue;
	private String theme;
	private List<Message> messages;
	private Set<Carnet> carnets;
	
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public Set<Carnet> getCarnets() {
		return carnets;
	}
	public void setCarnets(Set<Carnet> carnets) {
		this.carnets = carnets;
	}
	
	//CONSTRUCTEURS
	public Client() {
		
	}
	public Client(String nom, String prenom, Adresse adresse, String email) {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdresse(adresse);
		this.setEmail(email);
	}
	
}
