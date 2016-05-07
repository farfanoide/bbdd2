package bd2.model;

/**
 * Clase Leccion, representa las lecciones de los cursos.
 *
 * @author 
 */
public class Leccion {
    
    /** Atributo nombre. */
    protected String nombre;
    
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Constructor para instanciar lecciones.
     *
     * @param nombre: nombre que representara la leccion.
     */
    public Leccion(){}
    
    public Leccion(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo getter del atributo nombre.
     *
     * @return nombre: retorna el nombre de la leccion
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Metodo setter del atributo nombre.
     *
     * @param nombre: recibe un nombre para asignarle a la leccion.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
