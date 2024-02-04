package com.practica3.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

/*** Esta clase realiza/se encarga de devolver la conexión a la base de datos. * 
 * @author Daniel Muñoz */


public class ConnectJPA {

	private static EntityManagerFactory emFactory;
	private static EntityManager entitymanager;
	private static final String JPA_UNIT = "jpa-practica3-aad";

	static {
		try {
			emFactory = Persistence.createEntityManagerFactory(JPA_UNIT);
			entitymanager = emFactory.createEntityManager();
		} catch (PersistenceException persistence) {
			persistence.printStackTrace();
		}
	}

	public static EntityManager getEntityManager() {
		return entitymanager;
	}
}
