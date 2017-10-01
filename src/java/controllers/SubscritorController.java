/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.SubscritorBean;
import entities.Consumidor;
import entities.Noticia;
import entities.Subscritor;
import entities.Topico;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author andre
 */

@Named (value = "subscritorController")
@RequestScoped

public class SubscritorController {
    @EJB
    SubscritorBean sub;
    
    Subscritor novoSubscritor = new Subscritor();
    List<Subscritor> subscritorList = new ArrayList();
    List<Noticia> noticiaList = new ArrayList();
    List<Integer> intList = new ArrayList();
    Topico tp = new Topico();
    Consumidor consumidor = new Consumidor();
    int estado=0;
    
    public Subscritor getNovoSubscritor() {
        return novoSubscritor;
    }

    public void setNovoSubscritor(Subscritor novoSubscritor) {
        this.novoSubscritor = novoSubscritor;
    }

    public Topico getTp() {
        return tp;
    }

    public void setTp(Topico tp) {
        this.tp = tp;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }
    
    //Devolve a lista com as subscricoes
    public List<Subscritor> getSubscricoesList() {
        subscritorList = sub.getSubscricoes();
        return subscritorList;
    }
    
    //Devolve a lista com as subscricoes para um dado consumidor
    public List<Subscritor> getSubscricoesById(Consumidor cons) {
        subscritorList = sub.getSubscricoesById(cons);
        return subscritorList;
    }
   
    
    //Subscrever topico
    public String subscreverTopico() throws ParseException {
        subscritorList = sub.getSubscricoes();
        for(int i=0;i<subscritorList.size();i++) {
            if(subscritorList.get(i).getConsumidorId().equals(consumidor) && subscritorList.get(i).getTopicoId().equals(tp))
                return "consumidorRegMenu.xhtml";
        }
        novoSubscritor.setEstado(estado);
        novoSubscritor.setConsumidorId(consumidor);
        novoSubscritor.setTopicoId(tp);
        sub.addSubscricao(novoSubscritor);
        return "consumidorRegMenu.xhtml";
    }
    
    
}
