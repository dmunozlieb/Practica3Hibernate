package com.practica3.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.practica3.dao.GestionDAO;
import com.practica3.model.Jugador;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

public class GestionEquipo<T> implements GestionDAO<T> {

	private EntityManager entitymanager = ConnectJPA.getEntityManager();
	private static final Logger LOGGER = LogManager.getLogger(GestionEquipo.class);

	@Override
	public <T> void insert(T o1) {
		try {
			entitymanager.getTransaction().begin();
			entitymanager.persist(o1);
			entitymanager.getTransaction().commit();
		} catch (PersistenceException persistence) {
			LOGGER.error("Error - " + persistence.getMessage());
			entitymanager.getTransaction().rollback();
		} catch (Exception e) {
			LOGGER.error("Error - " + e.getMessage());
			entitymanager.getTransaction().rollback();
		}
	}

	@Override
	public <T> void remove(T o1) {
		try {
			entitymanager.getTransaction().begin();
			entitymanager.remove(o1);
			entitymanager.getTransaction().commit();
		} catch (PersistenceException persistence) {
			LOGGER.error("Error - " + persistence.getMessage());
			entitymanager.getTransaction().rollback();
		} catch (Exception e) {
			LOGGER.error("Error - " + e.getMessage());
			entitymanager.getTransaction().rollback();
		}

	}

	@SuppressWarnings("hiding")
	@Override
	public <T> List<T> findAll(Class<T> className) {
		try {
			entitymanager.getTransaction().begin();
			TypedQuery<T> query = entitymanager.createQuery("select a from " + className.getSimpleName() + " a",
					className);
			List<T> allData = query.getResultList();
			entitymanager.getTransaction().commit();
			return allData;
		} catch (PersistenceException persistence) {
			LOGGER.error("Error - " + persistence.getMessage());
			entitymanager.getTransaction().rollback();
		} catch (Exception e) {
			LOGGER.error("Error - " + e.getMessage());
			entitymanager.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public <T> T find(Class<T> className, int id) {
		try {
			entitymanager.getTransaction().begin();
			T object = entitymanager.find(className, id);
			entitymanager.getTransaction().commit();
			return object;
		} catch (PersistenceException persistence) {
			LOGGER.error("Error - " + persistence.getMessage());
			entitymanager.getTransaction().rollback();
		} catch (Exception e) {
			LOGGER.error("Error - " + e.getMessage());
			entitymanager.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public <T> void update(T o1) {
		try {
			entitymanager.getTransaction().begin();
			entitymanager.merge(o1);
			entitymanager.getTransaction().commit();
		} catch (PersistenceException persistence) {
			LOGGER.error("Error - " + persistence.getMessage());
			persistence.printStackTrace();
			entitymanager.getTransaction().rollback();
		} catch (Exception e) {
			LOGGER.error("Error - " + e.getMessage());
			e.printStackTrace();
			entitymanager.getTransaction().rollback();
		}

	}

	@Override
	public void shutdown() {
		entitymanager.close();
	}
	
	

}
