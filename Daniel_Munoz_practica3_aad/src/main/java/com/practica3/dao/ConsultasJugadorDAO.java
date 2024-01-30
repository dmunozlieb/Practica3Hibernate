package com.practica3.dao;

import java.util.List;

import com.practica3.model.Competicion;
import com.practica3.model.Equipo;
import com.practica3.model.Jugador;
import com.practica3.model.Patrocinador;

public interface ConsultasJugadorDAO {
	
	List<Jugador> getJugadoresEquipo(int id_equipo);
	double getEdadPromedioJugadores(int id_equipo);
	int getDeportistasMayorDe23();
	List<Jugador> getJugadoresOrdenados(String criterio);
	List<Jugador> getJugadoresCompeticion();
}
