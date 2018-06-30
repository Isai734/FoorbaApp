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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author isai.castro
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Persona.findByAPaterno", query = "SELECT p FROM Persona p WHERE p.aPaterno = :aPaterno"),
    @NamedQuery(name = "Persona.findByAMaterno", query = "SELECT p FROM Persona p WHERE p.aMaterno = :aMaterno"),
    @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Persona.findByEstadoCivil", query = "SELECT p FROM Persona p WHERE p.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Persona.findByOcupacion", query = "SELECT p FROM Persona p WHERE p.ocupacion = :ocupacion")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_persona")
    private Integer idPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "a_paterno")
    private String aPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "a_materno")
    private String aMaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @Size(max = 12)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Size(max = 45)
    @Column(name = "ocupacion")
    private String ocupacion;
    @JoinColumn(name = "id_escuela", referencedColumnName = "id_escuela")
    @ManyToOne
    private Escuela idEscuela;
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    @ManyToOne
    private Grupo idGrupo;
    @JoinColumn(name = "id_iglesia", referencedColumnName = "id_iglesia")
    @ManyToOne
    private Iglesia idIglesia;
    @OneToMany(mappedBy = "idPadre")
    private Collection<Persona> personaCollection;
    @JoinColumn(name = "id_padre", referencedColumnName = "id_persona")
    @ManyToOne
    private Persona idPadre;
    @JoinColumn(name = "id_vivienda", referencedColumnName = "id_vivienda")
    @ManyToOne
    private Vivienda idVivienda;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(Integer idPersona, String nombre, String aPaterno, String aMaterno, String fechaNacimiento, String estadoCivil) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAPaterno() {
        return aPaterno;
    }

    public void setAPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getAMaterno() {
        return aMaterno;
    }

    public void setAMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Escuela getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(Escuela idEscuela) {
        this.idEscuela = idEscuela;
    }

    public Grupo getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Grupo idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Iglesia getIdIglesia() {
        return idIglesia;
    }

    public void setIdIglesia(Iglesia idIglesia) {
        this.idIglesia = idIglesia;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    public Persona getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Persona idPadre) {
        this.idPadre = idPadre;
    }

    public Vivienda getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(Vivienda idVivienda) {
        this.idVivienda = idVivienda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.entities.Persona[ idPersona=" + idPersona + " ]";
    }
    
}
