package centrodeportivo;

import java.util.TreeMap;

public class Actividad {
	
	/* ATRIBUTOS */
	private Integer idActividad;
	private String nombre;
	private String siglas;
	private Monitor coordinador;
	private String[] arrayPrerrequisitos;
	private Integer duracion;
	private Float coste;
	private TreeMap<Integer, Grupo> grupos;
	private TreeMap<Integer, Actividad> prerrequisitos;
	
	/* METODOS */
	@Override
	public String toString() {
		return idActividad + " " + nombre + " " + siglas + " " + duracion + " " + coste;
	}

	/* GETTERS & SETTERS */
	public Integer getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public Monitor getCoordinador() {
		return coordinador;
	}

	public void setCoordinador(Monitor coordinador) {
		this.coordinador = coordinador;
	}

	public String[] getArrayPrerrequisitos() {
		return arrayPrerrequisitos;
	}

	public void setArrayPrerrequisitos(String[] arrayPrerrequisitos) {
		this.arrayPrerrequisitos = arrayPrerrequisitos;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Float getCoste() {
		return coste;
	}

	public void setCoste(Float coste) {
		this.coste = coste;
	}

	public TreeMap<Integer, Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(TreeMap<Integer, Grupo> grupos) {
		this.grupos = grupos;
	}

	public TreeMap<Integer, Actividad> getPrerrequisitos() {
		return prerrequisitos;
	}

	public void setPrerrequisitos(TreeMap<Integer, Actividad> prerrequisitos) {
		this.prerrequisitos = prerrequisitos;
	}

	/* CONSTRUCTORES */
	public Actividad(Integer idActividad, String nombre, String siglas, Monitor coordinador,
			String[] arrayPrerrequisitos, Integer duracion, Float coste, TreeMap<Integer, Grupo> grupos,
			TreeMap<Integer, Actividad> prerrequisitos) {
		super();
		this.idActividad = idActividad;
		this.nombre = nombre;
		this.siglas = siglas;
		this.coordinador = coordinador;
		this.arrayPrerrequisitos = arrayPrerrequisitos;
		this.duracion = duracion;
		this.coste = coste;
		this.grupos = grupos;
		this.prerrequisitos = prerrequisitos;
	}

	

}
