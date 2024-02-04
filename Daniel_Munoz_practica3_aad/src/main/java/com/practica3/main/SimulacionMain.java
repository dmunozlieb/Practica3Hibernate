package com.practica3.main;

import com.practica3.liga.ConsultasCompeticion;
import com.practica3.liga.Liga;
import com.practica3.service.DataPersist;

/*** Esta clase realiza/se encarga de ejecutar el programa. * 
 * @author Daniel Muñoz */

public class SimulacionMain {

	public static void main(String[] args) {

		Liga.ejecutarLiga();
		ConsultasCompeticion.ejecutarConsultas();
		DataPersist.shutdown();	
	}
}
