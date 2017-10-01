/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Consumidor;
import entities.Noticia;
import entities.Subscritor;
import entities.Topico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andre
 */
@Stateless
public class SubscritorBean {
    @PersistenceContext 
    EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //Devolve a lista de subscriçoes
    public List<Subscritor> getSubscricoes() {
        return (List<Subscritor>) em.createNamedQuery("Subscritor.findAll").getResultList();
    }
    
    public Subscritor addSubscricao(Subscritor cons) {
        em.persist(cons);
        return cons;
    }
    
    //Devolve a lista com as subscricoes de um determinado subscritor
    public List<Subscritor> getSubscricoesById(Consumidor cons) {
        return (List<Subscritor>) em.createNamedQuery("Subscritor.findByConsumidorId")
                .setParameter("consumidorId", cons)
                .getResultList();
    }    
    
    public void updateEstado(Consumidor c, Topico t, int estado) {
        em.createNamedQuery("Subscritor.updateEstado")
                .setParameter("consumidorId", c)
                .setParameter("topicoId", t)
                .setParameter("estado", estado)
                .executeUpdate();
    }
    
    //Devolve lista de topicos por consumidor
    public List<Topico> getTopicosConsumidor(Consumidor c) {
        return (List<Topico>) em.createNamedQuery("Subscritor.findTopicoByConsumidor")
                .setParameter("consumidorId", c)
                .getResultList();    
    }
        //Devolve lista de topicos por consumidor
    public List<Integer> getEstadoTopico(Topico tp, Consumidor cons) {
        return  (List<Integer>) em.createNamedQuery("Subscritor.findEstadoByTopico")
                .setParameter("topicoId", tp)
                .setParameter("consumidorId", cons)
                .getResultList();
    }
    
    //Devolve lista de noticias subscritas
    public List<Noticia> getNotciasSubscritas(Consumidor c) {
        return (List<Noticia>) em.createNamedQuery("Subscritor.findNoticiaConsumidor")
                .setParameter("consumidorId", c)
                .getResultList();
    }
    
    
}
