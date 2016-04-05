package bd2.tests;

import bd2.model.*;
import junit.framework.TestCase;

public class DiccionarioTest extends TestCase {

	private Idioma ingles;
	private Diccionario vacio;

	protected void setUp() throws Exception {
		super.setUp();
		ingles = new Idioma("Inglés");
		vacio = ingles.getDiccionario();
	}

	public void testDiccionario(){
		Idioma portugues = new Idioma("Portugues");
		Diccionario nuevoDiccionario = new Diccionario(portugues, "Edicion 1");
		assertTrue(nuevoDiccionario.getDefiniciones().isEmpty());
		assertEquals(nuevoDiccionario.getIdioma(), portugues);
	}

	public void testAgregarDefinicion() {
		assertTrue(vacio.getDefiniciones().isEmpty());
		vacio.agregarDefinicion("procrastinate", "Fancy word for doing nothing");
		assertEquals(vacio.definicion("procrastinate"), "Fancy word for doing nothing");
		vacio.agregarDefinicion("procrastinate", "Fancy word for doing nothing");
		assertEquals(vacio.definicion("procrastinate"), "Fancy word for doing nothing");
		assertEquals(vacio.getDefiniciones().size(), 1);
	}

}
