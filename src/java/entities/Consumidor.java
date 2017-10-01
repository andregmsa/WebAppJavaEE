/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author andre
 */
@Entity
@Table(name = "CONSUMIDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consumidor.findAll", query = "SELECT c FROM Consumidor c")
    , @NamedQuery(name = "Consumidor.findByConsumidorId", query = "SELECT c FROM Consumidor c WHERE c.consumidorId = :consumidorId")
    , @NamedQuery(name = "Consumidor.findByUsername", query = "SELECT c FROM Consumidor c WHERE c.username = :username")
    , @NamedQuery(name = "Consumidor.findByPassword", query = "SELECT c FROM Consumidor c WHERE c.password = :password")
    , @NamedQuery(name = "Consumidor.findByNome", query = "SELECT c FROM Consumidor c WHERE c.nome = :nome")})
public class Consumidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONSUMIDOR_ID")
    private Integer consumidorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 40)
    @Column(name = "NOME")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consumidorId")
    private Collection<Subscritor> subscritorCollection;

    public Consumidor() {
    }

    public Consumidor(Integer consumidorId) {
        this.consumidorId = consumidorId;
    }

    public Consumidor(Integer consumidorId, String username, String password) {
        this.consumidorId = consumidorId;
        this.username = username;
        this.password = password;
    }

    public Integer getConsumidorId() {
        return consumidorId;
    }

    public void setConsumidorId(Integer consumidorId) {
        this.consumidorId = consumidorId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Subscritor> getSubscritorCollection() {
        return subscritorCollection;
    }

    public void setSubscritorCollection(Collection<Subscritor> subscritorCollection) {
        this.subscritorCollection = subscritorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consumidorId != null ? consumidorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consumidor)) {
            return false;
        }
        Consumidor other = (Consumidor) object;
        if ((this.consumidorId == null && other.consumidorId != null) || (this.consumidorId != null && !this.consumidorId.equals(other.consumidorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Consumidor[ consumidorId=" + consumidorId + " ]";
    }
    
}
