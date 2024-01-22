package com.practica3.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.practica3.model.Equipo;
import com.practica3.model.Estadio;
import com.practica3.model.Jugador;
import com.practica3.model.Patrocinador;


public class GenerarEquipos {
	private static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static ArrayList<Equipo> lista_equipos = crearEquipos();

	static {
		addJugadores();
		addSponsors(lista_equipos);
	}

	public static ArrayList<Equipo> generarEquipos() {
		return lista_equipos;
	}

	private static ArrayList<Equipo> crearEquipos() {
		
		return new ArrayList<Equipo>(Arrays.asList(
				new Equipo("BARÇA", 510200.34,
						new Estadio("Palau Blaugrana", "Barcelona", LocalDate.parse("23/10/1973", PATTERN))),
				new Equipo("BIDASOA IRUN", 329000,
						new Estadio("Artaleku", "Irun", LocalDate.parse("12/07/2010", PATTERN))),
				new Equipo("FRAIKIN BM. GRANOLLERS", 234098.74,
						new Estadio("Palau d’Esports de Granollers", "Granollers",
								LocalDate.parse("20/09/1991", PATTERN))),
				new Equipo("BM. LOGROÑO LA RIOJA", 240200.22,
						new Estadio("Palacio de los Deportes de la Rioja", "Logroño",
								LocalDate.parse("29/04/2003", PATTERN))),
				new Equipo("RECOLETAS AT. VALLADOLID", 199000,
						new Estadio("Polideportivo Huerta Del Rey", "Valladolid",
								LocalDate.parse("17/07/1975", PATTERN))),
				new Equipo("BATHCO BM. TORRELAVEGA", 125734.67, new Estadio("Pabellón Municipal Vicente Trueba",
						"Torrelavega", LocalDate.parse("09/02/1986", PATTERN))),
				new Equipo("HELVETIA ANAITASUNA", 101000.67, new Estadio("Pabellón Anaitasuna",
						"Pamplona", LocalDate.parse("19/02/1976", PATTERN))),
				new Equipo("VIVEROS HEROL BM. NAVA", 86456.67, new Estadio("Pabellón Municipal Guerreros Naveros",
						"Nava de la Asunción", LocalDate.parse("22/07/1996", PATTERN)))));
	}

	private static void addJugadores() {
		for(Equipo equipo:lista_equipos) {
			List<Jugador>jugadores = GenerarJugadoresEquipo.getJugadoresByTeam(equipo.getNombre_equipo());
			equipo.agregarJugadores(jugadores);
		}
	}

	private static void addSponsors(ArrayList<Equipo> equipos) {
		for(Equipo equipo:lista_equipos) {
			List<Patrocinador>sponsors = GenerarSponsorsEquipo.getSponsorByTeam(equipo.getNombre_equipo());
			equipo.agregarSponsors(sponsors);
		}
		
	}
}
