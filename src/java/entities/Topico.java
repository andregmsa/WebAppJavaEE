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
@Table(name = "TOPICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Topico.findAll", query = "SELECT t FROM Topico t")
    , @NamedQuery(name = "Topico.findByTopicoId", query = "SELECT t FROM Topico t WHERE t.topicoId = :topicoId")
    , @NamedQuery(name = "Topico.findByDesignacao", query = "SELECT t FROM Topico t WHERE t.designacao = :designacao")
    , @NamedQuery(name = "Topico.findAllId", query = "SELECT t.topicoId FROM Topico t")
    , @NamedQuery(name = "Topico.findAllDesignacao", query = "SELECT t.designacao FROM Topico t")})
public class Topico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TOPICO_ID")
    private Integer topicoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DESIGNACAO")
    private String designacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topicoId")
    private Collection<Noticia> noticiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topicoId")
    private Collection<Subscritor> subscritorCollection;

    public Topico() {
    }

    public Topico(Integer topicoId) {
        this.topicoId = topicoId;
    }

    public Topico(Integer topicoId, String designacao) {
        this.topicoId = topicoId;
        this.designacao = designacao;
    }

    public Integer getTopicoId() {
        return topicoId;
    }

    public void setTopicoId(Integer topicoId) {
        this.topicoId = topicoId;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    @XmlTransient
    public Collection<Noticia> getNoticiaCollection() {
        return noticiaCollection;
    }

    public void setNoticiaCollection(Collection<Noticia> noticiaCollection) {
        this.noticiaCollection = noticiaCollection;
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
        hash += (topicoId != null ? topicoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Topico)) {
            return false;
        }
        Topico other = (Topico) object;
        if ((this.topicoId == null && other.topicoId != null) || (this.topicoId != null && !this.topicoId.equals(other.topicoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Topico[ topicoId=" + topicoId + " ]";
    }
    
}
