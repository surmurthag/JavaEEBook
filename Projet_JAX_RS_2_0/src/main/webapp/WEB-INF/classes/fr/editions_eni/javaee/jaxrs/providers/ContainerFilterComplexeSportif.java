package fr.editions_eni.javaee.jaxrs.providers;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(1)
public class ContainerFilterComplexeSportif implements ContainerRequestFilter, ContainerResponseFilter {

	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("Filtre avant exécution de la méthode ressource");
	}
	
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		System.out.println("Filtre après exécution de la méthode ressource");
	}
}


