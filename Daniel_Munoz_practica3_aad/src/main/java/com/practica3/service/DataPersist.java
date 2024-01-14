package com.practica3.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.practica3.data.GenerarCompeticion;
import com.practica3.data.GenerarEquipos;
import com.practica3.model.Clasificacion;
import com.practica3.model.Competicion;
import com.practica3.model.Equipo;
import com.practica3.model.Partido;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

public class DataPersist {

	private static EntityManager entitymanager = ConnectJPA.getEntityManager();
	private static final Logger LOGGER = LogManager.getLogger(DataPersist.class);
	private static GestionEquipo<Object> gestion = new GestionEquipo<>();
	
	public void dataPersist() {
		try {
			persistEquipos();
			persistClasificacion();
			persistCompeticion();
		} catch (PersistenceException persistence) {
			entitymanager.getTransaction().rollback();
			LOGGER.error("Error - " + persistence.getMessage());
		}catch (Exception e) {
			entitymanager.getTransaction().rollback();
			LOGGER.error("Error - " + e.getMessage());
		}

	}

	private void persistEquipos() throws PersistenceException {
		
		LOGGER.debug(" - - Entrada al método persitEquipos() - - ");
		entitymanager.getTransaction().begin();
		for (Equipo equipo : GenerarEquipos.generarEquipos())
			entitymanager.persist(equipo);

		entitymanager.getTransaction().commit();

	}

	private void persistClasificacion() throws PersistenceException{
		List<Equipo> equipos_registrados = gestion.findAll(Equipo.class);
		entitymanager.getTransaction().begin();
		for (Equipo equipo : equipos_registrados) {
			entitymanager.persist(new Clasificacion(equipo, 0, 0, 0, 0));
		}
		entitymanager.getTransaction().commit();
	}



	public void persistPartidos(List<Partido> partidos) {
		try {
			entitymanager.getTransaction().begin();
			for (Partido partido : partidos) {
				entitymanager.persist(partido);
			}
			entitymanager.getTransaction().commit();
		} catch (PersistenceException persistence) {
			LOGGER.error("Error - " + persistence.getMessage());
			entitymanager.getTransaction().rollback();
		} catch (Exception e) {
			LOGGER.error("Error - " + e.getMessage());
			entitymanager.getTransaction().rollback();
		}	
		
	}

	private void persistCompeticion() {
		try {
			entitymanager.getTransaction().begin();
			for(Competicion competicion:GenerarCompeticion.generarCompeticiones()) {
				entitymanager.persist(competicion);
			}
			entitymanager.getTransaction().commit();
		} catch (PersistenceException persistence) {
			LOGGER.error("Error - " + persistence.getMessage());
			entitymanager.getTransaction().rollback();
		} catch (Exception e) {
			LOGGER.error("Error - " + e.getMessage());
			entitymanager.getTransaction().rollback();
		}
	}
	
	public void actualizarClasificacion(List<Clasificacion> nueva_clasificacion) {
		try {
			entitymanager.getTransaction().begin();
			for (Clasificacion clasificacion : nueva_clasificacion) {
				entitymanager.merge(clasificacion);
			}
			entitymanager.getTransaction().commit();
		} catch (PersistenceException persistence) {
			LOGGER.error("Error - " + persistence.getMessage());
			entitymanager.getTransaction().rollback();
		} catch (Exception e) {
			LOGGER.error("Error - " + e.getMessage());
			entitymanager.getTransaction().rollback();
		}	
		
	}
	
	public static void shutdown() {
		entitymanager.close();
	}
}
