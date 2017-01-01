package centrodeportivo;

import java.util.Calendar;
import java.util.TreeMap;

public class Usuario extends Persona {

	/* ATRIBUTOS */
	private float saldo;
	private Calendar fechaAlta;
	private String[] arrayActividadesPrevias;
	private String[] arrayActividadesActuales;
	private TreeMap<Integer, Actividad> actividadesActuales;
	private TreeMap<Integer, Actividad> actividadesPrevias;
	
	
	/* METODOS */
	@Override
	public String toString(){
		return super.toString() + " " + this.fechaAlta.get(Calendar.DATE) + "/" + this.fechaAlta.get(Calendar.MONTH) + "/" + this.fechaAlta.get(Calendar.YEAR) 
			+ " " + this.saldo;
	}

	
	/* GETTERS & SETTERS */
	public float getSaldo() {
		return saldo;
	}


	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}


	public Calendar getFechaAlta() {
		return fechaAlta;
	}


	public void setFechaAlta(Calendar fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	public String[] getArrayActividadesPrevias() {
		return arrayActividadesPrevias;
	}


	public void setArrayActividadesPrevias(String[] arrayActividadesPrevias) {
		this.arrayActividadesPrevias = arrayActividadesPrevias;
	}


	public String[] getArrayActividadesActuales() {
		return arrayActividadesActuales;
	}


	public void setArrayActividadesActuales(String[] arrayActividadesActuales) {
		this.arrayActividadesActuales = arrayActividadesActuales;
	}


	public TreeMap<Integer, Actividad> getActividadesActuales() {
		return actividadesActuales;
	}


	public void setActividadesActuales(TreeMap<Integer, Actividad> actividadesActuales) {
		this.actividadesActuales = actividadesActuales;
	}


	public TreeMap<Integer, Actividad> getActividadesPrevias() {
		return actividadesPrevias;
	}


	public void setActividadesPrevias(TreeMap<Integer, Actividad> actividadesPrevias) {
		this.actividadesPrevias = actividadesPrevias;
	}



	/* CONSTRUCTORES */
	public Usuario(String nombre, String apellidos, Integer id, String perfil, Calendar fechaNacimiento,
			float saldo, Calendar fechaAlta) {
		super(nombre, apellidos, id, perfil, fechaNacimiento);
		this.saldo = saldo;
		this.fechaAlta = fechaAlta;
	}


	public Usuario(String nombre, String apellidos, Integer id, String perfil, Calendar fechaNacimiento, float saldo,
			Calendar fechaAlta, String[] arrayActividadesPrevias, String[] arrayActividadesActuales,
			TreeMap<Integer, Actividad> actividadesActuales, TreeMap<Integer, Actividad> actividadesPrevias) {
		super(nombre, apellidos, id, perfil, fechaNacimiento);
		this.saldo = saldo;
		this.fechaAlta = fechaAlta;
		this.arrayActividadesPrevias = arrayActividadesPrevias;
		this.arrayActividadesActuales = arrayActividadesActuales;
		this.actividadesActuales = actividadesActuales;
		this.actividadesPrevias = actividadesPrevias;
	}


	
}
