package bd2.tests;

import java.util.Date;

import bd2.model.Cursada;
import bd2.model.Curso;
import bd2.model.Idioma;
import bd2.model.Leccion;
import bd2.model.Prueba;
import bd2.model.Usuario;
import junit.framework.TestCase;

public class PruebaTest extends TestCase {

	private Prueba prueba;
	private Leccion vocabularioBasico;

	protected void setUp() throws Exception {
		vocabularioBasico = new Leccion("Vocabulario 1");
		prueba = new Prueba(vocabularioBasico, 1);
	}

	public void testPrueba() {
		Prueba nuevo;
		try {
			nuevo = new Prueba(vocabularioBasico, 60);
			assertEquals(nuevo.getLeccion(), vocabularioBasico);
			assertEquals(nuevo.getPuntaje(), 60);
		} catch (Exception e1) {
			fail("Crear una prueba con puntaje 60 no debería fallar.");
		}

		try {
			nuevo = new Prueba(vocabularioBasico, -1);
			fail("El puntaje de una prueba debe ser un valor entre 0 y 100");
		} catch (Exception e) {
			assertEquals("No se puede usar valores negativos como puntaje de una prueba.",
					e.getMessage());
		}

		try {
			nuevo = new Prueba(vocabularioBasico, 101);
			fail("El puntaje de una prueba debe ser un valor entre 0 y 100");
		} catch (Exception e) {
			assertEquals("No se puede usar valores mayores a 100 como puntaje de una prueba.", e.getMessage());
		}
	}

	public void testSetPuntaje() {
		try {
			prueba.setPuntaje(-1);
			fail("El puntaje de una prueba debe ser un valor entre 0 y 100");
		} catch (Exception e) {
			assertEquals("No se puede usar valores negativos como puntaje de una prueba.", e.getMessage());
			assertEquals(prueba.getPuntaje(), 1);
		}
		try {
			prueba.setPuntaje(0);
			assertEquals(prueba.getPuntaje(), 0);
		} catch (Exception e1) {
			fail("Poner puntaje 0 a una Prueba no debería fallar.");
		}

		try {
			prueba.setPuntaje(100);
			assertEquals(prueba.getPuntaje(), 100);
		} catch (Exception e1) {
			fail("Poner puntaje 100 a una Prueba no debería fallar.");
		}

		try {
			prueba.setPuntaje(101);
			fail("El puntaje de una prueba debe ser un valor entre 0 y 100");
		} catch (Exception e) {
			assertEquals("No se puede usar valores mayores a 100 como puntaje de una prueba.", e.getMessage());
			assertEquals(prueba.getPuntaje(), 100);
		}
	}

	public void testAprobada() throws Exception {
		assertFalse(prueba.aprobada());
		prueba.setPuntaje(59);
		assertFalse(prueba.aprobada());
		prueba.setPuntaje(60);
		assertTrue(prueba.aprobada());
		prueba.setPuntaje(61);
		assertTrue(prueba.aprobada());
	}
}
