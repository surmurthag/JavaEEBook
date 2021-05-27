package fr.editions_eni.javaee.websocket.server_end_points;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import fr.editions_eni.javaee.websocket.beans.Sport;

public class DecoderSport implements Decoder.Text<Sport> {

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		
	}

	@Override
	public Sport decode(String message) throws DecodeException {
		String[] donnees = message.split(";");
		Sport sport = new Sport();
		sport.setNom(donnees[0]);
		sport.setNombreJoueurs(Integer.parseInt(donnees[1]));
		return sport;
	}

	@Override
	public boolean willDecode(String message) {
		return true;
	}
}
