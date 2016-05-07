package bd2.model;

import java.util.Collection;
import java.util.HashSet;

/**
 * The Class Documento. representa un documento en el sistema el cual esta
 * compuesto por una coleccion de `Parrafos` y un `Idioma`
 *
 * @author farfanoide
 *
 */
public class Documento {

    /** The idioma. */
    protected Idioma idioma;

    /** The parrafos. */
    protected Collection<Parrafo> parrafos = new HashSet<Parrafo>();

    /** The nombre. */
    protected String nombre;

    /** The complejidad. */
    protected Integer complejidad;

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Instantiates a new documento.
     */
    public Documento(){}

    /**
     * Instantiates a new documento.
     *
     * @param nombre
     *            the nombre
     * @param idioma
     *            the idioma
     */


    public Documento(String nombre, Idioma idioma) {
        this.nombre = nombre;
        this.idioma = idioma;
    }

    /**
     * Instantiates a new documento.
     *
     * @param nombre
     *            the nombre
     * @param idioma
     *            the idioma
     * @param complejidad
     *            the complejidad
     */
    public Documento(String nombre, Idioma idioma, Integer complejidad) {
        this.nombre = nombre;
        this.idioma = idioma;
        this.complejidad = complejidad;
    }

    /**
     * Gets the idioma.
     *
     * @return the idioma
     */
    public Idioma getIdioma() {
        return this.idioma;
    }

    /**
     * Sets the idioma.
     *
     * @param idioma
     *            the new idioma
     */
    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    /**
     * Gets the complejidad.
     *
     * @return the complejidad
     */
    public Integer getComplejidad() {
        return this.complejidad;
    }

    /**
     * Sets the complejidad.
     *
     * @param complejidad
     *            the new complejidad
     */
    public void setComplejidad(Integer complejidad) {
        this.complejidad = complejidad;
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
     * Agregar parrafo.
     *
     * @param texto
     *            the texto
     * @return the parrafo
     */
    public Parrafo agregarParrafo(String texto) {
        Parrafo parrafo = new Parrafo(texto, this);
        this.parrafos.add(parrafo);
        return parrafo;
    }

    /**
     * Gets the parrafos.
     *
     * @return the parrafos
     */
    public Collection<Parrafo> getParrafos() {
        return this.parrafos;
    }

    public void setParrafos(Collection<Parrafo> parrafos) {
        this.parrafos = parrafos;
	}
}
