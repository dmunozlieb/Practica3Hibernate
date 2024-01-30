package com.practica3.dao;

import java.util.List;

import com.practica3.model.Competicion;

public interface ConsultasCompeticionDAO {
	List<Competicion> getCompeticion();
	void getIncorporaciones();
	void getEnumFichajes();
}
