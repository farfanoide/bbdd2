package bd2.model;

/**
 * The Class Prueba.
 *
 * @author 
 */
public class Prueba {
    
    /** The puntaje. */
    protected int puntaje;
    
    /** The leccion. */
    protected Leccion leccion;
    
    /** The id. */
    private long id;

    /**
     * Instantiates a new prueba.
     *
     * @param leccion the leccion
     * @param puntaje the puntaje
     * @throws Exception the exception
     */
    public Prueba(Leccion leccion, Integer puntaje) throws Exception {
        this.setLeccion(leccion);
        this.setPuntaje(puntaje);
    }

    /**
     * Instantiates a new prueba.
     *
     * @throws Exception the exception
     */
    public Prueba() throws Exception {
        super();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public long getId() {
        return this.id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(long id) {
        this.id = id;
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
     * @throws Exception the exception
     */
    public void setPuntaje(int puntaje) throws Exception {
        if (puntaje < 0)
            throw new Exception(
                "No se puede usar valores negativos como puntaje de una prueba.");
        if (puntaje > 100)
            throw new Exception("No se puede usar valores mayores a 100 como puntaje de una prueba.");
        this.puntaje = puntaje;
    }

    /**
     * Gets the leccion.
     *
     * @return the leccion
     */
    public Leccion getLeccion() {
        return this.leccion;
    }

    /**
     * Sets the leccion.
     *
     * @param leccion the new leccion
     */
    public void setLeccion(Leccion leccion) {
        this.leccion = leccion;
    }

    /**
     * Aprobada.
     *
     * @return the boolean
     */
    public Boolean aprobada() {
        return this.getPuntaje() >= 60;
    }
}
