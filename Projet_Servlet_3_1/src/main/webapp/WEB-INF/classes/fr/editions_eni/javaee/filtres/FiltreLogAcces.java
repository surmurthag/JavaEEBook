package fr.editions_eni.javaee.filtres;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class FiltreLogAcces
 */
@WebFilter(description="Filtre permettant de faire des logs d'accès",
			filterName="FiltreAcces",
			initParams = {
					@WebInitParam(name="auteur",value="Thierry")
			},
			urlPatterns = { 
					"/*" 
			},
			servletNames = {
					"MaServlet"
			},
			dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE,
				DispatcherType.ERROR
			})
public class FiltreLogAcces implements Filter {

	private String auteur;
    /**
     * Default constructor. 
     */
    public FiltreLogAcces() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Placez votre code ici
		System.out.println("Passage dans le filtre");
		HttpServletRequest requestHttp = (HttpServletRequest) request;
		System.out.println("Acces depuis " + request.getRemoteAddr() +" sur l'URL " + request.getServletContext().getContextPath());
		// Transmission de la requête le long de la chaine des filtres
		//jusqu'à atteindre la ressource demandée
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//Permet de lire les paramètres d'initialisation
		this.auteur = fConfig.getInitParameter("auteur");
	}

}
