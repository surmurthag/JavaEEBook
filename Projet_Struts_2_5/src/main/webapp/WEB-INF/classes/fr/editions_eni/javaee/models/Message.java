package fr.editions_eni.javaee.models;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	//VARIABLES MEMBRES
	private int identifiant;
	private String message;
	private Date dateEcriture;
	
	//ACCESSEURS/MUTATEURS
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDateEcriture() {
		return dateEcriture;
	}
	public void setDateEcriture(Date dateEcriture) {
		this.dateEcriture = dateEcriture;
	}
	
	//CONSTRUCTEURS
	public Message() {

	}
	public Message(String message, Date dateEcriture) {
		super();
		this.setMessage(message);
		this.setDateEcriture(dateEcriture);
	}
	
}
