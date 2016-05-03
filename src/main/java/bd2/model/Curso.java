package bd2.model;

import java.util.Collection;
import java.util.HashSet;

	
/**
 * The Class Curso: Representa cursos del sitio.
 *
 * @author 
 */
public class Curso {
    
    /** The nombre. */
    protected String nombre;
    
    /** The idioma. */
    protected Idioma idioma;
    
    /** The nivel. */
    protected int nivel;
    
    /** The lecciones. */
    protected Collection<Leccion> lecciones = new HashSet<Leccion>();
    
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    /**
     * Instantiates a new curso.
     *
     * @param nombre the nombre
     * @param idioma the idioma
     * @param nivel the nivel
     */
    public Curso(String nombre, Idioma idioma, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.idioma = idioma;
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
     * @param nombre the new nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the nivel.
     *
     * @return the nivel
     */
    public int getNivel() {
        return this.nivel;
    }

    /**
     * Sets the nivel.
     *
     * @param nivel the new nivel
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Gets the lecciones.
     *
     * @return the lecciones
     */
    public Collection<Leccion> getLecciones() {
        return this.lecciones;
    }


    /**
     * Agregar leccion.
     *
     * @param leccion the leccion
     */
    public void agregarLeccion(Leccion leccion) {
        this.lecciones.add(leccion);
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
     * @param idioma the new idioma
     */
    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

}
