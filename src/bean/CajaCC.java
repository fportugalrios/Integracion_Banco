package bean;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CuentasCorrientes")
public class CajaCC extends Cuenta {
	
	private float descubierto;
	
	@Override
	public float extraer(float monto, String desc) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
