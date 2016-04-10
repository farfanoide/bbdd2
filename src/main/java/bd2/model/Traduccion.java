package bd2.model;

import java.util.Date;

/**
 * @author
 */
public class Traduccion extends Tarea {


    protected String texto;
    protected Parrafo parrafo;
    protected Idioma idioma;

    public Traduccion(Date fecha, String descripcion, Boolean completa, String texto, Parrafo parrafo, Idioma idioma) {
        super(fecha, descripcion, completa);
        this.texto = texto;
        this.idioma = idioma;
        this.parrafo = parrafo;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Idioma getIdioma() {
        return this.idioma;
    }

    public Idioma getIdiomaOriginal() {
        return this.getParrafo().getDocumento().getIdioma();
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Parrafo getParrafo() {
        return this.parrafo;
    }

    public void setParrafo(Parrafo parrafo) {
        this.parrafo = parrafo;
    }

}
