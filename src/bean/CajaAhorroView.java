package bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CajaAhorroView {
	
	private int numero;
	private LocalDate fechaApertura;
	private float saldo;
	private String nombreCliente;
	private List<String> movimientos;

	
	public CajaAhorroView(int numero, float saldo, String CBU,List<Movimiento>movs , ) 
	{
		super();
		this.numero = numero;
		this.fechaApertura = fechaApertura;
		this.saldo = saldo;
		this.nombreCliente = nombreCliente;
		movimientos = new ArrayList<String>();
		cargarMovimientos(movs);
	}



	private void cargarMovimientos(List<Movimiento> movs) 
	{
		for(Movimiento mov : movs)
		{
			movimientos.add(mov.toString());
		}
		
	}



	public int getNumero() {
		return numero;
	}



	public LocalDate getFechaApertura() {
		return fechaApertura;
	}



	public float getSaldo() {
		return saldo;
	}
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	public List<String> getMovimientos() {
		return movimientos;
	}


}

}
