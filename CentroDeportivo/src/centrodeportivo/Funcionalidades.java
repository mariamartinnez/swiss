package centrodeportivo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TreeMap;

public class Funcionalidades {
	
	public TreeMap<Integer, Usuario> usuarios = new TreeMap<Integer, Usuario>();
	public TreeMap<Integer, Monitor> monitores = new TreeMap<Integer, Monitor>();
	public TreeMap<Integer, Actividad> actividades = new TreeMap<Integer, Actividad>();
	private int contador = 0;

	public void insertarPersona(String linea, TreeMap<Integer, Monitor> monitores, TreeMap<Integer, Usuario> usuarios) {
		
		contador++;
		Integer id = contador;
		String[] lineaDesplegadaComillas = linea.trim().split("\"");
		String[] lineaDesplegadaComillasAux = lineaDesplegadaComillas[0].trim().split("\\s*");
		String perfil = lineaDesplegadaComillasAux[2].trim();
		String nombre = lineaDesplegadaComillas[1].trim();
		String apellidos = lineaDesplegadaComillas[2].trim();
		
		String lineaAux = lineaDesplegadaComillas[3].trim();
		String[] lineaAuxDesplegadaEspacios = lineaAux.split("\\s*");
		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		Calendar fechaNacimiento = Calendar.getInstance();
		try {
			fechaNacimiento.setTime(formatoFecha.parse(lineaAuxDesplegadaEspacios[0]));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if (perfil.compareTo("usuario") == 0) {
			Calendar fechaAlta = Calendar.getInstance();
			try {
				fechaAlta.setTime(formatoFecha.parse(lineaAuxDesplegadaEspacios[1]));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Float saldo = Float.parseFloat(lineaAuxDesplegadaEspacios[2]);
			Usuario usuario = new Usuario(nombre, apellidos, id, perfil, fechaNacimiento, saldo, fechaAlta);
			usuarios.put(id, usuario);
			
		}
		
		if(perfil.compareTo("monitor") == 0) {
			Integer maxHoras = Integer.parseInt(lineaAuxDesplegadaEspacios[1]);
			Monitor monitor = new Monitor(nombre, apellidos, id, perfil, fechaNacimiento, maxHoras);
			monitores.put(id, monitor);
		}

	}
	
	public void asignarMonitorGrupo ( String linea, TreeMap<Integer, Monitor> monitores, TreeMap<Integer, Actividad> actividades) {
		
		String[] datos = linea.trim().split("\\s*");
		Integer idMonitor = Integer.parseInt(datos[2]);
		Integer idActividad = Integer.parseInt(datos[3]);
		Integer idGrupo = Integer.parseInt(datos[4]);
	
		/* FALTAN LAS COMPROBACIONES DE ERRORES */
		
		Grupo grupo = actividades.get(idActividad).getGrupos().get(idGrupo);
		monitores.get(idMonitor).getActividadesImpartidas().get(idActividad).getGrupos().put(idGrupo, grupo);
	}
	
	public void alta(String linea, TreeMap<Integer, Usuario> usuarios, TreeMap<Integer, Actividad> actividades) {
		
		String[] datos = linea.trim().split("//s*");
		Integer idUsuario = Integer.parseInt(datos[2]);
		Integer idActividad = Integer.parseInt(datos[3]);
		
		/* FALTAN LAS COMPROBACIONES DE ERRORES */
		
		Actividad actividad = actividades.get(idActividad);
		usuarios.get(idUsuario).getActividadesActuales().put(idActividad, actividad);
	}
	
	public void asignaGrupo (String linea, TreeMap<Integer, Actividad> actividades, TreeMap<Integer, Usuario> usuarios) {
		
		String[] datos = linea.trim().split("//s*");
		Integer idUsuario = Integer.parseInt(datos[2]);
		Integer idActividad = Integer.parseInt(datos[3]);
		Integer idGrupo = Integer.parseInt(datos[4]);
		
		/* FALTAN LAS COMPROBACIONES DE ERRORES */
		
		Grupo grupo = actividades.get(idActividad).getGrupos().get(idGrupo);
		usuarios.get(idUsuario).getActividadesActuales().get(idActividad).getGrupos().put(idGrupo, grupo);	
	}
	
	public void cobrar (String linea, TreeMap<Integer, Actividad> actividades, TreeMap<Integer, Usuario> usuarios) {
		
		String[] datos = linea.trim().split("//s*");
		Integer idUsuario = Integer.parseInt(datos[2]);
		
	}
	
}
	
