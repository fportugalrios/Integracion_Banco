package bean;

import java.util.ArrayList;
import java.util.List;

import bean.srv.CuentaSRV;



public class ListCuentas {
	private List<Cuenta> cuentas;
	
	public ListCuentas()
	{
		cuentas= new ArrayList<Cuenta>();
		cuentas = CuentaSRV.leerCuentas();
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	
	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	public void addCuenta(Cuenta cta){
		cuentas.add(cta);
		CuentaSRV.grabarCuenta(cta);
	}
	
	public boolean removeCuenta(Cuenta cta) {
		return cuentas.remove(cta);
	}
	
	public Cuenta getCuentaPorId(int id){
		for(Cuenta u : cuentas){
			if(u.getNumero()==id) 
				return u;
		}
		return null;
	}
	
	
	
	public int size(){
		return cuentas.size();
	}

	public void actualizarBD() 
	{
		CuentaSRV.grabarCuentas(cuentas);
		
	}

	public List<CuentaView> getCuentasView() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CuentaView> getCuentasView() {
		// TODO Auto-generated method stub
		return null;
	}

/*	public List<CuentaView> getCuentasView() 
	{
		List<CuentaView>lista =new ArrayList<CuentaView>();
		for(Cuenta cta : cuentas){
			lista.add(cta.getView());
		}
		return lista;
	}*/

	
}
