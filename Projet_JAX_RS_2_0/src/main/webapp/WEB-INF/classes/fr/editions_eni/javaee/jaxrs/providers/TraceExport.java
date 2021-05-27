package fr.editions_eni.javaee.jaxrs.providers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.ws.rs.NameBinding;

//Annotation permettant de nommer un filtre afin de l'associer qu'à certaines classes ressources ou certaines méthodes ressources
@NameBinding
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TraceExport {

}
