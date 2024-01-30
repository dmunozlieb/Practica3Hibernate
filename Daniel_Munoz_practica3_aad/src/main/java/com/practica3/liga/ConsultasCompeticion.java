package com.practica3.liga;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.practica3.impldao.CompeticionImplDAO;
import com.practica3.impldao.JugadorImplDAO;
import com.practica3.model.Competicion;
import com.practica3.model.Jugador;



public class ConsultasCompeticion {
	
	private static final Logger LOGGER = LogManager.getLogger(Fichajes.class);
	private static JugadorImplDAO jugadorDAO = new JugadorImplDAO();
	private static CompeticionImplDAO competicionDAO = new CompeticionImplDAO();

	public static void ejecutarConsultas() {
		ejecutarConsulta1();
		ejecutarConsulta3();

	}
	
	private static void ejecutarConsulta1() {
		LOGGER.info("## 1. Obtener características de competicion. ##");
		List<Competicion> competiciones = competicionDAO.getCompeticion();
		competiciones.forEach(competicion -> LOGGER.info(competicion.toString()));
		LOGGER.info("##################### FIN Consulta 1 #################################");
	}
	
	private static void ejecutarConsulta3() {
		LOGGER.info("## 3. Obtener jugadores del equipo indicado. ##");
		List<Jugador> jugadores_equipo = jugadorDAO.getJugadoresEquipo(1);
		jugadores_equipo.forEach(jugador -> LOGGER.info(jugador.toString()));
		LOGGER.info("##################### FIN Consulta 3 #################################");
	}
}


