/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "SUBSCRITOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subscritor.findAll", query = "SELECT s FROM Subscritor s")
    , @NamedQuery(name = "Subscritor.findBySubscritorId", query = "SELECT s FROM Subscritor s WHERE s.subscritorId = :subscritorId")
    , @NamedQuery(name = "Subscritor.findByEstado", query = "SELECT s FROM Subscritor s WHERE s.estado = :estado")
    , @NamedQuery(name = "Subscritor.findByConsumidorId", query = "SELECT s FROM Subscritor s WHERE s.consumidorId = :consumidorId")
    , @NamedQuery(name = "Subscritor.findTopicoByConsumidor", query = "SELECT s.topicoId FROM Subscritor s WHERE s.consumidorId = :consumidorId")
    , @NamedQuery(name = "Subscritor.updateEstado", query = "UPDATE Subscritor s SET s.estado = :estado WHERE s.topicoId = :topicoId AND s.consumidorId = :consumidorId")
    , @NamedQuery(name = "Subscritor.findNoticiaConsumidor", query = "SELECT n FROM Subscritor s, Topico t, Noticia n WHERE s.consumidorId= :consumidorId AND s.topicoId = t AND n.topicoId = t")
    , @NamedQuery(name = "Subscritor.findEstadoByTopico", query = "SELECT s.estado FROM Subscritor s WHERE s.topicoId = :topicoId AND s.consumidorId= :consumidorId")})
public class Subscritor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SUBSCRITOR_ID")
    private Integer subscritorId;
    @Column(name = "ESTADO")
    private Integer estado;
    @JoinColumn(name = "CONSUMIDOR_ID", referencedColumnName = "CONSUMIDOR_ID")
    @ManyToOne(optional = false)
    private Consumidor consumidorId;
    @JoinColumn(name = "TOPICO_ID", referencedColumnName = "TOPICO_ID")
    @ManyToOne(optional = false)
    private Topico topicoId;

    public Subscritor() {
    }

    public Subscritor(Integer subscritorId) {
        this.subscritorId = subscritorId;
    }

    public Integer getSubscritorId() {
        return subscritorId;
    }

    public void setSubscritorId(Integer subscritorId) {
        this.subscritorId = subscritorId;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Consumidor getConsumidorId() {
        return consumidorId;
    }

    public void setConsumidorId(Consumidor consumidorId) {
        this.consumidorId = consumidorId;
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
        hash += (subscritorId != null ? subscritorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subscritor)) {
            return false;
        }
        Subscritor other = (Subscritor) object;
        if ((this.subscritorId == null && other.subscritorId != null) || (this.subscritorId != null && !this.subscritorId.equals(other.subscritorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Subscritor[ subscritorId=" + subscritorId + " ]";
    }
    
}
