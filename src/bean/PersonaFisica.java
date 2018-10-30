package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PersonasFisicas")
public class PersonaFisica extends Cliente {
	@Id 
	@Column (name = "DNI")
	private String dni;
	@Column (name = "NombreApellido", nullable = false, length = 50)
	private String nombre;
	
	
	public PersonaFisica(String dni, String domicilio, String nombre, int telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}
	
	
}
