package fr.editions_eni.javaee.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="clients")
@SecondaryTable(name="preferences",
				pkJoinColumns=@PrimaryKeyJoinColumn(name="identifiant_client"),
				foreignKey=@ForeignKey(name="fk_preferences_clients"))
//@IdClass(ClientPK.class)
@NamedQueries({
	@NamedQuery(name="Client.selectAll",query="SELECT c FROM Client c"),
	@NamedQuery(name="Client.selectByName",query="SELECT c FROM Client c WHERE c.nom=:nom")})
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	//VARIABLES MEMBRES
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int identifiant;
	//@Id
	@Column(length=45,nullable=false)
	private String nom;
	//@Id
	@Column(length=45)
	private String prenom;
//	@OneToOne
//	@JoinColumn(name="adresse", foreignKey=@ForeignKey(name="fk_clients_adresses"))
	private Adresse adresse;
	@Column(length=100,nullable=false)
	private String email;
	@Column(name="mot_de_passe",length=100,nullable=false)
	private String motDePasse;
	@Column(length=45,table="preferences")
	private String langue;
	@Column(length=45,table="preferences")
	private String theme;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@OrderBy(value="dateEcriture")
	@JoinColumn(name="identifiant_client", foreignKey=@ForeignKey(name="fk_messages_clients"), nullable=false, updatable=false)
	//@MapKey
	private List<Message> messages;
	//private Map<Integer, Message> messages;
	@OneToMany(mappedBy="client")
	private Set<Carnet> carnets;
	
	@ElementCollection(fetch=FetchType.LAZY)
	@CollectionTable(name="venues",
					joinColumns=@JoinColumn(name="identifiant_client"),
					foreignKey=@ForeignKey(name="fk_venues_clients"))
	private List<Date> datesVenues;
	
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
	
	public List<Date> getDatesVenues() {
		return datesVenues;
	}
	public void setDatesVenues(List<Date> datesVenues) {
		this.datesVenues = datesVenues;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
//	public Map<Integer, Message> getMessages() {
//		return messages;
//	}
//	public void setMessages(Map<Integer, Message> messages) {
//		this.messages = messages;
//	}
	public Set<Carnet> getCarnets() {
		return carnets;
	}
	public void setCarnets(Set<Carnet> carnets) {
		this.carnets = carnets;
	}
	
	//CONSTRUCTEURS
	public Client() {
		//this.messages=new ArrayList<>();
	}
	public Client(String nom, String prenom, Adresse adresse, String email, String motDePasse) {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdresse(adresse);
		this.setEmail(email);
		this.setMotDePasse(motDePasse);
		//this.messages=new ArrayList<>();
		this.datesVenues=new ArrayList<>();
	}
	
}
