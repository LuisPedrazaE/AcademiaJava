package com.TiendaLibros.Abs;

public class Fantasia extends Libro {
	

	//Atributo
	  private String autor;

	  
	  //Constructor
	  public Fantasia() { };
	  public Fantasia(String nombre, double precioUnit, int cantStock, boolean disponible, String autor) {
	    super(nombre, precioUnit, cantStock, disponible);
	    this.autor = autor;
	  }
	  
	  
	  //Metodo
	  @Override
	  public String toString() {
	    return  "Libro de Fantasia: "+
	        super.toString()+
	        "[Autor: "  +this.autor;
	  }
	  
	  //Gets and Sets
	  public String getAutor() {
	    return autor;
	  }
	  public void setAutor(String autor) {
	    this.autor = autor;
	  }
	}	


