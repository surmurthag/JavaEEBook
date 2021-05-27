package fr.editions_eni.javaee.jaxrs.providers;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import fr.editions_eni.javaee.jaxrs.beans.Sport;

@Provider
@Produces(MediaType.TEXT_PLAIN)
public class MessageBodyWriterSport implements MessageBodyWriter<List<Sport>> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		boolean isWritable=false;
	    if (List.class.isAssignableFrom(type) && genericType instanceof ParameterizedType) 
	    {
	      ParameterizedType typeConstruit = (ParameterizedType) genericType;
	      Type[] typesArguments = (typeConstruit.getActualTypeArguments());
	      isWritable = (typesArguments.length == 1 && typesArguments[0].equals(Sport.class));
	    } 
	    return isWritable;
	}
	
	@Override
	public long getSize(List<Sport> t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return -1;
	}

	@Override
	public void writeTo(List<Sport> t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
					throws IOException, WebApplicationException {
		PrintWriter pw = new PrintWriter(entityStream);
		for(Sport sport:t)
		{
			pw.println(sport.getNom()+";"+sport.getNombreJoueurs());
		}
		pw.flush();
		pw.close();
	}

	

	
}
