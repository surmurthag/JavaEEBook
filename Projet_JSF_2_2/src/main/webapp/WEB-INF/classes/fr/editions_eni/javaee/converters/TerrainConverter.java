package fr.editions_eni.javaee.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import fr.editions_eni.javaee.models.Surface;
import fr.editions_eni.javaee.models.Terrain;

@FacesConverter(value="TerrainConverter")
public class TerrainConverter implements Converter
{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) 
	{
		return new Terrain(value, Surface.BETON);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) 
	{
		String retour = null;
		
		if(value instanceof Terrain)
		{
			retour = ((Terrain)value).getCode();
		}
		return retour;
	}
}
