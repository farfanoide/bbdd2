/**
 *
 */
package bd2.model;

/**
 * @author
 *
 */
import java.util.Date;

public abstract class Tarea {

    protected Date fecha;
    protected String descripcion;
    protected Boolean completa = false;;
    private long id;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Tarea(Date fecha, String descripcion, Boolean completa) {
        super();
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.completa = completa;
    }

    public Date getFecha() {
        return this.fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Boolean getCompleta() {
        return this.completa;
    }
    public void setCompleta(Boolean completa) {
        this.completa = completa;
    }
    public void completar(){
        this.setCompleta(false);
    }

}
