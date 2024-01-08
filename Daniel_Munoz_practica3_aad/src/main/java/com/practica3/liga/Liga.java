package com.practica3.liga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.practica3.data.OrdenarClasificacion;
import com.practica3.model.Clasificacion;
import com.practica3.model.Equipo;
import com.practica3.model.Partido;
import com.practica3.service.DataPersist;
import com.practica3.service.GestionEquipo;

public class Liga {

	private static final Logger LOGGER = LogManager.getLogger(Liga.class);
	private static ArrayList<Partido> partidos_liga = new ArrayList<>();
	private static List<Clasificacion> clasificacion = new ArrayList<>();
	private static StringBuilder sb;
	private static DataPersist persistencia;
	private static GestionEquipo<Object> gestion;

	public static void ejecutarLiga() {
		gestion = new GestionEquipo<>();
		persistencia = new DataPersist();
//		DataPersist.dataPersist();
		persistencia.dataPersist();
		clasificacion = gestion.findAll(Clasificacion.class);
		LOGGER.info(" * * * * LIGA ASOBAL * * * * ");
		LOGGER.info(" --------------------------- ");
		int total_jornadas = clasificacion.size() - 1;
		int mitadEquipo = clasificacion.size() / 2;
		for (int jornada = 0; jornada < total_jornadas; jornada++) {
			sb = new StringBuilder();
			LOGGER.info(" - - - Jornada " + (jornada + 1) + " - - - ");
			bucle2: for (int i = 0; i < mitadEquipo; i++) {
				LOGGER.info(" - - - Partido - - - ");
				Equipo equipo_local = clasificacion.get(i).getEquipo();
				Equipo equipo_visitante = clasificacion.get(clasificacion.size() - 1 - i).getEquipo();
				LOGGER.info(equipo_local.getNombre_equipo() + " - " + equipo_visitante.getNombre_equipo());
				int goles_locales = generarGoles();
				int goles_visitantes = generarGoles();
				sb.append("\n" + equipo_local.getNombre_equipo() + " " + goles_locales + " - " + goles_visitantes + " "
						+ equipo_visitante.getNombre_equipo());

				if (ganaLocal(goles_locales, goles_visitantes)) {
					sumarPuntuacion(i, 3);
					partidos_liga.add(generarPartido((jornada + 1), equipo_local, equipo_visitante, goles_locales,
							goles_visitantes));
					continue bucle2;
				}
				if (ganaVisitante(goles_locales, goles_visitantes)) {
					sumarPuntuacion(clasificacion.size() - 1 - i, 0);
					partidos_liga.add(generarPartido((jornada + 1), equipo_local, equipo_visitante, goles_locales,
							goles_visitantes));
					continue bucle2;
				}
				sumarPuntuacion(i, 1);
				sumarPuntuacion(clasificacion.size() - 1 - i, 1);
				partidos_liga.add(
						generarPartido((jornada + 1), equipo_local, equipo_visitante, goles_locales, goles_visitantes));

			}
			LOGGER.info(" - - - Resultados - - - ");
			LOGGER.info(" |____________________| ");
			LOGGER.info(sb.toString());
			Collections.rotate(clasificacion.subList(1, clasificacion.size()), 1);

		}
		almacenarPosicion();
		persistencia.persistPartidos(partidos_liga);
		persistencia.actualizarClasificacion(clasificacion);	
		traspasos();
		DataPersist.shutdown();	
	}

	private static boolean ganaLocal(int goles_local, int goles_visitante) {
		return goles_local > goles_visitante;
	}

	private static boolean ganaVisitante(int goles_local, int goles_visitante) {
		return goles_local < goles_visitante;
	}

	private static int generarGoles() {
		return (int) (Math.random() * 6);
	}

	private static void sumarPuntuacion(int posicion_lista, int puntuacion_sumar) {
		int puntuacion_total = clasificacion.get(posicion_lista).getPuntuacion();
		puntuacion_total += puntuacion_sumar;
		System.out.println(puntuacion_total);
		clasificacion.get(posicion_lista).setPuntuacion(puntuacion_total);
	}

	private static Partido generarPartido(int num_jornada, Equipo equipo_local, Equipo equipo_visitante,
			int resultado_local, int resultado_visitante) {
		return new Partido(num_jornada, equipo_local, equipo_visitante, resultado_local, resultado_visitante, null);
	}

	private static void almacenarPosicion() {
		Collections.sort(clasificacion, new OrdenarClasificacion());
		for (int i = 0; i < clasificacion.size(); i++) {
			clasificacion.get(i).setPosicion(i + 1);
		}
	}

	private static <T> void traspasos() {
		Fichajes<T> fichajes = new Fichajes<>();
		fichajes.fichajesTemporada();
	}

}
