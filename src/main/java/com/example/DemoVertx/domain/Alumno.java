package com.example.DemoVertx.domain;

public class Alumno {
	
	private String nombre;
	
	public Alumno() {}
	
	public Alumno(String nombre){
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
