package fr.editions_eni.javaee.models;

import java.io.Serializable;
import java.util.List;

public class Terrain implements Serializable {

	private static final long serialVersionUID = 1L;
	//VARIABLES MEMBRES
	private int identifiant;
	private String code;
	private Surface surface;
	private List<Sport> sportsAutorises;
	
	//ACCESSEURS/MUTATEURS
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Surface getSurface() {
		return surface;
	}
	public void setSurface(Surface surface) {
		this.surface = surface;
	}
	public List<Sport> getSportsAutorises() {
		return sportsAutorises;
	}
	public void setSportsAutorises(List<Sport> sportsAutorises) {
		this.sportsAutorises = sportsAutorises;
	}
	
	//CONSTRUCTEURS
	public Terrain() {
		super();
		
	}
	public Terrain(String code, Surface surface) {
		super();
		this.setCode(code);
		this.setSurface(surface);
	}
	
}
