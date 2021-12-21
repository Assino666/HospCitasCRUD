package com.hospital.mx.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.mx.entities.TblDoctor;

@Repository
public interface TblDoctorDao extends JpaRepository<TblDoctor, Integer> {

}
