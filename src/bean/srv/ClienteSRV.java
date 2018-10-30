package bean.srv;

import java.util.List;
import bean.Cliente;
import bean.dao.HibernateClienteDAO;


public class ClienteSRV {
	private static HibernateClienteDAO dao;
	
	static {
		dao = HibernateClienteDAO.getInstancia();
	}
	
	public static void grabarCliente(Cliente cli){
		dao.grabarCliente(cli);
	}
	
	public static void grabarClientes(List<Cliente> clientes){
		dao.grabarClientes(clientes);
	}
	
	public static List<Cliente >leerClientes()
	{
		return dao.leerClientes();
	}
	
}
