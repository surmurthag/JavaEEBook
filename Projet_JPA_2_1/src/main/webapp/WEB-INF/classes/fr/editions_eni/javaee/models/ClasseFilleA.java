package fr.editions_eni.javaee.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ClasseFilleA")
public class ClasseFilleA extends ClasseRacine {
	private String variableMembreClasseFilleA;

	public String getVariableMembreClasseFilleA() {
		return variableMembreClasseFilleA;
	}

	public void setVariableMembreClasseFilleA(String variableMembreClasseFilleA) {
		this.variableMembreClasseFilleA = variableMembreClasseFilleA;
	}
}
