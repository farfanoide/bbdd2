package bd2.model;

/**
 * @author
 */
public class Prueba {
    protected int puntaje;
    protected Leccion leccion;
    private long id;

    public Prueba(Leccion leccion, Integer puntaje) throws Exception {
        this.setLeccion(leccion);
        this.setPuntaje(puntaje);
    }

    public Prueba() throws Exception {
        super();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPuntaje() {
        return this.puntaje;
    }

    public void setPuntaje(int puntaje) throws Exception {
        if (puntaje < 0)
            throw new Exception(
                "No se puede usar valores negativos como puntaje de una prueba.");
        if (puntaje > 100)
            throw new Exception("No se puede usar valores mayores a 100 como puntaje de una prueba.");
        this.puntaje = puntaje;
    }

    public Leccion getLeccion() {
        return this.leccion;
    }

    public void setLeccion(Leccion leccion) {
        this.leccion = leccion;
    }

    public Boolean aprobada() {
        return this.getPuntaje() >= 60;
    }
}
