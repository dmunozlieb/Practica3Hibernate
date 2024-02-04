package com.practica3.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.practica3.model.Competicion;

/*** Esta clase realiza/se encarga de Generar objetos competición. * 
 * @author Daniel Muñoz */

public class GenerarCompeticion {
	private static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	public static List<Competicion> generarCompeticion(){
		return List.of(new Competicion("Liga Asobal", LocalDate.parse("10/09/2023", PATTERN), 5),
				new Competicion("Liga Asobal", LocalDate.parse("10/09/2024", PATTERN), 5));
	}
}
