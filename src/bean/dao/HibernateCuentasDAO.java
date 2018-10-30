package bean.dao;

import java.util.List;
import hbt.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import bean.Cuenta;

public class HibernateCuentasDAO {
	private static HibernateCuentasDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernateCuentasDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateCuentasDAO();
		} 
		return instancia;
	}
	
	public void grabarCuentas(List<Cuenta> cuentas){
		Session session = sf.openSession();
		session.beginTransaction();
		for(Cuenta c:cuentas)
			session.merge(c);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public void grabarCuenta(Cuenta cta){
		Session session = sf.openSession();
		session.beginTransaction();
		session.merge(cta);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	public List<Cuenta> leerCuentas()
	{
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Cuenta> list = session.createQuery("from CajaAhorroPesos").list();
		session.close();
		return list;
	}
}
