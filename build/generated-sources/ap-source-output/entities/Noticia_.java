package entities;

import entities.Produtor;
import entities.Topico;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-08T14:44:41")
@StaticMetamodel(Noticia.class)
public class Noticia_ { 

    public static volatile SingularAttribute<Noticia, String> corpo;
    public static volatile SingularAttribute<Noticia, Date> data;
    public static volatile SingularAttribute<Noticia, Topico> topicoId;
    public static volatile SingularAttribute<Noticia, Integer> noticiaId;
    public static volatile SingularAttribute<Noticia, Produtor> produtorId;

}