package com.practica3.dao;

import java.util.List;

import com.practica3.model.Competicion;
import com.practica3.model.Fichaje_historia;
import com.practica3.model.Jugador;

public interface ConsultasCompeticionDAO {
	List<Competicion> getCompeticion();
	List<Jugador> getIncorporaciones();
	List<Fichaje_historia> getEnumFichajes();
}
