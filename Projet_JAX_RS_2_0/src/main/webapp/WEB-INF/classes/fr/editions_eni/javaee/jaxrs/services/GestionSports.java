package fr.editions_eni.javaee.jaxrs.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.BeanParam;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import fr.editions_eni.javaee.jaxrs.beans.Sport;
import fr.editions_eni.javaee.jaxrs.providers.TraceExport;


@Path("/Sports")
public class GestionSports {
	
	//EXEMPLE BASIQUE
	/*@GET
	public String getSports()
	{
		return "Tennis,Squash,Padel,Badminton";
	}*/
	
	//EXEMPLE @QueryParam
	@GET
	public String getSports(@QueryParam("ordre") String ordre)
	{
		if("asc".equalsIgnoreCase(ordre))
		{
			return "Badminton,Padel,Squash,Tennis";
		}
		else
		{
			return "Tennis,Squash,Padel,Badminton";
		}
	}
	
	//EXEMPLE @FormParam
	/*@POST
	public @NotNull String ajouterSport(@FormParam("nom") String nom,
										@FormParam("nombreJoueurs") int nombreJoueurs) throws IOException
	{
			return "Nom : " + nom + ", " +	"Nombre de joueurs : " + nombreJoueurs;
	}*/
	
	//EXEMPLE @BeanParam
	@POST
	public String ajouterSport(@BeanParam Sport sport)
	{
		return "Nom : " + sport.getNom() + ", " + "Nombre de joueurs : " + sport.getNombreJoueurs();
	}
	
	//EXEMPLE @PathParam
	@Path("/{id : \\d+}")
	@GET
	public String getSport(@PathParam("id") int id)
	{
		return "Le sport d'id " + id + " est le badminton";
	}
	
	//EXEMPLE @CookieParam - Extraction de la valeur d'un Cookie
	/*@Path("/Consultes")
	@GET
	public String getSportsDejaConsulte(@CookieParam("sportsConsutles") String sportConsultes)
	{
		return sportConsultes;
	}*/
	
	//EXEMPLE @CookieParam - Extraction d'un Cookie
	@Path("/Consultes")
	@GET
	public String getSportsDejaConsulte(@CookieParam("sportsConsutles") Cookie sportConsultes)
	{
		return sportConsultes!=null?sportConsultes.getValue():null;
	}
	
	//EXEMPLE @HeaderParam	
	@Path("/ReponseAdaptee")
	@GET
	public String getSportsReponseAdaptee(@HeaderParam("User-Agent") String userAgent)
	{
		if(userAgent.contains("Firefox"))
		{
			return "Voici la liste pour le navigateur FireFox: BADMINTON, SQUASH, PADEL, TENNIS";
		}
		return "Voici la liste pour les autres navigateurs: Badminton,Padel,Squash,Tennis";
	}
	
	//EXEMPLE @Context
	public void uneMethode(@Context UriInfo uri, @Context HttpHeaders httpHeaders){}
	
	//EXEMPLE retour de type Response
	@GET
	public Response getSports()
	{
		return Response.status(200)
				.encoding("UTF-8")
				.entity("Tennis,Squash,Padel,Badminton")
				.build();	
	}
	
	//EXEMPLE Validation élémentaire
	/*@POST
	public @NotNull String ajouterSport(@Size(min=2,max=30) @FormParam("nom") String nom,@FormParam("nombreJoueurs") int nombreJoueurse) throws IOException
	{
		String retour = null;
		if(nombreJoueurs>0)
		{
			retour = "Nom : " + nom + ", " + "Nombre de joueurs : " + nombreJoueurs;
		}
		return retour;
	}*/
	
	//EXEMPLE Validation des entités
	/*@POST
	public String ajouterSport(@Valid @BeanParam Sport sport)
	{
		return "Nom : "+ sport.getNom()+", "+"Nombre de joueurs : "+ sport.getNombreJoueurs();
	}*/
	
	//EXEMPLE MessageBodyReader (le paramètre sport est valorisé avec l'utilisation du MessageBodyReaderSport)
	@POST
	@Path("/ImportCSV")
	public String ajouterSportCSV(Sport sport)
	{
		
		String retour ="Le sport saisi est le "+sport.getNom();
		retour+=", il y a "+sport.getNombreJoueurs()+" joueurs";
		return retour;
	}
	
	//EXEMPLE MessageBodyWriter (le contenu du corps de la réponse est généré avec l'utilisation du MessageBodyWriterSport)
	@GET
	@Path("/ExportCSV")
	@Produces("text/csv")
	@TraceExport
	public Response getSportsCSV()
	{
		List<Sport> sports = new ArrayList<Sport>();
		sports.add(new Sport("Tennis",2));
		sports.add(new Sport("Squash",2));
		sports.add(new Sport("Padel",4));
		sports.add(new Sport("Badminton",2));
		
		GenericEntity<List<Sport>> resultat = new GenericEntity<List<Sport>>(sports){};
		
		return Response
				.ok()
				.entity(resultat)
				.build();
	}
	
	//EXEMPLE Utilisation du MessageBodyWriter de l'implémentation JAX permettant de générer du XML
	@GET
	@Path("/ExportXML")
	@Produces(MediaType.APPLICATION_XML)
	@TraceExport
	public Response getSportsXML()
	{
		List<Sport> sports = new ArrayList<Sport>();
		sports.add(new Sport("Tennis",2));
		sports.add(new Sport("Squash",2));
		sports.add(new Sport("Padel",4));
		sports.add(new Sport("Badminton",2));
		
		GenericEntity<List<Sport>> resultat = new GenericEntity<List<Sport>>(sports){};
		
		return Response
				.ok()
				.entity(resultat)
				.build();
	}
	
	//EXEMPLE Utilisation du MessageBodyWriter d'une librairie tierce pour générer du JSON
	@GET
	@Path("/ExportJSON")
	@Produces(MediaType.APPLICATION_JSON)
	@TraceExport
	public Response getSportsJSON()
	{
		List<Sport> sports =  new ArrayList<Sport>();
		sports.add(new Sport("Tennis",2));
		sports.add(new Sport("Squash",2));
		sports.add(new Sport("Padel",4));
		sports.add(new Sport("Badminton",2));
		
		GenericEntity<List<Sport>> resultat = new GenericEntity<List<Sport>>(sports){};
		
		return Response
				.ok()
				.entity(resultat)
				.build();
	}
}

