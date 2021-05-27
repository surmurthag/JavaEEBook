package fr.editions_eni.converters;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import fr.editions_eni.javaee.models.Surface;
import fr.editions_eni.javaee.models.Terrain;


public class ListeTerrainsConverter extends StrutsTypeConverter
{

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		List<Terrain> terrains = new ArrayList<>();
		if(values!=null)
		{
			for(String codeTerrain:values)
			{
				terrains.add(new Terrain(codeTerrain, Surface.BETON));
			}
		}
		
		return terrains;
	}
	
	@Override
	public String convertToString(Map context, Object o) {
		String retour = null;
		
		if(o instanceof Terrain)
		{
			retour = ((Terrain)o).getCode();
		}
		return retour;
	}
}
