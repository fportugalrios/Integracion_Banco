package bean;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="cuentas")
public abstract class Cuenta 
{
	@Id
	protected int nroCuenta;
	protected LocalDate fechaApertura;
	protected float saldo;
	@OneToMany (cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="nroCuenta")
	protected List<Movimiento> movimientos;
	
	/*
	 * @ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "idPersona", referencedColumnName = "idPersona")
	 * 
	 */
	@OneToOne
	@JoinColumn(name="dnicliente")
	protected Cliente cliente;
	
	public Cuenta()
	{
		movimientos = new ArrayList<Movimiento>();
		saldo = 0;
	}
	public void setDatos(LocalDate fechaApertura, int numero,Cliente cli) 
	{
		this.fechaApertura = fechaApertura;
		this.nroCuenta = numero;
		saldo = 0;
		cliente = cli;
		
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public int getNumero() {
		return nroCuenta;
	}

	public LocalDate getFechaApertura() {
		return fechaApertura;
	}
	
	public float depositar(float monto)
	{
		saldo = saldo + monto;
		movimientos.add(new Movimiento(LocalDate.now(),monto,"Deposito"));
		return saldo;
	}
	
	public abstract float extraer (float monto, String desc);
	
	@Override
	public String toString() {
		return "#"+nroCuenta+" $ "+saldo;
	}
	public CuentaView getView() {
		CuentaView c = new cuentaView(this.numero,  this.fechaApertura, this.saldo, 
				this.nombreCliente, null)
		return null;
	}

}
