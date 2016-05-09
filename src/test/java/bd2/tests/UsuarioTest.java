package bd2.tests;

import java.util.Calendar;
import java.util.Date;
import java.util.Collection;

import bd2.model.*;
import junit.framework.TestCase;

public class UsuarioTest extends TestCase {
	private Cursada cursadaInglesNivel1, cursadaInglesNivel6;
	private Usuario sven;
	private Curso cursoInglesNivel1, cursoInglesNivel6;
	private Idioma ingles;
	private Leccion vocabularioBasico, articuloDeterminado, presentePerfecto;
	private Date hoy, hace1Anho;
	private Prueba vocabularioBasicoAprobada, vocabularioBasicoDesaprobada, articuloDeterminadoAprobado,
			presentePerfectoAprobado, presentePerfectoDesaprobado;

	protected void setUp() throws Exception {
		super.setUp();
		ingles = new Idioma("Inglés");

		Calendar cal = Calendar.getInstance();
		hoy = cal.getTime();
		cal.add(Calendar.YEAR, -1);
		hace1Anho = cal.getTime();

		sven = new Usuario("sven@polyglot.com", "Sven Knutsen", hace1Anho);
		cursoInglesNivel1 = new Curso("Introducción al ingles", ingles, 1);
		cursoInglesNivel6 = new Curso("Conjugación de Verbos Avanzado", ingles, 6);

		vocabularioBasico = new Leccion("Vocabulario 1");
		articuloDeterminado = new Leccion("Articulo determinado");
		presentePerfecto = new Leccion("Presente Perfecto");

		cursoInglesNivel1.agregarLeccion(vocabularioBasico);
		cursoInglesNivel1.agregarLeccion(articuloDeterminado);

		vocabularioBasicoAprobada = new Prueba(vocabularioBasico, 60);
		vocabularioBasicoDesaprobada = new Prueba(vocabularioBasico, 30);
		articuloDeterminadoAprobado = new Prueba(articuloDeterminado, 90);

		presentePerfectoDesaprobado = new Prueba(presentePerfecto, 59);
		presentePerfectoAprobado = new Prueba(presentePerfecto, 60);
		cursoInglesNivel6.agregarLeccion(presentePerfecto);

		cursadaInglesNivel1 = new Cursada(cursoInglesNivel1, hace1Anho, sven);
		cursadaInglesNivel1.agregarPrueba(vocabularioBasicoDesaprobada);
		cursadaInglesNivel1.agregarPrueba(articuloDeterminadoAprobado);
	}

	public void testUsuario() {
		Calendar cal = Calendar.getInstance();
		Date hoy = cal.getTime();
		Usuario nuevo = new Usuario("juan@polyglot.com", "Juan", hoy);
		assertEquals(nuevo.getNombre(), "Juan");
		assertEquals(nuevo.getEmail(), "juan@polyglot.com");
		assertEquals(nuevo.getFechaDeCreacion(), hoy);
		assertEquals(nuevo.nivel(ingles), 0);
	}

	public void testCursadasAprobadas() {
		Collection<Cursada> aprobadasSvenIngles = sven.cursadasAprobadas(ingles);
		assertFalse(aprobadasSvenIngles.contains(cursadaInglesNivel1));
		assertTrue(aprobadasSvenIngles.isEmpty());

		cursadaInglesNivel1.agregarPrueba(vocabularioBasicoAprobada);
		aprobadasSvenIngles = sven.cursadasAprobadas(ingles);
		assertTrue(aprobadasSvenIngles.contains(cursadaInglesNivel1));
		assertEquals(aprobadasSvenIngles.size(), 1);
		
		Cursada cursadaDesapInglesNivel6 = new Cursada(cursoInglesNivel6, hace1Anho, sven);
		aprobadasSvenIngles = sven.cursadasAprobadas(ingles);
		assertTrue(aprobadasSvenIngles.contains(cursadaInglesNivel1));
		assertEquals(aprobadasSvenIngles.size(), 1);
		
		Cursada cursadaAprobadaInglesNivel6 = new Cursada(cursoInglesNivel6, hoy, sven);
		cursadaAprobadaInglesNivel6.agregarPrueba(presentePerfectoAprobado);
		aprobadasSvenIngles = sven.cursadasAprobadas(ingles);
		assertTrue(aprobadasSvenIngles.contains(cursadaInglesNivel1));
		assertTrue(aprobadasSvenIngles.contains(cursadaAprobadaInglesNivel6));
		assertEquals(aprobadasSvenIngles.size(), 2);
	}

	public void testNivel() {
		assertEquals(sven.nivel(ingles), 0);
		cursadaInglesNivel1.agregarPrueba(vocabularioBasicoAprobada);
		assertEquals(sven.nivel(ingles), 1);

		cursadaInglesNivel6 = new Cursada(cursoInglesNivel6, hace1Anho, sven);
		cursadaInglesNivel6.agregarPrueba(presentePerfectoDesaprobado);
		assertEquals(sven.nivel(ingles), 1);

		cursadaInglesNivel6.agregarPrueba(presentePerfectoAprobado);
		assertEquals(sven.nivel(ingles), 6);
	}
}
