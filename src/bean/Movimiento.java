package bean;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="movimientos")
public class Movimiento implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate fecha;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numero;
	private float importe;
	private String observaciones;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name="nroCuenta")
	private Cuenta Cuenta;
	
	public Movimiento()
	{
		fecha = LocalDate.now();
	}
	public Movimiento (LocalDate fec,float imp, String obs)
	{
		fecha = fec;
		importe = imp;
		observaciones = obs;
	}
	public Movimiento (LocalDate fec,float imp)
	{
		fecha = fec;
		importe = imp;
		observaciones = "";
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getNumero() {
		return numero;
	}
	
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public String toString()
	{
		return fecha + "\t" + observaciones + "\t\t\t" + importe;
	}
	

}
