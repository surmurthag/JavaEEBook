package fr.editions_eni.javaee.jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

import fr.editions_eni.javaee.jpa.listeners.ApplicationListener;

public class JPAUtil {
	public static EntityManager getEntityManager()
	{
		return ApplicationListener.getEmf().createEntityManager();
	}
}
