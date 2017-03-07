package es.gorka.edu.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.gorka.edu.dto.AlumnoDTO;
import es.gorka.edu.repository.LonganizaRepository;


@Service
public class LonganizaService {
	
	@Autowired
	LonganizaRepository repository;

	public boolean insertNewBocadillo(AlumnoDTO alumnoDto) {
		repository.insertNewLonganiza(alumnoDto);
		return true;
	}
	
	public ArrayList<AlumnoDTO> listAll() {
		return repository.listAll();
	}
}
