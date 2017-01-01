package centrodeportivo;

import java.util.Calendar;
import java.util.TreeMap;

public class Monitor extends Persona{
	
	/* ATRIBUTOS */
	private String actividadEspecialista;
	private Integer maxHoras;
	private String[] arrayActividadesImpartidas;
	private TreeMap<Integer, Actividad> actividadesImpartidas;
	private TreeMap<Integer, Actividad> acividadesCoordinadas;

	
	
	/* METODOS */
	@Override
	public String toString() {
		return super.toString() + " " + this.actividadEspecialista + " " + this.maxHoras;
	}


	/* GETTERS & SETTERS */
	public String getActividadEspecialista() {
		return actividadEspecialista;
	}


	public void setActividadEspecialista(String actividadEspecialista) {
		this.actividadEspecialista = actividadEspecialista;
	}


	public Integer getMaxHoras() {
		return maxHoras;
	}


	public void setMaxHoras(Integer maxHoras) {
		this.maxHoras = maxHoras;
	}


	public String[] getArrayActividadesImpartidas() {
		return arrayActividadesImpartidas;
	}


	public void setArrayActividadesImpartidas(String[] arrayActividadesImpartidas) {
		this.arrayActividadesImpartidas = arrayActividadesImpartidas;
	}


	public TreeMap<Integer, Actividad> getActividadesImpartidas() {
		return actividadesImpartidas;
	}


	public void setActividadesImpartidas(TreeMap<Integer, Actividad> actividadesImpartidas) {
		this.actividadesImpartidas = actividadesImpartidas;
	}


	public TreeMap<Integer, Actividad> getAcividadesCoordinadas() {
		return acividadesCoordinadas;
	}


	public void setAcividadesCoordinadas(TreeMap<Integer, Actividad> acividadesCoordinadas) {
		this.acividadesCoordinadas = acividadesCoordinadas;
	}


	/* CONSTRUSCTORES */
	public Monitor(String nombre, String apellidos, Integer id, String perfil, Calendar fechaNacimiento, Integer maxHoras) {
		super(nombre, apellidos, id, perfil, fechaNacimiento);
		this.maxHoras = maxHoras;
	}


	public Monitor(String nombre, String apellidos, Integer id, String perfil, Calendar fechaNacimiento,
			String actividadEspecialista, Integer maxHoras, String[] arrayActividadesImpartidas,
			TreeMap<Integer, Actividad> actividadesImpartidas, TreeMap<Integer, Actividad> acividadesCoordinadas) {
		super(nombre, apellidos, id, perfil, fechaNacimiento);
		this.actividadEspecialista = actividadEspecialista;
		this.maxHoras = maxHoras;
		this.arrayActividadesImpartidas = arrayActividadesImpartidas;
		this.actividadesImpartidas = actividadesImpartidas;
		this.acividadesCoordinadas = acividadesCoordinadas;
	}
	

}
