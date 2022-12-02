package com.lambda;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		
		List<Pelicula> listaPeliculas = new ArrayList<>();
		listaPeliculas.add(new Pelicula("Black Adam",2022,250.00));
		listaPeliculas.add(new Pelicula("Duna",2021,230.00));
		listaPeliculas.add(new Pelicula("Rogue One",2016,299.80));
		listaPeliculas.add(new Pelicula("Eternals",2021,448.57));

		System.out.println("-----AÑO MAYOR A 2020----------");		
		mostrarPelicula(listaPeliculas,emp -> emp.getAño() > 2020);

		System.out.println("-----COSTO MAYOR A 280----------");
		mostrarPelicula(listaPeliculas,x -> x.getCosto() > 280);

		System.out.println("-----NOMBRE LONGITUD MAYOR A 8----------");
		mostrarPelicula(listaPeliculas,Z -> Z.getNombre().length() > 8);

		System.out.println("PELICULAS CUYO NOMBRE LONGITUD MAYOR A 8 Y CUESTA MAS DE 280");
		mostrarPelicula(listaPeliculas, w -> w.getNombre().length()>8 
										&& w.getCosto() > 280);
	}

	static void mostrarPelicula(List<Pelicula> lista, 
			PredicadoPelicula p ) {

		for(Pelicula e :lista) {
			if (p.probar(e)) //EJECUTA LA LAMBDA
				System.out.println(e);
		}

	}

	}


