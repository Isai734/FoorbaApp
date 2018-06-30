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
@Table(name = "escuela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escuela.findAll", query = "SELECT e FROM Escuela e"),
    @NamedQuery(name = "Escuela.findByIdEscuela", query = "SELECT e FROM Escuela e WHERE e.idEscuela = :idEscuela"),
    @NamedQuery(name = "Escuela.findByNivel", query = "SELECT e FROM Escuela e WHERE e.nivel = :nivel"),
    @NamedQuery(name = "Escuela.findByGrado", query = "SELECT e FROM Escuela e WHERE e.grado = :grado"),
    @NamedQuery(name = "Escuela.findByGrupo", query = "SELECT e FROM Escuela e WHERE e.grupo = :grupo")})
public class Escuela implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_escuela")
    private Integer idEscuela;
    @Size(max = 15)
    @Column(name = "nivel")
    private String nivel;
    @Size(max = 15)
    @Column(name = "grado")
    private String grado;
    @Size(max = 10)
    @Column(name = "grupo")
    private String grupo;
    @OneToMany(mappedBy = "idEscuela")
    private Collection<Persona> personaCollection;

    public Escuela() {
    }

    public Escuela(Integer idEscuela) {
        this.idEscuela = idEscuela;
    }

    public Integer getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(Integer idEscuela) {
        this.idEscuela = idEscuela;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
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
        hash += (idEscuela != null ? idEscuela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escuela)) {
            return false;
        }
        Escuela other = (Escuela) object;
        if ((this.idEscuela == null && other.idEscuela != null) || (this.idEscuela != null && !this.idEscuela.equals(other.idEscuela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.entities.Escuela[ idEscuela=" + idEscuela + " ]";
    }
    
}
