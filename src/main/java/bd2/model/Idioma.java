package bd2.model;

/**
 * The Class Idioma. Representa un idioma del sitio
 *
 * @author farfanoide
 */
public class Idioma {

    /** The nombre. */
    protected String nombre;

    /** The diccionario. */
    protected Diccionario diccionario;
    
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Instantiates a new idioma.
     */
    public Idioma() {}

    /**
     * Instantiates a new idioma.
     *
     * @param nombre
     *            the nombre
     */
    public Idioma(String nombre) {
        this.nombre = nombre;
        this.diccionario = new Diccionario(this, "");
    }

    /**
     * Gets the nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Sets the nombre.
     *
     * @param nombre
     *            the new nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the diccionario.
     *
     * @return the diccionario
     */
    public Diccionario getDiccionario() {
        return this.diccionario;
    }

    /**
     * Sets the diccionario.
     *
     * @param diccionario
     *            the new diccionario
     */
    public void setDiccionario(Diccionario diccionario) {
        this.diccionario = diccionario;
    }
}
