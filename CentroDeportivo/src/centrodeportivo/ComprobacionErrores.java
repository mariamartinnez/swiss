package centrodeportivo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class ComprobacionErrores {

	public static boolean validarFecha(Calendar fechaNacimiento) {

		Calendar fechaMinima = new GregorianCalendar(1950, 0, 1);
		Calendar fechaMaxima = new GregorianCalendar(2020, 0, 1);

		/*
		 * Al desactivar el modo lenient, si la fecha no es correcta salta una
		 * excepcion
		 */

		fechaNacimiento.setLenient(false);
		try {
			fechaNacimiento.getTime();
		} catch (IllegalArgumentException excepcion) {
			System.out.println("ERROR: fecha introducida incorrecta");
			return true;
		}
		if (fechaNacimiento.before(fechaMinima) || fechaNacimiento.after(fechaMaxima))
			return true;
		else
			return false;
	}

	public static boolean validarFechaIngreso(Calendar fechaNacimiento, Calendar fechaAlta) {

		int anho1 = fechaNacimiento.get(GregorianCalendar.YEAR);
		int anho2 = fechaAlta.get(GregorianCalendar.YEAR);
		double n_years = 0.0;
		while (anho1 < anho2) {
			n_years++;
			anho1++;
		}
		int dianho1 = fechaNacimiento.get(Calendar.DAY_OF_YEAR);
		int dianho2 = fechaAlta.get(Calendar.DAY_OF_YEAR);
		/* Compruebo si el año es bisiesto y si me afecta que lo sea */
		if (((GregorianCalendar) fechaAlta).isLeapYear(fechaAlta.get(Calendar.YEAR))) {
			if (fechaAlta.get(Calendar.DAY_OF_YEAR) > 60) {
				fechaAlta.add(Calendar.DAY_OF_YEAR, -1);
				dianho2 = fechaAlta.get(Calendar.DAY_OF_YEAR);
			}
		}
		double dif_dias = dianho2 - dianho1;
		if (dif_dias < 0) {
			n_years--;
			dif_dias += 365;
		}
		n_years += dif_dias / 365;
		if (((GregorianCalendar) fechaAlta).isLeapYear(fechaAlta.get(Calendar.YEAR))) {
			if (fechaAlta.get(Calendar.DAY_OF_YEAR) > 60) {
				fechaAlta.add(Calendar.DAY_OF_YEAR, 1);
				dianho2 = fechaAlta.get(Calendar.DAY_OF_YEAR);
			}
		}
		if (n_years < 5 || n_years > 80) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean validarSaldo(float saldo) {

		if (saldo < 0) {
			return false;
		} else {
			return true;
		}

	}

	public static boolean validarMaxHorasMonitor(float maxHoras) {

		if (maxHoras > 20 || maxHoras < 0) {
			return false;
		} else {
			return true;
		}
	}

	public void guardarError(Integer nLinea, String abreviatura, String texto) {

		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("avisos.txt", true);
			pw = new PrintWriter(fichero);
			pw.println(nLinea + " -- " + abreviatura + " -- " + texto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}


	/* Comprueba si un usuario está repetido */
	public Boolean compruebaUsuarioRepetido(TreeMap<Integer, Usuario> usuarios, String nombre, String apellidos) {

		if (usuarios.containsValue(nombre) && usuarios.containsValue(apellidos))
			return true;
		else
			return false;
	}

	/* Comprueba si un monitor está repetido */
	public Boolean compruebaMonitorRepetido(TreeMap<Integer, Monitor> monitores, String nombre, String apellidos) {

		if (monitores.containsValue(nombre) && monitores.containsValue(apellidos))
			return true;
		else
			return false;
	}

	/* Comprueba si la actividad requerida está registrada */
	public Boolean existeActividad(TreeMap<Integer, Actividad> actividades, Integer idActividad) {
		
		Set<Integer> setActividades = actividades.keySet();
		Iterator<Integer> it = setActividades.iterator();
		Boolean flag = false;
		while (it.hasNext())
			if (actividades.get(it.next()).getIdActividad().equals(idActividad))
				flag = true;
		if (flag)
			return true;
		else
			return false;
	}

	/* Comprueba si el monitor requerido está registrado */
	public Boolean existeMonitor(TreeMap<Integer, Monitor> monitores, Integer idMonitor) {
		
		Set<Integer> setMonitores = monitores.keySet();
		Iterator<Integer> it = setMonitores.iterator();
		Boolean flag = false;
		while (it.hasNext())
			if (monitores.get(it.next()).getId().equals(idMonitor));
				flag = true;
			if (flag)
				return true;
			else 
				return false;
	}
	
	/* Comprueba si el grupo requerido está registrado */
	public Boolean existeGrupo(TreeMap<Integer, Actividad> actividades, Integer idGrupo, Integer idActividad) {
		
		if (!actividades.get(idActividad).getGrupos().containsKey(idGrupo))
			return false;
		else 
			return true;
	}
	
	/* Comprueba si añadiéndole horas de clase a un monitor estamos superando sus horas asignables maximas */
	public Boolean horasAsignablesSuperanMaximo(Integer idMonitor, Integer idActividad, Integer idGrupo, 
			TreeMap<Integer, Monitor> monitores, TreeMap<Integer, Actividad> actividades){
		
		Integer maxHorasAsignables = monitores.get(idMonitor).getMaxHoras();
	    Set<Integer> setActividadesImpartidas = monitores.get(idMonitor).getActividadesImpartidas().keySet();
		Iterator<Integer> it = setActividadesImpartidas.iterator();
		Integer horasAsignadas = 0;
		if (!setActividadesImpartidas.isEmpty()) {
			while (it.hasNext()) {
				Actividad actividadImpartida = monitores.get(idMonitor).getActividadesImpartidas().get(it.next());
				Integer duracion = actividadImpartida.getDuracion();
				Integer nGrupos = actividadImpartida.getGrupos().size(); /* DUDA: ¿de esta forma accedemos a todos los grupos de la actividad o solamente a los grupos de dicha actividad que imparte el monitor? */
				horasAsignadas = horasAsignadas + (duracion*nGrupos);
			}
		}
		
		Integer duracionGrupo = 0;
		Grupo grupo = actividades.get(idActividad).getGrupos().get(idGrupo);
		duracionGrupo = grupo.getHoraFin() - grupo.getHoraInicio();
		if (duracionGrupo + horasAsignadas > maxHorasAsignables) 
			return true;
		else
			return false;
		
	}
	
	/* Comprueba si el monitor tiene alguna otra clase en el horario del nuevo grupo que le queremos asignar */
	public Boolean generaSolape(Integer idMonitor, Integer idActividad, Integer idGrupo, TreeMap<Integer, Monitor> monitores,
			TreeMap<Integer, Actividad> actividades) {
		
		Grupo grupo = actividades.get(idActividad).getGrupos().get(idGrupo);
		Integer horaInicio = grupo.getHoraInicio();
		Integer horaFin = grupo.getHoraFin();
		String dia = grupo.getDia();
		Set<Integer> setActividadesImpartidas = monitores.get(idMonitor).getActividadesImpartidas().keySet();
		Set<Integer> setGruposImpartidos = monitores.get(idMonitor).getActividadesImpartidas().get(idActividad).getGrupos().keySet();
		Iterator<Integer> it = setActividadesImpartidas.iterator();
		Iterator<Integer> it1 = setGruposImpartidos.iterator();
		if (!setActividadesImpartidas.isEmpty()) {
			while (it.hasNext()){
			Actividad actividad = monitores.get(idMonitor).getActividadesImpartidas().get(it.next());
			Integer idActividadIt = actividad.getIdActividad();
			if (!setGruposImpartidos.isEmpty()) {
				while(it1.hasNext()) {
					Grupo grupoIt = monitores.get(idMonitor).getActividadesImpartidas().get(idActividadIt).getGrupos().get(it1.next());
					if (grupoIt.getDia().contentEquals(dia)) {
						if(!((horaInicio < grupoIt.getHoraInicio() && horaFin <= grupoIt.getHoraInicio()) || 
								(horaInicio >= grupoIt.getHoraFin() && horaFin > grupoIt.getHoraFin()))) 
							return true;
					}
				}
			}
			}
		}
		return false;
	}
	
	/*  Comprueba si el grupo al que se quiere matricular a este usuario se solapa con algun grupo al que ya este asistiendo */
	public Boolean generaSolapeUsuarios(Integer idUsuario, Integer idActividad, Integer idGrupo, TreeMap<Integer, Actividad> actividades,
			TreeMap<Integer, Usuario> usuarios) {
		
		Grupo grupo = actividades.get(idActividad).getGrupos().get(idGrupo);
		Integer horaInicio = grupo.getHoraInicio();
		Integer horaFin = grupo.getHoraFin();
		String dia = grupo.getDia();
		Set<Integer> setActividadesActuales = usuarios.get(idUsuario).getActividadesActuales().keySet();
		Set<Integer> setGruposActuales = usuarios.get(idUsuario).getActividadesActuales().get(idActividad).getGrupos().keySet();
		Iterator<Integer> it = setActividadesActuales.iterator();
		Iterator<Integer> it1 = setGruposActuales.iterator();
		if (!setActividadesActuales.isEmpty()) {
			while (it.hasNext()){
			Actividad actividad = usuarios.get(idUsuario).getActividadesActuales().get(it.next());
			Integer idActividadIt = actividad.getIdActividad();
			if (!setGruposActuales.isEmpty()) {
				while(it1.hasNext()) {
					Grupo grupoIt = usuarios.get(idUsuario).getActividadesActuales().get(idActividadIt).getGrupos().get(it1.next());
					if (grupoIt.getDia().contentEquals(dia)) {
						if(!((horaInicio < grupoIt.getHoraInicio() && horaFin <= grupoIt.getHoraInicio()) || 
								(horaInicio >= grupoIt.getHoraFin() && horaFin > grupoIt.getHoraFin()))) 
							return true;
					}
				}
			}
			}
		}
		return false;
		
	}
	
}
