package com.TiendaLibros.Int;


public class Tienda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bienvenido a la tienda de Libros");
		   
	    
		   //Se instancian y cargan los libros
		    Libro libro1 = new Fantasia("Harry Potter 2", 18.53, 6, "J.K. Rowling");
		    Libro libro2 = new SciFi("Duna 2", 21.2, 20, "Frank Herbert");
		    Libro libro3  = new Ciencia("El origen de las especies 2", 30.2, 5, "Charles Darwin");
		    
		    //Se crea el array "catálogo" para contener los libros.
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
