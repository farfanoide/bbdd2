package bd2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * The Class Cursada: Representa las cursadas de un usuario sobre un curso del
 * sitio.
 *
 * @author
 */

public class Cursada {

	/** The curso. */
	protected Curso curso;

	/** The inicio. */
	protected Date inicio;

	/** The usuario. */
	protected Usuario usuario;

	/** The pruebas. */
	protected Collection<Prueba> pruebas = new HashSet<Prueba>();

	private long id;

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cursada() {}
    /**
	 * Instantiates a new cursada.
	 *
	 * @param curso
	 *            the curso
	 * @param inicio
	 *            the inicio
	 * @param usuario
	 *            the usuario
	 */
	public Cursada(Curso curso, Date inicio, Usuario usuario) {
		this.curso = curso;
		this.inicio = inicio;
		this.usuario = usuario;
		usuario.agregarCursada(this);
	}

	/**
	 * Gets the curso.
	 *
	 * @return the curso
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * Sets the curso.
	 *
	 * @param curso
	 *            the new curso
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	/**
	 * Gets the inicio.
	 *
	 * @return the inicio
	 */
	public Date getInicio() {
		return inicio;
	}

	/**
	 * Gets the idioma.
	 *
	 * @return the idioma
	 */
	public Idioma getIdioma() {
		return this.getCurso().getIdioma();
	}

	/**
	 * Gets the nivel.
	 *
	 * @return the nivel
	 */
	public int getNivel() {
		return this.getCurso().getNivel();
	}

	/**
	 * Sets the inicio.
	 *
	 * @param inicio
	 *            the new inicio
	 */
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	/**
	 * Agregar prueba.
	 *
	 * @param prueba
	 *            the prueba
	 */
	public void agregarPrueba(Prueba prueba) {
		this.pruebas.add(prueba);
	}

	/**
	 * Gets the pruebas.
	 *
	 * @return the pruebas
	 */
	public Collection<Prueba> getPruebas() {
		return pruebas;
	}

	public void setPruebas(Collection<Prueba> pruebas) {
        this.pruebas = pruebas;
	}

	/**
	 * Finalizada: Itera sobre todas las lecciones del curso evaluando una por
	 * una si se encuentra en la coleccion de las lecciones aprobadas de la
	 * cursada.
	 *
	 * @return the boolean
	 */
	public Boolean finalizada() {
		Collection<Leccion> aprobadas = this.leccionesAprobadas();
		Collection<Leccion> esperadas = this.getCurso().getLecciones();
		for (Leccion esperada : esperadas)
			if (!aprobadas.contains(esperada))
				return false;
		return true;
	}

	/**
	 * Lecciones aprobadas: Itera sobre todas las pruebas de la cursada,
	 * agregando a un arreglo auxiliar las pruebas aprobadas.
	 *
	 * @return the collection
	 */
	public Collection<Leccion> leccionesAprobadas() {
		Collection<Leccion> aprobadas = new ArrayList<Leccion>();
		for (Prueba prueba : this.getPruebas())
			if (prueba.aprobada())
				aprobadas.add(prueba.getLeccion());
		return aprobadas;
	}

	/**
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * Sets the usuario.
	 *
	 * @param usuario
	 *            the new usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
