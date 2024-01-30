package com.practica3.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "competition")
public class Competicion {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (name = "competition_name")
	private String nombreCompeticion;
	@Column (name = "start_date")
	private LocalDate fechaCreacion;
	@Column (name = "numbers_of_matchday")
	private int numJornadas;
	@Column (name = "numbers_of_teams")
	private int numEquipos;
	@OneToMany (mappedBy = "competicion",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
	private List<Equipo> equipos_participantes;
	
		
	public Competicion() {
		
	}

	public Competicion(String nombreCompeticion, LocalDate fechaCreacion, int numJornadas) {		
		this.nombreCompeticion = nombreCompeticion;
		this.fechaCreacion = fechaCreacion;
		this.numJornadas = numJornadas;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCompeticion() {
		return nombreCompeticion;
	}

	public void setNombreCompeticion(String nombreCompeticion) {
		this.nombreCompeticion = nombreCompeticion;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getNumEquipos() {
		return numEquipos;
	}

	public void setNumEquipos(int numEquipos) {
		this.numEquipos = numEquipos;
	}
	
	

	public int getNumJornadas() {
		return numJornadas;
	}

	public void setNumJornadas(int numJornadas) {
		this.numJornadas = numJornadas;
	}

	
	
	public List<Equipo> getEquipos_participantes() {
		return equipos_participantes;
	}

	public void setEquipos_participantes(List<Equipo> equipos_participantes) {
		this.equipos_participantes = equipos_participantes;
		almacenarCompeticion(equipos_participantes);
		setNumEquipos(equipos_participantes.size());
	}
	
	public void almacenarCompeticion(List<Equipo> equipos_participantes) {
		equipos_participantes.forEach(equipo -> equipo.setCompeticion(this));
	}

	@Override
	public String toString() {
		return "Competicion [id=" + id + ", nombre de Competicion=" + nombreCompeticion + ", fecha de Creacion=" + fechaCreacion
				+ ", número de Equipos=" + numEquipos + "]";
	}
	
	
}
