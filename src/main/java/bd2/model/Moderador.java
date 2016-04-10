package bd2.model;

import java.util.Date;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 */
public class Moderador extends Usuario {

    protected Collection<Evaluacion> evaluaciones = new HashSet<Evaluacion>();
    protected Collection<Idioma> idiomas = new HashSet<Idioma>();

    public Moderador(String email, String nombre, Date fechaDeCreacion) {
        super(email, nombre, fechaDeCreacion);
    }

    public int reputacion() {
        return this.getEvaluaciones().size();
    }

    public Collection<Evaluacion> getEvaluaciones() {
        return this.evaluaciones;
    }

    public void setEvaluaciones(Collection<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public Collection<Idioma> getIdiomas() {
        return this.idiomas;
    }

    public void setIdiomas(Collection<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    public boolean manejaIdioma(Idioma idioma) {
        return this.getIdiomas().contains(idioma);
    }

    public void agregarIdioma(Idioma idioma) {
        this.getIdiomas().add(idioma);
    }

    public void evaluar(Traduccion traduccion, String descripcion, int puntaje) throws Exception {
        Calendar cal = Calendar.getInstance();
        if (this.manejaIdioma(traduccion.getIdioma()) & this.manejaIdioma(traduccion.getIdiomaOriginal())) {
            Evaluacion evaluacion = new Evaluacion(cal.getTime(), descripcion, true, traduccion, puntaje);
            this.getEvaluaciones().add(evaluacion);
        } else
            throw new Exception("No se pueden evaluar traducciones de idiomas que el moderador no maneja.");
    }

}
