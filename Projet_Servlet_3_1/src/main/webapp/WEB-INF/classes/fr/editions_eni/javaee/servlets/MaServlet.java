package fr.editions_eni.javaee.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MaServlet
 */
@WebServlet(description="Ma première servlet",
			name="MaServlet",
			value={"/MaServlet","/UneAutreUrl/*"},
			initParams={@WebInitParam(description="un paramètre",name = "auteur", value = "Thierry")})
/**
 * 
 * @author trichard
 */
public class MaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //Attention les variables membres sont partagées par tous les threads
	private String auteur;
    
	public MaServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println("Appel de la méthode init de la servlet");
    	this.auteur = this.getInitParameter("auteur");
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("Appel de la méthode service de la servlet");
    	System.out.println(this.getServletContext().getContextPath());
    	super.service(req, resp);
    	
    }
    
    @Override
    public void destroy() {
    	System.out.println("Appel de la méthode destroy de la servlet");
    	super.destroy();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Appel de la méthode doGet de la servlet");
		System.out.println();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
