package bd2.model;

import java.util.Collection;
import java.util.HashSet;

/**
 * Clase Sitio.
 *
 * @author farfanoide
 */
public class Sitio {

    /**
     * Los usuarios. Utilizamos un set para no tener usuarios duplicados
     */
    private Collection<Usuario> usuarios;

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Los cursos. Idem usuarios.
     */
    private Collection<Curso> cursos;

    /** The documentos. */
    private Collection<Documento> documentos;

    /**
     * Instantiates a new sitio.
     */
    public Sitio() {
        this.usuarios = new HashSet<Usuario>();
        this.cursos = new HashSet<Curso>();
        this.documentos = new HashSet<Documento>();
    }

    /**
     * Gets the usuarios.
     *
     * @return the usuarios
     */
    public Collection<Usuario> getUsuarios() {
        return this.usuarios;
    }

    /**
     * Registrar usuario.
     *
     * @param usuario
     *            the usuario
     */
    public void registrarUsuario(Usuario usuario) {
        this.getUsuarios().add(usuario);
    }

    /**
     * Gets the cursos.
     *
     * @return the cursos
     */
    public Collection<Curso> getCursos() {
        return this.cursos;
    }

    /**
     * Agregar curso.
     *
     * @param curso
     *            the curso
     */
    public void agregarCurso(Curso curso) {
        this.getCursos().add(curso);
    }

    /**
     * Agregar documento.
     *
     * @param documento
     *            the documento
     */
    public void agregarDocumento(Documento documento) {
        this.getDocumentos().add(documento);
    }

    /**
     * Gets the documentos.
     *
     * @return the documentos
     */
    public Collection<Documento> getDocumentos() {
        return this.documentos;
    }
}