package bd2.tests;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;
import bd2.model.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateTest extends TestCase {

	private static SessionFactory factory;

	private void crearSessionFactory(String pathConfig) {
		Configuration configuration = new Configuration();
	    configuration.configure(pathConfig);
	    

		System.out.println("Droping schema.........");
		new SchemaExport(configuration).drop(true, true);
		System.out.println("DONE.");

		System.out.println("Generating schema.........");
		new SchemaExport(configuration).create(true, true);
		System.out.println("DONE.");

		System.out.println("Building sessions.........");    
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).buildServiceRegistry();
	    factory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public void testGuardarYLeer() {
		this.crearSessionFactory("hibernate/hibernate.cfg.xml");
		this.guardarYLeerBasico();
		factory.close();
	}

	public void guardarYLeerBasico() {
		Sitio sitio = new Sitio();
		Calendar cal = Calendar.getInstance();
		
		Idioma espanol = new Idioma("Español");
		espanol.getDiccionario().agregarDefinicion("Libre", "Luz ha encontrar victorioso guapa atreves va al senoras");
		espanol.getDiccionario().agregarDefinicion("Menudeaban", "En murio extrana hable abrio el van perversion extrana");
		espanol.getDiccionario().agregarDefinicion("Va", "Fantasmas sexto tio las libre lo hay le luz libre levitas seduciendo sexto murio lo van lo");
		Idioma aleman = new Idioma("Alemán");
		aleman.getDiccionario().agregarDefinicion("Leuchtturm", "Em vorsichtig duftenden du so leuchtturm wu zu wo merken groben wo");
		aleman.getDiccionario().agregarDefinicion("Bedeckten", "Wo angst armeln kraftiger ri");
		aleman.getDiccionario().agregarDefinicion("Wasserkrug", "Es norden wasserkrug lust horen es stockwerke verbergend so duftenden da mi jungen");
		Idioma portugues = new Idioma("Portugués");
		portugues.getDiccionario().agregarDefinicion("Camillo", "Uso baixo quer sao raiva afinal em");
		portugues.getDiccionario().agregarDefinicion("Se", "Censuro alli sao do portanto apanhar gremio com cousa es ir has");
		portugues.getDiccionario().agregarDefinicion("Apanhar", "Uso");		
		this.guardarYLeer(Idioma.class, espanol);
		this.guardarYLeer(Idioma.class, aleman);
		this.guardarYLeer(Idioma.class, portugues);
		
		cal.set(2015, 8, 12);
		Usuario ezequiel = new Usuario("ezequiel@polyglot.net", "Ezequiel", cal.getTime());
		sitio.registrarUsuario(ezequiel);
		cal.set(2014, 11, 9);
		Usuario ronny = new Usuario("ronny@polyglot.net", "Ronny", cal.getTime());
		sitio.registrarUsuario(ronny);
		cal.set(2015, 5, 24);
		Usuario carolyn = new Usuario("carolyn@polyglot.net", "Carolyn", cal.getTime());
		sitio.registrarUsuario(carolyn);
		cal.set(2015, 2, 3);
		Moderador jeff = new Moderador("jeff@polyglot.net", "Jeff", cal.getTime());
		sitio.registrarUsuario(jeff);
		this.guardarYLeer(Usuario.class, ezequiel);
		this.guardarYLeer(Usuario.class, ronny);
		this.guardarYLeer(Usuario.class, carolyn);
		this.guardarYLeer(Moderador.class, jeff);

		Documento reinab_d1 = new Documento("Reinaba en bueno", espanol);
		Parrafo reinab_d11 = reinab_d1.agregarParrafo("Playa encontrar chi flagrante lugar parecio senoras hembras ha fantasmas seduciendo en reinaba reservaba extrana sexto deliciosas va dia tuviera menudeaban traia lugar deliciosas lo. Es bueno no en en bueno el tuviera encontrar van da le reservaba libre asustados extrana da no flagrante libre dia perversion las. ");
		Parrafo reinab_d12 = reinab_d1.agregarParrafo("Amigo es. ");
		sitio.agregarDocumento(reinab_d1);
		Documento muwomu_d1 = new Documento("Mu wo mu", aleman);
		Parrafo muwomu_d11 = muwomu_d1.agregarParrafo("Jungen wo jungen wo wo in horen. Verbergend ausblasen in mi wo ab jungen lief. Kraftiger wasserkrug armeln mu wo ri wachsamen zuschauen kraftiger so erregt es dran da holen nettigkeit wo nach norden in. ");
		Parrafo muwomu_d12 = muwomu_d1.agregarParrafo("Ruth merken wo so duftenden im leuchtturm wo te armeln kraftiger em mu. ");
		sitio.agregarDocumento(muwomu_d1);
		Documento viveme_d1 = new Documento("Vivem eu alli", portugues);
		Parrafo viveme_d11 = viveme_d1.agregarParrafo("Uso pernil farca afinal com baixo com impoe baixo essencial senao vir for censuro ii. Raiva com afinal apregoam gremio essencial educacao se ii gremio for iraou ii liberdade uso paulo paulo na. Ama se no nao vivem ficam iraou senao ma alli buscaes se camillo pernil com eu firmeza pernil arrumava ma baixo pernil for afinal paulo exclamou fim sao bom. ");
		Parrafo viveme_d12 = viveme_d1.agregarParrafo("Educacao pareco camillo arrumava ma bom quer em. ");
		sitio.agregarDocumento(viveme_d1);
		this.guardarYLeer(Documento.class, reinab_d1);
		this.guardarYLeer(Documento.class, muwomu_d1);
		this.guardarYLeer(Documento.class, viveme_d1);
		
		cal.set(2015, 1, 22);
		Traduccion viveme_d11ByEzequiel = new Traduccion(cal.getTime(), "Portugues a Aleman", true,"Vorsichtig ab nach da wasserkrug nettigkeit mu dran in stockwerke so so ruth dran es. Du wasserkrug kraftiger da zu verbergend ruth dran. ", viveme_d11, aleman );
		ezequiel.agregarTraduccion(viveme_d11ByEzequiel);
		jeff.agregarIdioma(portugues);
		jeff.agregarIdioma(aleman);
		try {
			jeff.evaluar(viveme_d11ByEzequiel, "Supplicou mulheres fim", 3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.set(2014, 8, 30);
		Traduccion viveme_d11ByRonny = new Traduccion(cal.getTime(), "Portugues a Espanol", true,"Senoras te senoras atreves mi reinaba no va mi tuviera playa ha renta al asustados metia deliciosas en lugar en usaba ha flagrante traia. En seduciendo no traia traia lo tio levitas no libre en traia. Tio extrana tuviera asustados asustados amigo ha victorioso van. ", viveme_d11, espanol );
		ronny.agregarTraduccion(viveme_d11ByRonny);
		cal.set(2015, 1, 18);
		Traduccion reinab_d11ByRonny = new Traduccion(cal.getTime(), "Espanol a Aleman", true,"Wo wachsamen groben kammer horen wu wo lief vorsichtig zu sich vorsichtig vorsichtig. Norden dran em norden du ruth em ri so zu so so kammer zu zu ausblasen lief erregt. ", reinab_d11, aleman );
		ronny.agregarTraduccion(reinab_d11ByRonny);
		cal.set(2014, 4, 12);
		Traduccion reinab_d11ByCarolyn = new Traduccion(cal.getTime(), "Espanol a Aleman", true,"Em duftenden wo zu mu es du lust wo wo duftenden. ", reinab_d11, aleman );
		carolyn.agregarTraduccion(reinab_d11ByCarolyn);
		cal.set(2014, 9, 1);
		Traduccion viveme_d12ByCarolyn = new Traduccion(cal.getTime(), "Portugues a Aleman", true,"Duftenden lief wo wasserkrug horen stockwerke wo wo norden leuchtturm kammer ruth zu kammer armeln duftenden im erregt erregt erregt lust horen mi an armeln vorsichtig wo. ", viveme_d12, aleman );
		carolyn.agregarTraduccion(viveme_d12ByCarolyn);
		this.guardarYLeer(Traduccion.class, viveme_d11ByEzequiel);
		this.guardarYLeer(Traduccion.class, viveme_d11ByRonny);
		this.guardarYLeer(Traduccion.class, reinab_d11ByRonny);
		this.guardarYLeer(Traduccion.class, reinab_d11ByCarolyn);
		this.guardarYLeer(Traduccion.class, viveme_d12ByCarolyn);
		
		Curso daesme1 = new Curso("Da es metia implacable no", espanol, 2);
		Leccion daesme11 = new Leccion("Tuviera dia hay murio sexto en crecido libre atreves traerle");
		daesme1.agregarLeccion(daesme11);
		Leccion daesme12 = new Leccion("Mi menudeaban menudeaban hable va reinaba reservaba mi extrana perversion");
		daesme1.agregarLeccion(daesme12);
		sitio.agregarCurso(daesme1);
		cal.set(2015, 0, 21);
		Cursada ezequielCdaesme1 = new Cursada(daesme1, cal.getTime(), ezequiel);
		Prueba ezequielTakesdaesme11;
		try {
			ezequielTakesdaesme11 = new Prueba(daesme11, 53);
			ezequielCdaesme1.agregarPrueba(ezequielTakesdaesme11);
		} catch (Exception e) {e.printStackTrace();}
		this.guardarYLeer(Curso.class, daesme1);
		this.guardarYLeer(Cursada.class, ezequielCdaesme1);
		

		this.guardarYLeer(Sitio.class, sitio);
	}

	public void guardarYLeer(Class clazz, Object o) {
		Session session = factory.openSession();
		Transaction tx = null;
		Long id = null;
		tx = session.beginTransaction();
		id = (Long) session.save(o);
		assertNotNull(session.get(clazz, id));
		tx.commit();
		session.close();
	}
}

