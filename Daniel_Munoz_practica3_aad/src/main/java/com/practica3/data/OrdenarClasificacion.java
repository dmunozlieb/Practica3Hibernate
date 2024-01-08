package com.practica3.data;

import java.util.Comparator;

import com.practica3.model.Clasificacion;

public class OrdenarClasificacion implements Comparator<Clasificacion> {

	@Override
	public int compare(Clasificacion o1, Clasificacion o2) {		
		if (o1.getPuntuacion() < o2.getPuntuacion()) {
			return 1;
		} else if (o1.getPuntuacion() > o2.getPuntuacion()) {
			return -1;
		} else {
			return 0;
		}
	}
}
