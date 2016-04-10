package bd2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * @author
 *
 */
public class Cursada {
    protected Curso curso;
    protected Date inicio;
    protected Usuario usuario;
    protected Collection<Prueba> pruebas = new HashSet<Prueba>();
    private long id;

    public Cursada(Curso curso, Date inicio, Usuario usuario) {
        this.curso = curso;
        this.inicio = inicio;
        this.usuario = usuario;
        usuario.agregarCursada(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getInicio() {
        return inicio;
    }

    public Idioma getIdioma() {
        return this.getCurso().getIdioma();
    }

    public int getNivel() {
        return this.getCurso().getNivel();
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public void agregarPrueba(Prueba prueba) {
        this.pruebas.add(prueba);
    }

    public Collection<Prueba> getPruebas() {
        return pruebas;
    }

    public void setPruebas(Collection<Prueba> pruebas) {
        this.pruebas = pruebas;
    }

    public Boolean finalizada() {
        Collection<Leccion> leccionesAprobadas = this.leccionesAprobadas();
        Collection<Leccion> leccionesEsperadas = this.getCurso().getLecciones();
        for (Leccion esperada : leccionesEsperadas)
            if (!leccionesAprobadas.contains(esperada))
                return false;
        return true;
    }

    public Collection<Leccion> leccionesAprobadas() {
        Collection<Leccion> aprobadas = new ArrayList<Leccion>();
        for (Prueba prueba : this.getPruebas())
            if (prueba.aprobada())
                aprobadas.add(prueba.getLeccion());
        return aprobadas;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

}
