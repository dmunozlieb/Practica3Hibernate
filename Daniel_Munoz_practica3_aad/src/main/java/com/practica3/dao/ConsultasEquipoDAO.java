package com.practica3.dao;

import java.util.List;

import com.practica3.model.Equipo;

public interface ConsultasEquipoDAO {
	List<Equipo> getEquiposCompeticion();
	List<Equipo> getEquiposMasPuntos();
	List<Equipo> getEquiposMenosPuntos();
}
