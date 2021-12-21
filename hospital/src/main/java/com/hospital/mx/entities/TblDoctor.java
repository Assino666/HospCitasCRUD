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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_doctor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDoctor.findAll", query = "SELECT t FROM TblDoctor t"),
    @NamedQuery(name = "TblDoctor.findByIdDoctor", query = "SELECT t FROM TblDoctor t WHERE t.idDoctor = :idDoctor"),
    @NamedQuery(name = "TblDoctor.findByNombreDoctor", query = "SELECT t FROM TblDoctor t WHERE t.nombreDoctor = :nombreDoctor"),
    @NamedQuery(name = "TblDoctor.findByApellidoPaterno", query = "SELECT t FROM TblDoctor t WHERE t.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "TblDoctor.findByApellidoMaterno", query = "SELECT t FROM TblDoctor t WHERE t.apellidoMaterno = :apellidoMaterno")})
public class TblDoctor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_doctor")
    private Integer idDoctor;
    @Column(name = "nombre_doctor")
    private String nombreDoctor;
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @JoinColumn(name = "fk_especialidad", referencedColumnName = "id_especialidad")
    @ManyToOne
    private CatEspecialidad fkEspecialidad;
    @OneToMany(mappedBy = "idDoctor")
    private Collection<TblCita> tblCitaCollection;

    public TblDoctor() {
    }

    public TblDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public CatEspecialidad getFkEspecialidad() {
        return fkEspecialidad;
    }

    public void setFkEspecialidad(CatEspecialidad fkEspecialidad) {
        this.fkEspecialidad = fkEspecialidad;
    }

    @XmlTransient
    public Collection<TblCita> getTblCitaCollection() {
        return tblCitaCollection;
    }

    public void setTblCitaCollection(Collection<TblCita> tblCitaCollection) {
        this.tblCitaCollection = tblCitaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDoctor != null ? idDoctor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDoctor)) {
            return false;
        }
        TblDoctor other = (TblDoctor) object;
        if ((this.idDoctor == null && other.idDoctor != null) || (this.idDoctor != null && !this.idDoctor.equals(other.idDoctor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades_v1.TblDoctor[ idDoctor=" + idDoctor + " ]";
    }
    
}
