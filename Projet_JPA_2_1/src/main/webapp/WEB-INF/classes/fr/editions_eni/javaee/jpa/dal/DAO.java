package fr.editions_eni.javaee.jpa.dal;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import fr.editions_eni.javaee.jpa.utils.Transactional;

@RequestScoped
public class DAO {

	@Inject
	EntityManager em;
	
	public DAO() {
		System.out.println("création DAO");
	}
	
	@Transactional
	public <T> void enregister(T entite)
	{
		try
		{
		System.out.println("début enregistrement");
		System.out.println(em.hashCode());
		em.persist(entite);
		System.out.println("fin enregistrement");
		while(true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Transactional
	public <T> T mettreAjour(T entite)
	{
		entite =em.merge(entite);
		em.persist(entite);
		return entite;
	}
	@Transactional
	public <T> void supprimer(T entite)
	{
		em.remove(entite);
	}

	public<T> List<T> getEntites() {
		//...
		return null;
	}
}
