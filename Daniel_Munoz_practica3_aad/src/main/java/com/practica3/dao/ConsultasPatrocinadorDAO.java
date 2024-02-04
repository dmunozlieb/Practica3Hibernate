package com.practica3.dao;

import java.util.List;

import com.practica3.model.Equipo;
import com.practica3.model.Patrocinador;

public interface ConsultasPatrocinadorDAO {
	List<Patrocinador> getPatrocinadoresEquipo(int id_equipo);
	List<Object[]> getJugadoresYPatrocinadores(int id_equipo);
	List<Patrocinador> getPatrocinadoresComunes(Equipo equipo1, Equipo equipo2);
}
