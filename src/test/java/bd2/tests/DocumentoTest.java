package bd2.tests;

import junit.framework.TestCase;
import bd2.model.*;

public class DocumentoTest extends TestCase {

	private Documento vacio, lleno;
	private Idioma latin = new Idioma("Latin");

	protected void setUp() throws Exception {
		super.setUp();
		vacio = new Documento("Vacuum Document", latin);
		lleno = new Documento("Plena Document", latin);
		lleno.agregarParrafo("Etiam porta sem malesuada magna mollis euismod.");
		lleno.agregarParrafo("Sed posuere consectetur est at lobortis.");
		lleno.agregarParrafo(
				"Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit.");
		lleno.agregarParrafo("Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.");
	}

	public void testDocumento() {
		Idioma portugues = new Idioma("Portugues");
		Documento nuevo = new Documento("Vacuum Document", portugues);
		assertTrue(nuevo.getParrafos().isEmpty());
		assertEquals(nuevo.getNombre(), "Vacuum Document");
		assertEquals(nuevo.getIdioma(), portugues);
	}

	public void testAgregarParrafo() {
		assertTrue(vacio.getParrafos().isEmpty());
		vacio.agregarParrafo("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		assertEquals(vacio.getParrafos().size(), 1);
		Parrafo primero = vacio.getParrafos().iterator().next();
		assertEquals(primero.getTexto(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		assertTrue(vacio.getParrafos().contains(primero));
		vacio.agregarParrafo(
				"Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit.");
		assertEquals(vacio.getParrafos().size(), 2);
		assertTrue(vacio.getParrafos().contains(primero));
	}

}
