package bd2.model;

import java.util.Date;

/**
 * @author
 */
public class Evaluacion extends Tarea {

    protected Traduccion traduccion;
    protected int puntaje;

    public Evaluacion(Date fecha, String descripcion, Boolean completa, Traduccion traduccion, int puntaje) {
        super(fecha, descripcion, completa);
        this.traduccion = traduccion;
        this.puntaje = puntaje;
    }

    public Traduccion getTraduccion() {
        return this.traduccion;
    }

    public void setTraduccion(Traduccion traduccion) {
        this.traduccion = traduccion;
    }

    public int getPuntaje() {
        return this.puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

}
