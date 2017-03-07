package es.gorka.edu.connection;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import es.gorka.edu.dto.AlumnoDTO;

@Service
public class DataBase {
	
	private ArrayList<AlumnoDTO> BocadilloLonganiza = new ArrayList<AlumnoDTO>();
	private ArrayList<AlumnoDTO> BocadilloTofu = new ArrayList<AlumnoDTO>();
	private ArrayList<AlumnoDTO> Naranja = new ArrayList<AlumnoDTO>();
	
	public ArrayList<AlumnoDTO> getBocadilloLonganiza() {
		return BocadilloLonganiza;
	}
	public void setBocadilloLonganiza(ArrayList<AlumnoDTO> bocadilloLonganiza) {
		BocadilloLonganiza = bocadilloLonganiza;
	}
	
	public ArrayList<AlumnoDTO> getBocadilloTofu() {
		return BocadilloTofu;
	}
	
	public void setBocadilloTofu(ArrayList<AlumnoDTO> bocadilloTofu) {
		BocadilloTofu = bocadilloTofu;
	}
	
	public ArrayList<AlumnoDTO> getNaranja() {
		return Naranja;
	}
	public void setNaranja(ArrayList<AlumnoDTO> naranja) {
		Naranja = naranja;
	}
}
