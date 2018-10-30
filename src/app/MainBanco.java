
package app;


import java.io.*;
import java.util.List;
import bean.CuentaView;
/**
 * Inserte aqu� la descripci�n del tipo.
 * Fecha de creaci�n: (31/08/2005 15:21:06)
 * @author: Maria Paula Sarasa
 */
public class MainBanco {
	private Banco banco;
/**
 * Comentario de constructor MainBanco.
 */
public MainBanco() {
	super();
	banco = new Banco();
}
/**
 * Inserte aqu� la descripci�n del m�todo.
 * Fecha de creaci�n: (31/08/2005 15:27:02)
 */
public void abrirCuenta()
{
	try
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Solicito informacion
		System.out.println("ALTA DE CUENTA");
		System.out.println("---------------");
		System.out.print("Ingrese numero cuenta:");
		int nro = Integer.parseInt(reader.readLine());
		System.out.println("");
		System.out.print("Ingrese DNI:");
		String dni = reader.readLine();
		System.out.print("Seleccione si la nueva cuenta sera Caja Ahorro o Cuenta Corriente (CA - CC):");
		String tipoCuenta = reader.readLine();
		if (tipoCuenta.equalsIgnoreCase("CA"))
		{
			System.out.print("Ingrese moneda (Pesos - Dolar):");
			String moneda = reader.readLine();
			if (moneda.equals("Pesos"))
				banco.abrirCajaAhorroPesos(dni, nro);
			//else
				//banco.crearCADolar(nro,0,dni);
		}
		else
		{
			System.out.print("Ingrese moneda (Pesos - Dolar):");
			String moneda = reader.readLine();
			/*if (moneda.equals("Pesos"))
				banco.crearCCPesos(nro,0,dni);
			else
				banco.crearCCDolar(nro,0,dni);*/
		}
			
		mostrarMenu();
	}
	catch(Exception e)
	{}
	

}

/**
 * Inserte aqu� la descripci�n del m�todo.
 * Fecha de creaci�n: (31/08/2005 15:27:02)
 */
public void depositar() 
{
	try
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Solicito informacion
		System.out.println("DEPOSITAR");
		System.out.println("---------");
		System.out.print("Ingrese numero de cuenta:");
		int cta = Integer.parseInt(reader.readLine());
		System.out.print("Ingrese monto a depositar:");
		float monto = Float.parseFloat(reader.readLine());
		
		banco.depositar(cta, monto);
			
		mostrarMenu();
	}
	catch(Exception e){
		e.printStackTrace();
	}

}
/**
 * Inserte aqu� la descripci�n del m�todo.
 * Fecha de creaci�n: (31/08/2005 15:27:02)
 */
public void extraer() 
{
	try
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Solicito informacion
		System.out.println("EXTRAER");
		System.out.println("---------");
		System.out.print("Ingrese numero de cuenta:");
		int cta = Integer.parseInt(reader.readLine());
		System.out.print("Ingrese monto a extraer:");
		float monto = Float.parseFloat(reader.readLine());
		
		banco.extraer(cta, monto);
			
		mostrarMenu();
	}
	catch(Exception e){}

}
public void crearCliente() 
{
	try
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Solicito informacion
		System.out.println("CREAR CLIENTE");
		System.out.println("---------------");
		System.out.print("Ingrese nombre:");
		String nombre = reader.readLine();
		System.out.print("Ingrese dni:");
		String dni = reader.readLine();
		System.out.print("Ingrese domicilio:");
		String domicilio = reader.readLine();
		System.out.print("Ingrese telefono:");
		int telefono = Integer.parseInt(reader.readLine());
		
		banco.crearCliente(nombre, dni, telefono, domicilio);
			
		mostrarMenu();
	}
	catch(Exception e){}
	
}
/**
 * Inserte aqu� la descripci�n del m�todo.
 * Fecha de creaci�n: (31/08/2005 15:35:15)
 * @return demo.paula.Banco
 */
public Banco getBanco() {
	return banco;
}
/**
 * Inserte aqu� la descripci�n del m�todo.
 * Fecha de creaci�n: (31/08/2005 15:27:02)
 */
public void listarCuentas()
{
	try
	{
		//Solicito informacion
		System.out.println("LISTAR CUENTAS");
		System.out.println("---------------");
		
		List<CuentaView> cuentas = banco.getCuentas();
		for(CuentaView cta : cuentas)
		{
			
			System.out.println("NRO CUENTA: "+ cta.getNumero());
			System.out.println("NOMBRE CLIENTE: "+ cta.getNombreCliente());
			System.out.println("SALDO: "+ cta.getSaldo());
			System.out.println("----------------------------------------------------");			
		}

		mostrarMenu();
	}
	catch(Exception e)
	{
	}
	
}
/**
 * Inicia la aplicaci�n.
 * @param args una matriz de argumentos de l�nea de mandatos
 */
