/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.ConsumidorBean;
import beans.NoticiaBean;
import entities.Consumidor;
import entities.Noticia;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author andre
 */

@Named (value = "consumidorController")
@RequestScoped

public class ConsumidorController {
    @EJB
    ConsumidorBean cons;
   
    
    Consumidor novoConsumidor = new Consumidor();
    List<Consumidor> consumidorList = new ArrayList();
    String usrn;
    String pass;
    int id;

    public Consumidor getNovoConsumidor() {
        return novoConsumidor;
    }

    public void setNovoConsumidor(Consumidor novoConsumidor) {
        this.novoConsumidor = novoConsumidor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsrn() {
        return usrn;
    }

    public void setUsrn(String usrn) {
        this.usrn = usrn;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    //Devolve a lista com os consumidores registados
    public List<Consumidor> getConsumidorList() {
        consumidorList = cons.getConsumidores();
        return consumidorList;
    }
    
    public String registarConsumidor() {
        consumidorList = cons.getConsumidores();
        System.out.println(consumidorList);
        for(int i=0;i<consumidorList.size();i++) {
            if(consumidorList.get(i).getUsername().equals(novoConsumidor.getUsername())) {
                System.out.println("Este utilizador já existe!");
                return "index.xhtml";
            }
        }
        
        cons.addConsumidor(novoConsumidor);
        return "index.xhtml";
    }
    
    public String loginConsumidor() {
        for(int i=0;i<cons.getConsumidores().size();i++) {
            if(usrn.equals(cons.getConsumidores().get(i).getUsername()) && pass.equals(cons.getConsumidores().get(i).getPassword())) {
                novoConsumidor.setConsumidorId(cons.getConsumidores().get(i).getConsumidorId());
                setNovoConsumidor(novoConsumidor);
                return "consumidorRegMenu.xhtml";
            }
        }
        return "consumidorLogin.xhtml";
    }
    
        //Devolve o nome do consumidor autenticado (usado na mensagem de boas vindas)
    public String getNomeCons() {
        try {
            for(int i=0;i<cons.getConsumidores().size();i++) {
                if(usrn.equals(cons.getConsumidores().get(i).getUsername())) {
                    System.out.println(cons.getConsumidores().get(i).getNome());
                    return "Bem-vindo, " + cons.getConsumidores().get(i).getNome() + "!";
                }    
            }
        } catch(Exception e) {
            System.out.println(" " + e.getMessage());
        }
        return " ";
    }
    

    
    //Devolve o username do consumidor dado o consumidor
    public String getUserConsId(Consumidor id) {
        for(int i=0;i<cons.getConsumidores().size();i++) {
            if(id.equals(cons.getConsumidores().get(i)))
                return cons.getConsumidores().get(i).getUsername();
        }
        return " ";
    }
    
   
}
