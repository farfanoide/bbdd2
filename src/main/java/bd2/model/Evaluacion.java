package bd2.model;

import java.util.Date;

/**
 * The Class Evaluacion. Utilizada para representar la evaluacion de una
 * traduccion de un usuario (aprendiz).
 *
 * @author farfanoide
 */
public class Evaluacion extends Tarea {

    /** The traduccion. */
    protected Traduccion traduccion;

    /** The puntaje. */
    protected int puntaje;

    /**
     * Instantiates a new evaluacion.
     *
     * @param fecha the fecha
     * @param descripcion the descripcion
     * @param completa the completa
     * @param traduccion the traduccion
     * @param puntaje the puntaje
     */
    public Evaluacion(){}
    
    public Evaluacion(Date fecha, String descripcion, Boolean completa, Traduccion traduccion, int puntaje) {
        super(fecha, descripcion, completa);
        this.traduccion = traduccion;
        this.puntaje = puntaje;
    }

    /**
     * Gets the traduccion.
     *
     * @return the traduccion
     */
    public Traduccion getTraduccion() {
        return this.traduccion;
    }

    /**
     * Sets the traduccion.
     *
     * @param traduccion the new traduccion
     */
    public void setTraduccion(Traduccion traduccion) {
        this.traduccion = traduccion;
    }

    /**
     * Gets the puntaje.
     *
     * @return the puntaje
     */
    public int getPuntaje() {
        return this.puntaje;
    }

    /**
     * Sets the puntaje.
     *
     * @param puntaje the new puntaje
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

}
