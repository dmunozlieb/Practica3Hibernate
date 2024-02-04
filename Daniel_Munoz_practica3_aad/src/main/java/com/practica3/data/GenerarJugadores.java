package com.practica3.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import com.practica3.model.Jugador;

/*** Esta clase realiza/se encarga de Generar objetos Jugadores. * 
 * @author Daniel Muñoz */

public class GenerarJugadores {

	private static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static ArrayList<Jugador> jugadores = new ArrayList<>();
	public static List<Jugador> jugadoresBarsa() {
		return List.of(
				new Jugador("Pérez de Vargas", LocalDate.parse("10/01/1991", PATTERN), "España", "Portero", 188, 88,LocalDate.parse("14/05/2008", PATTERN)),
				new Jugador("Carlsbogard", LocalDate.parse("19/04/1995", PATTERN), "Suecia", "Lateral izquierdo", 195,
						96,LocalDate.parse("04/03/2022", PATTERN)),
				new Jugador("Mem", LocalDate.parse("31/08/1997", PATTERN), "Francia", "Lateral derecho", 194, 104,LocalDate.parse("14/05/2016", PATTERN)),
				new Jugador("Valera", LocalDate.parse("19/08/1998", PATTERN), "España", "Central", 186, 86,LocalDate.parse("23/04/2017", PATTERN)),
				new Jugador("Aleix", LocalDate.parse("07/05/1997", PATTERN), "España", "Extremo derecho", 183, 81,LocalDate.parse("03/05/2022", PATTERN)),
				new Jugador("Wanne", LocalDate.parse("10/12/1993", PATTERN), "Suecia", "Extremo izquierdo", 185, 84,LocalDate.parse("08/05/2011", PATTERN)),
				new Jugador("Gallego", LocalDate.parse("10/12/2001", PATTERN), "España", "Pívot", 199, 107,LocalDate.parse("11/05/2021", PATTERN)));
	}

	public static List<Jugador> jugadoresBidasoa() {
		return List.of(
				new Jugador("Mehdi Harbaoui", LocalDate.parse("11/09/1996", PATTERN), "República Tunecina", "Portero",
						196, 95,LocalDate.parse("02/05/2022", PATTERN)),
				new Jugador("Eneko Furundarena", LocalDate.parse("30/04/2003", PATTERN), "España", "Lateral izquierdo",
						194, 93,LocalDate.parse("01/05/2020", PATTERN)),
				new Jugador("Rodrigo Salinas", LocalDate.parse("25/02/1989", PATTERN), "Chile", "Lateral derecho", 189,
						89,LocalDate.parse("20/04/2011", PATTERN)),
				new Jugador("Asier Iribar", LocalDate.parse("02/04/2003", PATTERN), "España", "Central", 191, 90,LocalDate.parse("23/05/2021", PATTERN)),
				new Jugador("Iñaki Cavero", LocalDate.parse("07/04/1996", PATTERN), "España", "Extremo derecho", 181,
						80,LocalDate.parse("13/05/2013", PATTERN)),
				new Jugador("Mikel Zabala", LocalDate.parse("23/04/1998", PATTERN), "España", "Extremo izquierdo", 180,
						82,LocalDate.parse("10/04/2018", PATTERN)),
				new Jugador("Marko Jevtic", LocalDate.parse("17/10/2001", PATTERN), "Serbia", "Pívot", 194, 103,LocalDate.parse("02/05/2023", PATTERN)));
	}

	public static List<Jugador> jugadoresGranollers() {
		return List.of(
				new Jugador("Roberto Rodriguez", LocalDate.parse("19/07/2000", PATTERN), "España", "Portero", 187, 88,LocalDate.parse("23/04/2019", PATTERN)),
				new Jugador("Joan Amigó", LocalDate.parse("17/07/1993", PATTERN), "España", "Lateral izquierdo", 190,
						90,LocalDate.parse("10/01/2017", PATTERN)),
				new Jugador("Faruk Yusuf", LocalDate.parse("19/02/2004", PATTERN), "Nigeria", "Lateral derecho", 185,
						84,LocalDate.parse("29/04/2022", PATTERN)),
				new Jugador("Sergi Franco", LocalDate.parse("10/05/1999", PATTERN), "España", "Extremo derecho", 190,
						89,LocalDate.parse("01/02/2018", PATTERN)),
				new Jugador("Guilherme Torriani", LocalDate.parse("06/02/1999", PATTERN), "Brasil", "Extremo izquierdo",
						186, 85,LocalDate.parse("09/05/2022", PATTERN)),
				new Jugador("Bruno Reguart", LocalDate.parse("25/05/2003", PATTERN), "España", "Central", 187, 84,LocalDate.parse("14/01/2022", PATTERN)),
				new Jugador("Victor Romero", LocalDate.parse("09/03/2004", PATTERN), "España", "Pívot", 192, 101,LocalDate.parse("21/05/2022", PATTERN)));
	}

