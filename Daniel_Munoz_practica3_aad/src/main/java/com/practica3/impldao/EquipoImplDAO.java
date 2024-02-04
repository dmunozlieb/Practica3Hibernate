package com.practica3.impldao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.practica3.dao.ConsultasEquipoDAO;
import com.practica3.liga.Fichajes;
import com.practica3.model.Equipo;
import com.practica3.service.ConnectJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

/*** Esta clase realiza/se encarga de generar consultas relacionadas con los equipos. * 
 * @author Daniel Muñoz */

public class EquipoImplDAO implements ConsultasEquipoDAO {
	private static final Logger LOGGER = LogManager.getLogger(Fichajes.class);
	private EntityManager etManager = ConnectJPA.getEntityManager();

	@Override
	public List<Equipo> getEquiposCompeticion() {
		try {
			Query query = etManager.createQuery("select e from Equipo e join e.competicion", Equipo.class);
			return query.getResultList();
		} catch (IllegalStateException e) {
			LOGGER.error(e.getMessage());
		} catch (PersistenceException e) {
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Equipo> getEquiposMasPuntos() {
		try {
			Query query = etManager.createQuery(
					"select e from Clasificacion c join c.equipo e order by c.puntuacion desc limit 3", Equipo.class);
			return query.getResultList();
		} catch (IllegalStateException e) {
			LOGGER.error(e.getMessage());
		} catch (PersistenceException e) {
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Equipo> getEquiposMenosPuntos() {
		try {
			Query query = etManager.createQuery(
					"select e from Clasificacion c join c.equipo e order by c.puntuacion asc limit 3", Equipo.class);
			return query.getResultList();
		} catch (IllegalStateException e) {
			LOGGER.error(e.getMessage());
		} catch (PersistenceException e) {
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

}
