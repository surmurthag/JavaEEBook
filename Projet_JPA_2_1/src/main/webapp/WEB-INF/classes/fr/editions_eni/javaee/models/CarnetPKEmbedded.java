package fr.editions_eni.javaee.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CarnetPKEmbedded implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idSport;
	private int idClient;
	
	public int getIdSport() {
		return idSport;
	}

	public void setIdSport(int idSport) {
		this.idSport = idSport;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
	public CarnetPKEmbedded() {

	}
	
	@Override
	public int hashCode() {
		return this.getIdClient()+this.getIdSport();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean sontEgaux=false;
		if(obj!=null && obj instanceof CarnetPKEmbedded)
		{
			CarnetPKEmbedded autre = (CarnetPKEmbedded)obj;
			sontEgaux=this.getIdClient()==autre.getIdClient() &&
					  this.getIdSport()==autre.getIdSport();
		}
		return sontEgaux;
	}

	
}
