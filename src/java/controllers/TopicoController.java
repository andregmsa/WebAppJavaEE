/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.TopicoBean;
import entities.Consumidor;
import entities.Topico;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author andre
 */

@Named (value = "topicoController")
@RequestScoped

public class TopicoController {
    @EJB
    TopicoBean tp;
    
    Topico novoTopico = new Topico(); 
    List<Topico> topicoList = new ArrayList();

    public Topico getNovoTopico() {
        return novoTopico;
    }

    public void setNovoTopico(Topico novoTopico) {
        this.novoTopico = novoTopico;
    }
    
    //Devolve a lista com os topicos inseridos
    public List<Topico> getTopicoList() {
        topicoList = tp.getTopicos();
        return topicoList;
    }
    
    //Devolve a lista com os topicos pelo id
    public List<Topico> getTopicoListId() {
        topicoList = tp.getTopicosId();
        return topicoList;
    }
    
    //Devolve a lista com os topicos pela designacao
    public List<Topico> getTopicoListDesignacao() {
        topicoList = tp.getTopicosDesignacao();
        return topicoList;
    }
    
    //Usado para converter o id em uma String e assim colocar na lista de topicos a designacao
    public Topico getTopico(Integer id) {
        topicoList=getTopicoList();
        if (id == null){
            throw new IllegalArgumentException("id nao foi inserido");
        }
        
        for (Topico topico : topicoList){
            if (id.equals(topico.getTopicoId())){
                return topico;
            }
        }
        return null;
    }
    
    public String adicionarTopico() {  
        topicoList = tp.getTopicos();
        //Verificar se o topico tem designacao repetida
        for(int i=0;i<topicoList.size();i++) {
            if(novoTopico.getDesignacao().equals(topicoList.get(i).getDesignacao()))
                return "produtorMenu.xhtml";
        }
        tp.addTopico(novoTopico);
        return "produtorMenu.xhtml";
    }
    
    public String topicoErro() {
        return "Erro: Este tópico já existe! ";
    }
    
    //Devolve a designação do topico dado o topico
    public String getDesignacaoTopico(Topico id) {
        for(int i=0;i<tp.getTopicos().size();i++) {
            if(id.equals(tp.getTopicos().get(i)))
                return tp.getTopicos().get(i).getDesignacao();
        }
        return " ";
    }
    
}
