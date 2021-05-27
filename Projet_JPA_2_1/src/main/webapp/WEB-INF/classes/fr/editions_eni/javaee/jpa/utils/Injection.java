package fr.editions_eni.javaee.jpa.utils;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Injection {

	@Inject
	private EntityManagerFactory emf;
	
	@Produces @ApplicationScoped
	public EntityManagerFactory getEntityManagerFactory()
	{
		System.out.println("creation entitymanagerfactory");
		return Persistence.createEntityManagerFactory("PU_JPA");
	}
	
	@Produces @RequestScoped
	public EntityManager getEntityManager()
	{
		System.out.println("creation entity mananger");
		return emf.createEntityManager();
	}
	
	@Produces @RequestScoped
	public Date getDate()
	{
		return new Date();
	}	
}
