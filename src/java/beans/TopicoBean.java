/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Produtor;
import entities.Topico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author andre
 */
@Stateless
public class TopicoBean {
    @PersistenceContext 
    EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //Devolve a lista dos topicos 
    public List<Topico> getTopicos() {
        return (List<Topico>) em.createNamedQuery("Topico.findAll").getResultList();
    }
    
    //Devolve a lista dos topicos pelo id
    public List<Topico> getTopicosId() {
        return (List<Topico>) em.createNamedQuery("Topico.findAllId").getResultList();
    }
    
    //Devolve a lista dos topicos pela designação
    public List<Topico> getTopicosDesignacao() {
        return (List<Topico>) em.createNamedQuery("Topico.findAllDesignacao").getResultList();
    }
    
        /*Devolve o ID do produto passando como parametro o a descricao
    public Product getProductByDescription(String description) {
        TypedQuery<Product> query = em.createNamedQuery("Product.findByDescription", Product.class);
        return query.setParameter("description", description).getSingleResult();
    } */
    
    public Topico addTopico(Topico tp) {
        em.persist(tp);
        return tp;
    }
    
}
