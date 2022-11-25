package com.TiendaLibros.Int;

public class SciFi implements Libro{
	
	  String nombre;
	  double precioUnit;
	  int cantStock;
	  //boolean disponible;
	  String autor;
	  
	//Constructors
	  public SciFi() { }
	  public SciFi(String nombre, double precioUnit, int cantStock, String autor) {
	    this.nombre   = nombre;
	    this.precioUnit = precioUnit;
	    this.cantStock  = cantStock;
	    //this.disponible = disponible;
	    this.autor = autor;
	    
	  }
	
	//Methods
	  @Override
	  public String toString() {
	    return  "Nombre: "      +getNombre()+    " "+
	        "Precio unidad: " +getPrecioUnit()+  " $ "+
	        "En Stock: "    +getCantStock()+ " "+
	        "Autor: " +getAutor();
	  }
	  
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecioUnit() {
		return precioUnit;
	}
	
	public int getCantStock() {
		return cantStock;
	}
	
	public String getAutor() {
		return autor;
	}

	
}
