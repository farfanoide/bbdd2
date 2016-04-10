package bd2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Date;

/**
 * @author
 *
 */
public class Usuario {
    protected String email;
    protected String nombre;
    protected Date fechaDeCreacion;
    protected Collection<Traduccion> traducciones = new HashSet<Traduccion>();
    protected Collection<Cursada> cursadasRealizadas = new HashSet<Cursada>();
    private long id;

    public Usuario(String email, String nombre, Date fechaDeCreacion) {
        super();
        this.email = email;
        this.nombre = nombre;
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaDeCreacion() {
        return this.fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public void agregarCursada(Cursada cursada) {
        this.cursadasRealizadas.add(cursada);
    }

    public void agregarTraduccion(Traduccion traduccion) {
        this.traducciones.add(traduccion);
    }

    public int nivel(Idioma idioma) {
        ArrayList<Integer> niveles = new ArrayList<Integer>();
        for (Cursada cursada : this.cursadasAprobadas(idioma))
            niveles.add(cursada.getNivel());
        if(niveles.isEmpty())
            return 0;
        else
            return Collections.max(niveles);
    }

    public Collection<Cursada> cursadasAprobadas(Idioma idioma) {
        Collection<Cursada> aprobadas = new ArrayList<Cursada>();
        for (Cursada cursada : this.getCursadasRealizadas())
            if (cursada.finalizada() & cursada.getIdioma().equals(idioma))
                aprobadas.add(cursada);
        return aprobadas;
    }

    public Collection<Cursada> getCursadasRealizadas() {
        return this.cursadasRealizadas;
    }

    public void setCursadasRealizadas(Collection<Cursada> cursadasRealizadas) {
        this.cursadasRealizadas = cursadasRealizadas;
    }

    public Collection<Traduccion> getTraducciones() {
        return this.traducciones;
    }

    public void setTraducciones(Collection<Traduccion> traducciones) {
        this.traducciones = traducciones;
    }
}