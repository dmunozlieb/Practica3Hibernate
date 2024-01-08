package com.practica3.liga;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.practica3.model.Equipo;
import com.practica3.model.Jugador;
import com.practica3.service.GestionEquipo;


public class Fichajes <T>{
	
	private static final Logger LOGGER = LogManager.getLogger(Fichajes.class);
	private GestionEquipo <T> gestion = new GestionEquipo<>();
	private static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public void fichajesTemporada() {
		intercambioJugadores();
		fichajeBidasoa();
		ratiradaJugador();
		fichajeValladolid();
	}
	
	private void intercambioJugadores() {
		LOGGER.info("** Intercambio de jugadores entre el Barcelona y el Granollers **");
		LOGGER.info("** BARCELONA: EI WANNE <-----> Guilherme Torriani EI y 10000 :GRANOLLERS**");
		Equipo barcelona = gestion.find(Equipo.class, 1);
		Equipo granollers = gestion.find(Equipo.class, 3);
		Jugador wanne = gestion.find(Jugador.class, 6);
		Jugador torriani = gestion.find(Jugador.class, 19);
		barcelona.eliminarJugador(wanne);
		granollers.eliminarJugador(torriani);
		barcelona.agregarJugador(torriani);
		granollers.agregarJugador(wanne);
		gestion.update(barcelona);
		gestion.update(granollers);
	}
	
	private void fichajeBidasoa() {
		LOGGER.info("** Fichaje del bidasoa de Ismael El Korchi del BM. LOGROÑO LA RIOJA **");
		LOGGER.info("** Ismael El Korchi -----> 100000 euros **");
		Equipo bidasoa = gestion.find(Equipo.class, 2);
		Equipo logronio = gestion.find(Equipo.class, 4);
		Jugador korchi = gestion.find(Jugador.class, 23);
		logronio.eliminarJugador(korchi);
		bidasoa.agregarJugador(korchi);
		bidasoa.setRenumeracion(restaSalarial(bidasoa, 100000));
		gestion.update(bidasoa);
		gestion.update(logronio);
	}
	
	private void ratiradaJugador() {
		LOGGER.info("** Nicoló D´Antino - RECOLETAS AT. VALLADOLID ha tomado la decisión de retirarse del balonmano **");
		Equipo valladolid = gestion.find(Equipo.class, 5);
		Jugador antino = gestion.find(Jugador.class, 33);
		valladolid.eliminarJugador(antino);
		gestion.remove(antino);
		gestion.update(valladolid);	
	}
	
	private void fichajeValladolid() {
		LOGGER.info("** Fichaje del RECOLETAS AT. VALLADOLID, nuevo jugador incorporado **");
		LOGGER.info("** Álvaro Gastón ---> 34000 **");
		Equipo valladolid = gestion.find(Equipo.class, 5);
		valladolid.agregarJugador(new Jugador("Álvaro Gastón", LocalDate.parse("21/06/1993",PATTERN),"España","Extremo derecho",181,73));
		valladolid.setRenumeracion(restaSalarial(valladolid, 34000));
		gestion.update(valladolid);
	}
	
	private double restaSalarial(Equipo equipo, double cantidad) {
		double salario = equipo.getRenumeracion();
		salario -= cantidad;
		return salario;
	}
}