	public static List<Jugador> jugadoresRioja() {
		return List.of(
				new Jugador("Kristóf Palasics", LocalDate.parse("19/04/2002", PATTERN), "Hungria", "Portero", 199, 105,LocalDate.parse("11/02/2023", PATTERN)),
				new Jugador("Ismael El Korchi", LocalDate.parse("19/03/2001", PATTERN), "España", "Lateral izquierdo",
						194, 95,LocalDate.parse("07/05/2020", PATTERN)),
				new Jugador("Angel Rivero", LocalDate.parse("24/10/1992", PATTERN), "Cuba", "Lateral derecho", 187, 95,LocalDate.parse("20/04/2017", PATTERN)),
				new Jugador("Alvaro Preciado", LocalDate.parse("15/02/2000", PATTERN), "España", "Central", 188, 87,LocalDate.parse("03/05/2020", PATTERN)),
				new Jugador("Edu Ortíz Badillo", LocalDate.parse("12/12/2002", PATTERN), "España", "Extremo derecho",
						184, 83,LocalDate.parse("23/01/2018", PATTERN)),
				new Jugador("Marti Soler", LocalDate.parse("28/04/2003", PATTERN), "España", "Extremo izquierdo", 190,
						89,LocalDate.parse("19/01/2021", PATTERN)),
				new Jugador("Abdoula Modi", LocalDate.parse("14/08/2001", PATTERN), "Togo", "Pívot", 211, 111,LocalDate.parse("22/05/2023", PATTERN)));
	}

	public static List<Jugador> jugadoresValladolid() {
		return List.of(new Jugador("Cesar Pérez", LocalDate.parse("26/01/1993", PATTERN), "España", "Portero", 188, 88,LocalDate.parse("27/01/2012", PATTERN)),
				new Jugador("Edu Calle", LocalDate.parse("03/05/2000", PATTERN), "España", "Lateral izquierdo", 185,
						84,LocalDate.parse("24/04/2021", PATTERN)),
				new Jugador("Miguel Martínez Lobato", LocalDate.parse("31/12/1999", PATTERN), "España",
						"Lateral derecho", 195, 107,LocalDate.parse("10/05/2017", PATTERN)),
				new Jugador("Tarcisio Freitas", LocalDate.parse("25/01/2000", PATTERN), "Brasil", "Central", 190, 90,LocalDate.parse("03/02/2021", PATTERN)),
				new Jugador("Nicoló D´Antino", LocalDate.parse("22/06/1999", PATTERN), "Italia", "Extremo derecho", 170,
						74,LocalDate.parse("12/05/2019", PATTERN)),
				new Jugador("Dimitar Dimitrioski", LocalDate.parse("16/02/1998", PATTERN), "Macedonia",
						"Extremo izquierdo", 183, 81,LocalDate.parse("16/05/2022", PATTERN)),
				new Jugador("Álvaro Martínez Lobato", LocalDate.parse("31/12/1999", PATTERN), "España", "Pívot", 195,
						102,LocalDate.parse("30/01/2016", PATTERN)));
	}

