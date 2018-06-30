/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author isai.castro
 */
@Entity
@Table(name = "servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s"),
    @NamedQuery(name = "Servicio.findByIdServicio", query = "SELECT s FROM Servicio s WHERE s.idServicio = :idServicio"),
    @NamedQuery(name = "Servicio.findByAgua", query = "SELECT s FROM Servicio s WHERE s.agua = :agua"),
    @NamedQuery(name = "Servicio.findByTelefono", query = "SELECT s FROM Servicio s WHERE s.telefono = :telefono"),
    @NamedQuery(name = "Servicio.findByLuz", query = "SELECT s FROM Servicio s WHERE s.luz = :luz"),
    @NamedQuery(name = "Servicio.findByGas", query = "SELECT s FROM Servicio s WHERE s.gas = :gas"),
    @NamedQuery(name = "Servicio.findByInternet", query = "SELECT s FROM Servicio s WHERE s.internet = :internet"),
    @NamedQuery(name = "Servicio.findByCable", query = "SELECT s FROM Servicio s WHERE s.cable = :cable")})
public class Servicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_servicio")
    private Integer idServicio;
    @Size(max = 1)
    @Column(name = "agua")
    private String agua;
    @Size(max = 1)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 1)
    @Column(name = "luz")
    private String luz;
    @Size(max = 1)
    @Column(name = "gas")
    private String gas;
    @Size(max = 1)
    @Column(name = "internet")
    private String internet;
    @Size(max = 1)
    @Column(name = "cable")
    private String cable;
    @OneToMany(mappedBy = "idServicios")
    private Collection<Vivienda> viviendaCollection;

    public Servicio() {
    }

    public Servicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getAgua() {
        return agua;
    }

    public void setAgua(String agua) {
        this.agua = agua;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLuz() {
        return luz;
    }

    public void setLuz(String luz) {
        this.luz = luz;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public String getCable() {
        return cable;
    }

    public void setCable(String cable) {
        this.cable = cable;
    }

    @XmlTransient
    public Collection<Vivienda> getViviendaCollection() {
        return viviendaCollection;
    }

    public void setViviendaCollection(Collection<Vivienda> viviendaCollection) {
        this.viviendaCollection = viviendaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.entities.Servicio[ idServicio=" + idServicio + " ]";
    }
    
}
