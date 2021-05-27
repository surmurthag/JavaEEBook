package fr.editions_eni.javaee.websocket.server_end_points;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import fr.editions_eni.javaee.websocket.beans.Sport;

public class EncoderSport implements Encoder.Text<Sport> {

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		
	}

	@Override
	public String encode(Sport sport) throws EncodeException {
		String representationTextuelle="";
		if(sport!=null)
		{
			representationTextuelle=sport.getNom()+";"+sport.getNombreJoueurs();
		}
		return representationTextuelle;
	}

	

}
