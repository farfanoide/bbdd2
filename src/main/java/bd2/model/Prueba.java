package bd2.model;

/**
 * The Class Prueba: Representa la prueba sobre una leccion de un curso.
 *
 * @author
 */
public class Prueba {

	/** The puntaje. */
	protected int puntaje;

	/** The leccion. */
	protected Leccion leccion;

	/**
	 * Instantiates a new prueba.
	 *
	 * @param leccion
	 *            the leccion
	 * @param puntaje
	 *            the puntaje
	 * @throws Exception
	 *             the exception
	 */
	public Prueba(Leccion leccion, Integer puntaje) throws Exception {
		this.setLeccion(leccion);
		this.setPuntaje(puntaje);
	}

	/**
	 * Instantiates a new prueba.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public Prueba() throws Exception {
		super();
	}

	/**
	 * Gets the puntaje.
	 *
	 * @return the puntaje
	 */
	public int getPuntaje() {
		return this.puntaje;
	}

	/**
	 * Sets the puntaje: Evalua si el puntaje recibido como parametro es un
	 * numero valido de puntuacion.
	 *
	 * @param puntaje
	 *            the new puntaje
	 * @throws Exception
	 *             the exception
	 */
	public void setPuntaje(int puntaje) throws Exception {
		if (puntaje < 0)
			throw new Exception("No se puede usar valores negativos como puntaje de una prueba.");
		if (puntaje > 100)
			throw new Exception("No se puede usar valores mayores a 100 como puntaje de una prueba.");
		this.puntaje = puntaje;
	}

	/**
	 * Gets the leccion.
	 *
	 * @return the leccion
	 */
	public Leccion getLeccion() {
		return this.leccion;
	}

	/**
	 * Sets the leccion.
	 *
	 * @param leccion
	 *            the new leccion
	 */
	public void setLeccion(Leccion leccion) {
		this.leccion = leccion;
	}

	/**
	 * Aprobada: Retorna True en caso de que el puntaje recibido en prueba fue
	 * mayor/igual a 60. Caso contrario False.
	 *
	 * @return the boolean
	 */
	public Boolean aprobada() {
		return this.getPuntaje() >= 60;
	}
}
