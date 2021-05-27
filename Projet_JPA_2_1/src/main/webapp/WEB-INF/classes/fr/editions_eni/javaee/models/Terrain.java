package fr.editions_eni.javaee.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="terrains")
public class Terrain implements Serializable {

	private static final long serialVersionUID = 1L;
	//VARIABLES MEMBRES
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int identifiant;
	private String code;
	@Enumerated(EnumType.STRING)
	@Column(length=45)
	private Surface surface;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="terrains_sports",
			joinColumns=@JoinColumn(name="identifiant_terrain", 
					foreignKey=@ForeignKey(name="fk_terrains"), 
					nullable=false),
			inverseJoinColumns=@JoinColumn(name="identifiant_sport",
									foreignKey=@ForeignKey(name="fk_sports"),
									nullable=false))
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
		this.sportsAutorises=new ArrayList<Sport>();
	}
	
}
