package com.TiendaLibros.Abs;

public class Ciencia extends Libro {
	

	//Atributo
	  private String autor;

	  
	  //Constructor
	  public Ciencia() { };
	  public Ciencia(String nombre, double precioUnit, int cantStock, boolean disponible, String autor) {
	    super(nombre, precioUnit, cantStock, disponible);
	    this.autor = autor;
	  }
	  
	  
	  //Metodo
	  @Override
	  public String toString() {
	    return  "Libro de Ciencia: "+
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