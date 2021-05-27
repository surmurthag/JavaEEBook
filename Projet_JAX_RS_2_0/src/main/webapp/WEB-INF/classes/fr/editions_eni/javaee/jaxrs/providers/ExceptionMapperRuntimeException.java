package fr.editions_eni.javaee.jaxrs.providers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionMapperRuntimeException implements ExceptionMapper<RuntimeException> {

	@Override
	public Response toResponse(RuntimeException exception) {
		return Response
				.status(Status.INTERNAL_SERVER_ERROR)
				.entity("Erreur inattendue : " + exception.getMessage())
				.build();
	}

}
