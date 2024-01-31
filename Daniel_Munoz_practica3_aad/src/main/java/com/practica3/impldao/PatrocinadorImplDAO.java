package com.practica3.impldao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.practica3.dao.ConsultasPatrocinadorDAO;
import com.practica3.liga.Fichajes;
import com.practica3.model.Patrocinador;
import com.practica3.service.ConnectJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class PatrocinadorImplDAO implements ConsultasPatrocinadorDAO {

	private static final Logger LOGGER = LogManager.getLogger(Fichajes.class);
	private EntityManager etManager = ConnectJPA.getEntityManager();

	@Override
	public List<Patrocinador> getPatrocinadoresEquipo(int id_equipo) {
		try {
			Query query = etManager.createQuery(
					"select p from Equipo e join e.patrocinadores p where e.id_equipo = :idequipo", Patrocinador.class);
			query.setParameter("idequipo", id_equipo);
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
	public List<Object[]> getJugadoresYPatrocinadores(int id_equipo) {
		try {
			Query query = etManager.createQuery(
					"select distinct j,p from Jugador j join j.equipo e join e.patrocinadores p where e.id_equipo = :idequipo");
			query.setParameter("idequipo", id_equipo);
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
	public List<Patrocinador> getPatrocinadoresComunes(int id_equipo, int id_equipo2) {
		// TODO Auto-generated method stub
		return null;
	}

}
