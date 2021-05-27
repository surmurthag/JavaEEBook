package fr.editions_eni.javaee.jaxrs.providers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import fr.editions_eni.javaee.jaxrs.beans.Sport;

@Provider
public class MessageBodyReaderSport implements MessageBodyReader<Sport> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		
		return type.equals(Sport.class);
	}

	@Override
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Sport readFrom(Class<Sport> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
					throws IOException, WebApplicationException {
		int longueurContenu =Integer.parseInt(httpHeaders.get("content-length").get(0));
		byte[] contenuEnByte = new byte[longueurContenu];
		entityStream.read(contenuEnByte, 0, longueurContenu);
		String contenu = new String(contenuEnByte);
		contenu = URLDecoder.decode(contenu,"UTF-8");
		contenu = contenu.replace("csv=", "");
		String[] donneesDuSport = contenu.split(";");
		
		Sport sport = new Sport();
		sport.setNom(donneesDuSport[0]);
		sport.setNombreJoueurs(Integer.parseInt(donneesDuSport[1]));
		return sport;
	}

}


