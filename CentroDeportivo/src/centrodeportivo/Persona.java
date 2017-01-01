package centrodeportivo;

import java.util.Calendar;

public abstract class Persona {
	
	/* ATRIBUTOS */
	private String nombre;
	private String apellidos;
	private Integer id;
	private String perfil;
	private Calendar fechaNacimiento;
	
	
	/* METODOS */
	@Override
	public String toString(){
		return this.id + " " + this.nombre + " " + this.apellidos + " " + this.fechaNacimiento.get(Calendar.DATE) + "/" +
				this.fechaNacimiento.get(Calendar.MONTH) + "/" + this.fechaNacimiento.get(Calendar.YEAR);
	}
	

	/* GETTERS & SETTERS */
	
	public String getNombre() {
		return nombre;
	}

	public String getPerfil() {
		return perfil;
	}


	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	/* CONSTRUCTORES */
	public Persona(String nombre, String apellidos, Integer id, String perfil, Calendar fechaNacimiento) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.id = id;
		this.perfil = perfil;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
	
	
	
	
	

}
