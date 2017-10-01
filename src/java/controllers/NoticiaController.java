/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.NoticiaBean;
import beans.SubscritorBean;
import entities.Consumidor;
import entities.Noticia;
import entities.Produtor;
import entities.Subscritor;
import entities.Topico;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author andre
 */

@Named (value = "noticiaController")
@RequestScoped

public class NoticiaController {
    
    @EJB
    NoticiaBean not;
    
    @EJB
    SubscritorBean sub;
  
    Noticia novaNoticia = new Noticia();
    List<Noticia> noticiaList = new ArrayList();
    Topico tp = new Topico();
    Noticia last = new Noticia();
    Produtor produtor = new Produtor();
    Date date;
    Date dt;
    Date ddt;
    List<Subscritor> subscritorList = new ArrayList();

    public Noticia getNovaNoticia() {
        return novaNoticia;
    }

    public void setNovaNoticia(Noticia novaNoticia) {
        this.novaNoticia = novaNoticia;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    public Topico getTp() {
        return tp;
    }

    public void setTp(Topico tp) {
        this.tp = tp;
    }
    
    public void fazerUpdate(Consumidor cons, int estado, Topico top) {
           sub.updateEstado(cons, top, estado);
    }
    
    public void setTopicoAvisos(Consumidor cons) {
        List<Topico> tops = new ArrayList();
        int estado=0;
        Noticia n = new Noticia();
        for(int i=0;i<sub.getSubscricoes().size();i++) {
            if(cons.equals(sub.getSubscricoes().get(i).getConsumidorId()))
                tops.add(sub.getSubscricoes().get(i).getTopicoId());
        }
        try {
            for(int j=0;j<tops.size();j++) {
                tp=tops.get(j);
                System.out.println("TOPICO" + tp);
                n = getUltimaAvisos(tp);
                estado = n.getNoticiaId();
                System.out.println("ESTADO" + estado);
                System.out.println("CONSUMIDOR" + cons);
                fazerUpdate(cons, estado, tp);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }   
    
    //Devolve noticias subscritas de um subscritor
    public List<Noticia> getNoticiasConsumidor(Consumidor c) {
        noticiaList=sub.getNotciasSubscritas(c);
        return noticiaList;
    }

    public Noticia getLast() {
        return last;
    }

    public void setLast(Noticia last) {
        this.last = last;
    }

    public Date getDate() throws ParseException {
        String data = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new GregorianCalendar().getTime());
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.ENGLISH);
        date = format.parse(data);
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public Date getDdt() {
        return ddt;
    }

    public void setDdt(Date ddt) {
        this.ddt = ddt;
    }
    
    //Devolve a lista com as noticias publicadas
    public List<Noticia> getNoticiaList() {
        noticiaList = not.getNoticias();
        return noticiaList;
    }
    
    public String adicionarNoticia() throws ParseException {    
        novaNoticia.setTopicoId(tp);
        novaNoticia.setProdutorId(produtor);
        novaNoticia.setData(getDate());
        not.addNoticia(novaNoticia);
        noticiaList = not.getNoticias();
        return "produtorMenu.xhtml";
    }
    
    //Definir entre datas 
    public String setNotEntreDatas(Date dt, Date ddt) {
        this.dt=dt;
        this.ddt=ddt;
        return "notEntreDatas.xhtml";
    }
    
        //Definir entre datas nao registado
    public String setNaoRegDatas(Date dt, Date ddt) {
        this.dt=dt;
        this.ddt=ddt;
        return "naoRegDatas.xhtml";
    }
    
    public Noticia getUltimaNoticiaTopico() {
        try{
            noticiaList = not.getNoticiasTopico(tp);
            last = noticiaList.get(noticiaList.size()-1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }    
        return last;
    }
    
    public Noticia getUltimaAvisos(Topico tp) {
        try{
            noticiaList = not.getNoticiasTopico(tp);
            last = noticiaList.get(noticiaList.size()-1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }    
        return last;
    }
    
    
    public Noticia ultimaNot(Topico top) {
        noticiaList = not.getNoticiasTopico(top);
        try {
            if(noticiaList.size()==0) 
                return null;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }    
        Noticia ultima = noticiaList.get(noticiaList.size()-1);
        return ultima;
    }
    
    public int topicoEstado(Topico tp, Consumidor cons) { 
        System.out.println("ESTADO DO TÓPICO:" + sub.getEstadoTopico(tp, cons).get(0));
        return sub.getEstadoTopico(tp, cons).get(0);
    }

    
    public ArrayList<String> compararEstado(Consumidor cons) {
        String aviso="Existem novas notícias publicadas!";
        String sem_aviso="Não há novas noticias publicadas!";
        ArrayList<String> avList = new ArrayList();
        List<Subscritor> list= sub.getSubscricoesById(cons);
        for(int i = 0;i<list.size();i++) {
            Noticia ultima = ultimaNot(list.get(i).getTopicoId());
            int estado=topicoEstado(list.get(i).getTopicoId(), cons);     
            try {
                if(ultima.getNoticiaId().equals(estado)) {
                    System.out.println("O ESTADO = ULTIMO ID DA NOTCIA, NÃO HOUVE ATUALIZAÇÃO NAS NOTICIAS SUBSCRITAS!");
                    avList.add(sem_aviso);
                } else {
                    System.out.println("O ESTADO =! ULTIMA NOTICIA, GERA NOTIFICAÇAO!"); 
                    avList.add(aviso);
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return avList;
    }
    
    public String mandaAviso(Consumidor cons) {
        ArrayList<String> avisos=compararEstado(cons);
        for(int i=0;i<avisos.size();i++) {
            if(avisos.get(i).equals("Existem novas notícias publicadas!")) 
                return "Existem novas notícias publicadas!";
        }
        return "Não há novas noticias publicadas!";
    }
    
    //Devolve a lista de noticias entre datas
    public List<Noticia> getNoticiasEntreDatas() throws ParseException {
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //dt = sdf.parse("24/05/2017");
        //ddt = sdf.parse("02/06/2017");
        try {
            System.out.println(dt);
            System.out.println(ddt);
            noticiaList = not.getNoticiasBetweenDatas(dt, ddt);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }    
        return noticiaList;
    }
    
    
}
