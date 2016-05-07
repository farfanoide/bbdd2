package bd2.model;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class Diccionario. Esta clase representa un diccionario donde
 * guardaremos definiciones para palabras.
 *
 * @author farfanoide
 */
public class Diccionario {

    /** Las definiciones. */
    protected Map<String, String> definiciones;

    /** El idioma. */
    protected Idioma idioma;

    /** La edicion. */
    protected String edicion;

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    /**
     * Istancia un diccionario.
     *
     * @param idioma
     *            el idioma
     * @param edicion
     *            la edicion
     */
    public Diccionario(){}
    
    public Diccionario(Idioma idioma, String edicion) {
        this.idioma = idioma;
        this.edicion = edicion;
        this.definiciones = new HashMap<String, String>();
    }

    /**
     * Devuelve las definiciones.
     *
     * @return las definiciones
     */
    public Map<String, String> getDefiniciones() {
        return this.definiciones;
    }

    /**
     * Setea las definiciones.
     *
     * @param definiciones
     *            las definiciones
     */
    public void setDefiniciones(Map<String, String> definiciones) {
        this.definiciones = definiciones;
    }

    /**
     * Agregar definicion.
     *
     * @param palabra
     *            la palabra
     * @param significado
     *            el significado
     */
    public void agregarDefinicion(String palabra, String significado) {
        this.getDefiniciones().put(palabra, significado);
    }

    /**
     * Definicion.
     *
     * @param palabra
     *            la palabra
     * @return la palabra
     */
    public String definicion(String palabra) {
        return this.getDefiniciones().get(palabra);
    }

    /**
     * Devuelve las idioma.
     *
     * @return el idioma
     */
    public Idioma getIdioma() {
        return this.idioma;
    }

    /**
     * Setea las idioma.
     *
     * @param idioma
     *            el nuevo idioma
     */
    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    /**
     * Devuelve la edicion.
     *
     * @return la edicion
     */
    public String getEdicion() {
        return this.edicion;
    }

    /**
     * Setea las edicion.
     *
     * @param edicion
     *            la nueva edicion
     */
    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

}
