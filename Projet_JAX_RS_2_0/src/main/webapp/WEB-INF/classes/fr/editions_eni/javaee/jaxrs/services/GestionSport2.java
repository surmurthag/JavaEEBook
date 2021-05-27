package fr.editions_eni.javaee.jaxrs.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import fr.editions_eni.javaee.jaxrs.beans.Sport;

@Path("/Sports2")
public class GestionSport2 {

	/*@GET
	public Response getSports()
	{
		return Response.status(200)
				.encoding("UTF-8")
				.entity("Tennis,Squash,Padel,Badminton")
				.build();	
	}*/
	
	
	/*@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getSports()
	{
		List<Sport> listeSport= new ArrayList<>();
		listeSport.add(new Sport("Tennis"));
		listeSport.add(new Sport("Squash"));
		listeSport.add(new Sport("Padel"));
		listeSport.add(new Sport("Badminton"));
		GenericEntity<List<Sport>> resultat = new GenericEntity<List<Sport>>(listeSport) {};
		
		return Response.status(200)
				.entity(resultat)
				.build();	
	}*/
	
	@GET
	public GenericEntity<List<String>> getSports()
	{
		List<String> listeSport= new ArrayList<String>();
		listeSport.add("Foot");
		listeSport.add("Squash");
		listeSport.add("Padel");
		listeSport.add("Badminton");
		GenericEntity<List<String>> resultat = new GenericEntity<List<String>>(listeSport, Sport.class) {};	
		return resultat;	
	}
	
	/*
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Sport getSports()
	{
		return new Sport("UN SPORT");	
	}*/
	
	/*@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Sport> getSports()
	{
		List<Sport> listeSport= new ArrayList<>();
		listeSport.add(new Sport("a"));
		listeSport.add(new Sport("b"));
		listeSport.add(new Sport("c"));
		listeSport.add(new Sport("d"));
		return listeSport;	
	}*/
}
