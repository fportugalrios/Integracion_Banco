package app;

import java.time.LocalDate;
import java.util.List;

import bean.CajaAhorro;
import bean.Cliente;
import bean.Cuenta;
import bean.CuentaView;
import bean.ListClientes;
import bean.ListCuentas;

public class CuentaController {
	
	private ListCuentas cuentas;
	private float interesCADolar;
	private float descubiertoCCDolar;
	private float interesCAPesos;
	private float descubiertoCCPesos;
	
	public CuentaController()
	{
		
		cuentas = new ListCuentas();
	}


	public float getInteresCADolar() {
		return interesCADolar;
	}

	public void setInteresCADolar(float interesCADolar) {
		this.interesCADolar = interesCADolar;
	}

	public float getDescubiertoCCDolar() {
		return descubiertoCCDolar;
	}

	public void setDescubiertoCCDolar(float descubiertoCCDolar) {
		this.descubiertoCCDolar = descubiertoCCDolar;
	}

	public float getInteresCAPesos() {
		return interesCAPesos;
	}

	public void setInteresCAPesos(float interesCAPesos) {
		this.interesCAPesos = interesCAPesos;
	}

	public float getDescubiertoCCPesos() {
		return descubiertoCCPesos;
	}

	public void setDescubiertoCCPesos(float descubiertoCCPesos) {
		this.descubiertoCCPesos = descubiertoCCPesos;
	}
	

	public void abrirCajaAhorroPesos (String dni,int nroCta)
	{
		Cliente c = buscarCliente(dni);
		if (c!=null)
		{
			Cuenta cta = buscarCuenta(nroCta);
			if (cta==null)
			{
				CajaAhorro ca$ = new CajaAhorro ();
				ca$.setDatos(LocalDate.now(),nroCta,c,interesCAPesos);
				cuentas.addCuenta(ca$);
				//c.add(ca$);
				
			}
		}
	}

	private Cliente buscarCliente(String dni) {
		// TODO Auto-generated method stub
		return null;
	}


	private Cuenta buscarCuenta(int nroCta) 
	{
		return cuentas.getCuentaPorId(nroCta);
	}
	public float depositar(int nroCta, float monto)
	{
		Cuenta cta = buscarCuenta(nroCta);
		if (cta!=null)
		{
			cta.depositar(monto);
			return cta.getSaldo();
		}
		return 0;
	}
	
	public float extraer(int nroCta, float monto)
	{
		Cuenta cta = buscarCuenta(nroCta);
		if (cta!=null)
			return cta.extraer(monto, "Extraccion de cuenta");
		return -2;
	}	
	
	public void actualizarBD()
	{
		cuentas.actualizarBD();	
	}

	public List<CuentaView> getCuentas() 
	{
		return cuentas.getCuentasView();
	}

	public void debitarMantenimiento(float monto) 
	{
		for(Cuenta c : cuentas.getCuentas())
		{
			c.extraer(monto,"Debito Mantenimiento");
		}
		
	}

	public float consultarSaldoCuenta(int cta) 
	{
		Cuenta cuenta = cuentas.getCuentaPorId(cta);
		if (cuenta!=null)
			return cuenta.getSaldo();
		return 0;
	}

	public CuentaView getCuenta(int cta) 
	{
		Cuenta cuenta = cuentas.getCuentaPorId(cta);
		if (cuenta!=null)
			return cuenta.getView();
		return null;
	}
	
}
