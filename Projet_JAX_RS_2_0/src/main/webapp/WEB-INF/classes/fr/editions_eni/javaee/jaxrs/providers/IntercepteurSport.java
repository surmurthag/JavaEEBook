package fr.editions_eni.javaee.jaxrs.providers;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

@Provider
public class IntercepteurSport implements ReaderInterceptor, WriterInterceptor {

	@Override
	public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
		System.out.println("Intercepteur avant l'écriture");
		context.proceed();

	}

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
		System.out.println("Intercepteur avant lecture");
		return context.proceed();
	}

}
