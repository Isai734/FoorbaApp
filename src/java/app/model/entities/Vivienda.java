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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "vivienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vivienda.findAll", query = "SELECT v FROM Vivienda v"),
    @NamedQuery(name = "Vivienda.findByIdVivienda", query = "SELECT v FROM Vivienda v WHERE v.idVivienda = :idVivienda"),
    @NamedQuery(name = "Vivienda.findByEsPropia", query = "SELECT v FROM Vivienda v WHERE v.esPropia = :esPropia"),
    @NamedQuery(name = "Vivienda.findByViveCon", query = "SELECT v FROM Vivienda v WHERE v.viveCon = :viveCon")})
public class Vivienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vivienda")
    private Integer idVivienda;
    @Size(max = 1)
    @Column(name = "es_propia")
    private String esPropia;
    @Size(max = 15)
    @Column(name = "vive_con")
    private String viveCon;
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion")
    @ManyToOne
    private Direccion idDireccion;
    @JoinColumn(name = "id_servicios", referencedColumnName = "id_servicio")
    @ManyToOne
    private Servicio idServicios;
    @OneToMany(mappedBy = "idVivienda")
    private Collection<Persona> personaCollection;

    public Vivienda() {
    }

    public Vivienda(Integer idVivienda) {
        this.idVivienda = idVivienda;
    }

    public Integer getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(Integer idVivienda) {
        this.idVivienda = idVivienda;
    }

    public String getEsPropia() {
        return esPropia;
    }

    public void setEsPropia(String esPropia) {
        this.esPropia = esPropia;
    }

    public String getViveCon() {
        return viveCon;
    }

    public void setViveCon(String viveCon) {
        this.viveCon = viveCon;
    }

    public Direccion getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Direccion idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Servicio getIdServicios() {
        return idServicios;
    }

    public void setIdServicios(Servicio idServicios) {
        this.idServicios = idServicios;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVivienda != null ? idVivienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vivienda)) {
            return false;
        }
        Vivienda other = (Vivienda) object;
        if ((this.idVivienda == null && other.idVivienda != null) || (this.idVivienda != null && !this.idVivienda.equals(other.idVivienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.entities.Vivienda[ idVivienda=" + idVivienda + " ]";
    }
    
}
