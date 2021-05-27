package fr.editions_eni.javaee.listeners;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
@WebListener
public class RequestListener implements ServletRequestListener, ServletRequestAttributeListener, AsyncListener {

    /**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }
    
    /**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    }
    
    /**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    }
    
	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see AsyncListener#onStartAsync(AsyncEvent)
     */
    public void onStartAsync(AsyncEvent event) throws java.io.IOException { 
         // TODO Auto-generated method stub
    }
    
    /**
     * @see AsyncListener#onComplete(AsyncEvent)
     */
    public void onComplete(AsyncEvent event) throws java.io.IOException { 
         // TODO Auto-generated method stub
    }
    
    /**
     * @see AsyncListener#onError(AsyncEvent)
     */
    public void onError(AsyncEvent event) throws java.io.IOException { 
         // TODO Auto-generated method stub
    }

	/**
     * @see AsyncListener#onTimeout(AsyncEvent)
     */
    public void onTimeout(AsyncEvent event) throws java.io.IOException { 
         // TODO Auto-generated method stub
    }

	
	
}
