package es.gorka.edu.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.gorka.edu.dto.AlumnoDTO;
import es.gorka.edu.repository.TofuRepository;

@Service
public class TofuService {
	
	@Autowired
	TofuRepository repository;

	public boolean insertNewTofu(AlumnoDTO alumnoDto) {
		repository.insertNewTofu(alumnoDto);
		return true;
	}
	
	public ArrayList<AlumnoDTO> listAll() {
		return repository.listAll();
	}
}
