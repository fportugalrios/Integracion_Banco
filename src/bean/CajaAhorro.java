package bean;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CajasAhorro")
public class CajaAhorro extends Cuenta 
{
	private float interes;
	

	public void setDatos(LocalDate fechaApertura, int numero,Cliente cli,float interes) 
	{
		setDatos(fechaApertura, numero,cli);
		this.interes = interes;	
	}
	
	public float getInteres() {
		return interes;
	}

	public void setInteres(float interes) {
		this.interes = interes;
	}

	@Override
	public float extraer(float monto,String desc) 
	{
		if (saldo >=monto)
		{
			saldo = saldo - monto;
			movimientos.add(new Movimiento(LocalDate.now(),monto,desc));
			return saldo;
		}
		
		return -1;
	}

	

}
