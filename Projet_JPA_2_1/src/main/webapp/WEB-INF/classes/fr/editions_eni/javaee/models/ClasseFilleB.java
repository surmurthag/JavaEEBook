package fr.editions_eni.javaee.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ClasseFilleB")
public class ClasseFilleB extends ClasseRacine {
	private String variableMembreClasseFilleB;

	public String getVariableMembreClasseFilleB() {
		return variableMembreClasseFilleB;
	}

	public void setVariableMembreClasseFilleB(String variableMembreClasseFilleB) {
		this.variableMembreClasseFilleB = variableMembreClasseFilleB;
	}
}
