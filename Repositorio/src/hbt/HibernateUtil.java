package hbt;

// lo que hace es la configuracion lo que le decimos a las 
//clases es o que vamsos a manejar le vamos a pasar lo que hibernate quiere
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import negocio.*;



 
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	Configuration config = new Configuration();
        	config.addAnnotatedClass(Titular.class);
        	 config.addAnnotatedClass(Escolaridad.class);
        	config.addAnnotatedClass(Alumno.class);
            config.addAnnotatedClass(Adicional.class);
            config.addAnnotatedClass(Cuota.class);
            config.addAnnotatedClass(Empleado.class);
           
            config.addAnnotatedClass(Factura.class);
            config.addAnnotatedClass(ItemFactura.class);
            
            config.addAnnotatedClass(TipoDePago.class);
            config.addAnnotatedClass(Credito.class);
            config.addAnnotatedClass(Deposito.class);
            
            
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
