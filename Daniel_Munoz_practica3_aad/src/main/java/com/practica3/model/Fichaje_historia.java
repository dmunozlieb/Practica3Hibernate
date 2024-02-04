package com.practica3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*** Entity Fichajes historial * 
 * @author Daniel Muñoz */

@Entity
@Table(name = "transfer_history")
public class Fichaje_historia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_fichaje;
	@ManyToOne
	@JoinColumn(name = "id_player_transfer")
	private Jugador jugador_fichaje;
	@ManyToOne
	@JoinColumn(name = "id_team_origin")
	private Equipo equipo_origen;
	@ManyToOne
	@JoinColumn(name = "id_team_destination")
	private Equipo equipo_destino;
	@Column(name = "cost")
	private double coste;

	public Fichaje_historia() {

	}

	public Fichaje_historia(Jugador jugador_fichaje, Equipo equipo_origen, Equipo equipo_destino, double coste) {
		this.jugador_fichaje = jugador_fichaje;
		this.equipo_origen = equipo_origen;
		this.equipo_destino = equipo_destino;
		this.coste = coste;
	}

	public Long getId_fichaje() {
		return id_fichaje;
	}

	public void setId_fichaje(Long id_fichaje) {
		this.id_fichaje = id_fichaje;
	}

	public Jugador getJugador_fichaje() {
		return jugador_fichaje;
	}

	public void setJugador_fichaje(Jugador jugador_fichaje) {
		this.jugador_fichaje = jugador_fichaje;
	}

	public Equipo getEquipo_origen() {
		return equipo_origen;
	}

	public void setEquipo_origen(Equipo equipo_origen) {
		this.equipo_origen = equipo_origen;
	}

	public Equipo getEquipo_destino() {
		return equipo_destino;
	}

	public void setEquipo_destino(Equipo equipo_destino) {
		this.equipo_destino = equipo_destino;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	@Override
	public String toString() {
		return "Fichaje_historia [id_fichaje=" + id_fichaje + ", jugador_fichaje=" + jugador_fichaje
				+ ", equipo_origen=" + equipo_origen + ", equipo_destino=" + equipo_destino + ", coste=" + coste
				+ "]\n";
	}

}
