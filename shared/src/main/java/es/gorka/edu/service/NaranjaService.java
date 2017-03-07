package es.gorka.edu.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.gorka.edu.dto.AlumnoDTO;
import es.gorka.edu.repository.LonganizaRepository;
import es.gorka.edu.repository.NaranjaRepository;

@Service
public class NaranjaService {
	
	@Autowired
	NaranjaRepository repository;

	public boolean insertNewNaranja(AlumnoDTO alumnoDto) {
		repository.insertNewNaranja(alumnoDto);
		return true;
	}
	
	public ArrayList<AlumnoDTO> listAll() {
		return repository.listAll();
	}
}
