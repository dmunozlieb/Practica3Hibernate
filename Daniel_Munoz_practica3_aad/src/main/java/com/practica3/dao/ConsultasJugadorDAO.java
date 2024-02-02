package com.practica3.dao;

import java.util.List;

import com.practica3.model.Competicion;
import com.practica3.model.Equipo;
import com.practica3.model.Jugador;
import com.practica3.model.Patrocinador;

public interface ConsultasJugadorDAO {
	
	List<Jugador> getJugadoresEquipo(int id_equipo);
	Object getEdadPromedioJugadores(int id_equipo);
	List<Object[]> getDeportistasMayorDe23();
	List<Jugador> getJugadoresOrdenados(String criterio);
	Object getJugadoresCompeticion();
}
