/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.ProdutorBean;
import entities.Produtor;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author andre
 */

@Named (value = "produtorController")
@RequestScoped

public class ProdutorController {
    @EJB
    ProdutorBean prod;
    
    //@ManagedProperty("#{param.novoProdutor}")
    Produtor novoProdutor = new Produtor();
    List<Produtor> produtorList = new ArrayList();
    NoticiaController noti = new NoticiaController();
    int id;
    String usrn;
    String pass;
    
    public Produtor getNovoProdutor() {
        return novoProdutor;
    }

    public void setNovoProdutor(Produtor novoProdutor) {
        this.novoProdutor = novoProdutor;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    //Devolve no nome do produtor autenticado (usado na mensagem de boas vindas)
    public String getNomeProd() {
        try {
            for(int i=0;i<prod.getProdutores().size();i++) {
                if(usrn.equals(prod.getProdutores().get(i).getUsername())) {
                    return "Bem-vindo, " + prod.getProdutores().get(i).getNome() + "!";
                }    
            }
        } catch(Exception e) {
            System.out.println(" " + e.getMessage());
        }
        return " ";
    }
    
    public String loginProdutor() {
        for(int i=0;i<prod.getProdutores().size();i++) {
            if(usrn.equals(prod.getProdutores().get(i).getUsername()) && pass.equals(prod.getProdutores().get(i).getPassword())) {
                novoProdutor.setProdutorId(prod.getProdutores().get(i).getProdutorId());
                setNovoProdutor(novoProdutor);
                return "produtorMenu.xhtml";
            }
        }
        return "produtorLogin.xhtml";
    }
    
    //Devolve a lista com os produtores registados
    public List<Produtor> getProdutorList() {
        produtorList = prod.getProdutores();
        return produtorList;
    }
    
    public String registarProdutor() {
        produtorList = prod.getProdutores();
        System.out.println(produtorList);
        for(int i=0;i<produtorList.size();i++) {
            if(produtorList.get(i).getUsername().equals(novoProdutor.getUsername())) {
                System.out.println("Este utilizador já existe!");
                return "index.xhtml";
            }
        }
        
        prod.addProdutor(novoProdutor);
        return "index.xhtml";
    }
    
}
