package com.example.DemoVertx.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.DemoVertx.dao.AlumnoDAO;
import com.example.DemoVertx.domain.Alumno;

@Service
public class AlumnoService {

	private AlumnoDAO alumnoRepository=AlumnoDAO.getInstance();
	
	public AlumnoService(){}
	
	public List<Alumno> findAll(){
		return alumnoRepository.findAll();
	}

}
