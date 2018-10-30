package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import bean.Movimiento;


public class HibernateMovimientoDAO {
	private static HibernateMovimientoDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernateMovimientoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateMovimientoDAO();
		} 
		return instancia;
	}
	
	public void grabarMovimientos(List<Movimiento> movimientos)
	{
		Session session = sf.openSession();
		session.beginTransaction();
		for(Movimiento movimiento:movimientos)
			session.save(movimiento);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Movimiento> leerMovimientos(){
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Movimiento> list = session.createQuery("from Movimiento").list();
		session.close();
		return list;
	}

	public void grabarMovimiento(Movimiento mov) 
	{
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(mov);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
	}

}
