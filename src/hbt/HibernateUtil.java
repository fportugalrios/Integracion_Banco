package hbt;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import bean.CajaAhorro;
import bean.CajaCC;
import bean.Cliente;
import bean.Cuenta;
import bean.Movimiento;
import bean.PersonaFisica;
import bean.PersonaJuridica;

 
public class HibernateUtil
{
	private static SessionFactory sessionFactory;
	 private static HibernateUtil instancia;
		
	    public static HibernateUtil getInstancia() {
	        if (instancia == null){
	            instancia = new HibernateUtil();
	        }
	        return instancia;
	    }
		
	    private HibernateUtil(){
	        configurar();
	    }
	    private void configurar() {
    
        try
        {
        	
        	Configuration config = new Configuration();
            config.addAnnotatedClass(Cliente.class);
            config.addAnnotatedClass(PersonaFisica.class);
            config.addAnnotatedClass(PersonaJuridica.class);
            config.addAnnotatedClass(Cuenta.class);
            config.addAnnotatedClass(CajaAhorro.class);
            config.addAnnotatedClass(CajaCC.class);
            config.addAnnotatedClass(Movimiento.class);
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
