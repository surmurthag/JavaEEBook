package fr.editions_eni.javaee.models;

import java.io.Serializable;

public class CarnetPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int sport;
	private int client;
	
	public int getSport() {
		return sport;
	}
	public void setSport(int sport) {
		this.sport = sport;
	}
	public int getClient() {
		return client;
	}
	public void setclient(int client) {
		this.client = client;
	}
	
	public CarnetPK() {

	}
	
	@Override
	public int hashCode() {
		return this.getClient()+this.getSport();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean sontEgaux=false;
		if(obj!=null && obj instanceof CarnetPK)
		{
			CarnetPK autre = (CarnetPK)obj;
			sontEgaux=this.getClient()==autre.getClient() &&
					  this.getSport()==autre.getSport();
		}
		return sontEgaux;
	}
}
