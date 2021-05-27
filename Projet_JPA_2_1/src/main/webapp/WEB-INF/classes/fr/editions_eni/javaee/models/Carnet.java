package fr.editions_eni.javaee.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="carnets")
@IdClass(CarnetPK.class)
public class Carnet implements Serializable {

	private static final long serialVersionUID = 1L;
	//VARIABLES MEMBRES
//	@EmbeddedId
//	private CarnetPKEmbedded carnetPKEmbedded;
	//@MapsId("idSport")
	@Id
	@ManyToOne
	@JoinColumn(name="identifiant_sport", foreignKey=@ForeignKey(name="fk_carnets_sports"))
	private Sport sport;
	//@MapsId("idClient")
	@Id
	@ManyToOne
	@JoinColumn(name="identifiant_client", foreignKey=@ForeignKey(name="fk_carnets_clients"))
	private Client client;
	@Column(name="nombre_entrees",nullable=false)
	private int nombreEntrees;
	
	//ACCESSEURS/MUTATEURS
//	public CarnetPKEmbedded getCarnetPKEmbedded() {
//		return carnetPKEmbedded;
//	}
//	private void setCarnetPKEmbedded(CarnetPKEmbedded carnetPKEmbedded) {
//		this.carnetPKEmbedded = carnetPKEmbedded;
//	}
	public Sport getSport() {
		return sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getNombreEntrees() {
		return nombreEntrees;
	}
	public void setNombreEntrees(int nombreEntrees) {
		this.nombreEntrees = nombreEntrees;
	}
	
	//CONSTRUCTEURS
	public Carnet() {
		//this.carnetPKEmbedded=new CarnetPKEmbedded();
	}
	public Carnet(Sport sport, Client client, int nombreEntrees) {
		this();
		this.setSport(sport);
		this.setClient(client);
		this.setNombreEntrees(nombreEntrees);
	}
	
	
}
