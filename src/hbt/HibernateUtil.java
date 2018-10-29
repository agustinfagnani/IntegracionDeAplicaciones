package hbt;

// lo que hace es la configuracion lo que le decimos a las 
//clases es o que vamsos a manejar le vamos a pasar lo que hibernate quiere
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.AdicionalEntity;
import entities.AlumnoEntity;
import entities.CuotaEntity;
import entities.EmpleadoEntity;
import entities.EscolaridadEntity;
import entities.FacturaEntity;
import entities.ItemFacturaEntity;
import entities.TitularEntity;

 
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	Configuration config = new Configuration();
            config.addAnnotatedClass(AdicionalEntity.class);
            config.addAnnotatedClass(AlumnoEntity.class);
            config.addAnnotatedClass(CuotaEntity.class);
            config.addAnnotatedClass(EmpleadoEntity.class);
            config.addAnnotatedClass(EscolaridadEntity.class);
            config.addAnnotatedClass(FacturaEntity.class);
            config.addAnnotatedClass(ItemFacturaEntity.class);
            config.addAnnotatedClass(TitularEntity.class);
            sessionFactory = config.buildSessionFactory();
                 
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
