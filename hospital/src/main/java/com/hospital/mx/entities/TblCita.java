/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.mx.entities;


import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "tbl_cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCita.findAll", query = "SELECT t FROM TblCita t"),
    @NamedQuery(name = "TblCita.findByIdCita", query = "SELECT t FROM TblCita t WHERE t.idCita = :idCita"),
    @NamedQuery(name = "TblCita.findByFechahora", query = "SELECT t FROM TblCita t WHERE t.fechahora = :fechahora"),
    @NamedQuery(name = "TblCita.findByNombrePaciente", query = "SELECT t FROM TblCita t WHERE t.nombrePaciente = :nombrePaciente")})
public class TblCita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cita")
    private Integer idCita;
    @Basic(optional = false)
    @Column(name = "fechahora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahora;
    @Column(name = "nombre_paciente")
    private String nombrePaciente;
    @JoinColumn(name = "id_consultorio", referencedColumnName = "id_consultorio")
    @ManyToOne
    private CatConsultorio idConsultorio;
    @JoinColumn(name = "id_doctor", referencedColumnName = "id_doctor")
    @ManyToOne
    private TblDoctor idDoctor;

    public TblCita() {
    }

    public TblCita(Integer idCita) {
        this.idCita = idCita;
    }

    public TblCita(Integer idCita, Date fechahora) {
        this.idCita = idCita;
        this.fechahora = fechahora;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public CatConsultorio getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(CatConsultorio idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public TblDoctor getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(TblDoctor idDoctor) {
        this.idDoctor = idDoctor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCita != null ? idCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCita)) {
            return false;
        }
        TblCita other = (TblCita) object;
        if ((this.idCita == null && other.idCita != null) || (this.idCita != null && !this.idCita.equals(other.idCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades_v1.TblCita[ idCita=" + idCita + " ]";
    }
    
}