	public static List<Jugador> jugadoresTorrelavega() {
		return List.of(new Jugador("Carlos Calle", LocalDate.parse("22/12/1994", PATTERN), "España", "Portero", 192, 91,LocalDate.parse("19/04/2016", PATTERN)),
				new Jugador("Sergio Crespo", LocalDate.parse("23/08/1996", PATTERN), "España", "Lateral izquierdo", 190,
						93,LocalDate.parse("12/05/2017", PATTERN)),
				new Jugador("Alonso Moreno", LocalDate.parse("01/01/1996", PATTERN), "España", "Lateral derecho", 189,
						88,LocalDate.parse("05/02/2013", PATTERN)),
				new Jugador("Adrián Fernández", LocalDate.parse("15/06/1994", PATTERN), "España", "Central", 188, 89,LocalDate.parse("21/05/2013", PATTERN)),
				new Jugador("Javi Muñoz", LocalDate.parse("22/05/1992", PATTERN), "España", "Extremo derecho", 191, 93,LocalDate.parse("09/04/2010", PATTERN)),
				new Jugador("Alex Rubiño", LocalDate.parse("06/11/2001", PATTERN), "España", "Extremo izquierdo", 181,
						78,LocalDate.parse("07/05/2021", PATTERN)),
				new Jugador("Dani Ramos", LocalDate.parse("08/11/1999", PATTERN), "España", "Pívot", 191, 104,LocalDate.parse("14/05/2016", PATTERN)));
	}
	
	public static List<Jugador> jugadoresHelvetia() {
		return List.of(new Jugador("Iñaki Martínez", LocalDate.parse("13/10/2000", PATTERN), "España", "Portero", 182, 84,LocalDate.parse("01/05/2023", PATTERN)),
				new Jugador("Oleg Kisselev", LocalDate.parse("20/08/1997", PATTERN), "España", "Lateral izquierdo", 199,
						100,LocalDate.parse("24/04/2019", PATTERN)),
				new Jugador("Eduardo Fernandez", LocalDate.parse("01/01/1997", PATTERN), "España", "Lateral derecho", 189,
						86,LocalDate.parse("10/02/2014", PATTERN)),
				new Jugador("Niko Martinovic", LocalDate.parse("01/08/2003", PATTERN), "Croacia", "Central", 184, 83,LocalDate.parse("09/05/2023", PATTERN)),
				new Jugador("Xavier Gonzalez", LocalDate.parse("10/12/2004", PATTERN), "España", "Extremo derecho", 180, 79,LocalDate.parse("17/01/2022", PATTERN)),
				new Jugador("Martín Ganuza", LocalDate.parse("03/10/2000", PATTERN), "España", "Extremo izquierdo", 178,
						76,LocalDate.parse("11/02/2019", PATTERN)),
				new Jugador("Antonio Bazan", LocalDate.parse("19/05/1996", PATTERN), "España", "Pívot", 196, 95,LocalDate.parse("18/01/2013", PATTERN)));
	}
	
	public static List<Jugador> jugadoresViveros() {
		return List.of(new Jugador("Luis De Vega", LocalDate.parse("14/09/1988", PATTERN), "España", "Portero", 190, 89,LocalDate.parse("03/02/2008", PATTERN)),
				new Jugador("Jakub Prokop", LocalDate.parse("21/08/1998", PATTERN), "Eslovaquia", "Lateral izquierdo", 191,
						97,LocalDate.parse("27/04/2021", PATTERN)),
				new Jugador("Isaías Guardiola", LocalDate.parse("01/10/1984", PATTERN), "España", "Lateral derecho", 200,
						104,LocalDate.parse("14/01/2003", PATTERN)),
				new Jugador("Borja Mendez", LocalDate.parse("19/07/2001", PATTERN), "España", "Central", 174, 78,LocalDate.parse("16/04/2017", PATTERN)),
				new Jugador("Francisco Ahumada", LocalDate.parse("10/12/2004", PATTERN), "Chile", "Extremo derecho", 180, 79,LocalDate.parse("29/01/2023", PATTERN)),
				new Jugador("Dani Perez", LocalDate.parse("20/12/1996", PATTERN), "España", "Extremo izquierdo", 182,
						80,LocalDate.parse("25/01/2016", PATTERN)),
				new Jugador("Gonzalo Carró", LocalDate.parse("09/06/1994", PATTERN), "España", "Pívot", 194, 93,LocalDate.parse("11/05/2011", PATTERN)));
	}
	
	public static ArrayList<Jugador> allJugadores(){
		jugadores.addAll(jugadoresBarsa());
		jugadores.addAll(jugadoresBidasoa());
		jugadores.addAll(jugadoresGranollers());
		jugadores.addAll(jugadoresRioja());
		jugadores.addAll(jugadoresTorrelavega());
		jugadores.addAll(jugadoresValladolid());
		return jugadores;
	}
}
