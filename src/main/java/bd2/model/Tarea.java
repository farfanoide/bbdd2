package bd2.model;

import java.util.Date;

/**
 * The Class Tarea.
 *
 * @author farfanoide
 *
 */
public abstract class Tarea {

    /** The fecha. */
    protected Date fecha;

    /** The descripcion. */
    protected String descripcion;

    /** The completa. */
    protected Boolean completa;
    
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Instantiates a new tarea.
     *
     * @param fecha
     *            the fecha
     * @param descripcion
     *            the descripcion
     * @param completa
     *            the completa
     */
    public Tarea(Date fecha, String descripcion, Boolean completa) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.completa = completa;
    }

    /**
     * Gets the fecha.
     *
     * @return the fecha
     */
    public Date getFecha() {
        return this.fecha;
    }

    /**
     * Sets the fecha.
     *
     * @param fecha
     *            the new fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Gets the descripcion.
     *
     * @return the descripcion
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Sets the descripcion.
     *
     * @param descripcion
     *            the new descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Gets the completa.
     *
     * @return the completa
     */
    public Boolean getCompleta() {
        return this.completa;
    }

    /**
     * Sets the completa.
     *
     * @param completa
     *            the new completa
     */
    public void setCompleta(Boolean completa) {
        this.completa = completa;
    }

    /**
     * Completar.
     */
    public void completar() {
        this.setCompleta(true);
    }

}
