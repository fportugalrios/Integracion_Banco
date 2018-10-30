package server;

import org.hibernate.Session;

import hbt.HibernateUtil;

public class Server {
	
	private static Server instancia;
	
	public static Server getInstancia(){
		if (instancia == null)
			instancia = new Server();
		return instancia;
	}
	
	private Server(){
		iniciar();
	}

	@SuppressWarnings("static-access")
	private void iniciar() {
		System.out.println("Iniciar hibernate");
    	Session s = HibernateUtil.getInstancia().getSessionFactory().openSession();

    	s.close();
    	System.out.println("Hibernate iniciado");
	}
}
