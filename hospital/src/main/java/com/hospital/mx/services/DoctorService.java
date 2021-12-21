package com.hospital.mx.services;

import java.util.List;

import com.hospital.mx.dto.DoctorDto;

public interface DoctorService {
	
	void guardarDoctor(DoctorDto doctor);
	List mostrarDoctores();

}
