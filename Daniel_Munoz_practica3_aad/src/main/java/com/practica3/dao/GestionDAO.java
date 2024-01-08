package com.practica3.dao;

import java.util.List;

import com.practica3.model.Equipo;
import com.practica3.model.Jugador;

public interface GestionDAO<T> {
	void insert(Jugador player, int id_equipo);

	void remove(Jugador player);

	<T> T find(Class<T> className, int id);

	<T>List<T> findAll(Class<T> className);
	
	<T>void update(T o1);
}
