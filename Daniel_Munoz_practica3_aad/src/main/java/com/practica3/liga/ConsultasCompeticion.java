package com.practica3.liga;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.practica3.impldao.CompeticionImplDAO;
import com.practica3.impldao.EquipoImplDAO;
import com.practica3.impldao.JugadorImplDAO;
import com.practica3.impldao.PatrocinadorImplDAO;
import com.practica3.model.Competicion;
import com.practica3.model.Equipo;
import com.practica3.model.Fichaje_historia;
import com.practica3.model.Jugador;
import com.practica3.model.Patrocinador;
import com.practica3.service.GestionEquipo;

/*** Esta clase realiza/se encarga ejecutar todas las consultas de la 2 parte. * 
 * @author Daniel Muñoz */

public class ConsultasCompeticion {

	private static final Logger LOGGER = LogManager.getLogger(Fichajes.class);
	private static JugadorImplDAO jugadorDAO = new JugadorImplDAO();
	private static CompeticionImplDAO competicionDAO = new CompeticionImplDAO();
	private static EquipoImplDAO equipoDAO = new EquipoImplDAO();
	private static PatrocinadorImplDAO patrocinadorDAO = new PatrocinadorImplDAO();
	private static GestionEquipo<Object> gestion = new GestionEquipo<>();
	public static void ejecutarConsultas() {
		ejecutarConsulta1();
		ejecutarConsulta2();
		ejecutarConsulta3();
		ejecutarConsulta4();
		ejecutarConsulta5();
		ejecutarConsulta6();
		ejecutarConsulta7();
		ejecutarConsulta9();
		ejecutarConsulta10();
		ejecutarConsulta11();
		ejecutarConsulta12();
		ejecutarConsulta13();
		ejecutarConsulta14();
	}

	private static void ejecutarConsulta1() {
		LOGGER.info("#### 1. Obtener características de competicion. ####");
		List<Competicion> competiciones = competicionDAO.getCompeticion();
		competiciones.forEach(competicion -> LOGGER.info(competicion.toString()));
		LOGGER.info("##################### FIN Consulta 1 #################################");
	}

	private static void ejecutarConsulta2() {
		LOGGER.info("#### 2. Obtener equipos de la competicion. ####");
		List<Equipo> equipos = equipoDAO.getEquiposCompeticion();
		equipos.forEach(equipo -> LOGGER.info(equipo.toString()));
		LOGGER.info("##################### FIN Consulta 2 #################################");
	}

	private static void ejecutarConsulta3() {
		LOGGER.info("#### 3. Obtener jugadores del equipo indicado. ####");
		List<Jugador> jugadores_equipo = jugadorDAO.getJugadoresEquipo(1);
		jugadores_equipo.forEach(jugador -> LOGGER.info(jugador.toString()));
		LOGGER.info("##################### FIN Consulta 3 #################################");
	}
	
	private static void ejecutarConsulta4() {
		LOGGER.info("#### 4. Obtener patrocinadores de un equipo. ####");
		List<Patrocinador> patrocinadores = patrocinadorDAO.getPatrocinadoresEquipo(2);
		patrocinadores.forEach(patrocinador -> LOGGER.info(patrocinador.toString()));
		LOGGER.info("##################### FIN Consulta 4 #################################");
	}
	
	private static void ejecutarConsulta5() {
		LOGGER.info("#### 5. Obtener patrocinadores y jugadores de un equipo. ####");
		List<Object[]> patrocinadores_jugadores = patrocinadorDAO.getJugadoresYPatrocinadores(1);
		Set<Jugador> jugadores_sin_repetir = new HashSet<>();
		Set<Patrocinador> patrocinadores_sin_repetir = new HashSet<>();
		for(Object[]fila:patrocinadores_jugadores) {
			jugadores_sin_repetir.add((Jugador) fila[0]);
			patrocinadores_sin_repetir.add((Patrocinador) fila[1]);
		}
		LOGGER.info(jugadores_sin_repetir);
		LOGGER.info(patrocinadores_sin_repetir);
		LOGGER.info("##################### FIN Consulta 5 #################################");
	}
	
	private static void ejecutarConsulta6() {
		LOGGER.info("#### 6. Obtener media de los jugadores de un equipo. ####");
		Object media = jugadorDAO.getEdadPromedioJugadores(1);
		LOGGER.info(media);
		LOGGER.info("##################### FIN Consulta 6 #################################");
	}
	
