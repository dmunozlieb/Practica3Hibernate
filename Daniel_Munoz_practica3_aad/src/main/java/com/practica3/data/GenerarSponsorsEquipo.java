package com.practica3.data;

import java.util.HashMap;
import java.util.List;

import com.practica3.model.Patrocinador;

/*** Esta clase realiza/se encarga de relacionar sponsors a equipo. * 
 * @author Daniel Muñoz */

public class GenerarSponsorsEquipo {
	private static HashMap<String, List<Patrocinador>> sponsorsEquipo = new HashMap<String, List<Patrocinador>>();
	
	static {
		sponsorsEquipo.put("BARÇA", List.of(GenerarSponsors.sponsorAdidas(), GenerarSponsors.sponsorStar(), GenerarSponsors.sponsorVital()
				,GenerarSponsors.sponsorEnergy()));
		sponsorsEquipo.put("BIDASOA IRUN", List.of(GenerarSponsors.sponsorPuma(), GenerarSponsors.sponsorConnect(),GenerarSponsors.sponsorNike()));
		sponsorsEquipo.put("FRAIKIN BM. GRANOLLERS", List.of(GenerarSponsors.sponsorGameTime(),GenerarSponsors.sponsorSwift()));
		sponsorsEquipo.put("BM. LOGROÑO LA RIOJA", List.of(GenerarSponsors.sponsorNike()));
		sponsorsEquipo.put("RECOLETAS AT. VALLADOLID", List.of(GenerarSponsors.sponsorMetro()));
		sponsorsEquipo.put("BATHCO BM. TORRELAVEGA", List.of(GenerarSponsors.sponsorStar(), GenerarSponsors.sponsorVital()));
		sponsorsEquipo.put("HELVETIA ANAITASUNA", List.of(GenerarSponsors.sponsorConnect()));
		sponsorsEquipo.put("VIVEROS HEROL BM. NAVA",List.of(GenerarSponsors.sponsorGameTime()));
	}
	
	public static List<Patrocinador> getSponsorByTeam(String nombreEquipo){
		return sponsorsEquipo.get(nombreEquipo);
	}
}
