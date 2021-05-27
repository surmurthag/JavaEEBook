package fr.editions_eni.javaee.jaxrs.providers;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
@TraceExport
@Priority(2)
public class ContainerFilterExport implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("Export en cours "+ requestContext.getUriInfo().getPath());
	}

}
