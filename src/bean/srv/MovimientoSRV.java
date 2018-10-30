package bean.srv;

import java.util.List;
import bean.Movimiento;
import bean.dao.HibernateMovimientoDAO;


public class MovimientoSRV {
	private static HibernateMovimientoDAO dao;
	
	static {
		dao = HibernateMovimientoDAO.getInstancia();
	}
	
	public static void grabarMovimiento(Movimiento mov){
		dao.grabarMovimiento(mov);
	}
	
	public static void grabarMovimientos(List<Movimiento> movs){
		dao.grabarMovimientos(movs);
	}
	
	public static List<Movimiento >leerMovimientos()
	{
		return dao.leerMovimientos();
	}
	
}
