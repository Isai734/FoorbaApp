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
@Table(name = "iglesia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Iglesia.findAll", query = "SELECT i FROM Iglesia i"),
    @NamedQuery(name = "Iglesia.findByIdIglesia", query = "SELECT i FROM Iglesia i WHERE i.idIglesia = :idIglesia"),
    @NamedQuery(name = "Iglesia.findByNombre", query = "SELECT i FROM Iglesia i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Iglesia.findByClave", query = "SELECT i FROM Iglesia i WHERE i.clave = :clave")})
public class Iglesia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_iglesia")
    private Integer idIglesia;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 10)
    @Column(name = "clave")
    private String clave;
    @OneToMany(mappedBy = "idIglesia")
    private Collection<Persona> personaCollection;
    @JoinColumn(name = "direccion", referencedColumnName = "id_direccion")
    @ManyToOne
    private Direccion direccion;

    public Iglesia() {
    }

    public Iglesia(Integer idIglesia) {
        this.idIglesia = idIglesia;
    }

    public Integer getIdIglesia() {
        return idIglesia;
    }

    public void setIdIglesia(Integer idIglesia) {
        this.idIglesia = idIglesia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIglesia != null ? idIglesia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iglesia)) {
            return false;
        }
        Iglesia other = (Iglesia) object;
        if ((this.idIglesia == null && other.idIglesia != null) || (this.idIglesia != null && !this.idIglesia.equals(other.idIglesia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.entities.Iglesia[ idIglesia=" + idIglesia + " ]";
    }
    
}
