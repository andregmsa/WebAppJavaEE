/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Consumidor;
import entities.Noticia;
import entities.Produtor;
import entities.Subscritor;
import entities.Topico;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andre
 */
@Stateless
public class NoticiaBean {
    @PersistenceContext 
    EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //Devolve a lista de noticias publicadas de um daado topico por um produtor 
    public List<Noticia> getNoticias() {
        return (List<Noticia>) em.createNamedQuery("Noticia.findAll").getResultList();
    }
    
    //Dado um topico devolver as noticias
    public List<Noticia> getNoticiasTopico(Topico tp) {
        return (List<Noticia>) em.createNamedQuery("Noticia.findByTopico")
                .setParameter("topicoId", tp)
                .getResultList();
    }
    
    public Noticia addNoticia(Noticia not) {
        em.persist(not);
        return not;
    }
    
    //Devolve a lista de noticias entre datas
    public List<Noticia> getNoticiasBetweenDatas(Date dt, Date ddt) {
        return (List<Noticia>) em.createNamedQuery("Noticia.findBetweenData")
                .setParameter("data", dt)
                .setParameter("data2", ddt)
                .getResultList();
    } 
    
    //devolve notcias entre ids
    public List<Noticia> getNoticiasBetweenNoticias(int noti, int nott, Topico tp) {
        return (List<Noticia>) em.createNamedQuery("Noticia.findByNoticiaEntreNotcias")
                .setParameter("not", noti)
                .setParameter("not2", nott)
                .setParameter("topicoId", tp)
                .getResultList();        
    }
    
}
