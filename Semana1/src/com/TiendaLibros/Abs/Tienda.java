package com.TiendaLibros.Abs;

import java.util.*;

public class Tienda {

	public static void main(String[] args) {
		
		System.out.println("Bienvenido a la tienda de Libros");
	   
	    
	   //Se instancian y cargan los libros
	    Libro libro1 = new Fantasia("Harry Potter,", 18.53, 6, true, "J.K. Rowling]");
	    Libro libro2 = new SciFi("Duna,", 21.2, 20, true, "Frank Herbert]");
	    Libro libro3  = new Ciencia("El origen de las especies,", 30.2, 5, true, "Charles Darwin]");
	    
	   
	    Libro catalogo[];
	    catalogo = new Libro[3];
	    
	    //Se rellena el array catálogo
	    catalogo[0] = libro1;
	    catalogo[1] = libro2;
	    catalogo[2] = libro3;
	    
	   
	      System.out.println("Estos son los libros con los que contamos: ");
	      for (int i = 0; i < 3; i++) {
			System.out.println(catalogo[i]);
			
		}
	     
	        

	  }

	}


