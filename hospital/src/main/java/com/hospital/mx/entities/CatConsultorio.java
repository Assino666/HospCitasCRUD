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
@Table(name = "cat_consultorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatConsultorio.findAll", query = "SELECT c FROM CatConsultorio c"),
    @NamedQuery(name = "CatConsultorio.findByIdConsultorio", query = "SELECT c FROM CatConsultorio c WHERE c.idConsultorio = :idConsultorio"),
    @NamedQuery(name = "CatConsultorio.findByNumero", query = "SELECT c FROM CatConsultorio c WHERE c.numero = :numero"),
    @NamedQuery(name = "CatConsultorio.findByPiso", query = "SELECT c FROM CatConsultorio c WHERE c.piso = :piso")})
public class CatConsultorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_consultorio")
    private Integer idConsultorio;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "piso")
    private Integer piso;
    @OneToMany(mappedBy = "idConsultorio")
    private Collection<TblCita> tblCitaCollection;

    public CatConsultorio() {
    }

    public CatConsultorio(Integer idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public Integer getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(Integer idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
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
        hash += (idConsultorio != null ? idConsultorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatConsultorio)) {
            return false;
        }
        CatConsultorio other = (CatConsultorio) object;
        if ((this.idConsultorio == null && other.idConsultorio != null) || (this.idConsultorio != null && !this.idConsultorio.equals(other.idConsultorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades_v1.CatConsultorio[ idConsultorio=" + idConsultorio + " ]";
    }
    
}
