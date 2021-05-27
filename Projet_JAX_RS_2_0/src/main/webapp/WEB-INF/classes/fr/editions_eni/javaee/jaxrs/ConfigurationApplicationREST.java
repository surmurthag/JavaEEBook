package fr.editions_eni.javaee.jaxrs;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/REST")
public class ConfigurationApplicationREST extends Application {

	/*@Override
	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> classesAUtiliser = new HashSet<Class<?>>();
		classesAUtiliser.add(ContainerFilterComplexeSportif.class);
		classesAUtiliser.add(ContainerFilterExport.class);
		classesAUtiliser.add(MessageBodyReaderSport.class);
		classesAUtiliser.add(MessageBodyWriterSport.class);
		return classesAUtiliser;
	}
	
	@Override
	public Set<Object> getSingletons() {
		HashSet<Object> objetsAUtiliser = new HashSet<Object>();
		objetsAUtiliser.add(new IntercepteurSport());
		return super.getSingletons();
	}*/
}
