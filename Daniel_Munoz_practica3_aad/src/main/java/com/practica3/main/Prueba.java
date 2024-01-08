package com.practica3.main;

import com.practica3.liga.Liga;

import jakarta.persistence.EntityManager;




public class Prueba {
	private static  EntityManager manager = null;
	public static void main(String[] args) {
		
		Liga.ejecutarLiga();
	}
}
