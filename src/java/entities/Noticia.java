/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "NOTICIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Noticia.findAll", query = "SELECT n FROM Noticia n")
    , @NamedQuery(name = "Noticia.findByNoticiaId", query = "SELECT n FROM Noticia n WHERE n.noticiaId = :noticiaId")
    , @NamedQuery(name = "Noticia.findByCorpo", query = "SELECT n FROM Noticia n WHERE n.corpo = :corpo")
    , @NamedQuery(name = "Noticia.findByData", query = "SELECT n FROM Noticia n WHERE n.data = :data")
    , @NamedQuery(name = "Noticia.findByTopico", query = "SELECT n FROM Noticia n WHERE n.topicoId = :topicoId")
    , @NamedQuery(name = "Noticia.findByNoticiaEntreNotcias", query = "SELECT n FROM Noticia n WHERE n.noticiaId > :not AND n.noticiaId <= :not2 AND n.topicoId = :topicoId")        
    , @NamedQuery(name = "Noticia.findBetweenData", query = "SELECT n FROM Noticia n WHERE n.data > :data AND n.data < :data2")})
public class Noticia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NOTICIA_ID")
    private Integer noticiaId;
    @Size(max = 100)
    @Column(name = "CORPO")
    private String corpo;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "PRODUTOR_ID", referencedColumnName = "PRODUTOR_ID")
    @ManyToOne(optional = false)
    private Produtor produtorId;
    @JoinColumn(name = "TOPICO_ID", referencedColumnName = "TOPICO_ID")
    @ManyToOne(optional = false)
    private Topico topicoId;

    public Noticia() {
    }

    public Noticia(Integer noticiaId) {
        this.noticiaId = noticiaId;
    }

    public Integer getNoticiaId() {
        return noticiaId;
    }

    public void setNoticiaId(Integer noticiaId) {
        this.noticiaId = noticiaId;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Produtor getProdutorId() {
        return produtorId;
    }

    public void setProdutorId(Produtor produtorId) {
        this.produtorId = produtorId;
    }

    public Topico getTopicoId() {
        return topicoId;
    }

    public void setTopicoId(Topico topicoId) {
        this.topicoId = topicoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noticiaId != null ? noticiaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Noticia)) {
            return false;
        }
        Noticia other = (Noticia) object;
        if ((this.noticiaId == null && other.noticiaId != null) || (this.noticiaId != null && !this.noticiaId.equals(other.noticiaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Noticia[ noticiaId=" + noticiaId + " ]";
    }
    
}
