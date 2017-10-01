package entities;

import entities.Noticia;
import entities.Subscritor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-08T14:44:41")
@StaticMetamodel(Topico.class)
public class Topico_ { 

    public static volatile SingularAttribute<Topico, Integer> topicoId;
    public static volatile SingularAttribute<Topico, String> designacao;
    public static volatile CollectionAttribute<Topico, Noticia> noticiaCollection;
    public static volatile CollectionAttribute<Topico, Subscritor> subscritorCollection;

}