package com.practica3.impldao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.practica3.dao.ConsultasJugadorDAO;
import com.practica3.liga.Fichajes;
import com.practica3.model.Jugador;
import com.practica3.service.ConnectJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class JugadorImplDAO implements ConsultasJugadorDAO {

	private EntityManager etManager = ConnectJPA.getEntityManager();
	private static final Logger LOGGER = LogManager.getLogger(Fichajes.class);

	@Override
	public List<Jugador> getJugadoresEquipo(int id_equipo) {

		try {
			Query query = etManager.createQuery(
					"select j from Jugador j join j.equipo e where e.id_equipo = :id_equipo", Jugador.class);
			query.setParameter("id_equipo", id_equipo);
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
	public Object getEdadPromedioJugadores(int id_equipo) {
		try {
			Query query = etManager.createNativeQuery(
					"select avg(DATEDIFF(curdate(), birth_date) / 365) from player where id_team = :idteam",
					Object.class);
			query.setParameter("idteam", id_equipo);
			return query.getSingleResult();
		} catch (IllegalStateException e) {
			LOGGER.error(e.getMessage());
		} catch (PersistenceException e) {
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	@Override
	public List<Object[]> getDeportistasMayorDe23() {
		try {
			Query query = etManager.createNativeQuery(
					"select nationality, count(*) from player where DATEDIFF(curdate(), birth_date)/365 > 23 group by nationality",
					Object.class);

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
	public List<Jugador> getJugadoresOrdenados(String criterio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getJugadoresCompeticion() {
		try {
			Query query = etManager.createQuery(
					"select count(j) from Jugador j join j.equipo e join e.competicion c where YEAR(c.fechaCreacion) = 2024");

			return query.getSingleResult();
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
