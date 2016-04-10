package bd2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Date;

/**
 * The Class Usuario. Representa a un usuario del sistema, el cual tiene datos
 * personales e informacion sobre sus cursadas.
 * 
 * @author
 */
public class Usuario {

	/** The email. */
	protected String email;

	/** The nombre. */
	protected String nombre;

	/** The fecha de creacion. */
	protected Date fechaDeCreacion;

	/** The traducciones. */
	protected Collection<Traduccion> traducciones = new HashSet<Traduccion>();

	/** The cursadas realizadas. */
	protected Collection<Cursada> cursadasRealizadas = new HashSet<Cursada>();

	/**
	 * Instantiates a new usuario.
	 *
	 * @param email
	 *            the email
	 * @param nombre
	 *            the nombre
	 * @param fechaDeCreacion
	 *            the fecha de creacion
	 */
	public Usuario(String email, String nombre, Date fechaDeCreacion) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.fechaDeCreacion = fechaDeCreacion;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre
	 *            the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the fecha de creacion.
	 *
	 * @return the fecha de creacion
	 */
	public Date getFechaDeCreacion() {
		return this.fechaDeCreacion;
	}

	/**
	 * Sets the fecha de creacion.
	 *
	 * @param fechaDeCreacion
	 *            the new fecha de creacion
	 */
	public void setFechaDeCreacion(Date fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}

	/**
	 * Agregar cursada.
	 *
	 * @param cursada
	 *            the cursada
	 */
	public void agregarCursada(Cursada cursada) {
		this.cursadasRealizadas.add(cursada);
	}

	/**
	 * Agregar traduccion.
	 *
	 * @param traduccion
	 *            the traduccion
	 */
	public void agregarTraduccion(Traduccion traduccion) {
		this.traducciones.add(traduccion);
	}

	/**
	 * Nivel: Retorna el nivel maximo entre las cursadas aprobadas para un
	 * idioma dado. Itera sobre las cursadas aprobadas guardando en una variable
	 * auxiliar el mayor actual
	 *
	 * @param idioma
	 *            the idioma
	 * @return the int
	 */

	public int nivel(Idioma idioma) {
		int nivel = 0;
		for (Cursada cursada : this.cursadasAprobadas(idioma))
			if (nivel < cursada.getNivel())
				nivel = cursada.getNivel();
		return nivel;
	}

	/**
	 * Cursadas aprobadas: Retorna todas las cursadas aprobadas cuyos cursos son
	 * del idioma recibido por parametro. Itera sobre todas las cursadas
	 * realizadas preguntando por cada una si finalizo y si el idioma es el
	 * mismo que el recibido como parametro, en tal caso lo agrega a una
	 * coleccion auxiliar.
	 *
	 * @param idioma
	 *            the idioma
	 * @return the collection
	 */
	public Collection<Cursada> cursadasAprobadas(Idioma idioma) {
		Collection<Cursada> aprobadas = new ArrayList<Cursada>();
		for (Cursada cursada : this.getCursadasRealizadas())
			if (cursada.finalizada() & cursada.getIdioma().equals(idioma))
				aprobadas.add(cursada);
		return aprobadas;
	}

	/**
	 * Gets the cursadas realizadas.
	 *
	 * @return the cursadas realizadas
	 */
	public Collection<Cursada> getCursadasRealizadas() {
		return this.cursadasRealizadas;
	}

	/**
	 * Gets the traducciones.
	 *
	 * @return the traducciones
	 */
	public Collection<Traduccion> getTraducciones() {
		return this.traducciones;
	}

}