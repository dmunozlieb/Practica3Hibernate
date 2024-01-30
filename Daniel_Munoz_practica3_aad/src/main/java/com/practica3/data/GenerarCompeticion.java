package com.practica3.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.practica3.model.Competicion;

public class GenerarCompeticion {
	private static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	public static Competicion generarCompeticion(){
		return new Competicion("Liga Asobal", LocalDate.parse("10/09/2023", PATTERN), 5);
	}
}
