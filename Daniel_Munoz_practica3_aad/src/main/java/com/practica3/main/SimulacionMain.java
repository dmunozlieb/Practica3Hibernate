package com.practica3.main;

import com.practica3.liga.ConsultasCompeticion;
import com.practica3.liga.Liga;
import com.practica3.service.DataPersist;

public class SimulacionMain {

	public static void main(String[] args) {

		Liga.ejecutarLiga();
		ConsultasCompeticion.ejecutarConsultas();
		DataPersist.shutdown();	
	}
}
