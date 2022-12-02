package com.lambda;

public class Pelicula {
	
	private String nombre;
	private int año;
	private double costo;

	public Pelicula(String nombre, int año, double costo) {
		this.nombre = nombre;
		this.año = año;
		this.costo = costo;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Pelicula [nombre=" + nombre + ", año=" + año + ", costo=" + costo + "]";
	}

}
