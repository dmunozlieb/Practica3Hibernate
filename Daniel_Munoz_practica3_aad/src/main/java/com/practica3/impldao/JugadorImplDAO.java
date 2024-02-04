package com.practica3.impldao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.practica3.dao.ConsultasJugadorDAO;
import com.practica3.liga.Fichajes;
import com.practica3.model.Jugador;
import com.practica3.service.ConnectJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

/*** Esta clase realiza/se encarga de generar consultas relacionadas con los jugadores. * 
 * @author Daniel Muñoz */

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
					Integer.class);
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
					Object[].class);

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
	public Object getJugadoresCompeticion() {
		try {
			TypedQuery<Object> query = etManager.createQuery(
					"select count(j) from Jugador j join j.equipo e join e.competicion c where YEAR(c.fechaCreacion) = 2024",
					Object.class);

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

	@Override
	public List<Jugador> getJugadoresOrdenados(Optional<String> nombre, Optional<String> nacionalidad,
			Optional<String> posicion, Optional<Integer> altura, Optional<Integer> peso) {
		CriteriaBuilder builder = etManager.getCriteriaBuilder();
		CriteriaQuery<Jugador> criteria = builder.createQuery(Jugador.class);
		Root<Jugador> rootJugador = criteria.from(Jugador.class);
		List<Predicate> predicates = new ArrayList<>();
		nombre.ifPresent(value -> predicates.add(builder.equal(rootJugador.get("nombre"), value)));
	    nacionalidad.ifPresent(value -> predicates.add(builder.equal(rootJugador.get("nacionalidad"), value)));
	    posicion.ifPresent(value -> predicates.add(builder.equal(rootJugador.get("posicion"), value)));
	    altura.ifPresent(value -> predicates.add(builder.equal(rootJugador.get("altura"), value)));
	    peso.ifPresent(value -> predicates.add(builder.equal(rootJugador.get("peso"), value)));
		criteria.where(predicates.toArray(new Predicate[0])).orderBy(builder.asc(rootJugador.get("nombre")));
		TypedQuery<Jugador> query = etManager.createQuery(criteria);
		return query.getResultList();
	}

}
