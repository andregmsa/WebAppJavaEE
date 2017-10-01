package entities;

import entities.Consumidor;
import entities.Topico;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-08T14:44:41")
@StaticMetamodel(Subscritor.class)
public class Subscritor_ { 

    public static volatile SingularAttribute<Subscritor, Integer> estado;
    public static volatile SingularAttribute<Subscritor, Integer> subscritorId;
    public static volatile SingularAttribute<Subscritor, Consumidor> consumidorId;
    public static volatile SingularAttribute<Subscritor, Topico> topicoId;

}