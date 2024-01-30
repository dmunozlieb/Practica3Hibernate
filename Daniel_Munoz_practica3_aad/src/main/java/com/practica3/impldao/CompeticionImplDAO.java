package com.practica3.impldao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.practica3.dao.ConsultasCompeticionDAO;
import com.practica3.liga.Fichajes;
import com.practica3.model.Competicion;
import com.practica3.service.ConnectJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class CompeticionImplDAO implements ConsultasCompeticionDAO{
	
	private static final Logger LOGGER = LogManager.getLogger(Fichajes.class);
	private EntityManager etManager = ConnectJPA.getEntityManager();
	
	@Override
	public List<Competicion> getCompeticion() {
		try {
			Query query = etManager.createNativeQuery("select * from competition",Competicion.class);
			return query.getResultList();
		}catch (IllegalStateException e) {
			LOGGER.error(e.getMessage());
		}catch (PersistenceException e) {
			LOGGER.error(e.getMessage());
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void getIncorporaciones() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getEnumFichajes() {
		// TODO Auto-generated method stub
		
	}
	
	
}