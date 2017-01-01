package centrodeportivo;

public class Grupo {
	
	/* ATRIBUTOS */
	private Integer idGrupo;
	private String dia;
	private Integer horaInicio;
	private Integer horaFin;
	private Actividad actividad;
	
	/* METODOS */
	@Override
	public String toString() {
		return dia + " " + horaInicio + " " + actividad.getSiglas() + " " + idGrupo;
	}

	/* GETTERS & SETTERS */
	public Integer getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Integer getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Integer horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Integer getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Integer horaFin) {
		this.horaFin = horaFin;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	
	/* CONSTRUCTORES */
	public Grupo(Integer idGrupo, String dia, Integer horaInicio, Integer horaFin, Actividad actividad) {
		super();
		this.idGrupo = idGrupo;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.actividad = actividad;
	}
	
	
	

}
