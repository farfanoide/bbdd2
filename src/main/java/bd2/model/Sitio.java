package bd2.model;

import java.util.Collection;
import java.util.HashSet;


/**
 * @author farfanoide
 */
public class Sitio {

    private Collection<Usuario> usuarios = new HashSet<Usuario>();
    private Collection<Curso> cursos = new HashSet<Curso>();
    private Collection<Documento> documentos = new HashSet<Documento>();
    private long id;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Sitio() {
    }

    public Collection<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void registrarUsuario(Usuario usuario) {
        this.getUsuarios().add(usuario);
    }

    public Collection<Curso> getCursos() {
        return this.cursos;
    }

    public void agregarCurso(Curso curso) {
        this.getCursos().add(curso);
    }

    public void agregarDocumento(Documento documento) {
        this.getDocumentos().add(documento);
    }

    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setCursos(Collection<Curso> cursos) {
        this.cursos = cursos;
    }

    public Collection<Documento> getDocumentos() {
        return this.documentos;
    }

    public void setDocumentos(Collection<Documento> documentos) {
        this.documentos = documentos;
    }

}