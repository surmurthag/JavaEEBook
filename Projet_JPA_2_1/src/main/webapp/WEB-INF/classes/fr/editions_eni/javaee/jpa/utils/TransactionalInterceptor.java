package fr.editions_eni.javaee.jpa.utils;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Interceptor @Transactional
public class TransactionalInterceptor 
{
	private @Inject EntityManager em;
 
	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception
	{
		Object resultat=null;
		System.out.println("DEBUT TRANSACTION");
		EntityTransaction t = em.getTransaction();
		try 
		{
			if(!t.isActive())
			{
				t.begin();
			}
			resultat = context.proceed();
			if(t != null && t.isActive())
			{
				t.commit();
			}
			return resultat;
		} 
		catch(Exception e) 
		{
			System.out.println("ERREUR");
			e.printStackTrace();
			t.rollback();
			throw e;
		} 
	}	 
}
