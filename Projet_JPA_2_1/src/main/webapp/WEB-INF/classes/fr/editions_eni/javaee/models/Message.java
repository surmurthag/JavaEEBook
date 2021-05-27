package fr.editions_eni.javaee.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="messages")
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	//VARIABLES MEMBRES
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int identifiant;
	@Column(length=45,nullable=false)
	private String message;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_ecriture")
	private Date dateEcriture;
//	@ManyToOne
//	@JoinColumn(name="identifiant_client",foreignKey=@ForeignKey(name="fk_messages_clients"))
//	private Client client;
	
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
//	public Client getClient() {
//		return client;
//	}
//	public void setClient(Client client) {
//		this.client = client;
//	}
	
	//CONSTRUCTEURS
	public Message() {

	}
	public Message(String message, Date dateEcriture) {
		super();
		this.setMessage(message);
		this.setDateEcriture(dateEcriture);
	}
	
}