	private static void ejecutarConsulta7() {
		LOGGER.info("#### 7. Obtener jugadores mayores de 23 años, agrupados por nacionalidad. ####");
		List<Object[]> nacionalidad_cuenta = jugadorDAO.getDeportistasMayorDe23();
		for(Object[] fila:nacionalidad_cuenta) {
			LOGGER.info(fila[0]+" = "+fila[1]);	
		}
		LOGGER.info("##################### FIN Consulta 7 #################################");
	}
	
	private static void ejecutarConsulta9() {
		LOGGER.info("#### 9. Obtener los tres equipos con más y menos puntos de la clasificacion. ####");
		List<Equipo> equipos_mas_puntos = equipoDAO.getEquiposMasPuntos();
		LOGGER.info("## TOP 3 EQUIPOS MAS PUNTOS ##");
		equipos_mas_puntos.forEach(equipo -> LOGGER.info(equipo.toString()));
		List<Equipo> equipos_menos_puntos = equipoDAO.getEquiposMenosPuntos();
		LOGGER.info("## TOP 3 EQUIPOS MENOS PUNTOS ##");
		equipos_menos_puntos.forEach(equipo -> LOGGER.info(equipo.toString()));
		LOGGER.info("##################### FIN Consulta 9 #################################");
	}
	
	private static void ejecutarConsulta10() {
		LOGGER.info("#### 10. Obtener los nuevos jugadores incorporados. ####");
		List<Jugador> jugadores_incorporados = competicionDAO.getIncorporaciones();
		jugadores_incorporados.forEach(jugador -> LOGGER.info(jugador.toString()));
		LOGGER.info("##################### FIN Consulta 10 #################################");
	}
	
	private static void ejecutarConsulta11() {
		LOGGER.info("#### 11. Obtener fichajes entre equipos realizados. ####");
		List<Fichaje_historia> fichajes_nuevos = competicionDAO.getEnumFichajes();
		fichajes_nuevos.forEach(fichaje -> LOGGER.info(fichaje.toString()));
		LOGGER.info("##################### FIN Consulta 11 #################################");
	}
	private static void ejecutarConsulta12() {
		LOGGER.info("#### 12. Obtener recuento de jugadores de la competicion. ####");
		Object total_jugadores = jugadorDAO.getJugadoresCompeticion();
		LOGGER.info(total_jugadores);
		LOGGER.info("##################### FIN Consulta 12 #################################");
	}
	
	private static void ejecutarConsulta13() {
		LOGGER.info("#### 13. Obtener patrocinadores comunes. ####");
		Equipo barsa = gestion.find(Equipo.class, 1); 
		Equipo torrelavega = gestion.find(Equipo.class, 6); 
		List<Patrocinador> patrocinadores_comunes = patrocinadorDAO.getPatrocinadoresComunes(barsa,torrelavega);
		patrocinadores_comunes.forEach(patrocinador -> LOGGER.info(patrocinador.toString()));
		LOGGER.info("##################### FIN Consulta 13 #################################");
	}
	
	private static void ejecutarConsulta14() {
		LOGGER.info("#### 14. Consulta criteria. ####");
		LOGGER.info("### Jugadores filtrados por nacionalidad. ");

		Optional<String>nombre = Optional.empty();
		Optional<String>nacionalidad = Optional.of("Suecia");
		Optional<String>posicion = Optional.empty();
		Optional<Integer>altura = Optional.empty();
		Optional<Integer>peso = Optional.empty();

		List<Jugador> jugadores = jugadorDAO.getJugadoresOrdenados(nombre,nacionalidad,posicion,altura,peso);
		jugadores.forEach(jugador -> LOGGER.info(jugador.toString()));
		
		LOGGER.info("### Jugadores filtrados por nacionalidad y posición.");
		
		nacionalidad = Optional.of("España");
		posicion = Optional.of("Portero");
		
		jugadores = jugadorDAO.getJugadoresOrdenados(nombre,nacionalidad,posicion,altura,peso);
		jugadores.forEach(jugador -> LOGGER.info(jugador.toString()));
		
		LOGGER.info("### Jugadores filtrados por nacionalidad, posición y altura.");
		
		nacionalidad = Optional.of("España");
		posicion = Optional.of("Portero");
		altura = Optional.of(188);
		
		
		jugadores = jugadorDAO.getJugadoresOrdenados(nombre,nacionalidad,posicion,altura,peso);
		jugadores.forEach(jugador -> LOGGER.info(jugador.toString()));
		LOGGER.info("##################### FIN Consulta 14 #################################");
	}
}
