package com.practica3.dao;

import java.util.List;

import com.practica3.model.Patrocinador;

public interface ConsultasPatrocinadorDAO {
	List<Patrocinador> getPatrocinadoresEquipo(int id_equipo);
	List<Object[]> getJugadoresYPatrocinadores(int id_equipo);
	List<Patrocinador> getPatrocinadoresComunes(int id_equipo, int id_equipo2);
}
