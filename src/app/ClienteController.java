package app;
/*
 * 
 * Esto es una prueba
 */
import bean.Cliente;
import bean.ListClientes;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import bean.CajaAhorro;
import bean.Cuenta;
import bean.CuentaView;
import bean.ListCuentas;
import bean.PersonaFisica;
import bean.PersonaJuridica;

public class ClienteController {
	
	private ListClientes clientes;
	
	public  ClienteController() {
	clientes = new ListClientes();
	}
	
	public void altaPersonaFisica(String nombre, String dni,int telefono,
			String domicilio)
	{
		Cliente c = buscarCliente(dni);
		if (c==null)
		{
			c = new PersonaFisica(dni, domicilio, nombre,telefono);

			clientes.addCliente(c);
		}
	}
	
	
	
	public void altaPersonaJuridica(String nombre, String Cuit,int telefono,
			String domicilio)
	{
		Cliente c = buscarCliente(Cuit);
		if (c==null)
		{
			c = new PersonaJuridica(Cuit, domicilio, nombre, telefono);
			clientes.addCliente(c);
		}
	}

	private Cliente buscarCliente(String dni)
	{
		return clientes.getClientePorId(dni);
	}
	
	public void modificarCliente (String nombre, String dni, int telefono,
			String domicilio)
	{
		Cliente c = buscarCliente(dni);
		if (c!=null)
		{
			c.setNombre(nombre);
			c.setTelefono(telefono);
			c.setDomicilio(domicilio);
		}
	}
	
	public void eliminarCliente(String dni)
	{
		Cliente c = buscarCliente(dni);
		//if (!c.hayCuentasActivas())
			clientes.removeCliente(c);
	}


}
