/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Consumidor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andre
 */

@Stateless
public class ConsumidorBean {
    @PersistenceContext 
    EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //Devolve a lista dos consumidores registados
    public List<Consumidor> getConsumidores() {
        return (List<Consumidor>) em.createNamedQuery("Consumidor.findAll").getResultList();
    }
    
    public Consumidor addConsumidor(Consumidor cons) {
        em.persist(cons);
        return cons;
    }
}
