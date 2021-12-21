/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.mx.entities;


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "cat_especialidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatEspecialidad.findAll", query = "SELECT c FROM CatEspecialidad c"),
    @NamedQuery(name = "CatEspecialidad.findByIdEspecialidad", query = "SELECT c FROM CatEspecialidad c WHERE c.idEspecialidad = :idEspecialidad"),
    @NamedQuery(name = "CatEspecialidad.findByNombre", query = "SELECT c FROM CatEspecialidad c WHERE c.nombre = :nombre")})
public class CatEspecialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_especialidad")
    private Integer idEspecialidad;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "fkEspecialidad")
    private Collection<TblDoctor> tblDoctorCollection;

    public CatEspecialidad() {
    }

    public CatEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<TblDoctor> getTblDoctorCollection() {
        return tblDoctorCollection;
    }

    public void setTblDoctorCollection(Collection<TblDoctor> tblDoctorCollection) {
        this.tblDoctorCollection = tblDoctorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspecialidad != null ? idEspecialidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatEspecialidad)) {
            return false;
        }
        CatEspecialidad other = (CatEspecialidad) object;
        if ((this.idEspecialidad == null && other.idEspecialidad != null) || (this.idEspecialidad != null && !this.idEspecialidad.equals(other.idEspecialidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades_v1.CatEspecialidad[ idEspecialidad=" + idEspecialidad + " ]";
    }
    
}
