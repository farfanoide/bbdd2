package bd2.model;

import java.util.Date;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;

/**
 * The Class Moderador. Representa a los moderadores del sistema que se encargan
 * de calificar traducciones de los usuarios.
 */
public class Moderador extends Usuario {

	/** The evaluaciones. */
	protected Collection<Evaluacion> evaluaciones = new HashSet<Evaluacion>();

	/** The idiomas. */
	protected Collection<Idioma> idiomas = new HashSet<Idioma>();

	/**
	 * Instantiates a new moderador.
	 *
	 * @param email
	 *            the email
	 * @param nombre
	 *            the nombre
	 * @param fechaDeCreacion
	 *            the fecha de creacion
	 */
	public Moderador() {}
	
	public Moderador(String email, String nombre, Date fechaDeCreacion) {
		super(email, nombre, fechaDeCreacion);
	}

	/**
	 * Reputacion: Calcula la cantidad de evaluaciones realizadas.
	 *
	 * @return the int
	 */
	public int reputacion() {
		return this.getEvaluaciones().size();
	}

	/**
	 * Gets the evaluaciones.
	 *
	 * @return the evaluaciones
	 */
	public Collection<Evaluacion> getEvaluaciones() {
		return this.evaluaciones;
	}

	public void setEvaluaciones(Collection<Evaluacion> evaluaciones){
		this.evaluaciones = evaluaciones;
	}
	/**
	 * Agregar evaluacion.
	 *
	 * @param evaluacion
	 *            the evaluacion
	 */
	public void agregarEvaluacion(Evaluacion evaluacion) {
		this.getEvaluaciones().add(evaluacion);
	}

	/**
	 * Gets the idiomas.
	 *
	 * @return the idiomas
	 */
	public Collection<Idioma> getIdiomas() {
		return this.idiomas;
	}

	public void setIdiomas(Collection<Idioma> idiomas){
		this.idiomas = idiomas;
	}

	/**
	 * Maneja idioma: Se fija si tiene al idioma recibido como parametro entre
	 * los idiomas que maneja.
	 *
	 * @param idioma
	 *            the idioma
	 * @return true, if successful
	 */
	public boolean manejaIdioma(Idioma idioma) {
		return this.getIdiomas().contains(idioma);
	}

	/**
	 * Agregar idioma.
	 *
	 * @param idioma
	 *            the idioma
	 */
	public void agregarIdioma(Idioma idioma) {
		this.getIdiomas().add(idioma);
	}

	/**
	 * Evaluar: Se fija si la instancia del moderador es capaz de corregir la
	 * traduccion pasada como parametro, en tal caso crea una evaluacion con los
	 * datos recibidos y la agrega a su coleccion de evaluaciones corregidas.
	 * Caso contrario levanta una excepcion avisando que no puede corregir esa
	 * traduccion.
	 *
	 * @param traduccion
	 *            the traduccion
	 * @param descripcion
	 *            the descripcion
	 * @param puntaje
	 *            the puntaje
	 * @throws Exception
	 *             the exception
	 */
	public void evaluar(Traduccion traduccion, String descripcion, int puntaje) throws Exception {
		Calendar cal = Calendar.getInstance();
		if (this.manejaIdioma(traduccion.getIdioma()) & this.manejaIdioma(traduccion.getIdiomaOriginal())) {
			Evaluacion evaluacion = new Evaluacion(cal.getTime(), descripcion, true, traduccion, puntaje);
			this.getEvaluaciones().add(evaluacion);
		} else
			throw new Exception("No se pueden evaluar traducciones de idiomas que el moderador no maneja.");
	}

}
