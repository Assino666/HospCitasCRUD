package com.hospital.mx.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.mx.dao.TblDoctorDao;
import com.hospital.mx.dto.DoctorDto;
import com.hospital.mx.entities.CatEspecialidad;
import com.hospital.mx.entities.TblDoctor;
import com.hospital.mx.services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService  {
	
	
	@Autowired
	TblDoctorDao tblDoctorDao;
	
	@Override
	public void guardarDoctor(DoctorDto doctor) {
		
		System.out.println(">> El nombre del doctor es: " + doctor.getNombre());
		
		
		TblDoctor newDoctor = new TblDoctor();
		
		newDoctor.setNombreDoctor(doctor.getNombre());
		newDoctor.setApellidoPaterno(doctor.getApePaterno());
		newDoctor.setApellidoMaterno(doctor.getApeMaterno());
		
		newDoctor.setFkEspecialidad(new  CatEspecialidad(Integer.parseInt(doctor.getEspecialidad())));
		
		tblDoctorDao.save(newDoctor);
		
	}

	@Override
	public List mostrarDoctores() {
		
		List<TblDoctor> listaDoctores = tblDoctorDao.findAll();
		
		for(int i = 0; i < listaDoctores.size(); i++) {
			
			
			if(listaDoctores.get(i).getFkEspecialidad() == null) {
				CatEspecialidad esp = new CatEspecialidad();
				esp.setNombre("");
				
				listaDoctores.get(i).setFkEspecialidad(esp);

			}		
		}
		
		return listaDoctores;
	}

}
