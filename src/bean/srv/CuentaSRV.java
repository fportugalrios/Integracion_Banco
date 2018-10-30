package bean.srv;

import java.util.List;
import bean.Cuenta;
import bean.dao.HibernateCuentasDAO;


public class CuentaSRV {
	private static HibernateCuentasDAO dao;
	
	static {
		dao = HibernateCuentasDAO.getInstancia();
	}
	
	public static void grabarCuenta(Cuenta cta){
		dao.grabarCuenta(cta);
	}
	
	public static void grabarCuentas(List<Cuenta> cuentas){
		dao.grabarCuentas(cuentas);
	}
	
	public static List<Cuenta >leerCuentas()
	{
		return dao.leerCuentas();
	}
	
}
