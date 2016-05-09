package bd2.tests;

import junit.framework.TestCase;

import java.util.Calendar;
import java.util.Date;

import bd2.model.*;

public class CursadaTest extends TestCase {

	private Cursada encurso;
	private Usuario sven;
	private Curso cursoInglesBasico;
	private Idioma ingles;
	private Leccion vocabularioBasico, articuloDeterminado, presentePerfecto;
	private Date hoy, hace1Anho;
	private Prueba vocabularioBasicoAprobada, vocabularioBasicoDesaprobada, articuloDeterminadoAprobado,
			presentePerfectoAprobado;

	protected void setUp() throws Exception {
		super.setUp();
		ingles = new Idioma("Inglés");

		Calendar cal = Calendar.getInstance();
		hoy = cal.getTime();
		cal.add(Calendar.YEAR, -1);
		hace1Anho = cal.getTime();

		sven = new Usuario("sven@polyglot.com", "Sven Knutsen", hace1Anho);

		cursoInglesBasico = new Curso("Introducción al ingles", ingles, 1);

		vocabularioBasico = new Leccion("Vocabulario 1");
		articuloDeterminado = new Leccion("Articulo determinado");
		presentePerfecto = new Leccion("Presente Perfecto");

		cursoInglesBasico.agregarLeccion(vocabularioBasico);
		cursoInglesBasico.agregarLeccion(articuloDeterminado);

		vocabularioBasicoAprobada = new Prueba(vocabularioBasico, 60);
		vocabularioBasicoDesaprobada = new Prueba(vocabularioBasico, 30);
		articuloDeterminadoAprobado = new Prueba(articuloDeterminado, 90);
		presentePerfectoAprobado = new Prueba(presentePerfecto, 60);

		encurso = new Cursada(cursoInglesBasico, hoy, sven);
	}

	public void testCursada() {
		Calendar cal = Calendar.getInstance();
		Date hoy = cal.getTime();
		Idioma portugues = new Idioma("Portugues");
		Curso cursoIdioma = new Curso("Introducción al portugues", portugues, 1);
		Leccion vocabularioPortugues = new Leccion("Vocabulario 1");
		cursoIdioma.agregarLeccion(vocabularioPortugues);
		Usuario juan = new Usuario("juan@polyglot.com", "Juan", hoy);
		Cursada nuevaCursada = new Cursada(cursoIdioma, hoy, juan);

		assertEquals(nuevaCursada.getIdioma(), portugues);
		assertEquals(nuevaCursada.getInicio(), hoy);
		assertEquals(nuevaCursada.getCurso(), cursoIdioma);
		assertEquals(nuevaCursada.getUsuario(), juan);

		assertTrue(nuevaCursada.leccionesAprobadas().isEmpty());
		assertTrue(nuevaCursada.getPruebas().isEmpty());
		assertFalse(nuevaCursada.finalizada());
	}

	public void testAgregarPrueba() {
		assertEquals(encurso.getPruebas().size(), 0);
		encurso.agregarPrueba(vocabularioBasicoDesaprobada);
		assertEquals(encurso.getPruebas().size(), 1);
		encurso.agregarPrueba(vocabularioBasicoAprobada);
		assertEquals(encurso.getPruebas().size(), 2);
		encurso.agregarPrueba(articuloDeterminadoAprobado);
		assertEquals(encurso.getPruebas().size(), 3);
	}

	public void testFinalizada() throws Exception {
		assertFalse(encurso.finalizada());
		encurso.agregarPrueba(new Prueba(vocabularioBasico, 30));
		assertFalse(encurso.finalizada());
		encurso.agregarPrueba(new Prueba(articuloDeterminado, 60));
		assertFalse(encurso.finalizada());
		encurso.agregarPrueba(new Prueba(vocabularioBasico, 80));
		assertTrue(encurso.finalizada());
		encurso.agregarPrueba(new Prueba(vocabularioBasico, 88));
		assertTrue(encurso.finalizada());
	}

}
