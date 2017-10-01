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
@Table(name = "PRODUTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtor.findAll", query = "SELECT p FROM Produtor p")
    , @NamedQuery(name = "Produtor.findByProdutorId", query = "SELECT p FROM Produtor p WHERE p.produtorId = :produtorId")
    , @NamedQuery(name = "Produtor.findByUsername", query = "SELECT p FROM Produtor p WHERE p.username = :username")
    , @NamedQuery(name = "Produtor.findByPassword", query = "SELECT p FROM Produtor p WHERE p.password = :password")
    , @NamedQuery(name = "Produtor.findByNome", query = "SELECT p FROM Produtor p WHERE p.nome = :nome")})
public class Produtor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUTOR_ID")
    private Integer produtorId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtorId")
    private Collection<Noticia> noticiaCollection;

    public Produtor() {
    }

    public Produtor(Integer produtorId) {
        this.produtorId = produtorId;
    }

    public Produtor(Integer produtorId, String username, String password) {
        this.produtorId = produtorId;
        this.username = username;
        this.password = password;
    }

    public Integer getProdutorId() {
        return produtorId;
    }

    public void setProdutorId(Integer produtorId) {
        this.produtorId = produtorId;
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
    public Collection<Noticia> getNoticiaCollection() {
        return noticiaCollection;
    }

    public void setNoticiaCollection(Collection<Noticia> noticiaCollection) {
        this.noticiaCollection = noticiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produtorId != null ? produtorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtor)) {
            return false;
        }
        Produtor other = (Produtor) object;
        if ((this.produtorId == null && other.produtorId != null) || (this.produtorId != null && !this.produtorId.equals(other.produtorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Produtor[ produtorId=" + produtorId + " ]";
    }
    
}
