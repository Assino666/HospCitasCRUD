package com.hospital.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hospital.mx.dto.DoctorDto;
import com.hospital.mx.entities.TblDoctor;
import com.hospital.mx.services.DoctorService;
import com.hospital.mx.services.impl.DoctorServiceImpl;

@Controller
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
			
	@GetMapping("/registroDoctor")
	public String registroDoctor(Model model,  DoctorDto doctor) {
		
		doctor = new DoctorDto();
		model.addAttribute("doctor", doctor);
		
		return "index";
	}
	
	
	@PostMapping("/guardarDoctor")
	public String guardarDoctor(Model model,DoctorDto doctor) {
		
		System.out.println(doctor);
		
		doctorService.guardarDoctor(doctor);
		
		model.addAttribute("doctor", new DoctorDto());
		
		//return "index";
		return "redirect:/registroDoctor";
		
	}
	
	
	@GetMapping("/listaDoctores")
	public String getListaDoctor(Model model) {
		
		List<TblDoctor> listsDoctores = doctorService.mostrarDoctores();
		
		for(TblDoctor doctor : listsDoctores) {
			
			System.out.println(">> Nombre: " + doctor.getNombreDoctor());
		}
		
		model.addAttribute("listaDoctores", listsDoctores);
		
		return "listaDoctores";
	}
	
}
