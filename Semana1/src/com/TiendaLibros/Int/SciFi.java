package com.TiendaLibros.Int;

public class SciFi implements Libro{
	
	//Methods
	  @Override
	  public String toString() {
	    return  "Nombre: "      +this.nombre()+    " "+
	        "Precio unidad: " +this.precioUnit()+  " $ "+
	        "En Stock: "    +this.cantStock()+ " ";
	  }
	  
	  

	@Override
	public String nombre() {
		// TODO Auto-generated method stub
		return nombre();
	}

	@Override
	public double precioUnit() {
		// TODO Auto-generated method stub
		return precioUnit();
	}

	@Override
	public int cantStock() {
		// TODO Auto-generated method stub
		return cantStock();
	}

}
