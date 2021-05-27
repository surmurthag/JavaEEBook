package fr.editions_eni.javaee.jpa.listeners;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

	private static EntityManagerFactory emf;
	

	public static EntityManagerFactory getEmf() {
		return emf;
	}

	public static void setEmf(EntityManagerFactory emf) {
		ApplicationListener.emf = emf;
	}
	
    /**
     * Default constructor. 
     */
    public ApplicationListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	if(this.emf!=null && this.emf.isOpen())
    	{
    		this.emf.close();
    	}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         this.emf = Persistence.createEntityManagerFactory("PU_JPA");
    }

	
}
