package com.practica3.dao;

import java.util.List;
import java.util.Optional;


import com.practica3.model.Jugador;


public interface ConsultasJugadorDAO {

	List<Jugador> getJugadoresEquipo(int id_equipo);

	Object getEdadPromedioJugadores(int id_equipo);

	List<Object[]> getDeportistasMayorDe23();

	List<Jugador> getJugadoresOrdenados(Optional<String> nombre, Optional<String> nacionalidad,
			Optional<String> posicion, Optional<Integer> altura, Optional<Integer> peso);

	Object getJugadoresCompeticion();
}
