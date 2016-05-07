package bd2.model;

import java.util.Date;

/**
 * The Class Traduccion. representa una traduccion realizada por un usuario.
 *
 * @author farfanoide
 */
public class Traduccion extends Tarea {

    /** The texto. */
    protected String texto;

    /** The parrafo. */
    protected Parrafo parrafo;

    /** The idioma. */
    protected Idioma idioma;

    /**
     * Instantiates a new traduccion.
     *
     * @param fecha
     *            the fecha
     * @param descripcion
     *            the descripcion
     * @param completa
     *            the completa
     * @param texto
     *            the texto
     * @param parrafo
     *            the parrafo
     * @param idioma
     *            the idioma
     */
    public Traduccion(){}
    
    public Traduccion(Date fecha, String descripcion, Boolean completa, String texto, Parrafo parrafo, Idioma idioma) {
        super(fecha, descripcion, completa);
        this.texto = texto;
        this.idioma = idioma;
        this.parrafo = parrafo;
    }

    /**
     * Gets the texto.
     *
     * @return the texto
     */
    public String getTexto() {
        return this.texto;
    }

    /**
     * Sets the texto.
     *
     * @param texto
     *            the new texto
     */
    public void setTexto(String texto) {
        this.texto = texto;
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
     * Gets the idioma original.
     *
     * @return the idioma original
     */
    public Idioma getIdiomaOriginal() {
        return this.getParrafo().getDocumento().getIdioma();
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
     * Gets the parrafo.
     *
     * @return the parrafo
     */
    public Parrafo getParrafo() {
        return this.parrafo;
    }

    /**
     * Sets the parrafo.
     *
     * @param parrafo
     *            the new parrafo
     */
    public void setParrafo(Parrafo parrafo) {
        this.parrafo = parrafo;
    }

}
