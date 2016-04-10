package bd2.model;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author
 *
 */
public class Curso {
    protected String nombre;
    protected Idioma idioma;
    protected int nivel;
    protected Collection<Leccion> lecciones = new HashSet<Leccion>();
    private long id;



    public Curso(String nombre, Idioma idioma, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.idioma = idioma;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return this.nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Collection<Leccion> getLecciones() {
        return this.lecciones;
    }

    public void setLecciones(Collection<Leccion> lecciones) {
        this.lecciones = lecciones;
    }

    public void agregarLeccion(Leccion leccion) {
        this.lecciones.add(leccion);
    }

    public Idioma getIdioma() {
        return this.idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

}
