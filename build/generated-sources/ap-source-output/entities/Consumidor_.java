package entities;

import entities.Subscritor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-08T14:44:41")
@StaticMetamodel(Consumidor.class)
public class Consumidor_ { 

    public static volatile SingularAttribute<Consumidor, String> password;
    public static volatile SingularAttribute<Consumidor, Integer> consumidorId;
    public static volatile SingularAttribute<Consumidor, String> nome;
    public static volatile CollectionAttribute<Consumidor, Subscritor> subscritorCollection;
    public static volatile SingularAttribute<Consumidor, String> username;

}