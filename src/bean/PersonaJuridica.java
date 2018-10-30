package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PersonasJuridicas")
public class PersonaJuridica extends Cliente {
	@Id 
	@Column (name = "CUIT")
	private String CUIT;
	@Column (name = "RazonSocial", nullable = false, length = 50)
	private String RazonSocial;
	
	
	public PersonaJuridica(String cuit, String domicilio, String razonSocial, int telefono) {
		super();
		CUIT = cuit;
		RazonSocial = razonSocial;
	}
	
	

	
	
}

