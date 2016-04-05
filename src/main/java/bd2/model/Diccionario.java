package bd2.model;

import java.util.HashMap;
import java.util.Map;

public class Diccionario {

    protected Map<String, String> definiciones = new HashMap<String, String>();
    protected Idioma idioma;
    protected String edicion;
    private long id;

    public Diccionario(Idioma idioma, String edicion) {
        this.idioma = idioma;
        this.edicion = edicion;
    }

    public Map<String, String> getDefiniciones() {
        return this.definiciones;
    }

    public void setDefiniciones(Map<String, String> definiciones) {
        this.definiciones = definiciones;
    }

    public void agregarDefinicion(String palabra, String significado) {
        this.getDefiniciones().put(palabra, significado);
    }

    public String definicion(String palabra) {
        return this.getDefiniciones().get(palabra);
    }

    public Idioma getIdioma() {
        return this.idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public String getEdicion() {
        return this.edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
