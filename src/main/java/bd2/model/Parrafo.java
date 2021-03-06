package bd2.model;

/**
 * The Class Parrafo. representa un parrafo de un `Documento`.
 *
 * @author farfanoide
 */
public class Parrafo {

    /** The texto. */
    protected String texto;

    /** The documento. */
    protected Documento documento;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    /**
     * Instantiates a new parrafo.
     *
     * @param texto
     *            the texto
     * @param documento
     *            the documento
     */
    public Parrafo(){}
    
    public Parrafo(String texto, Documento documento) {
        this.texto = texto;
        this.documento = documento;
    }

    /**
     * Gets the texto.
     *
     * @return the texto
     */
    public String getTexto() {
        return this.texto;
    }

    /**
     * Sets the texto.
     *
     * @param texto
     *            the new texto
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * Gets the documento.
     *
     * @return the documento
     */
    public Documento getDocumento() {
        return this.documento;
    }

    /**
     * Sets the documento.
     *
     * @param documento
     *            the new documento
     */
    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
}
