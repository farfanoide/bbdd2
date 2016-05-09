package bd2.tests;

import java.util.Date;
import java.util.Calendar;

import bd2.model.Documento;
import bd2.model.Evaluacion;
import bd2.model.Idioma;
import bd2.model.Parrafo;
import bd2.model.Traduccion;
import junit.framework.TestCase;

public class EvaluacionTest extends TestCase {

	private Idioma sueco, ingles;
	private Documento manualIkea;
	private Parrafo manualIkeaIntro;
	private Traduccion suecoAIngles;
	private Date hoy;

	protected void setUp() throws Exception {
		super.setUp();
		Calendar cal = Calendar.getInstance();
		hoy = cal.getTime();
		sueco = new Idioma("Sueco");
		ingles = new Idioma("Inglés");
		manualIkea = new Documento("Manual de Ikea", sueco);
		manualIkeaIntro = new Parrafo(
				"Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Nullam quis risus eget urna mollis ornare vel eu leo. Integer posuere erat a ante venenatis dapibus posuere velit aliquet. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.",
				manualIkea);
		suecoAIngles = new Traduccion(hoy, "Sueco a Inglés", true, "Furniture is good", manualIkeaIntro, ingles);

	}

	public void testEvaluacion() {
		Evaluacion nueva = new Evaluacion(hoy, "Bien", true, suecoAIngles, 8);
		assertEquals(nueva.getFecha(), hoy);
		assertEquals(nueva.getDescripcion(), "Bien");
		assertTrue(nueva.getCompleta());
		assertEquals(nueva.getTraduccion(), suecoAIngles);
		assertEquals(nueva.getPuntaje(), 8);
	}

}