public static void main(java.lang.String[] args) 
{
	// Inserte aqu� c�digo para iniciar la aplicaci�n.
	MainBanco main = new MainBanco();
	main.mostrarMenu();
	
}
/**
 * Inserte aqu� la descripci�n del m�todo.
 * Fecha de creaci�n: (31/08/2005 15:22:26)
 */
public void mostrarMenu() 
{
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 	
	//Imprimo menu de opciones
	System.out.println("MENU DE OPCIONES");
	System.out.println("-------------------------------------------------------");
	System.out.println("1.- Crear Cliente");
	System.out.println("2.- Abrir Cuenta");
	System.out.println("3.- Listar cuentas");
	System.out.println("4.- Depositar");
	System.out.println("5.- Extraer");
	System.out.println("6.- Consultar saldo");
	System.out.println("7.- Listar Movimientos de una cuenta");
	System.out.println("8.- Debitar mantenimiento");
	System.out.println("9.- Salir");
	System.out.println("-------------------------------------------------------");
	System.out.print("Opcion:");
	try
	{
		char s = (char)reader.read();
		
	  	switch (s)
	  	{
	  		case '1' : 
	  			{
	  				this.crearCliente();
	  				break;
	  			}
		  	case '2' : 
		  		{
		  			this.abrirCuenta();
		  			break;
		  		}
		  	case '3' : 
		  		{
		  			this.listarCuentas();
		  			break;
		  		}
		  	case '4' : 
		  		{
		  			this.depositar();
		  			break;
		  		}
		  		
		  	case '5' : 
		  		{
		  			this.extraer();
		  			break;
		  		}
		  		
		  	case '6' : 
		  		{
		  			this.consultarSaldo();
		  			break;
		  		}
		  		
		  	case '7' : 
		  		{
		  			this.listarMovimientos();
		  			break;
		  		}
		  	case '8' : 
		  		{
		  			this.debitarMantenimiento();
		  			break;
		  		}
		  	case '9' : 
		  		{
		  			this.salir();
		  			break;
		  		}
	  	}
	}
	catch (Exception e)
	{
	}

}
private void listarMovimientos() 
{
	 try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//Solicito informacion
			System.out.println("LISTAR MOVIMIENTOS");
			System.out.println("------------------");
			System.out.print("Ingrese numero de cuenta:");
			int cta = Integer.parseInt(reader.readLine());
			
			CuentaView cuenta = banco.getCuenta(cta);
			List<String> movs = cuenta.getMovimientos();
			System.out.println("NRO CUENTA: "+ cuenta.getNumero());
			System.out.println("DETALLE DE MOVIMIENTOS");
			System.out.println("----------------------");
			for(String mov : movs)
			{
				System.out.println(mov);
							
			}
			mostrarMenu();
		}
		catch(Exception e)
	 {
			e.printStackTrace();
	 }
	
}
private void debitarMantenimiento() 
{
	try
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Solicito informacion
		System.out.println("DEBITAR MANTENIMIENTO");
		System.out.println("---------------------");
		System.out.print("Ingrese monto a debitar por mantenimiento:");
		float monto = Float.parseFloat(reader.readLine());
		
		banco.debitarMantenimiento(monto);
			
		mostrarMenu();
	}
	catch(Exception e){}
}

private void consultarSaldo() 
{
	 try
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Solicito informacion
		System.out.println("CONSULTA DE SALDO");
		System.out.println("------------------");
		System.out.print("Ingrese numero de cuenta:");
		int cta = Integer.parseInt(reader.readLine());
		
		float saldo = banco.consultarSaldoCuenta (cta);
		System.out.println("El saldo de la cuenta es: $ " + saldo);
		mostrarMenu();
	}
	catch(Exception e){}
	
}
/**
 * Inserte aqu� la descripci�n del m�todo.
 * Fecha de creaci�n: (31/08/2005 15:27:02)
 */
public void salir() 
{
	banco.actualizarBD();
	System.exit(0);
}
/**
 * Inserte aqu� la descripci�n del m�todo.
 * Fecha de creaci�n: (31/08/2005 15:35:15)
 * @param newBanco demo.paula.Banco
 */
public void setBanco(Banco newBanco) {
	banco = newBanco;
}
}
