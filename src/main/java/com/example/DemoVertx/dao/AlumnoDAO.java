package com.example.DemoVertx.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.DemoVertx.domain.Alumno;


public class AlumnoDAO {

	private static final AlumnoDAO alumnoRepository = new AlumnoDAO();

	private List<Alumno> alumnos;
	
	private AlumnoDAO() {
		alumnos=new ArrayList<Alumno>();
		mock();
	}
	
	private void mock() {
		alumnos.add(new Alumno("Ignacio"));
		alumnos.add(new Alumno("María"));
		alumnos.add(new Alumno("Laura"));
	}

	
	public List<Alumno> findAll(){
		return alumnos;
	}
	
	public List<Alumno> findByNombre(String nombre){
		return alumnos.stream()
				.filter(item->item.getNombre().equals(nombre))
				.collect(Collectors.toList());
	}
	
	public static AlumnoDAO getInstance() {
		return alumnoRepository;
	}

}
