package bd2.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import bd2.model.*;

public class DBLoader {

	private static SessionFactory sessions;

	public DBLoader() {
	}

	public static void main(String[] args) {
		try {
			System.out.println("----------------------- Setting up Hibernate -----------------------");
			Configuration cfg = new Configuration();
			cfg.configure("hibernate/hibernate.cfg.xml");

			System.out.println("Droping schema.........");
			new SchemaExport(cfg).drop(true, true);
			System.out.println("DONE.");

			System.out.println("Generating schema.........");
			new SchemaExport(cfg).create(true, true);
			System.out.println("DONE.");

			System.out.println("Building sessions.........");
			sessions = cfg.buildSessionFactory();
			Sitio sitio = cargarBase();

			Session session = sessions.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.save(sitio);
				session.flush();
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) {
					tx.rollback();
				}
				session.close();
			}
			session.disconnect();

			System.out.println("DONE.");
		} catch (Exception e) {
			System.out.println("------------------------FAIL.------------------------");
			e.printStackTrace();
		}
	}

	private static Sitio cargarBase() throws Exception {
		Sitio sitio = new Sitio();
		Calendar cal = Calendar.getInstance();

		Idioma espanol = new Idioma("Español");
		espanol.getDiccionario().setEdicion("Diccionario del Español, Primera Edición");
		espanol.getDiccionario().agregarDefinicion("En",
				"Guapa flagrante perversion sexto fantasmas deliciosas traerle te tuviera menudeaban mi tuviera seduciendo usaba al ha");
		espanol.getDiccionario().agregarDefinicion("Lugar", "Murio implacable luz implacable");
		espanol.getDiccionario().agregarDefinicion("Menudeaban",
				"Luz al hay luz senoras abrio en da flagrante deliciosas playa metia usaba las da da luz extrana");
		espanol.getDiccionario().agregarDefinicion("Bueno",
				"Le guapa en da le hembras metia murio murio extrana libre tio deliciosas chi");
		espanol.getDiccionario().agregarDefinicion("Usaba",
				"En victorioso renta traerle crecido seduciendo flagrante implacable abrio seduciendo las atreves en te flagrante perversion");
		espanol.getDiccionario().agregarDefinicion("Fantasmas", "En usaba deliciosas te hable van en dia playa te");
		espanol.getDiccionario().agregarDefinicion("Renta", "No ha murio murio van amigo crecido van levitas");
		espanol.getDiccionario().agregarDefinicion("Traerle",
				"Tuviera murio reservaba usaba sexto al al murio usaba dia atreves playa playa atreves");
		espanol.getDiccionario().agregarDefinicion("Extrana",
				"Al playa levitas metia no abrio al abrio en en amigo implacable parecio mi");
		espanol.getDiccionario().agregarDefinicion("Chi",
				"Traia menudeaban ha reservaba usaba implacable reservaba lo renta abrio no en hay abrio al va");
		espanol.getDiccionario().agregarDefinicion("Deliciosas",
				"Metia crecido menudeaban menudeaban lo mi sexto hay ha asustados va senoras implacable abrio");
		espanol.getDiccionario().agregarDefinicion("Tio",
				"Chi parecio hay perversion playa guapa flagrante crecido flagrante van guapa murio");
		espanol.getDiccionario().agregarDefinicion("Hay", "Asustados chi van atreves al ha deliciosas le lo crecido");
		espanol.getDiccionario().agregarDefinicion("Abrio", "Deliciosas reinaba le murio crecido playa amigo usaba");
		espanol.getDiccionario().agregarDefinicion("Implacable",
				"No no fantasmas dia murio no tio ha sexto asustados traia hable");
		espanol.getDiccionario().agregarDefinicion("Playa", "Mi bueno levitas usaba hay ha luz hay");
		espanol.getDiccionario().agregarDefinicion("Victorioso",
				"Reinaba encontrar bueno las en menudeaban fantasmas amigo renta chi metia victorioso es");
		espanol.getDiccionario().agregarDefinicion("Hable", "Va dia el asustados");
		espanol.getDiccionario().agregarDefinicion("Amigo",
				"Chi fantasmas menudeaban hable perversion reservaba es crecido van renta levitas es reservaba van abrio extrana no va");
		espanol.getDiccionario().agregarDefinicion("Dia", "En lo");
		espanol.getDiccionario().agregarDefinicion("Luz",
				"Te dia fantasmas senoras chi lo el da encontrar senoras hable renta el es en metia abrio");

		Idioma aleman = new Idioma("Alemán");
		aleman.getDiccionario().setEdicion("Deutsch, Erste Edizionung");
		aleman.getDiccionario().agregarDefinicion("Ausblasen", "Es leuchtturm mi sich nach da da so holen zu da te");
		aleman.getDiccionario().agregarDefinicion("Verbergend", "Dran em dran zu");
		aleman.getDiccionario().agregarDefinicion("Duftenden",
				"Bedeckten nach wasserkrug stockwerke dran sich so erregt leuchtturm te so");
		aleman.getDiccionario().agregarDefinicion("Es",
				"Erregt wu kraftiger wo wasserkrug verbergend zuschauen nettigkeit duftenden ab sich");
		aleman.getDiccionario().agregarDefinicion("Kraftiger",
				"Leuchtturm dran ausblasen nach im ausblasen ausblasen ri");
		aleman.getDiccionario().agregarDefinicion("Vorsichtig", "Nach horen te ri dran lief es mi kammer");
		aleman.getDiccionario().agregarDefinicion("Angst", "Armeln da norden armeln mu lust em zuschauen");
		aleman.getDiccionario().agregarDefinicion("Erregt", "Ri te du sich wo lust merken");
		aleman.getDiccionario().agregarDefinicion("Armeln",
				"Bedeckten wachsamen zuschauen erregt zuschauen verbergend mu merken holen duftenden es leuchtturm te ruth erregt");
		aleman.getDiccionario().agregarDefinicion("Du",
				"Mi so leuchtturm nettigkeit verbergend stockwerke zu kammer leuchtturm verbergend ausblasen erregt lust mu wachsamen horen norden verbergend");
		aleman.getDiccionario().agregarDefinicion("Ri",
				"Merken ab em zuschauen wo so kraftiger nach holen norden so wo mi zu ri zu zuschauen so nach");
		aleman.getDiccionario().agregarDefinicion("Wasserkrug", "Armeln im nach wasserkrug duftenden em lust so");
		aleman.getDiccionario().agregarDefinicion("Ruth", "Em em bedeckten zu holen");
		aleman.getDiccionario().agregarDefinicion("Stockwerke",
				"Du kraftiger wasserkrug holen groben wo mu dran so es in horen em te ausblasen");
		aleman.getDiccionario().agregarDefinicion("Ab",
				"Em lief holen mi mi zu wasserkrug kammer nettigkeit jungen norden erregt em ab mi");
		aleman.getDiccionario().agregarDefinicion("Mu", "Es erregt groben mi wachsamen bedeckten zu ri mi");
		aleman.getDiccionario().agregarDefinicion("Wu",
				"Verbergend an groben norden mi so nach mu norden kammer angst wo du so ab");
		aleman.getDiccionario().agregarDefinicion("So", "Ruth in mu vorsichtig jungen wu im wasserkrug so");
		aleman.getDiccionario().agregarDefinicion("Nettigkeit", "Bedeckten jungen te angst nettigkeit te ruth");
		aleman.getDiccionario().agregarDefinicion("Im",
				"Ab stockwerke stockwerke stockwerke wo te lief holen an ausblasen erregt");
		aleman.getDiccionario().agregarDefinicion("Groben",
				"Te merken lust zu mi sich norden leuchtturm stockwerke du angst mi ausblasen mu angst wo");
		aleman.getDiccionario().agregarDefinicion("Leuchtturm",
				"Armeln ausblasen lief holen mi wo stockwerke stockwerke angst sich nettigkeit nettigkeit ausblasen zu armeln kammer an duftenden an wo");

		Idioma ingles = new Idioma("Inglés");
		ingles.getDiccionario().setEdicion("English, Second Edition - Reviewed");
		ingles.getDiccionario().agregarDefinicion("Astonished",
				"Perpetual is eyes everything rent extended oh mr no collecting is barton new did barton resembled otherwise");
		ingles.getDiccionario().agregarDefinicion("Want", "Perpetual");
		ingles.getDiccionario().agregarDefinicion("At", "Neat eyes did rent past afford past");
		ingles.getDiccionario().agregarDefinicion("Am", "Do cultivated required eyes");
		ingles.getDiccionario().agregarDefinicion("Did", "Draw");
		ingles.getDiccionario().agregarDefinicion("Considered",
				"Incommode on want by oh by described out extended perpetual eyes");
		ingles.getDiccionario().agregarDefinicion("Is",
				"Change do shameless is man show mr required get want man tall");
		ingles.getDiccionario().agregarDefinicion("Cultivated", "Eyes extremity");
		ingles.getDiccionario().agregarDefinicion("Eyes",
				"Resembled want no travelling do no everything mr on change just no described incommode is am want described");
		ingles.getDiccionario().agregarDefinicion("Debating",
				"Cultivated afford just on add believing do she is astonished neat travelling add extremity incommode");
		ingles.getDiccionario().agregarDefinicion("Change",
				"Described by otherwise barton at as oh is but just do astonished by is");
		ingles.getDiccionario().agregarDefinicion("Travelling", "Otherwise described collecting");
		ingles.getDiccionario().agregarDefinicion("Must",
				"Shameless possession she tall wondered new so she on melancholy no astonished man he dispatched");
		ingles.getDiccionario().agregarDefinicion("So", "Described show everything so just is");
		ingles.getDiccionario().agregarDefinicion("Applauded",
				"Am wondered everything extremity perpetual face cultivated cultivated face extended draw");
		ingles.getDiccionario().agregarDefinicion("Everything", "By perpetual debating must is");
		ingles.getDiccionario().agregarDefinicion("Do", "Add as show");
		ingles.getDiccionario().agregarDefinicion("By",
				"But dispatched no face wondered is sportsman but must new cultivated so");
		ingles.getDiccionario().agregarDefinicion("Tall",
				"Shameless add so is eyes resembled on applauded by extremity up eyes up astonished described as melancholy new is");
		ingles.getDiccionario().agregarDefinicion("On",
				"Wondered change sportsman resembled square rent at as feebly extended mr he so cultivated square so");
		ingles.getDiccionario().agregarDefinicion("He",
				"Believing barton collecting dispatched up draw wondered eyes she afford astonished everything past am");
		ingles.getDiccionario().agregarDefinicion("Just",
				"Feebly rent perpetual wondered face new do did oh possession feebly must");
		ingles.getDiccionario().agregarDefinicion("Believing", "Neat oh barton just");

		Idioma portugues = new Idioma("Portugués");
		portugues.getDiccionario().setEdicion("Portugués, Quinta Ediçao");
		portugues.getDiccionario().agregarDefinicion("Firmeza",
				"Liberdade ii antes supplicou impoe firmeza raiva apregoam iraou sao sao do va essencial sao va apregoam");
		portugues.getDiccionario().agregarDefinicion("Ii",
				"Cousa brios senao vir cousa pareco baixo educacao nao carro paulo fez pernil baixo eu no");
		portugues.getDiccionario().agregarDefinicion("Gonzos", "Arrumava pernil educacao baixo");
		portugues.getDiccionario().agregarDefinicion("Buscaes",
				"Ir apregoam antes ma brios vir censuro em cousa eu paulo pernil salvo censuro raiva bom liberdade portanto arrumava");
		portugues.getDiccionario().agregarDefinicion("Apanhar",
				"Carro na eu vir fez ficam paulo ma vivem gremio portanto apanhar portanto");
		portugues.getDiccionario().agregarDefinicion("Com",
				"Impoe brios salvo pernil ama bom apregoam salvo apregoam uso ama afinal ii vivem firmeza");
		portugues.getDiccionario().agregarDefinicion("Censuro", "Cre");
		portugues.getDiccionario().agregarDefinicion("Arrumava", "Com exclamou es camillo camillo sao bom");
		portugues.getDiccionario().agregarDefinicion("Salvo", "Fim em senao antes baixo buscaes ir do bom");
		portugues.getDiccionario().agregarDefinicion("Gremio", "Arrumava no");
		portugues.getDiccionario().agregarDefinicion("Alli", "Vivido portanto");
		portugues.getDiccionario().agregarDefinicion("Cre",
				"Se antes estao em no do apanhar fez dor pareco no exclamou dor firmeza gonzos");
		portugues.getDiccionario().agregarDefinicion("Portanto",
				"Vivido fim sao alli firmeza essencial fez gonzos impoe arrumava");
		portugues.getDiccionario().agregarDefinicion("Nao",
				"Es bom ir vivem gonzos sao ficam estao fez buscaes liberdade carro estao");
		portugues.getDiccionario().agregarDefinicion("Estao", "Mulheres buscaes ii vivido do iraou portanto cousa");
		portugues.getDiccionario().agregarDefinicion("Supplicou",
				"Sao baixo dor pernil ficam supplicou raiva for baixo fim estao ii em buscaes antes gremio eu cre va paulo");
		portugues.getDiccionario().agregarDefinicion("Do",
				"Ama mulheres camillo ii portanto vivido vivem liberdade quer no fez");
		portugues.getDiccionario().agregarDefinicion("Na", "Fim for censuro for");
		portugues.getDiccionario().agregarDefinicion("Senao",
				"Uso carro mulheres arrumava camillo teremos antes raiva antes");
		portugues.getDiccionario().agregarDefinicion("Educacao",
				"Estao na quer liberdade salvo estao antes uso mulheres vir afinal senao do dor carro eu em has ii gremio");
		portugues.getDiccionario().agregarDefinicion("Liberdade",
				"Essencial exclamou vir firmeza no fez liberdade nao afinal es quer com essencial no liberdade gremio va brios portanto supplicou");
		portugues.getDiccionario().agregarDefinicion("Pernil", "Iraou farca no pernil ama ama cre ma sao");
		portugues.getDiccionario().agregarDefinicion("Has", "Na camillo arrumava no do antes brios dor");

		Idioma frances = new Idioma("Francés");
		frances.getDiccionario().setEdicion("Français, Deuxième Édition");
		frances.getDiccionario().agregarDefinicion("Jambes",
				"Profonde net triomphe chantant aux massacre sortaient art sur");
		frances.getDiccionario().agregarDefinicion("Ah", "Toutefois epouse toi traverse echauffer resterait");
		frances.getDiccionario().agregarDefinicion("Echauffer", "Demeurons traverse art atroce soutenir");
		frances.getDiccionario().agregarDefinicion("Net",
				"Des net et preferait demeurons campagne chantant precieux echauffer sa coupoles aux on or");
		frances.getDiccionario().agregarDefinicion("Des",
				"Les pas des sa triomphe voyage cavernes aux toi palais triomphe demeurons ennemies demeurons pourquoi palais");
		frances.getDiccionario().agregarDefinicion("Campagne", "Reprendre art six sa reprendre devant net ah");
		frances.getDiccionario().agregarDefinicion("Reprendre",
				"Sa sur remettre palais toutefois pourquoi et jambes sur demeurons resterait six echauffer massacre jusque");
		frances.getDiccionario().agregarDefinicion("Firmament",
				"Firmament chantant sortit resterait preferait massacre cavernes remettre rendre reprendre or et echauffer");
		frances.getDiccionario().agregarDefinicion("Chantant",
				"Sur preferait or sortaient campagne annees traverse voyage annees traverse net triomphe or les ah");
		frances.getDiccionario().agregarDefinicion("Sur",
				"Coupoles jusque annees resterait palais on epouse demeurons jambes des");
		frances.getDiccionario().agregarDefinicion("Or", "Toutefois les et chantant precieux");
		frances.getDiccionario().agregarDefinicion("Toi",
				"Remettre epouse sortaient jambes firmament art et net pas cavernes et sortit blason cet ennemies eux toutefois les");
		frances.getDiccionario().agregarDefinicion("Eux",
				"Six palais aux echauffer prudence sur je se campagne jusque");
		frances.getDiccionario().agregarDefinicion("Pourquoi",
				"Jambes pas remettre reprendre toutefois eux triomphe cavernes ah cavernes les ennemies");
		frances.getDiccionario().agregarDefinicion("Les",
				"Resterait ah sortit massacre massacre les preferait traverse palais jambes ennemies sa art toutefois six cavernes je coupoles");
		frances.getDiccionario().agregarDefinicion("Rendre", "Sortit");
		frances.getDiccionario().agregarDefinicion("Et",
				"Or reprendre demeurons rendre roc prennent resterait soutenir palais preferait aux devant les");
		frances.getDiccionario().agregarDefinicion("Massacre", "Eux des massacre six rendre je triomphe jusque");
		frances.getDiccionario().agregarDefinicion("Sa",
				"Net reprendre epouse jambes pourquoi sur eux voyage cet six les cavernes annees toi pourquoi echauffer art les");
		frances.getDiccionario().agregarDefinicion("Palais",
				"Echauffer devant sur toi campagne prennent massacre on traverse jusque");
		frances.getDiccionario().agregarDefinicion("Coupoles", "Pas reprendre sa sortit");
		frances.getDiccionario().agregarDefinicion("Traverse", "Six");
		frances.getDiccionario().agregarDefinicion("Sortit",
				"Cavernes se campagne voyage blason pas or demeurons echauffer annees massacre des aux six toi annees sortaient");
		frances.getDiccionario().agregarDefinicion("Sortaient", "Jusque ah pourquoi");

		cal.set(2015, 10, 7);
		Usuario ezequiel = new Usuario("ezequiel@polyglot.net", "Ezequiel", cal.getTime());
		sitio.registrarUsuario(ezequiel);
		cal.set(2015, 1, 15);
		Usuario ronny = new Usuario("ronny@polyglot.net", "Ronny", cal.getTime());
		sitio.registrarUsuario(ronny);
		cal.set(2014, 7, 30);
		Usuario carolyn = new Usuario("carolyn@polyglot.net", "Carolyn", cal.getTime());
		sitio.registrarUsuario(carolyn);
		cal.set(2014, 8, 28);
		Usuario kary = new Usuario("kary@polyglot.net", "Kary", cal.getTime());
		sitio.registrarUsuario(kary);
		cal.set(2015, 2, 10);
		Usuario jerrell = new Usuario("jerrell@polyglot.net", "Jerrell", cal.getTime());
		sitio.registrarUsuario(jerrell);
		cal.set(2015, 1, 8);
		Usuario remedios = new Usuario("remedios@polyglot.net", "Remedios", cal.getTime());
		sitio.registrarUsuario(remedios);
		cal.set(2016, 0, 28);
		Usuario svetlana = new Usuario("svetlana@polyglot.net", "Svetlana", cal.getTime());
		sitio.registrarUsuario(svetlana);
		cal.set(2014, 10, 12);
		Usuario osvaldo = new Usuario("osvaldo@polyglot.net", "Osvaldo", cal.getTime());
		sitio.registrarUsuario(osvaldo);
		cal.set(2016, 1, 1);
		Usuario shila = new Usuario("shila@polyglot.net", "Shila", cal.getTime());
		sitio.registrarUsuario(shila);
		cal.set(2016, 2, 26);
		Usuario adrien = new Usuario("adrien@polyglot.net", "Adrien", cal.getTime());
		sitio.registrarUsuario(adrien);
		cal.set(2016, 3, 5);
		Usuario agueda = new Usuario("agueda@polyglot.net", "Agueda", cal.getTime());
		sitio.registrarUsuario(agueda);
		cal.set(2014, 11, 21);
		Usuario marth = new Usuario("marth@polyglot.net", "Marth", cal.getTime());
		sitio.registrarUsuario(marth);
		cal.set(2015, 8, 14);
		Usuario claire = new Usuario("claire@polyglot.net", "Claire", cal.getTime());
		sitio.registrarUsuario(claire);
		cal.set(2016, 1, 23);
		Usuario olin = new Usuario("olin@polyglot.net", "Olin", cal.getTime());
		sitio.registrarUsuario(olin);
		cal.set(2014, 5, 11);
		Usuario hilma = new Usuario("hilma@polyglot.net", "Hilma", cal.getTime());
		sitio.registrarUsuario(hilma);
		cal.set(2016, 1, 8);
		Usuario gertrude = new Usuario("gertrude@polyglot.net", "Gertrude", cal.getTime());
		sitio.registrarUsuario(gertrude);
		cal.set(2014, 4, 30);
		Usuario micheline = new Usuario("micheline@polyglot.net", "Micheline", cal.getTime());
		sitio.registrarUsuario(micheline);

		cal.set(2014, 6, 11);
		Moderador jeff = new Moderador("jeff@polyglot.net", "Jeff", cal.getTime());
		sitio.registrarUsuario(jeff);
		cal.set(2016, 0, 18);
		Moderador una = new Moderador("una@polyglot.net", "Una", cal.getTime());
		sitio.registrarUsuario(una);
		cal.set(2015, 0, 28);
		Moderador martine = new Moderador("martine@polyglot.net", "Martine", cal.getTime());
		sitio.registrarUsuario(martine);
		cal.set(2014, 3, 18);
		Moderador minnie = new Moderador("minnie@polyglot.net", "Minnie", cal.getTime());
		sitio.registrarUsuario(minnie);

		Documento reinab_d1 = new Documento("Reinaba las amigo", espanol);
		Parrafo reinab_d11 = reinab_d1.agregarParrafo(
				"Deliciosas lo ha te. En. Chi tuviera ha seduciendo reservaba bueno perversion perversion lo murio al da metia lo ha deliciosas victorioso da encontrar abrio crecido lo asustados da bueno. Asustados crecido van senoras no. ");
		Parrafo reinab_d12 = reinab_d1
				.agregarParrafo("Es reinaba traerle dia lo playa metia tuviera usaba atreves. Guapa lo playa. ");
		Parrafo reinab_d13 = reinab_d1.agregarParrafo(
				"Dia hay traerle te chi el seduciendo extrana parecio ha mi deliciosas encontrar encontrar tio menudeaban fantasmas menudeaban levitas implacable el flagrante victorioso van lugar amigo extrana hembras traia metia. ");
		Parrafo reinab_d14 = reinab_d1.agregarParrafo(
				"Libre encontrar usaba seduciendo hay reservaba parecio traerle flagrante amigo victorioso murio deliciosas no al hable hembras encontrar hay. Senoras metia te al tuviera mi va es al luz guapa senoras sexto deliciosas parecio sexto extrana fantasmas extrana playa reservaba abrio te crecido hable. Crecido atreves tio el sexto mi murio flagrante hay es murio van el deliciosas atreves en abrio. ");
		Parrafo reinab_d15 = reinab_d1.agregarParrafo(
				"Reservaba atreves metia no libre flagrante ha sexto chi te playa murio usaba guapa menudeaban traia extrana reservaba hable seduciendo van tuviera libre lugar levitas luz ha no. Usaba lugar hay playa perversion crecido reservaba. Ha reservaba deliciosas victorioso libre dia en van en lo traerle flagrante chi mi el hable chi asustados implacable metia renta amigo dia parecio. ");
		sitio.agregarDocumento(reinab_d1);

		Documento encont_d2 = new Documento("Encontrar van reinaba", espanol);
		Parrafo encont_d21 = encont_d2.agregarParrafo("Va crecido guapa usaba luz hay. ");
		Parrafo encont_d22 = encont_d2.agregarParrafo(
				"Da el parecio renta senoras metia te playa crecido metia seduciendo no renta extrana reservaba metia seduciendo tio parecio hable luz va. Atreves menudeaban sexto lo en libre lo atreves usaba deliciosas te chi mi levitas el no van implacable deliciosas lugar bueno menudeaban en. ");
		Parrafo encont_d23 = encont_d2.agregarParrafo("Libre lugar dia asustados encontrar da luz asustados. ");
		Parrafo encont_d24 = encont_d2.agregarParrafo(
				"Amigo playa van va dia le implacable fantasmas tuviera al abrio traerle abrio bueno el traia traia lo hable usaba. Levitas menudeaban hay extrana perversion fantasmas encontrar menudeaban te fantasmas reinaba tuviera reinaba en tuviera va usaba va va es murio atreves reinaba ha traia es menudeaban chi. ");
		Parrafo encont_d25 = encont_d2.agregarParrafo(
				"Hembras hable chi seduciendo las le seduciendo bueno ha atreves no el sexto asustados reservaba lo asustados victorioso en renta traia al encontrar implacable al fantasmas. Deliciosas traerle fantasmas las fantasmas el lugar lo perversion murio lugar murio parecio seduciendo luz sexto le asustados bueno usaba. No atreves el senoras implacable da sexto chi reservaba el playa renta implacable victorioso traerle fantasmas lugar extrana las asustados. Murio bueno abrio menudeaban renta reinaba dia victorioso bueno. ");
		sitio.agregarDocumento(encont_d2);

		Documento horenb_d1 = new Documento("Horen bedeckten wachsamen", aleman);
		Parrafo horenb_d11 = horenb_d1.agregarParrafo(
				"Mi bedeckten te erregt kraftiger in merken te em lust wo erregt wu wachsamen verbergend es. Kammer im verbergend im stockwerke dran kraftiger angst kammer an im mu wo wu so. Norden so im verbergend kraftiger te armeln erregt merken lust zu zu leuchtturm mi. ");
		Parrafo horenb_d12 = horenb_d1.agregarParrafo(
				"Im es te ausblasen kammer in ruth em so kammer erregt wo vorsichtig angst te im wo dran angst nettigkeit es leuchtturm merken erregt zuschauen sich zuschauen mu nach sich. Da ab wo wo ausblasen. So zuschauen zu. ");
		Parrafo horenb_d13 = horenb_d1.agregarParrafo(
				"Verbergend du ab holen du te holen vorsichtig erregt wo armeln wo an ri kraftiger armeln te so wasserkrug groben so angst merken nettigkeit lief groben sich ri nettigkeit duftenden. In te ruth leuchtturm zu zu mi bedeckten wachsamen angst duftenden ri wo wo lust du holen nach em kraftiger dran verbergend im ruth da em dran nach. Horen jungen zu kraftiger dran lust erregt ausblasen norden te horen wo mi an groben lust wachsamen. ");
		Parrafo horenb_d14 = horenb_d1
				.agregarParrafo("Mu so wachsamen horen zu da dran zu. Ausblasen em ab es leuchtturm es. ");
		sitio.agregarDocumento(horenb_d1);

		Documento wozumi_d2 = new Documento("Wo zu mi", aleman);
		Parrafo wozumi_d21 = wozumi_d2.agregarParrafo("Erregt. ");
		Parrafo wozumi_d22 = wozumi_d2.agregarParrafo("Zuschauen. ");
		Parrafo wozumi_d23 = wozumi_d2.agregarParrafo(
				"Bedeckten stockwerke nach da norden te lust norden kraftiger ab jungen es kammer wo ab. Ruth angst. Norden so ab so so du erregt sich norden du merken groben an nettigkeit. Lief du stockwerke wu erregt kammer vorsichtig in kammer so zu zu bedeckten. ");
		Parrafo wozumi_d24 = wozumi_d2.agregarParrafo(
				"Merken norden angst sich leuchtturm norden horen lief stockwerke im lust zu. Mi wachsamen leuchtturm groben norden zuschauen bedeckten kraftiger kammer. Lief dran vorsichtig an mu ab dran angst da kammer ri angst sich. ");
		sitio.agregarDocumento(wozumi_d2);

		Documento melanc_d1 = new Documento("Melancholy rent barton", ingles);
		Parrafo melanc_d11 = melanc_d1.agregarParrafo(
				"Melancholy is add oh but do everything travelling draw barton. Eyes wondered considered afford. ");
		Parrafo melanc_d12 = melanc_d1.agregarParrafo(
				"At sportsman dispatched applauded but afford believing on tall by cultivated possession. ");
		Parrafo melanc_d13 = melanc_d1.agregarParrafo(
				"Melancholy required she collecting everything afford draw extended no shameless face by described no resembled am add do debating collecting perpetual afford applauded collecting feebly must add do on up. Otherwise eyes feebly get rent past shameless. Is feebly everything afford applauded extremity he just at show want astonished barton melancholy want is resembled by feebly everything otherwise must do he incommode. Everything out eyes just shameless up face debating neat at travelling incommode rent required up add collecting just eyes. ");
		Parrafo melanc_d14 = melanc_d1.agregarParrafo(
				"Square new possession draw do did barton man no must up otherwise do change face. Face is debating man rent he get everything collecting by want so melancholy perpetual cultivated feebly cultivated but oh past so square do is neat. Must astonished change rent past square neat he believing draw. ");
		Parrafo melanc_d15 = melanc_d1.agregarParrafo(
				"Believing cultivated past debating eyes dispatched perpetual collecting get astonished did. Out man get square is did but is past dispatched mr did. Get believing mr draw no as mr want draw oh did change astonished is new must past. ");
		Parrafo melanc_d16 = melanc_d1.agregarParrafo(
				"Wondered new so possession cultivated feebly. Did dispatched is square no she mr sportsman wondered collecting square collecting dispatched extended eyes possession want she extremity sportsman on just cultivated dispatched man get on neat possession. He. ");
		sitio.agregarDocumento(melanc_d1);

		Documento justis_d2 = new Documento("Just is no", ingles);
		Parrafo justis_d21 = justis_d2.agregarParrafo(
				"Considered do face travelling otherwise required astonished show wondered everything change considered required possession believing. Sportsman do is resembled afford shameless draw do do is mr. ");
		Parrafo justis_d22 = justis_d2.agregarParrafo(
				"Just debating travelling man possession otherwise everything barton do she otherwise feebly incommode. Show dispatched past cultivated am melancholy neat mr afford wondered square man required is feebly do past afford extremity melancholy man add possession must is as. ");
		Parrafo justis_d23 = justis_d2.agregarParrafo(
				"Up so. Dispatched new neat. Do described considered travelling wondered feebly is draw otherwise believing but change wondered no is tall get she required incommode but is do by. Get considered so out is astonished. ");
		Parrafo justis_d24 = justis_d2.agregarParrafo(
				"But change debating extremity past feebly want is perpetual otherwise eyes must so she is described face considered face tall on but afford draw mr no by. Add is considered must must oh collecting. ");
		sitio.agregarDocumento(justis_d2);

		Documento amrese_d3 = new Documento("Am resembled do", ingles);
		Parrafo amrese_d31 = amrese_d3
				.agregarParrafo("Melancholy did am mr incommode wondered so applauded extremity must. Collecting. ");
		Parrafo amrese_d32 = amrese_d3.agregarParrafo(
				"Believing incommode change is must believing. Feebly do am. Out extremity is but incommode must man am oh travelling is is by oh debating is cultivated show melancholy do but he at possession but believing. Add face get rent applauded feebly at applauded. ");
		Parrafo amrese_d33 = amrese_d3.agregarParrafo(
				"Is wondered considered she past do past dispatched barton just oh afford cultivated get get feebly change otherwise want required sportsman incommode change is. She eyes is applauded neat considered required do incommode extended just as described up change otherwise tall up add mr everything am. Otherwise is no as want barton wondered melancholy man cultivated required travelling cultivated out is do described did draw neat considered. Show neat is travelling rent by but applauded he required dispatched is change by. ");
		Parrafo amrese_d34 = amrese_d3.agregarParrafo(
				"She want he everything get cultivated melancholy up mr square astonished on just is do get change out described perpetual show wondered wondered. Extended astonished no is extremity get mr he dispatched square no eyes melancholy rent wondered did do afford otherwise astonished by applauded show described considered oh melancholy. ");
		Parrafo amrese_d35 = amrese_d3.agregarParrafo(
				"Extended travelling must incommode draw out must barton man everything on sportsman otherwise change melancholy change otherwise travelling considered by. By add everything believing neat cultivated resembled so no get did eyes feebly is believing change man change everything wondered required as do just. Debating described is wondered otherwise just feebly she. ");
		sitio.agregarDocumento(amrese_d3);

		Documento consid_d4 = new Documento("Considered described perpetual", ingles);
		Parrafo consid_d41 = consid_d4.agregarParrafo(
				"Want past on want wondered face perpetual sportsman must past. Dispatched is new new square on. Show feebly she add afford but eyes dispatched neat she by applauded possession feebly did man she neat sportsman no draw he incommode at required at face. No wondered show barton she required by afford believing eyes on otherwise debating shameless is extended just applauded so. ");
		Parrafo consid_d42 = consid_d4.agregarParrafo(
				"Change feebly on feebly possession just required no travelling otherwise do believing extended up up up required. Extended possession. ");
		Parrafo consid_d43 = consid_d4.agregarParrafo(
				"Square face melancholy collecting described past dispatched no neat applauded required extremity is oh up otherwise so she change otherwise afford. New afford as do change perpetual but show get extended show but must applauded eyes incommode show past do he rent. Melancholy wondered extremity get cultivated show must am by is on is neat no past wondered up he otherwise add must applauded believing is collecting dispatched man man so believing. Man past face do otherwise am on he. ");
		Parrafo consid_d44 = consid_d4.agregarParrafo(
				"Extended required as wondered resembled am show feebly. So she is face is wondered change sportsman by oh as wondered extended show applauded at perpetual she must incommode possession is travelling did he described described collecting perpetual do. Extended at afford eyes change incommode barton he no show. ");
		sitio.agregarDocumento(consid_d4);

		Documento pernil_d1 = new Documento("Pernil ma supplicou", portugues);
		Parrafo pernil_d11 = pernil_d1.agregarParrafo(
				"Essencial cousa pernil arrumava liberdade es antes eu antes cousa ficam essencial do salvo brios. Has antes afinal educacao mulheres ficam camillo nao. ");
		Parrafo pernil_d12 = pernil_d1.agregarParrafo(
				"Ficam has camillo ir no pernil apanhar impoe bom brios firmeza gonzos brios portanto fez va mulheres va brios exclamou ma fim no carro senao. ");
		Parrafo pernil_d13 = pernil_d1.agregarParrafo(
				"Cre vivem teremos supplicou alli vivido eu fim ficam pareco. Farca cousa fez salvo iraou baixo exclamou ii com quer faca ii estao vir. ");
		Parrafo pernil_d14 = pernil_d1.agregarParrafo(
				"Mulheres cousa educacao buscaes ma exclamou fez raiva gonzos alli ir paulo. Arrumava paulo buscaes fez vivem raiva farca essencial. ");
		Parrafo pernil_d15 = pernil_d1.agregarParrafo(
				"Vir no uso afinal ii. Arrumava apanhar. Raiva fez va gonzos exclamou teremos firmeza quer nao vivem educacao cre liberdade vir uso mulheres sao liberdade farca sao senao na no gonzos. Fez vivem cousa mulheres arrumava vivem quer teremos farca gremio se faca es ii em bom buscaes alli cousa em camillo teremos pareco firmeza antes antes raiva senao bom fim. ");
		sitio.agregarDocumento(pernil_d1);

		Documento nocrea_d2 = new Documento("No cre apregoam", portugues);
		Parrafo nocrea_d21 = nocrea_d2.agregarParrafo(
				"Vir do cousa vivem essencial va vir apregoam es gremio gonzos paulo ficam paulo essencial mulheres quer. Do buscaes portanto em ama ama pernil cre ii fim eu. Carro sao firmeza supplicou educacao se ii raiva apregoam gremio gremio camillo dor gonzos ma exclamou senao arrumava pareco nao ama salvo do teremos camillo no. Has ii educacao arrumava exclamou sao antes vir antes ir dor gremio gonzos no for mulheres carro eu apanhar censuro censuro estao carro impoe. ");
		Parrafo nocrea_d22 = nocrea_d2.agregarParrafo(
				"Estao liberdade apanhar estao farca ma do supplicou do no faca has farca brios portanto fim fez cousa afinal gremio dor fim do do pareco liberdade bom. Afinal vivem es ficam na baixo estao faca cousa fim. ");
		Parrafo nocrea_d23 = nocrea_d2.agregarParrafo(
				"Senao cre teremos cre no no paulo ir fez salvo impoe buscaes apanhar alli salvo pareco mulheres supplicou. Ii raiva arrumava for dor dor paulo va censuro iraou sao essencial ficam vir brios. Estao se quer pareco camillo educacao apregoam senao va ir. Mulheres es impoe gonzos exclamou es cousa faca pareco do essencial alli em com fim liberdade nao carro senao carro alli pernil portanto salvo pareco se apanhar apregoam vivido. ");
		Parrafo nocrea_d24 = nocrea_d2.agregarParrafo(
				"Ficam essencial farca do dor arrumava exclamou mulheres gremio buscaes pernil dor antes supplicou carro buscaes educacao fim na gremio pernil has impoe. Censuro pareco gonzos vivido paulo baixo gremio liberdade apregoam exclamou faca mulheres ama portanto fim sao firmeza bom nao cousa afinal liberdade. Firmeza iraou farca vivido na ama ficam cre fez salvo bom vir em senao pareco va ii com. ");
		Parrafo nocrea_d25 = nocrea_d2.agregarParrafo(
				"Pernil has alli ir na arrumava gonzos ma senao vivido gonzos paulo vir censuro iraou em gonzos bom for afinal supplicou apanhar cousa. Ma for portanto es quer essencial buscaes pernil fim portanto sao buscaes carro vivido firmeza for. Ii alli dor ama iraou pareco has supplicou dor apanhar raiva baixo eu ir teremos faca. Educacao do ii vir afinal. ");
		Parrafo nocrea_d26 = nocrea_d2.agregarParrafo(
				"Vivem bom do paulo. Estao estao do impoe se paulo educacao vivem. Has arrumava raiva carro firmeza baixo do brios essencial brios bom ficam ii es afinal ii ficam alli brios salvo ii antes fim ir do ma cre impoe arrumava va. ");
		sitio.agregarDocumento(nocrea_d2);

		Documento pareco_d3 = new Documento("Pareco estao farca", portugues);
		Parrafo pareco_d31 = pareco_d3.agregarParrafo(
				"No do dor do arrumava educacao vivido apanhar firmeza. Apanhar teremos teremos senao antes liberdade brios ficam es ii arrumava gremio senao gremio. Gremio gremio pareco mulheres buscaes apregoam exclamou essencial exclamou educacao vir sao com buscaes senao faca pernil es cousa. ");
		Parrafo pareco_d32 = pareco_d3.agregarParrafo(
				"Senao impoe nao buscaes vir quer vivem apregoam camillo vivem ama ma. Supplicou carro pareco ir. Ama essencial na arrumava com. ");
		Parrafo pareco_d33 = pareco_d3.agregarParrafo(
				"Apregoam es fim camillo do ma essencial farca farca teremos mulheres antes no faca liberdade baixo gremio. ");
		Parrafo pareco_d34 = pareco_d3.agregarParrafo(
				"Apanhar cousa afinal se paulo no alli vivem salvo vivido teremos raiva no baixo teremos fez pernil senao ama brios fez vivido mulheres fim dor liberdade firmeza iraou arrumava. Afinal va ii salvo raiva portanto ficam antes afinal senao camillo buscaes has quer na impoe firmeza apregoam. Liberdade carro pareco firmeza farca fez na estao fim arrumava salvo com exclamou raiva pareco vivem se pernil. Bom brios afinal do estao afinal brios. ");
		sitio.agregarDocumento(pareco_d3);

		Documento apanha_d4 = new Documento("Apanhar ii pernil", portugues);
		Parrafo apanha_d41 = apanha_d4
				.agregarParrafo("Censuro do arrumava apanhar apanhar fez buscaes bom va vivem ma fez. ");
		Parrafo apanha_d42 = apanha_d4.agregarParrafo("No ama buscaes. Bom. ");
		Parrafo apanha_d43 = apanha_d4.agregarParrafo(
				"Educacao alli ii pareco alli afinal brios antes uso. Faca afinal pernil apanhar. For firmeza senao ama arrumava dor iraou cousa portanto cousa portanto camillo impoe apanhar brios uso eu sao es em teremos pernil liberdade pernil vivido iraou apanhar ama. ");
		Parrafo apanha_d44 = apanha_d4.agregarParrafo(
				"Raiva raiva gonzos for teremos se supplicou baixo iraou firmeza vir antes gremio alli buscaes cousa pernil no has cre farca com ii ficam dor teremos brios pernil. ");
		Parrafo apanha_d45 = apanha_d4.agregarParrafo(
				"Apanhar ma afinal ma faca exclamou vivem nao fez es do com liberdade nao camillo. Se dor gonzos salvo senao afinal camillo arrumava teremos do salvo liberdade censuro do essencial faca supplicou portanto farca do pernil carro pernil ma fim apanhar. Apanhar brios senao com se has supplicou quer vir farca portanto vivem vivem supplicou pareco do iraou em arrumava portanto faca do buscaes nao. ");
		sitio.agregarDocumento(apanha_d4);

		Documento ficamn_d5 = new Documento("Ficam no com", portugues);
		Parrafo ficamn_d51 = ficamn_d5.agregarParrafo(
				"Raiva sao camillo iraou liberdade paulo alli em vivem for gremio teremos teremos camillo do vivem sao afinal censuro fim portanto em do eu no. ");
		Parrafo ficamn_d52 = ficamn_d5.agregarParrafo(
				"Afinal va afinal fim has liberdade pernil pernil carro essencial sao fez se apregoam raiva impoe pernil salvo alli carro vivem ii buscaes antes alli ir ama paulo. ");
		Parrafo ficamn_d53 = ficamn_d5.agregarParrafo(
				"Nao afinal antes vivido quer ama. Ii baixo ii va antes ii es. Vivido alli vir dor fez nao uso teremos camillo afinal ama gremio pernil paulo apregoam vivido impoe na bom. ");
		Parrafo ficamn_d54 = ficamn_d5.agregarParrafo(
				"Afinal mulheres ii em camillo senao va exclamou camillo afinal vir vivido firmeza gremio supplicou. Vivem raiva senao cousa firmeza ii essencial vir censuro pernil afinal se antes. ");
		Parrafo ficamn_d55 = ficamn_d5.agregarParrafo(
				"Firmeza ir bom nao uso. Estao exclamou afinal estao ii teremos do eu ama ficam quer portanto raiva ama fim has senao estao afinal va dor. Apregoam bom es es pernil ma baixo teremos vivido brios supplicou camillo salvo camillo bom brios eu liberdade. Gremio ir brios pareco impoe farca buscaes ii farca buscaes vivido ir uso essencial estao firmeza se antes iraou antes quer. ");
		Parrafo ficamn_d56 = ficamn_d5.agregarParrafo(
				"Vir eu com estao vir no va na ama nao es no sao va ma vir no educacao fim. Com se eu vivido. Quer eu pernil va educacao dor estao uso gonzos gremio carro portanto buscaes ii apanhar has educacao va. ");
		sitio.agregarDocumento(ficamn_d5);

		Documento repren_d1 = new Documento("Reprendre epouse net", frances);
		Parrafo repren_d11 = repren_d1.agregarParrafo(
				"Six triomphe massacre ah precieux demeurons sur les se preferait les toi toi chantant. ");
		Parrafo repren_d12 = repren_d1.agregarParrafo("Cavernes cet. ");
		Parrafo repren_d13 = repren_d1.agregarParrafo(
				"Six echauffer les epouse traverse sortaient les je triomphe aux toutefois net remettre firmament cavernes net se net je les se et ennemies annees net. Des profonde coupoles eux pourquoi. ");
		Parrafo repren_d14 = repren_d1.agregarParrafo(
				"Prudence ah ennemies palais annees devant des massacre atroce remettre toutefois blason. Prennent art aux des six eux. Art chantant prudence toi traverse traverse prudence precieux. Toi jambes toutefois blason les les reprendre remettre sortaient echauffer epouse preferait sortit annees six massacre massacre aux annees traverse des. ");
		sitio.agregarDocumento(repren_d1);

		Documento pruden_d2 = new Documento("Prudence net precieux", frances);
		Parrafo pruden_d21 = pruden_d2.agregarParrafo(
				"Campagne aux precieux et jambes. Atroce sur cavernes jusque. Eux devant preferait net six chantant annees cet ennemies epouse net des sortit cet les prudence palais jambes se prennent cavernes coupoles se jambes precieux. ");
		Parrafo pruden_d22 = pruden_d2.agregarParrafo(
				"Campagne jusque blason je pourquoi. Echauffer les eux jambes triomphe epouse pourquoi prennent jusque coupoles resterait epouse art on eux toi pourquoi echauffer epouse cet six jambes net. Blason des firmament pas prennent des devant blason palais reprendre triomphe precieux. ");
		Parrafo pruden_d23 = pruden_d2.agregarParrafo("Triomphe art six. ");
		Parrafo pruden_d24 = pruden_d2.agregarParrafo(
				"Or traverse eux remettre jusque pourquoi sortit rendre rendre resterait eux cavernes firmament. Pas rendre eux blason precieux je je. ");
		sitio.agregarDocumento(pruden_d2);

		Documento annees_d3 = new Documento("Annees reprendre preferait", frances);
		Parrafo annees_d31 = annees_d3
				.agregarParrafo("Prudence art art se net je je et echauffer epouse chantant eux cet. ");
		Parrafo annees_d32 = annees_d3.agregarParrafo(
				"Les prennent rendre remettre. Ah net remettre preferait sur rendre. Profonde les resterait cavernes prennent traverse remettre sortit cet les art les soutenir precieux jambes art annees epouse or net. Sortaient pourquoi. ");
		Parrafo annees_d33 = annees_d3.agregarParrafo(
				"Rendre massacre pourquoi palais sur coupoles sortit soutenir art remettre ah triomphe traverse atroce massacre six epouse rendre. Voyage campagne precieux sortit voyage massacre traverse sortaient devant chantant et ennemies chantant annees roc et echauffer pourquoi annees rendre cavernes remettre echauffer echauffer. Triomphe precieux prennent devant coupoles net resterait net atroce je on prudence sa ennemies jambes cavernes triomphe jambes or or ah jusque eux on echauffer sortit. Epouse jusque rendre remettre preferait roc blason devant rendre sortaient precieux prennent. ");
		Parrafo annees_d34 = annees_d3.agregarParrafo(
				"Ennemies resterait on reprendre des demeurons soutenir net les et art prudence prennent sortit six. ");
		sitio.agregarDocumento(annees_d3);

		cal.set(2014, 3, 12);
		Traduccion pareco_d32ByMarth = new Traduccion(cal.getTime(), "Portugues a Frances", true,
				"Traverse sortaient six art on des epouse palais jambes art blason chantant resterait sortaient sa palais se preferait et blason blason. Sa sur rendre jambes les jusque chantant cet palais coupoles pas epouse six prudence prudence aux cet jambes six ah precieux les rendre cet devant reprendre. ",
				pareco_d32, frances);
		marth.agregarTraduccion(pareco_d32ByMarth);
		cal.set(2015, 9, 3);
		Traduccion wozumi_d22ByOsvaldo = new Traduccion(cal.getTime(), "Aleman a Ingles", true,
				"Face did by wondered mr do incommode incommode described at extended rent square tall dispatched mr as did he astonished she do add as draw. So mr astonished draw do tall. ",
				wozumi_d22, ingles);
		osvaldo.agregarTraduccion(wozumi_d22ByOsvaldo);
		cal.set(2015, 3, 10);
		Traduccion repren_d13ByCarolyn = new Traduccion(cal.getTime(), "Frances a Espanol", true,
				"Lo hay abrio reinaba te playa levitas las seduciendo te metia senoras crecido guapa. Implacable seduciendo metia encontrar flagrante le hembras victorioso no abrio luz te da hembras hable da traia tio reservaba hembras victorioso amigo parecio usaba sexto va abrio. Deliciosas las hay tio encontrar parecio reinaba playa ha hembras traia en fantasmas en bueno hable el no. Lo renta va las al es mi perversion no fantasmas encontrar hay lugar parecio lo metia mi guapa traia crecido. ",
				repren_d13, espanol);
		carolyn.agregarTraduccion(repren_d13ByCarolyn);
		cal.set(2014, 4, 17);
		Traduccion horenb_d14ByGertrude = new Traduccion(cal.getTime(), "Aleman a Ingles", true,
				"Extended by travelling up do considered out change change collecting collecting barton extremity but on did considered astonished change astonished is neat. Is neat past considered draw resembled so wondered square do he collecting want he sportsman. ",
				horenb_d14, ingles);
		gertrude.agregarTraduccion(horenb_d14ByGertrude);
		cal.set(2014, 10, 16);
		Traduccion amrese_d33ByEzequiel = new Traduccion(cal.getTime(), "Ingles a Aleman", true,
				"Bedeckten groben wo ri. Wu stockwerke. ", amrese_d33, aleman);
		ezequiel.agregarTraduccion(amrese_d33ByEzequiel);
		una.agregarIdioma(ingles);
		una.agregarIdioma(aleman);
		una.evaluar(amrese_d33ByEzequiel, "Square debating he", 7);
		

		cal.set(2014, 10, 16);
		Traduccion amrese_d31ByEzequiel = new Traduccion(cal.getTime(), "Ingles a Aleman", true,
				"Bedeckten groben wo ri. Wu stockwerke. ", amrese_d31, aleman);
		ezequiel.agregarTraduccion(amrese_d31ByEzequiel);
		cal.set(2014, 10, 16);
		Traduccion amrese_d32ByEzequiel = new Traduccion(cal.getTime(), "Ingles a Aleman", true,
				"Bedeckten groben wo ri. Wu stockwerke. ", amrese_d32, aleman);
		ezequiel.agregarTraduccion(amrese_d32ByEzequiel);
		cal.set(2014, 10, 16);
		Traduccion amrese_d34ByEzequiel = new Traduccion(cal.getTime(), "Ingles a Aleman", true,
				"Bedeckten groben wo ri. Wu stockwerke. ", amrese_d34, aleman);
		ezequiel.agregarTraduccion(amrese_d34ByEzequiel);
		cal.set(2014, 10, 16);
		Traduccion amrese_d35ByEzequiel = new Traduccion(cal.getTime(), "Ingles a Aleman", true,
				"Bedeckten groben wo ri. Wu stockwerke. ", amrese_d35, aleman);
		ezequiel.agregarTraduccion(amrese_d35ByEzequiel);
		
		
		
		
		
		cal.set(2015, 3, 20);
		Traduccion amrese_d35ByMarth = new Traduccion(cal.getTime(), "Ingles a Frances", true,
				"Eux des annees toi ennemies atroce devant cavernes resterait net or les six se prudence net art remettre atroce les on jusque. Pourquoi cet six voyage sortaient art toi firmament or voyage six or echauffer six prudence cet cavernes firmament. Soutenir atroce demeurons firmament sortit des prudence echauffer demeurons roc demeurons or net net des devant toi sortaient atroce ah se devant precieux voyage je. Et precieux et aux coupoles cet. ",
				amrese_d35, frances);
		marth.agregarTraduccion(amrese_d35ByMarth);
		cal.set(2014, 7, 12);
		Traduccion ficamn_d54ByOlin = new Traduccion(cal.getTime(), "Portugues a Ingles", true, "By applauded. ",
				ficamn_d54, ingles);
		olin.agregarTraduccion(ficamn_d54ByOlin);
		martine.agregarIdioma(portugues);
		martine.agregarIdioma(ingles);
		martine.evaluar(ficamn_d54ByOlin, "Do ama va", 1);
		cal.set(2014, 5, 28);
		Traduccion justis_d24ByGertrude = new Traduccion(cal.getTime(), "Ingles a Espanol", true,
				"Bueno ha traia el ha tio encontrar chi traia deliciosas lugar da victorioso le fantasmas encontrar van fantasmas. Senoras tio dia. ",
				justis_d24, espanol);
		gertrude.agregarTraduccion(justis_d24ByGertrude);
		cal.set(2015, 3, 3);
		Traduccion pruden_d24ByMicheline = new Traduccion(cal.getTime(), "Frances a Aleman", true,
				"Wu vorsichtig wo. Vorsichtig wasserkrug merken horen stockwerke an da zuschauen mu wo sich em wu kraftiger du jungen ab in stockwerke ruth kraftiger bedeckten im wo nettigkeit ab. Jungen vorsichtig an em zuschauen vorsichtig lust so wachsamen wo du so so em verbergend. ",
				pruden_d24, aleman);
		micheline.agregarTraduccion(pruden_d24ByMicheline);
		

		cal.set(2015, 3, 3);
		Traduccion pruden_d21ByMicheline = new Traduccion(cal.getTime(), "Frances a Aleman", true,
				"Wu vorsichtig wo. Vorsichtig wasserkrug merken horen stockwerke an da zuschauen mu wo sich em wu kraftiger du jungen ab in stockwerke ruth kraftiger bedeckten im wo nettigkeit ab. Jungen vorsichtig an em zuschauen vorsichtig lust so wachsamen wo du so so em verbergend. ",
				pruden_d21, aleman);
		micheline.agregarTraduccion(pruden_d21ByMicheline);
		cal.set(2015, 3, 3);
		Traduccion pruden_d22ByMicheline = new Traduccion(cal.getTime(), "Frances a Aleman", true,
				"Wu vorsichtig wo. Vorsichtig wasserkrug merken horen stockwerke an da zuschauen mu wo sich em wu kraftiger du jungen ab in stockwerke ruth kraftiger bedeckten im wo nettigkeit ab. Jungen vorsichtig an em zuschauen vorsichtig lust so wachsamen wo du so so em verbergend. ",
				pruden_d22, aleman);
		micheline.agregarTraduccion(pruden_d22ByMicheline);
		cal.set(2015, 3, 3);
		Traduccion pruden_d23ByMicheline = new Traduccion(cal.getTime(), "Frances a Aleman", true,
				"Wu vorsichtig wo. Vorsichtig wasserkrug merken horen stockwerke an da zuschauen mu wo sich em wu kraftiger du jungen ab in stockwerke ruth kraftiger bedeckten im wo nettigkeit ab. Jungen vorsichtig an em zuschauen vorsichtig lust so wachsamen wo du so so em verbergend. ",
				pruden_d23, aleman);
		micheline.agregarTraduccion(pruden_d23ByMicheline);
		
		
		cal.set(2014, 11, 24);
		Traduccion ficamn_d51ByKary = new Traduccion(cal.getTime(), "Portugues a Frances", true,
				"Epouse ah des les les des massacre triomphe ennemies soutenir resterait net voyage eux. ", ficamn_d51,
				frances);
		kary.agregarTraduccion(ficamn_d51ByKary);
		cal.set(2014, 8, 23);
		Traduccion annees_d32ByRonny = new Traduccion(cal.getTime(), "Frances a Aleman", true,
				"Ausblasen lust mi jungen an stockwerke leuchtturm angst lust duftenden zu verbergend mu wo so so. Horen ab mu lief es dran. Armeln wasserkrug ab wu mi. Duftenden wo ruth angst wo verbergend du nach lust mu lief wachsamen in norden duftenden ruth ruth so angst merken leuchtturm. ",
				annees_d32, aleman);
		ronny.agregarTraduccion(annees_d32ByRonny);
		cal.set(2014, 7, 19);
		Traduccion ficamn_d55ByKary = new Traduccion(cal.getTime(), "Portugues a Frances", true,
				"Soutenir rendre et preferait epouse epouse roc cet cavernes sortit je devant triomphe net resterait coupoles palais je resterait. Des prudence six eux aux campagne soutenir on rendre atroce toutefois et ennemies voyage reprendre profonde triomphe preferait echauffer toutefois art. ",
				ficamn_d55, frances);
		kary.agregarTraduccion(ficamn_d55ByKary);
		cal.set(2015, 1, 10);
		Traduccion ficamn_d51BySvetlana = new Traduccion(cal.getTime(), "Portugues a Frances", true,
				"Cet profonde jusque on palais campagne les sortaient or epouse triomphe. Cavernes rendre jusque annees six profonde massacre annees. Demeurons cet six reprendre cet blason art net art toi se. ",
				ficamn_d51, frances);
		svetlana.agregarTraduccion(ficamn_d51BySvetlana);
		cal.set(2015, 0, 21);
		Traduccion repren_d12ByHilma = new Traduccion(cal.getTime(), "Frances a Aleman", true,
				"Bedeckten norden lust zuschauen holen zu nach so bedeckten. Erregt nettigkeit dran groben duftenden so jungen verbergend so duftenden da so zu kammer merken ri so horen. ",
				repren_d12, aleman);
		hilma.agregarTraduccion(repren_d12ByHilma);
		martine.agregarIdioma(frances);
		martine.agregarIdioma(aleman);
		martine.evaluar(repren_d12ByHilma, "Rendre les prennent", 4);
		cal.set(2015, 8, 5);
		Traduccion ficamn_d55ByHilma = new Traduccion(cal.getTime(), "Portugues a Ingles", true,
				"So he barton resembled debating considered do no incommode is so melancholy square described resembled. Extended tall on believing do just barton man travelling eyes is is dispatched otherwise tall is draw. ",
				ficamn_d55, ingles);
		hilma.agregarTraduccion(ficamn_d55ByHilma);
		cal.set(2015, 10, 13);
		Traduccion pruden_d24ByHilma = new Traduccion(cal.getTime(), "Frances a Ingles", true,
				"Get show debating so shameless square so oh cultivated face is neat so do at feebly shameless am collecting am. ",
				pruden_d24, ingles);
		hilma.agregarTraduccion(pruden_d24ByHilma);
		cal.set(2015, 6, 23);
		Traduccion pruden_d23ByOlin = new Traduccion(cal.getTime(), "Frances a Ingles", true,
				"At feebly just incommode but up up must eyes described is astonished she do past eyes is extremity described as up feebly man mr rent feebly considered cultivated out. Is must cultivated did is as cultivated possession perpetual travelling is. Applauded everything face as resembled believing do change so afford at do. No is on is out required sportsman neat is. ",
				pruden_d23, ingles);
		olin.agregarTraduccion(pruden_d23ByOlin);
		jeff.agregarIdioma(frances);
		jeff.agregarIdioma(ingles);
		jeff.evaluar(pruden_d23ByOlin, "Sortit pas et", 8);
		cal.set(2015, 7, 1);
		Traduccion encont_d24ByHilma = new Traduccion(cal.getTime(), "Espanol a Frances", true,
				"Palais on chantant prennent on prudence chantant preferait atroce ah ennemies campagne aux et ennemies pas profonde demeurons aux. Six remettre preferait six on palais remettre les sortaient des annees sortit pourquoi sortit voyage resterait toutefois pas art les atroce eux. Les or net se traverse on demeurons toi campagne se ennemies six resterait net les. Cet sortaient precieux les des eux roc massacre. ",
				encont_d24, frances);
		hilma.agregarTraduccion(encont_d24ByHilma);
		cal.set(2016, 0, 10);
		Traduccion wozumi_d23ByOlin = new Traduccion(cal.getTime(), "Aleman a Frances", true,
				"Demeurons aux demeurons traverse coupoles triomphe chantant eux pourquoi echauffer reprendre. ",
				wozumi_d23, frances);
		olin.agregarTraduccion(wozumi_d23ByOlin);
		cal.set(2014, 7, 29);
		Traduccion reinab_d11ByRonny = new Traduccion(cal.getTime(), "Espanol a Ingles", true,
				"Add so is dispatched rent draw. Rent as eyes is believing must want extremity required neat debating afford past is she get debating up so face just do add extended wondered travelling. ",
				reinab_d11, ingles);
		ronny.agregarTraduccion(reinab_d11ByRonny);
		martine.agregarIdioma(espanol);
		martine.agregarIdioma(ingles);
		martine.evaluar(reinab_d11ByRonny, "En el amigo", 2);
		cal.set(2014, 7, 28);
		Traduccion ficamn_d54BySvetlana = new Traduccion(cal.getTime(), "Portugues a Frances", true,
				"Massacre six massacre atroce eux devant soutenir eux. Voyage traverse les firmament rendre palais ah profonde epouse on aux triomphe pourquoi annees chantant soutenir demeurons eux rendre or echauffer sortit prennent remettre les sa aux se pas pourquoi. ",
				ficamn_d54, frances);
		svetlana.agregarTraduccion(ficamn_d54BySvetlana);
		cal.set(2014, 10, 20);
		Traduccion justis_d22ByGertrude = new Traduccion(cal.getTime(), "Ingles a Espanol", true,
				"Mi asustados tio fantasmas. Levitas reinaba tio en chi tio extrana traia va renta lo chi va chi asustados mi usaba crecido lugar playa mi. Menudeaban bueno atreves chi traia crecido lo usaba libre hembras victorioso lo flagrante guapa seduciendo sexto hable victorioso murio perversion playa hembras bueno reservaba hembras libre victorioso traerle traerle mi. Te crecido le luz al amigo luz las sexto usaba usaba hembras extrana murio va. ",
				justis_d22, espanol);
		gertrude.agregarTraduccion(justis_d22ByGertrude);
		una.agregarIdioma(ingles);
		una.agregarIdioma(espanol);
		una.evaluar(justis_d22ByGertrude, "Melancholy on square", 4);
		cal.set(2015, 5, 23);
		Traduccion ficamn_d54ByHilma = new Traduccion(cal.getTime(), "Portugues a Aleman", true,
				"Te sich vorsichtig wachsamen te duftenden vorsichtig duftenden kammer vorsichtig wo wo mu. Nettigkeit du da zuschauen so angst so dran wo sich so dran so mu im mi ruth dran in. ",
				ficamn_d54, aleman);
		hilma.agregarTraduccion(ficamn_d54ByHilma);
		cal.set(2015, 3, 16);
		Traduccion horenb_d12ByCarolyn = new Traduccion(cal.getTime(), "Aleman a Frances", true,
				"Des pourquoi et triomphe or or or epouse devant precieux les ennemies traverse et pourquoi massacre cet prennent firmament sortaient six toi. ",
				horenb_d12, frances);
		carolyn.agregarTraduccion(horenb_d12ByCarolyn);
		cal.set(2014, 9, 26);
		Traduccion encont_d22BySvetlana = new Traduccion(cal.getTime(), "Espanol a Portugues", true,
				"Liberdade vivido brios vir do ii na fim com raiva supplicou educacao gonzos pareco do alli essencial has dor camillo. Portanto apanhar com firmeza na vivem carro uso impoe has nao ma vir censuro na mulheres va gremio va educacao. Quer fim baixo raiva vivido bom no vir com se fim liberdade alli portanto apregoam ma em ii estao firmeza vivem censuro do arrumava ma dor salvo exclamou buscaes raiva. Iraou teremos apregoam mulheres fim vir senao senao. ",
				encont_d22, portugues);
		svetlana.agregarTraduccion(encont_d22BySvetlana);
		una.agregarIdioma(espanol);
		una.agregarIdioma(portugues);
		una.evaluar(encont_d22BySvetlana, "Amigo parecio en", 2);
		cal.set(2015, 8, 23);
		Traduccion pareco_d33BySvetlana = new Traduccion(cal.getTime(), "Portugues a Aleman", true,
				"Nettigkeit wo wo horen wasserkrug zuschauen an dran sich wo horen du em du so wo in wasserkrug wu lust kammer em groben jungen wo ruth mi lief. Leuchtturm so so an so ruth vorsichtig jungen so wachsamen dran an wachsamen jungen so em mu. Sich in. Im lust mi du mi zuschauen kraftiger mi merken sich groben im wo ab te sich so ri im. ",
				pareco_d33, aleman);
		svetlana.agregarTraduccion(pareco_d33BySvetlana);
		cal.set(2014, 10, 20);
		Traduccion horenb_d13ByHilma = new Traduccion(cal.getTime(), "Aleman a Frances", true,
				"Et cet et blason massacre toutefois annees eux profonde traverse traverse sortit traverse preferait toutefois triomphe les six je je sortaient toutefois jambes campagne remettre demeurons. Devant blason epouse sortit toutefois les annees toutefois six reprendre remettre prennent six coupoles chantant voyage profonde traverse. Se ennemies preferait annees voyage devant art toi soutenir art les pas se je coupoles massacre. On art des sortaient ah ennemies et blason pas eux soutenir cet. ",
				horenb_d13, frances);
		hilma.agregarTraduccion(horenb_d13ByHilma);
		cal.set(2015, 9, 11);
		Traduccion wozumi_d22ByMicheline = new Traduccion(cal.getTime(), "Aleman a Ingles", true,
				"Neat new resembled do by extended considered is am dispatched extremity extremity just mr. ",
				wozumi_d22, ingles);
		micheline.agregarTraduccion(wozumi_d22ByMicheline);
		cal.set(2015, 6, 3);
		Traduccion encont_d25ByAgueda = new Traduccion(cal.getTime(), "Espanol a Portugues", true,
				"Quer apanhar es do vivido uso fim bom iraou brios baixo farca ii carro apanhar educacao apregoam nao es. Cousa sao portanto ficam com bom no com paulo cousa senao na apanhar apanhar vivem gremio for. Ama do se buscaes paulo apanhar na salvo vivem baixo vivem liberdade buscaes nao dor has portanto ma apanhar raiva ii carro sao raiva ir raiva ficam ficam. ",
				encont_d25, portugues);
		agueda.agregarTraduccion(encont_d25ByAgueda);
		cal.set(2015, 10, 13);
		Traduccion wozumi_d23ByEzequiel = new Traduccion(cal.getTime(), "Aleman a Espanol", true,
				"Playa es mi reservaba hable abrio extrana bueno tuviera traia victorioso reservaba da reinaba asustados parecio reservaba implacable atreves al playa el chi mi libre da reinaba es. Atreves sexto traia traerle playa es traia las mi al tio ha traia metia metia perversion. Crecido usaba traerle abrio tuviera luz lo reservaba chi crecido. ",
				wozumi_d23, espanol);
		ezequiel.agregarTraduccion(wozumi_d23ByEzequiel);
		martine.agregarIdioma(aleman);
		martine.agregarIdioma(espanol);
		martine.evaluar(wozumi_d23ByEzequiel, "Nach so norden", 7);
		cal.set(2015, 3, 26);
		Traduccion melanc_d15ByShila = new Traduccion(cal.getTime(), "Ingles a Aleman", true,
				"Ruth da ruth groben wo wachsamen armeln em ruth horen duftenden horen nach mu wo te jungen lust. ",
				melanc_d15, aleman);
		shila.agregarTraduccion(melanc_d15ByShila);
		cal.set(2015, 9, 22);
		Traduccion apanha_d41ByAgueda = new Traduccion(cal.getTime(), "Portugues a Aleman", true,
				"Jungen nach leuchtturm stockwerke duftenden jungen kammer es kammer lief so ri duftenden. Kraftiger zuschauen wo nettigkeit. Ausblasen dran du so nach nettigkeit lief jungen so ab nach wo wu nettigkeit angst so ruth es dran es ab. ",
				apanha_d41, aleman);
		agueda.agregarTraduccion(apanha_d41ByAgueda);
		cal.set(2015, 5, 3);
		Traduccion pernil_d13ByAgueda = new Traduccion(cal.getTime(), "Portugues a Espanol", true,
				"Chi parecio van te el. Perversion en reservaba en da te murio te en tio traerle encontrar las da ha no guapa senoras tuviera. Perversion hay implacable hay el atreves dia playa murio libre atreves perversion reservaba ha traia deliciosas fantasmas parecio van no encontrar. ",
				pernil_d13, espanol);
		agueda.agregarTraduccion(pernil_d13ByAgueda);
		minnie.agregarIdioma(portugues);
		minnie.agregarIdioma(espanol);
		minnie.evaluar(pernil_d13ByAgueda, "Iraou do uso", 10);
		cal.set(2015, 3, 4);
		Traduccion pernil_d15ByAgueda = new Traduccion(cal.getTime(), "Portugues a Frances", true,
				"Six jusque soutenir prennent remettre chantant sortaient art net chantant je. Sa rendre massacre toutefois atroce six jusque six les demeurons coupoles eux profonde et reprendre ennemies sa demeurons six roc roc des se jusque campagne aux et soutenir prennent sur. Prudence demeurons on les. ",
				pernil_d15, frances);
		agueda.agregarTraduccion(pernil_d15ByAgueda);
		cal.set(2016, 0, 21);
		Traduccion ficamn_d52ByOsvaldo = new Traduccion(cal.getTime(), "Portugues a Espanol", true,
				"Hable luz mi playa usaba traerle implacable. Menudeaban playa usaba guapa flagrante le las guapa lugar el libre abrio es lo dia mi asustados extrana en victorioso implacable hembras encontrar ha lugar luz bueno sexto mi levitas. ",
				ficamn_d52, espanol);
		osvaldo.agregarTraduccion(ficamn_d52ByOsvaldo);
		jeff.agregarIdioma(portugues);
		jeff.agregarIdioma(espanol);
		jeff.evaluar(ficamn_d52ByOsvaldo, "Apanhar has gremio", 10);
		cal.set(2014, 9, 15);
		Traduccion encont_d22ByAgueda = new Traduccion(cal.getTime(), "Espanol a Portugues", true,
				"Supplicou firmeza quer eu gonzos com estao com brios impoe portanto ir em com. Uso cousa ama antes for carro na quer vir farca pernil afinal se nao ma essencial apregoam vir faca paulo es pernil quer gonzos. Alli apanhar exclamou censuro. Iraou ficam na gonzos vivem. ",
				encont_d22, portugues);
		agueda.agregarTraduccion(encont_d22ByAgueda);
		una.agregarIdioma(espanol);
		una.agregarIdioma(portugues);
		una.evaluar(encont_d22ByAgueda, "Seduciendo va fantasmas", 3);
		cal.set(2014, 4, 6);
		Traduccion justis_d22ByMarth = new Traduccion(cal.getTime(), "Ingles a Portugues", true,
				"Na fim es antes eu ficam carro teremos na no apanhar paulo buscaes dor se do dor quer. Em es ma gremio va cre essencial baixo va paulo liberdade has brios portanto supplicou afinal censuro impoe ama com ii estao raiva essencial eu apanhar ama ama na. Vivido educacao brios em raiva senao quer sao cre va fim pernil firmeza uso has cre supplicou do ii carro paulo teremos baixo nao faca faca brios se educacao. Vivem dor raiva senao exclamou eu iraou cousa em camillo fez. ",
				justis_d22, portugues);
		marth.agregarTraduccion(justis_d22ByMarth);
		minnie.agregarIdioma(ingles);
		minnie.agregarIdioma(portugues);
		minnie.evaluar(justis_d22ByMarth, "Otherwise considered feebly", 9);
		cal.set(2015, 10, 4);
		Traduccion nocrea_d25ByCarolyn = new Traduccion(cal.getTime(), "Portugues a Frances", true,
				"Je profonde je net jambes eux annees cavernes. Six cavernes se coupoles palais sortit sa profonde jusque six chantant toi blason des voyage sortaient pourquoi blason cet sa je voyage massacre jusque sur on precieux six reprendre. ",
				nocrea_d25, frances);
		carolyn.agregarTraduccion(nocrea_d25ByCarolyn);
		cal.set(2015, 7, 13);
		Traduccion pernil_d13ByAdrien = new Traduccion(cal.getTime(), "Portugues a Ingles", true,
				"Astonished dispatched so on collecting barton afford cultivated shameless mr get by extremity resembled no collecting incommode astonished collecting tall tall believing past. New no travelling at oh collecting incommode mr but do mr is must do must astonished believing incommode shameless astonished wondered shameless up show. But do want am man dispatched dispatched dispatched rent on do neat perpetual new want just shameless on do sportsman. ",
				pernil_d13, ingles);
		adrien.agregarTraduccion(pernil_d13ByAdrien);
		martine.agregarIdioma(portugues);
		martine.agregarIdioma(ingles);
		martine.evaluar(pernil_d13ByAdrien, "Antes buscaes faca", 7);
		cal.set(2015, 4, 9);
		Traduccion pareco_d34ByMicheline = new Traduccion(cal.getTime(), "Portugues a Frances", true,
				"Firmament profonde devant roc cet demeurons annees pas pas traverse sortit et toutefois net rendre profonde. Des pourquoi chantant echauffer ennemies voyage. Rendre echauffer voyage net reprendre coupoles cet sortit pourquoi on pourquoi atroce. ",
				pareco_d34, frances);
		micheline.agregarTraduccion(pareco_d34ByMicheline);
		cal.set(2016, 0, 24);
		Traduccion justis_d23BySvetlana = new Traduccion(cal.getTime(), "Ingles a Portugues", true,
				"For ir na cre has teremos mulheres baixo farca fim dor camillo afinal faca camillo vivido arrumava. No camillo impoe na liberdade salvo exclamou ir fim va pareco cre uso arrumava ii eu sao. ",
				justis_d23, portugues);
		svetlana.agregarTraduccion(justis_d23BySvetlana);
		cal.set(2015, 11, 17);
		Traduccion ficamn_d52ByMarth = new Traduccion(cal.getTime(), "Portugues a Aleman", true,
				"Mi. Nettigkeit an ausblasen so wasserkrug verbergend jungen lust da sich kammer sich. Du holen wo ausblasen kammer da mu leuchtturm ri in duftenden jungen so vorsichtig erregt vorsichtig em nach bedeckten da lief zu ausblasen wasserkrug. So merken an wo armeln sich verbergend wo ruth an kammer wo du dran erregt vorsichtig nach nach angst im vorsichtig wo mi nettigkeit armeln leuchtturm duftenden so. ",
				ficamn_d52, aleman);
		marth.agregarTraduccion(ficamn_d52ByMarth);
		martine.agregarIdioma(portugues);
		martine.agregarIdioma(aleman);
		martine.evaluar(ficamn_d52ByMarth, "Do gonzos es", 3);
		cal.set(2015, 6, 2);
		Traduccion repren_d11ByShila = new Traduccion(cal.getTime(), "Frances a Espanol", true,
				"Traia seduciendo en renta traia. ", repren_d11, espanol);
		shila.agregarTraduccion(repren_d11ByShila);
		cal.set(2015, 10, 7);
		Traduccion annees_d32ByClaire = new Traduccion(cal.getTime(), "Frances a Ingles", true,
				"On is applauded no on resembled oh considered eyes so believing cultivated applauded new new dispatched she feebly eyes perpetual incommode at draw perpetual is new neat did on do. Up sportsman believing she as past is perpetual is want new perpetual oh am but possession so by travelling must as do just incommode barton astonished extended possession. Face she show get collecting melancholy collecting is perpetual afford get past show up change cultivated considered incommode. Wondered everything want required did so described is cultivated tall wondered considered do she past shameless out must required resembled neat resembled collecting. ",
				annees_d32, ingles);
		claire.agregarTraduccion(annees_d32ByClaire);
		cal.set(2014, 9, 17);
		Traduccion reinab_d14ByEzequiel = new Traduccion(cal.getTime(), "Espanol a Ingles", true,
				"Resembled draw mr. Rent she neat wondered possession collecting he square astonished square eyes is do perpetual past collecting perpetual get melancholy travelling did. ",
				reinab_d14, ingles);
		ezequiel.agregarTraduccion(reinab_d14ByEzequiel);
		cal.set(2015, 2, 24);
		Traduccion horenb_d12ByRonny = new Traduccion(cal.getTime(), "Aleman a Portugues", true,
				"Do buscaes apregoam uso liberdade exclamou ii bom vivido fez uso apregoam senao for camillo bom liberdade ficam alli teremos carro va ii for portanto na es buscaes. Com afinal estao raiva em cousa fez buscaes for apanhar vivem liberdade camillo dor gonzos cre se gonzos ficam gremio afinal liberdade baixo. Salvo do ir no ii educacao apanhar impoe eu pernil camillo na antes raiva alli es teremos liberdade supplicou. Bom nao pareco exclamou exclamou censuro vivem com ma exclamou essencial estao censuro ir afinal teremos ma quer fez ii fim bom ficam ii. ",
				horenb_d12, portugues);
		ronny.agregarTraduccion(horenb_d12ByRonny);
		cal.set(2015, 0, 1);
		Traduccion reinab_d13ByClaire = new Traduccion(cal.getTime(), "Espanol a Ingles", true,
				"Eyes eyes do change mr possession otherwise. Eyes eyes is he as extended required on is described he extended described he considered astonished considered neat sportsman. ",
				reinab_d13, ingles);
		claire.agregarTraduccion(reinab_d13ByClaire);
		martine.agregarIdioma(espanol);
		martine.agregarIdioma(ingles);
		martine.evaluar(reinab_d13ByClaire, "Usaba va fantasmas", 6);
		cal.set(2015, 3, 1);
		Traduccion horenb_d13BySvetlana = new Traduccion(cal.getTime(), "Aleman a Frances", true,
				"Epouse cavernes six precieux net pourquoi pas sortit rendre les les art ah echauffer je rendre firmament voyage jusque precieux blason or traverse. Sortit roc voyage jambes cet preferait chantant et des roc se palais sur echauffer firmament blason blason or palais soutenir atroce eux or devant roc rendre annees epouse. Reprendre ennemies eux coupoles pourquoi ah on campagne ennemies six precieux ennemies cavernes toutefois pourquoi pourquoi et sortit annees six sa. Ah massacre pas. ",
				horenb_d13, frances);
		svetlana.agregarTraduccion(horenb_d13BySvetlana);
		cal.set(2015, 5, 29);
		Traduccion pareco_d31ByRemedios = new Traduccion(cal.getTime(), "Portugues a Frances", true,
				"Sortaient soutenir art aux echauffer rendre se cavernes soutenir chantant firmament precieux soutenir pas reprendre toutefois profonde campagne blason preferait prennent sortit toi preferait pourquoi or net. Coupoles six annees firmament. ",
				pareco_d31, frances);
		remedios.agregarTraduccion(pareco_d31ByRemedios);
		jeff.agregarIdioma(portugues);
		jeff.agregarIdioma(frances);
		jeff.evaluar(pareco_d31ByRemedios, "Buscaes vir ma", 4);
		
		cal.set(2015, 8, 3);
		for	(Evaluacion evaluacion : martine.getEvaluaciones())
			evaluacion.setFecha(cal.getTime());
		cal.set(2015, 0, 1);
		for	(Evaluacion evaluacion : una.getEvaluaciones())
			evaluacion.setFecha(cal.getTime());
		cal.set(2015, 11, 12);
		for	(Evaluacion evaluacion : minnie.getEvaluaciones())
			evaluacion.setFecha(cal.getTime());
		cal.set(2015, 0, 1);
		minnie.getEvaluaciones().iterator().next().setFecha(cal.getTime());
		cal.set(2015, 5, 10);
		for	(Evaluacion evaluacion : jeff.getEvaluaciones())
			evaluacion.setFecha(cal.getTime());
		

		Curso lugare1 = new Curso("Lugar el reservaba renta seduciendo", espanol, 3);
		Leccion lugare11 = new Leccion(
				"Traerle guapa seduciendo es reservaba seduciendo crecido hembras luz victorioso");
		lugare1.agregarLeccion(lugare11);
		Leccion lugare12 = new Leccion(
				"Senoras bueno extrana flagrante tuviera victorioso menudeaban parecio bueno las");
		lugare1.agregarLeccion(lugare12);
		sitio.agregarCurso(lugare1);

		Curso lolose2 = new Curso("Lo lo senoras hable es", espanol, 1);
		Leccion lolose21 = new Leccion("Fantasmas mi van parecio libre traerle ha hembras lugar fantasmas");
		lolose2.agregarLeccion(lolose21);
		Leccion lolose22 = new Leccion("Da lugar van traia tio crecido al flagrante no libre");
		lolose2.agregarLeccion(lolose22);
		sitio.agregarCurso(lolose2);

		Curso nohame3 = new Curso("No ha menudeaban seduciendo chi", espanol, 1);
		Leccion nohame31 = new Leccion("Chi luz usaba dia reinaba victorioso extrana le va encontrar");
		nohame3.agregarLeccion(nohame31);
		Leccion nohame32 = new Leccion("Te tuviera usaba traerle implacable levitas guapa las menudeaban van");
		nohame3.agregarLeccion(nohame32);
		Leccion nohame33 = new Leccion("Atreves va implacable va hembras traia en lugar senoras renta");
		nohame3.agregarLeccion(nohame33);
		sitio.agregarCurso(nohame3);

		Curso tioami4 = new Curso("Tio amigo tuviera es hay", espanol, 3);
		Leccion tioami41 = new Leccion("En libre guapa murio reservaba extrana reservaba fantasmas es te");
		tioami4.agregarLeccion(tioami41);
		Leccion tioami42 = new Leccion("Traia chi tuviera fantasmas traerle deliciosas traia traia renta guapa");
		tioami4.agregarLeccion(tioami42);
		Leccion tioami43 = new Leccion("Guapa va en victorioso traerle ha playa atreves asustados van");
		tioami4.agregarLeccion(tioami43);
		sitio.agregarCurso(tioami4);

		Curso hahabl5 = new Curso("Ha hable en asustados mi", espanol, 2);
		Leccion hahabl51 = new Leccion("Tuviera es fantasmas libre reinaba usaba crecido las implacable tio");
		hahabl5.agregarLeccion(hahabl51);
		Leccion hahabl52 = new Leccion("Amigo no libre ha victorioso guapa guapa asustados en senoras");
		hahabl5.agregarLeccion(hahabl52);
		Leccion hahabl53 = new Leccion("No dia reinaba parecio amigo asustados menudeaban en extrana ha");
		hahabl5.agregarLeccion(hahabl53);
		Leccion hahabl54 = new Leccion("En luz en libre van reservaba ha flagrante murio ha");
		hahabl5.agregarLeccion(hahabl54);
		sitio.agregarCurso(hahabl5);
		cal.set(2015, 8, 15);
		Cursada claireClolose2 = new Cursada(lolose2, cal.getTime(), claire);
		Prueba claireTakeslolose22 = new Prueba(lolose22, 93);
		claireClolose2.agregarPrueba(claireTakeslolose22);
		cal.set(2015, 2, 31);
		Cursada hilmaChahabl5 = new Cursada(hahabl5, cal.getTime(), hilma);
		Prueba hilmaTakeshahabl52 = new Prueba(hahabl52, 21);
		hilmaChahabl5.agregarPrueba(hilmaTakeshahabl52);
		Prueba hilmaTakeshahabl51 = new Prueba(hahabl51, 40);
		hilmaChahabl5.agregarPrueba(hilmaTakeshahabl51);
		Prueba hilmaTakeshahabl53 = new Prueba(hahabl53, 96);
		hilmaChahabl5.agregarPrueba(hilmaTakeshahabl53);
		cal.set(2014, 8, 21);
		Cursada ezequielCtioami4 = new Cursada(tioami4, cal.getTime(), ezequiel);
		Prueba ezequielTakestioami41 = new Prueba(tioami41, 69);
		ezequielCtioami4.agregarPrueba(ezequielTakestioami41);
		cal.set(2015, 8, 29);
		Cursada svetlanaCnohame3 = new Cursada(nohame3, cal.getTime(), svetlana);
		Prueba svetlanaTakesnohame31 = new Prueba(nohame31, 78);
		svetlanaCnohame3.agregarPrueba(svetlanaTakesnohame31);
		cal.set(2015, 4, 12);
		Cursada svetlanaClolose2 = new Cursada(lolose2, cal.getTime(), svetlana);
		Prueba svetlanaTakeslolose22 = new Prueba(lolose22, 39);
		svetlanaClolose2.agregarPrueba(svetlanaTakeslolose22);
		Prueba svetlanaTakeslolose21 = new Prueba(lolose21, 45);
		svetlanaClolose2.agregarPrueba(svetlanaTakeslolose21);
		cal.set(2015, 9, 6);
		Cursada karyChahabl5 = new Cursada(hahabl5, cal.getTime(), kary);
		Prueba karyTakeshahabl53 = new Prueba(hahabl53, 97);
		karyChahabl5.agregarPrueba(karyTakeshahabl53);
		Prueba karyTakeshahabl52 = new Prueba(hahabl52, 79);
		karyChahabl5.agregarPrueba(karyTakeshahabl52);
		cal.set(2014, 8, 30);
		Cursada adrienCtioami4 = new Cursada(tioami4, cal.getTime(), adrien);
		Prueba adrienTakestioami41 = new Prueba(tioami41, 29);
		adrienCtioami4.agregarPrueba(adrienTakestioami41);
		Prueba adrienTakestioami43 = new Prueba(tioami43, 23);
		adrienCtioami4.agregarPrueba(adrienTakestioami43);
		Prueba adrienTakestioami42 = new Prueba(tioami42, 33);
		adrienCtioami4.agregarPrueba(adrienTakestioami42);
		cal.set(2014, 11, 23);
		Cursada adrienCnohame3 = new Cursada(nohame3, cal.getTime(), adrien);
		Prueba adrienTakesnohame32 = new Prueba(nohame32, 95);
		adrienCnohame3.agregarPrueba(adrienTakesnohame32);
		Prueba adrienTakesnohame33 = new Prueba(nohame33, 87);
		adrienCnohame3.agregarPrueba(adrienTakesnohame33);
		cal.set(2015, 1, 18);
		Cursada gertrudeCnohame3 = new Cursada(nohame3, cal.getTime(), gertrude);
		Prueba gertrudeTakesnohame33 = new Prueba(nohame33, 85);
		gertrudeCnohame3.agregarPrueba(gertrudeTakesnohame33);
		Prueba gertrudeTakesnohame32 = new Prueba(nohame32, 68);
		gertrudeCnohame3.agregarPrueba(gertrudeTakesnohame32);
		Prueba gertrudeTakesnohame31 = new Prueba(nohame31, 49);
		gertrudeCnohame3.agregarPrueba(gertrudeTakesnohame31);
		cal.set(2016, 3, 2);
		Cursada gertrudeClugare1 = new Cursada(lugare1, cal.getTime(), gertrude);
		Prueba gertrudeTakeslugare12 = new Prueba(lugare12, 87);
		gertrudeClugare1.agregarPrueba(gertrudeTakeslugare12);
		cal.set(2015, 11, 24);
		Cursada gertrudeCtioami4 = new Cursada(tioami4, cal.getTime(), gertrude);
		Prueba gertrudeTakestioami41 = new Prueba(tioami41, 23);
		gertrudeCtioami4.agregarPrueba(gertrudeTakestioami41);
		cal.set(2015, 6, 9);
		Cursada michelineChahabl5 = new Cursada(hahabl5, cal.getTime(), micheline);
		Prueba michelineTakeshahabl51 = new Prueba(hahabl51, 37);
		michelineChahabl5.agregarPrueba(michelineTakeshahabl51);
		Prueba michelineTakeshahabl54 = new Prueba(hahabl54, 49);
		michelineChahabl5.agregarPrueba(michelineTakeshahabl54);
		cal.set(2015, 7, 3);
		Cursada michelineCnohame3 = new Cursada(nohame3, cal.getTime(), micheline);
		Prueba michelineTakesnohame32 = new Prueba(nohame32, 77);
		michelineCnohame3.agregarPrueba(michelineTakesnohame32);
		Prueba michelineTakesnohame33 = new Prueba(nohame33, 74);
		michelineCnohame3.agregarPrueba(michelineTakesnohame33);
		cal.set(2016, 2, 12);
		Cursada michelineClugare1 = new Cursada(lugare1, cal.getTime(), micheline);
		Prueba michelineTakeslugare12 = new Prueba(lugare12, 77);
		michelineClugare1.agregarPrueba(michelineTakeslugare12);
		Prueba michelineTakeslugare11 = new Prueba(lugare11, 78);
		michelineClugare1.agregarPrueba(michelineTakeslugare11);
		cal.set(2016, 2, 10);
		Cursada michelineClolose2 = new Cursada(lolose2, cal.getTime(), micheline);
		Prueba michelineTakeslolose21 = new Prueba(lolose21, 58);
		michelineClolose2.agregarPrueba(michelineTakeslolose21);
		Prueba michelineTakeslolose22 = new Prueba(lolose22, 90);
		michelineClolose2.agregarPrueba(michelineTakeslolose22);

		Curso imstoc1 = new Curso("Im stockwerke ab jungen an", aleman, 2);
		Leccion imstoc11 = new Leccion("Wo horen zu merken sich zu merken so ri wo");
		imstoc1.agregarLeccion(imstoc11);
		Leccion imstoc12 = new Leccion("Zu vorsichtig wachsamen leuchtturm im holen horen da armeln so");
		imstoc1.agregarLeccion(imstoc12);
		sitio.agregarCurso(imstoc1);

		Curso soausb2 = new Curso("So ausblasen armeln lust wo", aleman, 2);
		Leccion soausb21 = new Leccion("Verbergend im so wu stockwerke groben so wachsamen leuchtturm kraftiger");
		soausb2.agregarLeccion(soausb21);
		Leccion soausb22 = new Leccion("Zu armeln kammer norden ausblasen armeln an stockwerke wo te");
		soausb2.agregarLeccion(soausb22);
		Leccion soausb23 = new Leccion("Zu es so wo an kraftiger holen angst wu norden");
		soausb2.agregarLeccion(soausb23);
		sitio.agregarCurso(soausb2);

		Curso woimda3 = new Curso("Wo im da leuchtturm dran", aleman, 3);
		Leccion woimda31 = new Leccion("Leuchtturm wasserkrug norden lust wo wo duftenden verbergend bedeckten wo");
		woimda3.agregarLeccion(woimda31);
		Leccion woimda32 = new Leccion("Te em te zu mu merken angst vorsichtig groben so");
		woimda3.agregarLeccion(woimda32);
		Leccion woimda33 = new Leccion("Angst da ab wo da kammer du verbergend zu wasserkrug");
		woimda3.agregarLeccion(woimda33);
		sitio.agregarCurso(woimda3);

		Curso rizuka4 = new Curso("Ri zu kammer leuchtturm holen", aleman, 1);
		Leccion rizuka41 = new Leccion("Leuchtturm ab holen groben sich norden vorsichtig wasserkrug armeln lief");
		rizuka4.agregarLeccion(rizuka41);
		Leccion rizuka42 = new Leccion("Armeln im wo zuschauen horen lief zu lief wo wachsamen");
		rizuka4.agregarLeccion(rizuka42);
		Leccion rizuka43 = new Leccion("Duftenden an lust zu kraftiger ruth so ruth an in");
		rizuka4.agregarLeccion(rizuka43);
		Leccion rizuka44 = new Leccion("Wachsamen ab lief lief zu mi im em kraftiger verbergend");
		rizuka4.agregarLeccion(rizuka44);
		sitio.agregarCurso(rizuka4);
		cal.set(2015, 3, 2);
		Cursada ronnyCwoimda3 = new Cursada(woimda3, cal.getTime(), ronny);
		Prueba ronnyTakeswoimda32 = new Prueba(woimda32, 65);
		ronnyCwoimda3.agregarPrueba(ronnyTakeswoimda32);
		Prueba ronnyTakeswoimda31 = new Prueba(woimda31, 41);
		ronnyCwoimda3.agregarPrueba(ronnyTakeswoimda31);
		cal.set(2016, 2, 15);
		Cursada ronnyCrizuka4 = new Cursada(rizuka4, cal.getTime(), ronny);
		Prueba ronnyTakesrizuka41 = new Prueba(rizuka41, 36);
		ronnyCrizuka4.agregarPrueba(ronnyTakesrizuka41);
		Prueba ronnyTakesrizuka43 = new Prueba(rizuka43, 40);
		ronnyCrizuka4.agregarPrueba(ronnyTakesrizuka43);
		Prueba ronnyTakesrizuka42 = new Prueba(rizuka42, 40);
		ronnyCrizuka4.agregarPrueba(ronnyTakesrizuka42);
		cal.set(2015, 0, 4);
		Cursada ronnyCsoausb2 = new Cursada(soausb2, cal.getTime(), ronny);
		Prueba ronnyTakessoausb21 = new Prueba(soausb21, 72);
		ronnyCsoausb2.agregarPrueba(ronnyTakessoausb21);
		Prueba ronnyTakessoausb23 = new Prueba(soausb23, 53);
		ronnyCsoausb2.agregarPrueba(ronnyTakessoausb23);
		cal.set(2015, 2, 19);
		Cursada carolynCimstoc1 = new Cursada(imstoc1, cal.getTime(), carolyn);
		Prueba carolynTakesimstoc11 = new Prueba(imstoc11, 51);
		carolynCimstoc1.agregarPrueba(carolynTakesimstoc11);
		Prueba carolynTakesimstoc12 = new Prueba(imstoc12, 42);
		carolynCimstoc1.agregarPrueba(carolynTakesimstoc12);
		cal.set(2015, 5, 25);
		Cursada carolynCwoimda3 = new Cursada(woimda3, cal.getTime(), carolyn);
		Prueba carolynTakeswoimda33 = new Prueba(woimda33, 66);
		carolynCwoimda3.agregarPrueba(carolynTakeswoimda33);
		Prueba carolynTakeswoimda32 = new Prueba(woimda32, 66);
		carolynCwoimda3.agregarPrueba(carolynTakeswoimda32);
		Prueba carolynTakeswoimda31 = new Prueba(woimda31, 58);
		carolynCwoimda3.agregarPrueba(carolynTakeswoimda31);
		cal.set(2015, 7, 13);
		Cursada karyCwoimda3 = new Cursada(woimda3, cal.getTime(), kary);
		Prueba karyTakeswoimda31 = new Prueba(woimda31, 87);
		karyCwoimda3.agregarPrueba(karyTakeswoimda31);
		cal.set(2016, 1, 2);
		Cursada karyCrizuka4 = new Cursada(rizuka4, cal.getTime(), kary);
		Prueba karyTakesrizuka44 = new Prueba(rizuka44, 28);
		karyCrizuka4.agregarPrueba(karyTakesrizuka44);
		cal.set(2014, 7, 3);
		Cursada karyCsoausb2 = new Cursada(soausb2, cal.getTime(), kary);
		Prueba karyTakessoausb22 = new Prueba(soausb22, 96);
		karyCsoausb2.agregarPrueba(karyTakessoausb22);
		Prueba karyTakessoausb23 = new Prueba(soausb23, 63);
		karyCsoausb2.agregarPrueba(karyTakessoausb23);
		cal.set(2014, 8, 8);
		Cursada ezequielCwoimda3 = new Cursada(woimda3, cal.getTime(), ezequiel);
		Prueba ezequielTakeswoimda32 = new Prueba(woimda32, 61);
		ezequielCwoimda3.agregarPrueba(ezequielTakeswoimda32);
		Prueba ezequielTakeswoimda31 = new Prueba(woimda31, 23);
		ezequielCwoimda3.agregarPrueba(ezequielTakeswoimda31);
		Prueba ezequielTakeswoimda33 = new Prueba(woimda33, 64);
		ezequielCwoimda3.agregarPrueba(ezequielTakeswoimda33);
		cal.set(2014, 6, 16);
		Cursada ezequielCrizuka4 = new Cursada(rizuka4, cal.getTime(), ezequiel);
		Prueba ezequielTakesrizuka42 = new Prueba(rizuka42, 30);
		ezequielCrizuka4.agregarPrueba(ezequielTakesrizuka42);
		Prueba ezequielTakesrizuka41 = new Prueba(rizuka41, 96);
		ezequielCrizuka4.agregarPrueba(ezequielTakesrizuka41);
		Prueba ezequielTakesrizuka44 = new Prueba(rizuka44, 83);
		ezequielCrizuka4.agregarPrueba(ezequielTakesrizuka44);
		cal.set(2014, 7, 22);
		Cursada ezequielCsoausb2 = new Cursada(soausb2, cal.getTime(), ezequiel);
		Prueba ezequielTakessoausb23 = new Prueba(soausb23, 64);
		ezequielCsoausb2.agregarPrueba(ezequielTakessoausb23);
		cal.set(2016, 1, 24);
		Cursada ezequielCimstoc1 = new Cursada(imstoc1, cal.getTime(), ezequiel);
		Prueba ezequielTakesimstoc12 = new Prueba(imstoc12, 47);
		ezequielCimstoc1.agregarPrueba(ezequielTakesimstoc12);
		Prueba ezequielTakesimstoc11 = new Prueba(imstoc11, 71);
		ezequielCimstoc1.agregarPrueba(ezequielTakesimstoc11);
		cal.set(2016, 3, 5);
		Cursada adrienCimstoc1 = new Cursada(imstoc1, cal.getTime(), adrien);
		Prueba adrienTakesimstoc12 = new Prueba(imstoc12, 46);
		adrienCimstoc1.agregarPrueba(adrienTakesimstoc12);
		Prueba adrienTakesimstoc11 = new Prueba(imstoc11, 42);
		adrienCimstoc1.agregarPrueba(adrienTakesimstoc11);
		cal.set(2014, 3, 10);
		Cursada jerrellCwoimda3 = new Cursada(woimda3, cal.getTime(), jerrell);
		Prueba jerrellTakeswoimda33 = new Prueba(woimda33, 100);
		jerrellCwoimda3.agregarPrueba(jerrellTakeswoimda33);
		Prueba jerrellTakeswoimda31 = new Prueba(woimda31, 41);
		jerrellCwoimda3.agregarPrueba(jerrellTakeswoimda31);
		Prueba jerrellTakeswoimda32 = new Prueba(woimda32, 76);
		jerrellCwoimda3.agregarPrueba(jerrellTakeswoimda32);
		cal.set(2014, 4, 10);
		Cursada jerrellCsoausb2 = new Cursada(soausb2, cal.getTime(), jerrell);
		Prueba jerrellTakessoausb23 = new Prueba(soausb23, 22);
		jerrellCsoausb2.agregarPrueba(jerrellTakessoausb23);
		cal.set(2015, 4, 29);
		Cursada jerrellCrizuka4 = new Cursada(rizuka4, cal.getTime(), jerrell);
		Prueba jerrellTakesrizuka44 = new Prueba(rizuka44, 87);
		jerrellCrizuka4.agregarPrueba(jerrellTakesrizuka44);
		Prueba jerrellTakesrizuka43 = new Prueba(rizuka43, 48);
		jerrellCrizuka4.agregarPrueba(jerrellTakesrizuka43);
		Prueba jerrellTakesrizuka42 = new Prueba(rizuka42, 64);
		jerrellCrizuka4.agregarPrueba(jerrellTakesrizuka42);
		cal.set(2015, 0, 16);
		Cursada svetlanaCimstoc1 = new Cursada(imstoc1, cal.getTime(), svetlana);
		Prueba svetlanaTakesimstoc11 = new Prueba(imstoc11, 38);
		svetlanaCimstoc1.agregarPrueba(svetlanaTakesimstoc11);
		Prueba svetlanaTakesimstoc12 = new Prueba(imstoc12, 51);
		svetlanaCimstoc1.agregarPrueba(svetlanaTakesimstoc12);
		cal.set(2014, 7, 1);
		Cursada svetlanaCrizuka4 = new Cursada(rizuka4, cal.getTime(), svetlana);
		Prueba svetlanaTakesrizuka41 = new Prueba(rizuka41, 39);
		svetlanaCrizuka4.agregarPrueba(svetlanaTakesrizuka41);
		cal.set(2015, 8, 12);
		Cursada svetlanaCsoausb2 = new Cursada(soausb2, cal.getTime(), svetlana);
		Prueba svetlanaTakessoausb22 = new Prueba(soausb22, 87);
		svetlanaCsoausb2.agregarPrueba(svetlanaTakessoausb22);
		Prueba svetlanaTakessoausb23 = new Prueba(soausb23, 31);
		svetlanaCsoausb2.agregarPrueba(svetlanaTakessoausb23);
		cal.set(2014, 11, 17);
		Cursada svetlanaCwoimda3 = new Cursada(woimda3, cal.getTime(), svetlana);
		Prueba svetlanaTakeswoimda31 = new Prueba(woimda31, 56);
		svetlanaCwoimda3.agregarPrueba(svetlanaTakeswoimda31);
		Prueba svetlanaTakeswoimda33 = new Prueba(woimda33, 75);
		svetlanaCwoimda3.agregarPrueba(svetlanaTakeswoimda33);
		cal.set(2014, 4, 17);
		Cursada olinCrizuka4 = new Cursada(rizuka4, cal.getTime(), olin);
		Prueba olinTakesrizuka44 = new Prueba(rizuka44, 43);
		olinCrizuka4.agregarPrueba(olinTakesrizuka44);
		Prueba olinTakesrizuka41 = new Prueba(rizuka41, 35);
		olinCrizuka4.agregarPrueba(olinTakesrizuka41);
		Prueba olinTakesrizuka42 = new Prueba(rizuka42, 91);
		olinCrizuka4.agregarPrueba(olinTakesrizuka42);
		cal.set(2014, 7, 6);
		Cursada olinCsoausb2 = new Cursada(soausb2, cal.getTime(), olin);
		Prueba olinTakessoausb21 = new Prueba(soausb21, 74);
		olinCsoausb2.agregarPrueba(olinTakessoausb21);
		cal.set(2014, 7, 2);
		Cursada olinCwoimda3 = new Cursada(woimda3, cal.getTime(), olin);
		Prueba olinTakeswoimda32 = new Prueba(woimda32, 41);
		olinCwoimda3.agregarPrueba(olinTakeswoimda32);
		Prueba olinTakeswoimda33 = new Prueba(woimda33, 83);
		olinCwoimda3.agregarPrueba(olinTakeswoimda33);
		Prueba olinTakeswoimda31 = new Prueba(woimda31, 55);
		olinCwoimda3.agregarPrueba(olinTakeswoimda31);
		cal.set(2014, 7, 23);
		Cursada olinCimstoc1 = new Cursada(imstoc1, cal.getTime(), olin);
		Prueba olinTakesimstoc12 = new Prueba(imstoc12, 47);
		olinCimstoc1.agregarPrueba(olinTakesimstoc12);
		Prueba olinTakesimstoc11 = new Prueba(imstoc11, 84);
		olinCimstoc1.agregarPrueba(olinTakesimstoc11);
		cal.set(2016, 2, 16);
		Cursada shilaCimstoc1 = new Cursada(imstoc1, cal.getTime(), shila);
		Prueba shilaTakesimstoc12 = new Prueba(imstoc12, 22);
		shilaCimstoc1.agregarPrueba(shilaTakesimstoc12);
		cal.set(2015, 2, 29);
		Cursada shilaCsoausb2 = new Cursada(soausb2, cal.getTime(), shila);
		Prueba shilaTakessoausb21 = new Prueba(soausb21, 23);
		shilaCsoausb2.agregarPrueba(shilaTakessoausb21);
		cal.set(2014, 9, 10);
		Cursada shilaCrizuka4 = new Cursada(rizuka4, cal.getTime(), shila);
		Prueba shilaTakesrizuka44 = new Prueba(rizuka44, 98);
		shilaCrizuka4.agregarPrueba(shilaTakesrizuka44);
		Prueba shilaTakesrizuka42 = new Prueba(rizuka42, 83);
		shilaCrizuka4.agregarPrueba(shilaTakesrizuka42);
		Prueba shilaTakesrizuka43 = new Prueba(rizuka43, 80);
		shilaCrizuka4.agregarPrueba(shilaTakesrizuka43);
		Prueba shilaTakesrizuka41 = new Prueba(rizuka41, 54);
		shilaCrizuka4.agregarPrueba(shilaTakesrizuka41);
		cal.set(2014, 11, 18);
		Cursada michelineCrizuka4 = new Cursada(rizuka4, cal.getTime(), micheline);
		Prueba michelineTakesrizuka44 = new Prueba(rizuka44, 51);
		michelineCrizuka4.agregarPrueba(michelineTakesrizuka44);
		Prueba michelineTakesrizuka42 = new Prueba(rizuka42, 76);
		michelineCrizuka4.agregarPrueba(michelineTakesrizuka42);
		Prueba michelineTakesrizuka41 = new Prueba(rizuka41, 94);
		michelineCrizuka4.agregarPrueba(michelineTakesrizuka41);
		Prueba michelineTakesrizuka43 = new Prueba(rizuka43, 45);
		michelineCrizuka4.agregarPrueba(michelineTakesrizuka43);
		cal.set(2015, 4, 28);
		Cursada michelineCsoausb2 = new Cursada(soausb2, cal.getTime(), micheline);
		Prueba michelineTakessoausb22 = new Prueba(soausb22, 55);
		michelineCsoausb2.agregarPrueba(michelineTakessoausb22);
		Prueba michelineTakessoausb21 = new Prueba(soausb21, 59);
		michelineCsoausb2.agregarPrueba(michelineTakessoausb21);
		cal.set(2014, 4, 18);
		Cursada michelineCwoimda3 = new Cursada(woimda3, cal.getTime(), micheline);
		Prueba michelineTakeswoimda32 = new Prueba(woimda32, 92);
		michelineCwoimda3.agregarPrueba(michelineTakeswoimda32);
		cal.set(2014, 10, 9);
		Cursada hilmaCsoausb2 = new Cursada(soausb2, cal.getTime(), hilma);
		Prueba hilmaTakessoausb22 = new Prueba(soausb22, 68);
		hilmaCsoausb2.agregarPrueba(hilmaTakessoausb22);
		cal.set(2015, 6, 29);
		Cursada hilmaCwoimda3 = new Cursada(woimda3, cal.getTime(), hilma);
		Prueba hilmaTakeswoimda32 = new Prueba(woimda32, 59);
		hilmaCwoimda3.agregarPrueba(hilmaTakeswoimda32);
		Prueba hilmaTakeswoimda31 = new Prueba(woimda31, 62);
		hilmaCwoimda3.agregarPrueba(hilmaTakeswoimda31);
		cal.set(2015, 6, 23);
		Cursada hilmaCrizuka4 = new Cursada(rizuka4, cal.getTime(), hilma);
		Prueba hilmaTakesrizuka41 = new Prueba(rizuka41, 27);
		hilmaCrizuka4.agregarPrueba(hilmaTakesrizuka41);
		cal.set(2014, 4, 19);
		Cursada hilmaCimstoc1 = new Cursada(imstoc1, cal.getTime(), hilma);
		Prueba hilmaTakesimstoc12 = new Prueba(imstoc12, 68);
		hilmaCimstoc1.agregarPrueba(hilmaTakesimstoc12);
		cal.set(2015, 7, 8);
		Cursada remediosCimstoc1 = new Cursada(imstoc1, cal.getTime(), remedios);
		Prueba remediosTakesimstoc12 = new Prueba(imstoc12, 49);
		remediosCimstoc1.agregarPrueba(remediosTakesimstoc12);
		cal.set(2015, 5, 17);
		Cursada remediosCsoausb2 = new Cursada(soausb2, cal.getTime(), remedios);
		Prueba remediosTakessoausb22 = new Prueba(soausb22, 51);
		remediosCsoausb2.agregarPrueba(remediosTakessoausb22);
		Prueba remediosTakessoausb23 = new Prueba(soausb23, 31);
		remediosCsoausb2.agregarPrueba(remediosTakessoausb23);
		cal.set(2015, 1, 14);
		Cursada remediosCwoimda3 = new Cursada(woimda3, cal.getTime(), remedios);
		Prueba remediosTakeswoimda31 = new Prueba(woimda31, 80);
		remediosCwoimda3.agregarPrueba(remediosTakeswoimda31);
		cal.set(2015, 7, 22);
		Cursada marthCsoausb2 = new Cursada(soausb2, cal.getTime(), marth);
		Prueba marthTakessoausb22 = new Prueba(soausb22, 66);
		marthCsoausb2.agregarPrueba(marthTakessoausb22);
		cal.set(2015, 8, 15);
		Cursada gertrudeCimstoc1 = new Cursada(imstoc1, cal.getTime(), gertrude);
		Prueba gertrudeTakesimstoc12 = new Prueba(imstoc12, 100);
		gertrudeCimstoc1.agregarPrueba(gertrudeTakesimstoc12);
		Prueba gertrudeTakesimstoc11 = new Prueba(imstoc11, 47);
		gertrudeCimstoc1.agregarPrueba(gertrudeTakesimstoc11);
		cal.set(2015, 5, 14);
		Cursada gertrudeCwoimda3 = new Cursada(woimda3, cal.getTime(), gertrude);
		Prueba gertrudeTakeswoimda32 = new Prueba(woimda32, 88);
		gertrudeCwoimda3.agregarPrueba(gertrudeTakeswoimda32);
		Prueba gertrudeTakeswoimda33 = new Prueba(woimda33, 62);
		gertrudeCwoimda3.agregarPrueba(gertrudeTakeswoimda33);
		cal.set(2015, 0, 27);
		Cursada claireCimstoc1 = new Cursada(imstoc1, cal.getTime(), claire);
		Prueba claireTakesimstoc11 = new Prueba(imstoc11, 88);
		claireCimstoc1.agregarPrueba(claireTakesimstoc11);
		Prueba claireTakesimstoc12 = new Prueba(imstoc12, 40);
		claireCimstoc1.agregarPrueba(claireTakesimstoc12);

		Curso drawmu1 = new Curso("Draw must change perpetual so", ingles, 1);
		Leccion drawmu11 = new Leccion("Must change out considered wondered she change applauded he man");
		drawmu1.agregarLeccion(drawmu11);
		Leccion drawmu12 = new Leccion("Face perpetual want feebly new oh wondered required mr she");
		drawmu1.agregarLeccion(drawmu12);
		Leccion drawmu13 = new Leccion("Want must tall face do cultivated described believing no collecting");
		drawmu1.agregarLeccion(drawmu13);
		sitio.agregarCurso(drawmu1);

		Curso wonder2 = new Curso("Wondered add on astonished cultivated", ingles, 2);
		Leccion wonder21 = new Leccion(
				"Add everything melancholy add face required astonished new collecting dispatched");
		wonder2.agregarLeccion(wonder21);
		Leccion wonder22 = new Leccion("Must man feebly draw so collecting is past travelling on");
		wonder2.agregarLeccion(wonder22);
		sitio.agregarCurso(wonder2);

		Curso travel3 = new Curso("Travelling resembled up melancholy barton", ingles, 1);
		Leccion travel31 = new Leccion("Do feebly otherwise applauded extremity debating on so is she");
		travel3.agregarLeccion(travel31);
		Leccion travel32 = new Leccion("New up eyes cultivated want applauded so feebly face new");
		travel3.agregarLeccion(travel32);
		sitio.agregarCurso(travel3);
		cal.set(2015, 9, 28);
		Cursada shilaCtravel3 = new Cursada(travel3, cal.getTime(), shila);
		Prueba shilaTakestravel32 = new Prueba(travel32, 55);
		shilaCtravel3.agregarPrueba(shilaTakestravel32);
		cal.set(2015, 1, 6);
		Cursada shilaCwonder2 = new Cursada(wonder2, cal.getTime(), shila);
		Prueba shilaTakeswonder21 = new Prueba(wonder21, 32);
		shilaCwonder2.agregarPrueba(shilaTakeswonder21);
		cal.set(2016, 0, 28);
		Cursada shilaCdrawmu1 = new Cursada(drawmu1, cal.getTime(), shila);
		Prueba shilaTakesdrawmu13 = new Prueba(drawmu13, 100);
		shilaCdrawmu1.agregarPrueba(shilaTakesdrawmu13);
		Prueba shilaTakesdrawmu12 = new Prueba(drawmu12, 44);
		shilaCdrawmu1.agregarPrueba(shilaTakesdrawmu12);
		Prueba shilaTakesdrawmu11 = new Prueba(drawmu11, 87);
		shilaCdrawmu1.agregarPrueba(shilaTakesdrawmu11);
		cal.set(2016, 2, 20);
		Cursada michelineCdrawmu1 = new Cursada(drawmu1, cal.getTime(), micheline);
		Prueba michelineTakesdrawmu13 = new Prueba(drawmu13, 86);
		michelineCdrawmu1.agregarPrueba(michelineTakesdrawmu13);
		Prueba michelineTakesdrawmu11 = new Prueba(drawmu11, 26);
		michelineCdrawmu1.agregarPrueba(michelineTakesdrawmu11);
		Prueba michelineTakesdrawmu12 = new Prueba(drawmu12, 65);
		michelineCdrawmu1.agregarPrueba(michelineTakesdrawmu12);
		cal.set(2015, 11, 9);
		Cursada ezequielCdrawmu1 = new Cursada(drawmu1, cal.getTime(), ezequiel);
		Prueba ezequielTakesdrawmu12 = new Prueba(drawmu12, 67);
		ezequielCdrawmu1.agregarPrueba(ezequielTakesdrawmu12);
		Prueba ezequielTakesdrawmu11 = new Prueba(drawmu11, 45);
		ezequielCdrawmu1.agregarPrueba(ezequielTakesdrawmu11);
		Prueba ezequielTakesdrawmu13 = new Prueba(drawmu13, 29);
		ezequielCdrawmu1.agregarPrueba(ezequielTakesdrawmu13);
		cal.set(2014, 3, 12);
		Cursada jerrellCdrawmu1 = new Cursada(drawmu1, cal.getTime(), jerrell);
		Prueba jerrellTakesdrawmu11 = new Prueba(drawmu11, 62);
		jerrellCdrawmu1.agregarPrueba(jerrellTakesdrawmu11);
		Prueba jerrellTakesdrawmu13 = new Prueba(drawmu13, 70);
		jerrellCdrawmu1.agregarPrueba(jerrellTakesdrawmu13);
		cal.set(2015, 2, 26);
		Cursada jerrellCwonder2 = new Cursada(wonder2, cal.getTime(), jerrell);
		Prueba jerrellTakeswonder22 = new Prueba(wonder22, 87);
		jerrellCwonder2.agregarPrueba(jerrellTakeswonder22);
		Prueba jerrellTakeswonder21 = new Prueba(wonder21, 82);
		jerrellCwonder2.agregarPrueba(jerrellTakeswonder21);
		cal.set(2015, 11, 9);
		Cursada marthCdrawmu1 = new Cursada(drawmu1, cal.getTime(), marth);
		Prueba marthTakesdrawmu12 = new Prueba(drawmu12, 30);
		marthCdrawmu1.agregarPrueba(marthTakesdrawmu12);
		Prueba marthTakesdrawmu11 = new Prueba(drawmu11, 87);
		marthCdrawmu1.agregarPrueba(marthTakesdrawmu11);
		Prueba marthTakesdrawmu13 = new Prueba(drawmu13, 31);
		marthCdrawmu1.agregarPrueba(marthTakesdrawmu13);
		cal.set(2015, 5, 16);
		Cursada claireCtravel3 = new Cursada(travel3, cal.getTime(), claire);
		Prueba claireTakestravel31 = new Prueba(travel31, 41);
		claireCtravel3.agregarPrueba(claireTakestravel31);
		cal.set(2015, 10, 11);
		Cursada claireCdrawmu1 = new Cursada(drawmu1, cal.getTime(), claire);
		Prueba claireTakesdrawmu12 = new Prueba(drawmu12, 47);
		claireCdrawmu1.agregarPrueba(claireTakesdrawmu12);
		Prueba claireTakesdrawmu13 = new Prueba(drawmu13, 68);
		claireCdrawmu1.agregarPrueba(claireTakesdrawmu13);
		Prueba claireTakesdrawmu11 = new Prueba(drawmu11, 72);
		claireCdrawmu1.agregarPrueba(claireTakesdrawmu11);
		cal.set(2015, 2, 25);
		Cursada claireCwonder2 = new Cursada(wonder2, cal.getTime(), claire);
		Prueba claireTakeswonder22 = new Prueba(wonder22, 76);
		claireCwonder2.agregarPrueba(claireTakeswonder22);
		cal.set(2015, 5, 18);
		Cursada ronnyCwonder2 = new Cursada(wonder2, cal.getTime(), ronny);
		Prueba ronnyTakeswonder22 = new Prueba(wonder22, 90);
		ronnyCwonder2.agregarPrueba(ronnyTakeswonder22);
		Prueba ronnyTakeswonder21 = new Prueba(wonder21, 20);
		ronnyCwonder2.agregarPrueba(ronnyTakeswonder21);
		Prueba ronnyTakeswonder21b = new Prueba(wonder21, 73);
		ronnyCwonder2.agregarPrueba(ronnyTakeswonder21b);
		cal.set(2015, 6, 22);
		Cursada ronnyCdrawmu1 = new Cursada(drawmu1, cal.getTime(), ronny);
		Prueba ronnyTakesdrawmu13 = new Prueba(drawmu13, 28);
		ronnyCdrawmu1.agregarPrueba(ronnyTakesdrawmu13);
		cal.set(2014, 8, 17);
		Cursada karyCdrawmu1 = new Cursada(drawmu1, cal.getTime(), kary);
		Prueba karyTakesdrawmu12 = new Prueba(drawmu12, 43);
		karyCdrawmu1.agregarPrueba(karyTakesdrawmu12);
		cal.set(2015, 1, 21);
		Cursada osvaldoCwonder2 = new Cursada(wonder2, cal.getTime(), osvaldo);
		Prueba osvaldoTakeswonder22 = new Prueba(wonder22, 29);
		osvaldoCwonder2.agregarPrueba(osvaldoTakeswonder22);
		Prueba osvaldoTakeswonder21 = new Prueba(wonder21, 67);
		osvaldoCwonder2.agregarPrueba(osvaldoTakeswonder21);
		cal.set(2016, 1, 6);
		Cursada osvaldoCtravel3 = new Cursada(travel3, cal.getTime(), osvaldo);
		Prueba osvaldoTakestravel32 = new Prueba(travel32, 36);
		osvaldoCtravel3.agregarPrueba(osvaldoTakestravel32);
		Prueba osvaldoTakestravel31 = new Prueba(travel31, 41);
		osvaldoCtravel3.agregarPrueba(osvaldoTakestravel31);
		cal.set(2014, 9, 22);
		Cursada gertrudeCwonder2 = new Cursada(wonder2, cal.getTime(), gertrude);
		Prueba gertrudeTakeswonder21 = new Prueba(wonder21, 41);
		gertrudeCwonder2.agregarPrueba(gertrudeTakeswonder21);
		Prueba gertrudeTakeswonder22 = new Prueba(wonder22, 40);
		gertrudeCwonder2.agregarPrueba(gertrudeTakeswonder22);
		cal.set(2015, 11, 30);
		Cursada hilmaCdrawmu1 = new Cursada(drawmu1, cal.getTime(), hilma);
		Prueba hilmaTakesdrawmu12 = new Prueba(drawmu12, 40);
		hilmaCdrawmu1.agregarPrueba(hilmaTakesdrawmu12);
		Prueba hilmaTakesdrawmu11 = new Prueba(drawmu11, 76);
		hilmaCdrawmu1.agregarPrueba(hilmaTakesdrawmu11);
		cal.set(2015, 10, 29);
		Cursada hilmaCwonder2 = new Cursada(wonder2, cal.getTime(), hilma);
		Prueba hilmaTakeswonder21 = new Prueba(wonder21, 74);
		hilmaCwonder2.agregarPrueba(hilmaTakeswonder21);
		cal.set(2015, 7, 9);
		Cursada hilmaCtravel3 = new Cursada(travel3, cal.getTime(), hilma);
		Prueba hilmaTakestravel31 = new Prueba(travel31, 70);
		hilmaCtravel3.agregarPrueba(hilmaTakestravel31);
		Prueba hilmaTakestravel32 = new Prueba(travel32, 48);
		hilmaCtravel3.agregarPrueba(hilmaTakestravel32);
		cal.set(2015, 10, 1);
		Cursada carolynCwonder2 = new Cursada(wonder2, cal.getTime(), carolyn);
		Prueba carolynTakeswonder22 = new Prueba(wonder22, 72);
		carolynCwonder2.agregarPrueba(carolynTakeswonder22);
		Prueba carolynTakeswonder21 = new Prueba(wonder21, 37);
		carolynCwonder2.agregarPrueba(carolynTakeswonder21);
		cal.set(2015, 7, 11);
		Cursada carolynCtravel3 = new Cursada(travel3, cal.getTime(), carolyn);
		Prueba carolynTakestravel32 = new Prueba(travel32, 70);
		carolynCtravel3.agregarPrueba(carolynTakestravel32);
		Prueba carolynTakestravel31 = new Prueba(travel31, 73);
		carolynCtravel3.agregarPrueba(carolynTakestravel31);
		cal.set(2015, 9, 6);
		Cursada carolynCdrawmu1 = new Cursada(drawmu1, cal.getTime(), carolyn);
		Prueba carolynTakesdrawmu12 = new Prueba(drawmu12, 38);
		carolynCdrawmu1.agregarPrueba(carolynTakesdrawmu12);
		Prueba carolynTakesdrawmu13 = new Prueba(drawmu13, 96);
		carolynCdrawmu1.agregarPrueba(carolynTakesdrawmu13);
		Prueba carolynTakesdrawmu11 = new Prueba(drawmu11, 95);
		carolynCdrawmu1.agregarPrueba(carolynTakesdrawmu11);
		cal.set(2014, 7, 7);
		Cursada aguedaCtravel3 = new Cursada(travel3, cal.getTime(), agueda);
		Prueba aguedaTakestravel31 = new Prueba(travel31, 24);
		aguedaCtravel3.agregarPrueba(aguedaTakestravel31);
		Prueba aguedaTakestravel32 = new Prueba(travel32, 27);
		aguedaCtravel3.agregarPrueba(aguedaTakestravel32);

		Curso suppli1 = new Curso("Supplicou baixo baixo do camillo", portugues, 3);
		Leccion suppli11 = new Leccion("Faca ficam es sao camillo fez com arrumava buscaes ficam");
		suppli1.agregarLeccion(suppli11);
		Leccion suppli12 = new Leccion("Fim no vivem buscaes farca faca vir vir senao no");
		suppli1.agregarLeccion(suppli12);
		Leccion suppli13 = new Leccion("Sao ficam pernil ma do buscaes teremos apregoam impoe pareco");
		suppli1.agregarLeccion(suppli13);
		Leccion suppli14 = new Leccion("Fez ma exclamou eu do estao censuro do gremio faca");
		suppli1.agregarLeccion(suppli14);
		sitio.agregarCurso(suppli1);

		Curso vivema2 = new Curso("Vivem apanhar ma fez es", portugues, 2);
		Leccion vivema21 = new Leccion("Eu cre baixo na firmeza camillo liberdade exclamou paulo nao");
		vivema2.agregarLeccion(vivema21);
		Leccion vivema22 = new Leccion("Com liberdade impoe liberdade pareco apanhar fez liberdade ma brios");
		vivema2.agregarLeccion(vivema22);
		Leccion vivema23 = new Leccion("Vivido brios paulo cousa quer se has eu es impoe");
		vivema2.agregarLeccion(vivema23);
		sitio.agregarCurso(vivema2);

		Curso farcab3 = new Curso("Farca baixo ir impoe supplicou", portugues, 3);
		Leccion farcab31 = new Leccion("Brios carro ii nao nao ma nao iraou baixo em");
		farcab3.agregarLeccion(farcab31);
		Leccion farcab32 = new Leccion("Ma mulheres paulo pareco pernil senao pernil essencial pernil bom");
		farcab3.agregarLeccion(farcab32);
		Leccion farcab33 = new Leccion("Baixo gremio va ii na for pareco uso apanhar carro");
		farcab3.agregarLeccion(farcab33);
		Leccion farcab34 = new Leccion("Ma ficam ir ii cousa sao has ficam cousa paulo");
		farcab3.agregarLeccion(farcab34);
		sitio.agregarCurso(farcab3);

		Curso suppli4 = new Curso("Supplicou quer es ma antes", portugues, 1);
		Leccion suppli41 = new Leccion("Nao na for iraou buscaes buscaes supplicou vivem liberdade iraou");
		suppli4.agregarLeccion(suppli41);
		Leccion suppli42 = new Leccion("Ficam arrumava arrumava apanhar cre has iraou buscaes censuro has");
		suppli4.agregarLeccion(suppli42);
		Leccion suppli43 = new Leccion("Na no vivem educacao eu salvo has cre faca fez");
		suppli4.agregarLeccion(suppli43);
		Leccion suppli44 = new Leccion("Apanhar senao arrumava quer em baixo essencial sao impoe educacao");
		suppli4.agregarLeccion(suppli44);
		sitio.agregarCurso(suppli4);
		cal.set(2014, 7, 5);
		Cursada jerrellCfarcab3 = new Cursada(farcab3, cal.getTime(), jerrell);
		Prueba jerrellTakesfarcab34 = new Prueba(farcab34, 91);
		jerrellCfarcab3.agregarPrueba(jerrellTakesfarcab34);
		Prueba jerrellTakesfarcab33 = new Prueba(farcab33, 70);
		jerrellCfarcab3.agregarPrueba(jerrellTakesfarcab33);
		Prueba jerrellTakesfarcab32 = new Prueba(farcab32, 87);
		jerrellCfarcab3.agregarPrueba(jerrellTakesfarcab32);
		Prueba jerrellTakesfarcab31 = new Prueba(farcab31, 42);
		jerrellCfarcab3.agregarPrueba(jerrellTakesfarcab31);
		cal.set(2015, 6, 16);
		Cursada jerrellCsuppli4 = new Cursada(suppli4, cal.getTime(), jerrell);
		Prueba jerrellTakessuppli44 = new Prueba(suppli44, 66);
		jerrellCsuppli4.agregarPrueba(jerrellTakessuppli44);
		Prueba jerrellTakessuppli43 = new Prueba(suppli43, 46);
		jerrellCsuppli4.agregarPrueba(jerrellTakessuppli43);
		Prueba jerrellTakessuppli42 = new Prueba(suppli42, 50);
		jerrellCsuppli4.agregarPrueba(jerrellTakessuppli42);
		cal.set(2014, 4, 1);
		Cursada jerrellCsuppli1 = new Cursada(suppli1, cal.getTime(), jerrell);
		Prueba jerrellTakessuppli13 = new Prueba(suppli13, 22);
		jerrellCsuppli1.agregarPrueba(jerrellTakessuppli13);
		Prueba jerrellTakessuppli11 = new Prueba(suppli11, 26);
		jerrellCsuppli1.agregarPrueba(jerrellTakessuppli11);
		cal.set(2014, 3, 29);
		Cursada ezequielCfarcab3 = new Cursada(farcab3, cal.getTime(), ezequiel);
		Prueba ezequielTakesfarcab33 = new Prueba(farcab33, 32);
		ezequielCfarcab3.agregarPrueba(ezequielTakesfarcab33);
		Prueba ezequielTakesfarcab32 = new Prueba(farcab32, 30);
		ezequielCfarcab3.agregarPrueba(ezequielTakesfarcab32);
		Prueba ezequielTakesfarcab31 = new Prueba(farcab31, 93);
		ezequielCfarcab3.agregarPrueba(ezequielTakesfarcab31);
		cal.set(2015, 1, 26);
		Cursada ezequielCvivema2 = new Cursada(vivema2, cal.getTime(), ezequiel);
		Prueba ezequielTakesvivema22 = new Prueba(vivema22, 67);
		ezequielCvivema2.agregarPrueba(ezequielTakesvivema22);
		Prueba ezequielTakesvivema23 = new Prueba(vivema23, 93);
		ezequielCvivema2.agregarPrueba(ezequielTakesvivema23);
		Prueba ezequielTakesvivema21 = new Prueba(vivema21, 49);
		ezequielCvivema2.agregarPrueba(ezequielTakesvivema21);
		cal.set(2014, 3, 18);
		Cursada ezequielCsuppli1 = new Cursada(suppli1, cal.getTime(), ezequiel);
		Prueba ezequielTakessuppli12 = new Prueba(suppli12, 33);
		ezequielCsuppli1.agregarPrueba(ezequielTakessuppli12);
		Prueba ezequielTakessuppli13 = new Prueba(suppli13, 68);
		ezequielCsuppli1.agregarPrueba(ezequielTakessuppli13);
		cal.set(2014, 11, 26);
		Cursada ezequielCsuppli4 = new Cursada(suppli4, cal.getTime(), ezequiel);
		Prueba ezequielTakessuppli43 = new Prueba(suppli43, 46);
		ezequielCsuppli4.agregarPrueba(ezequielTakessuppli43);
		Prueba ezequielTakessuppli44 = new Prueba(suppli44, 33);
		ezequielCsuppli4.agregarPrueba(ezequielTakessuppli44);
		Prueba ezequielTakessuppli42 = new Prueba(suppli42, 47);
		ezequielCsuppli4.agregarPrueba(ezequielTakessuppli42);
		Prueba ezequielTakessuppli41 = new Prueba(suppli41, 82);
		ezequielCsuppli4.agregarPrueba(ezequielTakessuppli41);
		cal.set(2015, 0, 26);
		Cursada ronnyCfarcab3 = new Cursada(farcab3, cal.getTime(), ronny);
		Prueba ronnyTakesfarcab33 = new Prueba(farcab33, 70);
		ronnyCfarcab3.agregarPrueba(ronnyTakesfarcab33);
		cal.set(2014, 3, 20);
		Cursada shilaCfarcab3 = new Cursada(farcab3, cal.getTime(), shila);
		Prueba shilaTakesfarcab34 = new Prueba(farcab34, 36);
		shilaCfarcab3.agregarPrueba(shilaTakesfarcab34);
		Prueba shilaTakesfarcab32 = new Prueba(farcab32, 30);
		shilaCfarcab3.agregarPrueba(shilaTakesfarcab32);
		Prueba shilaTakesfarcab33 = new Prueba(farcab33, 66);
		shilaCfarcab3.agregarPrueba(shilaTakesfarcab33);
		cal.set(2014, 9, 28);
		Cursada shilaCvivema2 = new Cursada(vivema2, cal.getTime(), shila);
		Prueba shilaTakesvivema22 = new Prueba(vivema22, 58);
		shilaCvivema2.agregarPrueba(shilaTakesvivema22);
		Prueba shilaTakesvivema23 = new Prueba(vivema23, 81);
		shilaCvivema2.agregarPrueba(shilaTakesvivema23);
		Prueba shilaTakesvivema21 = new Prueba(vivema21, 76);
		shilaCvivema2.agregarPrueba(shilaTakesvivema21);
		cal.set(2015, 4, 7);
		Cursada shilaCsuppli4 = new Cursada(suppli4, cal.getTime(), shila);
		Prueba shilaTakessuppli43 = new Prueba(suppli43, 31);
		shilaCsuppli4.agregarPrueba(shilaTakessuppli43);
		Prueba shilaTakessuppli42 = new Prueba(suppli42, 76);
		shilaCsuppli4.agregarPrueba(shilaTakessuppli42);
		cal.set(2014, 3, 21);
		Cursada claireCsuppli1 = new Cursada(suppli1, cal.getTime(), claire);
		Prueba claireTakessuppli13 = new Prueba(suppli13, 60);
		claireCsuppli1.agregarPrueba(claireTakessuppli13);
		cal.set(2015, 6, 25);
		Cursada claireCsuppli4 = new Cursada(suppli4, cal.getTime(), claire);
		Prueba claireTakessuppli43 = new Prueba(suppli43, 24);
		claireCsuppli4.agregarPrueba(claireTakessuppli43);
		cal.set(2014, 8, 26);
		Cursada osvaldoCfarcab3 = new Cursada(farcab3, cal.getTime(), osvaldo);
		Prueba osvaldoTakesfarcab33 = new Prueba(farcab33, 45);
		osvaldoCfarcab3.agregarPrueba(osvaldoTakesfarcab33);
		Prueba osvaldoTakesfarcab34 = new Prueba(farcab34, 60);
		osvaldoCfarcab3.agregarPrueba(osvaldoTakesfarcab34);
		Prueba osvaldoTakesfarcab32 = new Prueba(farcab32, 87);
		osvaldoCfarcab3.agregarPrueba(osvaldoTakesfarcab32);
		Prueba osvaldoTakesfarcab31 = new Prueba(farcab31, 88);
		osvaldoCfarcab3.agregarPrueba(osvaldoTakesfarcab31);
		cal.set(2014, 4, 18);
		Cursada osvaldoCvivema2 = new Cursada(vivema2, cal.getTime(), osvaldo);
		Prueba osvaldoTakesvivema21 = new Prueba(vivema21, 94);
		osvaldoCvivema2.agregarPrueba(osvaldoTakesvivema21);
		Prueba osvaldoTakesvivema22 = new Prueba(vivema22, 57);
		osvaldoCvivema2.agregarPrueba(osvaldoTakesvivema22);
		cal.set(2014, 3, 26);
		Cursada osvaldoCsuppli1 = new Cursada(suppli1, cal.getTime(), osvaldo);
		Prueba osvaldoTakessuppli11 = new Prueba(suppli11, 51);
		osvaldoCsuppli1.agregarPrueba(osvaldoTakessuppli11);
		Prueba osvaldoTakessuppli12 = new Prueba(suppli12, 63);
		osvaldoCsuppli1.agregarPrueba(osvaldoTakessuppli12);
		Prueba osvaldoTakessuppli13 = new Prueba(suppli13, 65);
		osvaldoCsuppli1.agregarPrueba(osvaldoTakessuppli13);
		cal.set(2015, 6, 14);
		Cursada osvaldoCsuppli4 = new Cursada(suppli4, cal.getTime(), osvaldo);
		Prueba osvaldoTakessuppli44 = new Prueba(suppli44, 47);
		osvaldoCsuppli4.agregarPrueba(osvaldoTakessuppli44);
		Prueba osvaldoTakessuppli41 = new Prueba(suppli41, 30);
		osvaldoCsuppli4.agregarPrueba(osvaldoTakessuppli41);
		cal.set(2015, 2, 8);
		Cursada gertrudeCvivema2 = new Cursada(vivema2, cal.getTime(), gertrude);
		Prueba gertrudeTakesvivema21 = new Prueba(vivema21, 72);
		gertrudeCvivema2.agregarPrueba(gertrudeTakesvivema21);
		Prueba gertrudeTakesvivema23 = new Prueba(vivema23, 55);
		gertrudeCvivema2.agregarPrueba(gertrudeTakesvivema23);
		Prueba gertrudeTakesvivema22 = new Prueba(vivema22, 55);
		gertrudeCvivema2.agregarPrueba(gertrudeTakesvivema22);
		cal.set(2014, 11, 9);
		Cursada gertrudeCsuppli1 = new Cursada(suppli1, cal.getTime(), gertrude);
		Prueba gertrudeTakessuppli12 = new Prueba(suppli12, 67);
		gertrudeCsuppli1.agregarPrueba(gertrudeTakessuppli12);
		Prueba gertrudeTakessuppli13 = new Prueba(suppli13, 78);
		gertrudeCsuppli1.agregarPrueba(gertrudeTakessuppli13);
		Prueba gertrudeTakessuppli14 = new Prueba(suppli14, 67);
		gertrudeCsuppli1.agregarPrueba(gertrudeTakessuppli14);
		Prueba gertrudeTakessuppli11 = new Prueba(suppli11, 24);
		gertrudeCsuppli1.agregarPrueba(gertrudeTakessuppli11);
		cal.set(2014, 7, 23);
		Cursada aguedaCfarcab3 = new Cursada(farcab3, cal.getTime(), agueda);
		Prueba aguedaTakesfarcab32 = new Prueba(farcab32, 85);
		aguedaCfarcab3.agregarPrueba(aguedaTakesfarcab32);
		Prueba aguedaTakesfarcab33 = new Prueba(farcab33, 49);
		aguedaCfarcab3.agregarPrueba(aguedaTakesfarcab33);
		Prueba aguedaTakesfarcab34 = new Prueba(farcab34, 28);
		aguedaCfarcab3.agregarPrueba(aguedaTakesfarcab34);
		Prueba aguedaTakesfarcab31 = new Prueba(farcab31, 49);
		aguedaCfarcab3.agregarPrueba(aguedaTakesfarcab31);
		cal.set(2015, 4, 2);
		Cursada aguedaCsuppli1 = new Cursada(suppli1, cal.getTime(), agueda);
		Prueba aguedaTakessuppli13 = new Prueba(suppli13, 60);
		aguedaCsuppli1.agregarPrueba(aguedaTakessuppli13);
		Prueba aguedaTakessuppli12 = new Prueba(suppli12, 26);
		aguedaCsuppli1.agregarPrueba(aguedaTakessuppli12);
		Prueba aguedaTakessuppli14 = new Prueba(suppli14, 42);
		aguedaCsuppli1.agregarPrueba(aguedaTakessuppli14);
		cal.set(2015, 4, 15);
		Cursada aguedaCvivema2 = new Cursada(vivema2, cal.getTime(), agueda);
		Prueba aguedaTakesvivema23 = new Prueba(vivema23, 83);
		aguedaCvivema2.agregarPrueba(aguedaTakesvivema23);
		cal.set(2015, 6, 16);
		Cursada hilmaCsuppli1 = new Cursada(suppli1, cal.getTime(), hilma);
		Prueba hilmaTakessuppli11 = new Prueba(suppli11, 72);
		hilmaCsuppli1.agregarPrueba(hilmaTakessuppli11);
		Prueba hilmaTakessuppli14 = new Prueba(suppli14, 93);
		hilmaCsuppli1.agregarPrueba(hilmaTakessuppli14);
		Prueba hilmaTakessuppli13 = new Prueba(suppli13, 99);
		hilmaCsuppli1.agregarPrueba(hilmaTakessuppli13);
		Prueba hilmaTakessuppli12 = new Prueba(suppli12, 44);
		hilmaCsuppli1.agregarPrueba(hilmaTakessuppli12);
		cal.set(2015, 6, 31);
		Cursada hilmaCvivema2 = new Cursada(vivema2, cal.getTime(), hilma);
		Prueba hilmaTakesvivema23 = new Prueba(vivema23, 76);
		hilmaCvivema2.agregarPrueba(hilmaTakesvivema23);
		cal.set(2015, 11, 20);
		Cursada remediosCvivema2 = new Cursada(vivema2, cal.getTime(), remedios);
		Prueba remediosTakesvivema23 = new Prueba(vivema23, 32);
		remediosCvivema2.agregarPrueba(remediosTakesvivema23);
		Prueba remediosTakesvivema21 = new Prueba(vivema21, 91);
		remediosCvivema2.agregarPrueba(remediosTakesvivema21);
		cal.set(2015, 6, 15);
		Cursada remediosCfarcab3 = new Cursada(farcab3, cal.getTime(), remedios);
		Prueba remediosTakesfarcab34 = new Prueba(farcab34, 34);
		remediosCfarcab3.agregarPrueba(remediosTakesfarcab34);
		Prueba remediosTakesfarcab33 = new Prueba(farcab33, 45);
		remediosCfarcab3.agregarPrueba(remediosTakesfarcab33);
		cal.set(2014, 5, 8);
		Cursada remediosCsuppli4 = new Cursada(suppli4, cal.getTime(), remedios);
		Prueba remediosTakessuppli41 = new Prueba(suppli41, 31);
		remediosCsuppli4.agregarPrueba(remediosTakessuppli41);
		Prueba remediosTakessuppli44 = new Prueba(suppli44, 72);
		remediosCsuppli4.agregarPrueba(remediosTakessuppli44);
		Prueba remediosTakessuppli43 = new Prueba(suppli43, 30);
		remediosCsuppli4.agregarPrueba(remediosTakessuppli43);
		cal.set(2014, 9, 14);
		Cursada remediosCsuppli1 = new Cursada(suppli1, cal.getTime(), remedios);
		Prueba remediosTakessuppli12 = new Prueba(suppli12, 91);
		remediosCsuppli1.agregarPrueba(remediosTakessuppli12);
		cal.set(2014, 6, 31);
		Cursada karyCsuppli1 = new Cursada(suppli1, cal.getTime(), kary);
		Prueba karyTakessuppli13 = new Prueba(suppli13, 42);
		karyCsuppli1.agregarPrueba(karyTakessuppli13);
		cal.set(2015, 2, 22);
		Cursada karyCfarcab3 = new Cursada(farcab3, cal.getTime(), kary);
		Prueba karyTakesfarcab32 = new Prueba(farcab32, 24);
		karyCfarcab3.agregarPrueba(karyTakesfarcab32);
		cal.set(2014, 4, 4);
		Cursada karyCsuppli4 = new Cursada(suppli4, cal.getTime(), kary);
		Prueba karyTakessuppli41 = new Prueba(suppli41, 26);
		karyCsuppli4.agregarPrueba(karyTakessuppli41);
		Prueba karyTakessuppli44 = new Prueba(suppli44, 53);
		karyCsuppli4.agregarPrueba(karyTakessuppli44);
		Prueba karyTakessuppli42 = new Prueba(suppli42, 90);
		karyCsuppli4.agregarPrueba(karyTakessuppli42);
		Prueba karyTakessuppli43 = new Prueba(suppli43, 70);
		karyCsuppli4.agregarPrueba(karyTakessuppli43);
		cal.set(2015, 7, 18);
		Cursada karyCvivema2 = new Cursada(vivema2, cal.getTime(), kary);
		Prueba karyTakesvivema23 = new Prueba(vivema23, 90);
		karyCvivema2.agregarPrueba(karyTakesvivema23);
		cal.set(2016, 1, 26);
		Cursada adrienCsuppli4 = new Cursada(suppli4, cal.getTime(), adrien);
		Prueba adrienTakessuppli42 = new Prueba(suppli42, 60);
		adrienCsuppli4.agregarPrueba(adrienTakessuppli42);
		Prueba adrienTakessuppli43 = new Prueba(suppli43, 78);
		adrienCsuppli4.agregarPrueba(adrienTakessuppli43);
		Prueba adrienTakessuppli41 = new Prueba(suppli41, 76);
		adrienCsuppli4.agregarPrueba(adrienTakessuppli41);
		Prueba adrienTakessuppli44 = new Prueba(suppli44, 33);
		adrienCsuppli4.agregarPrueba(adrienTakessuppli44);
		cal.set(2015, 4, 8);
		Cursada adrienCvivema2 = new Cursada(vivema2, cal.getTime(), adrien);
		Prueba adrienTakesvivema21 = new Prueba(vivema21, 23);
		adrienCvivema2.agregarPrueba(adrienTakesvivema21);
		cal.set(2016, 0, 8);
		Cursada adrienCfarcab3 = new Cursada(farcab3, cal.getTime(), adrien);
		Prueba adrienTakesfarcab32 = new Prueba(farcab32, 28);
		adrienCfarcab3.agregarPrueba(adrienTakesfarcab32);
		Prueba adrienTakesfarcab31 = new Prueba(farcab31, 80);
		adrienCfarcab3.agregarPrueba(adrienTakesfarcab31);
		Prueba adrienTakesfarcab34 = new Prueba(farcab34, 26);
		adrienCfarcab3.agregarPrueba(adrienTakesfarcab34);
		Prueba adrienTakesfarcab33 = new Prueba(farcab33, 53);
		adrienCfarcab3.agregarPrueba(adrienTakesfarcab33);
		cal.set(2014, 8, 8);
		Cursada svetlanaCfarcab3 = new Cursada(farcab3, cal.getTime(), svetlana);
		Prueba svetlanaTakesfarcab32 = new Prueba(farcab32, 22);
		svetlanaCfarcab3.agregarPrueba(svetlanaTakesfarcab32);
		Prueba svetlanaTakesfarcab33 = new Prueba(farcab33, 56);
		svetlanaCfarcab3.agregarPrueba(svetlanaTakesfarcab33);
		cal.set(2015, 0, 16);
		Cursada svetlanaCsuppli1 = new Cursada(suppli1, cal.getTime(), svetlana);
		Prueba svetlanaTakessuppli14 = new Prueba(suppli14, 45);
		svetlanaCsuppli1.agregarPrueba(svetlanaTakessuppli14);
		cal.set(2015, 1, 23);
		Cursada olinCfarcab3 = new Cursada(farcab3, cal.getTime(), olin);
		Prueba olinTakesfarcab32 = new Prueba(farcab32, 70);
		olinCfarcab3.agregarPrueba(olinTakesfarcab32);
		Prueba olinTakesfarcab31 = new Prueba(farcab31, 66);
		olinCfarcab3.agregarPrueba(olinTakesfarcab31);
		Prueba olinTakesfarcab33 = new Prueba(farcab33, 22);
		olinCfarcab3.agregarPrueba(olinTakesfarcab33);
		Prueba olinTakesfarcab34 = new Prueba(farcab34, 78);
		olinCfarcab3.agregarPrueba(olinTakesfarcab34);
		cal.set(2015, 10, 30);
		Cursada olinCvivema2 = new Cursada(vivema2, cal.getTime(), olin);
		Prueba olinTakesvivema23 = new Prueba(vivema23, 37);
		olinCvivema2.agregarPrueba(olinTakesvivema23);
		Prueba olinTakesvivema22 = new Prueba(vivema22, 67);
		olinCvivema2.agregarPrueba(olinTakesvivema22);
		cal.set(2016, 2, 2);
		Cursada olinCsuppli4 = new Cursada(suppli4, cal.getTime(), olin);
		Prueba olinTakessuppli44 = new Prueba(suppli44, 71);
		olinCsuppli4.agregarPrueba(olinTakessuppli44);
		Prueba olinTakessuppli43 = new Prueba(suppli43, 60);
		olinCsuppli4.agregarPrueba(olinTakessuppli43);
		Prueba olinTakessuppli41 = new Prueba(suppli41, 32);
		olinCsuppli4.agregarPrueba(olinTakessuppli41);
		Prueba olinTakessuppli42 = new Prueba(suppli42, 97);
		olinCsuppli4.agregarPrueba(olinTakessuppli42);

		Curso palais1 = new Curso("Palais je ah traverse devant", frances, 1);
		Leccion palais11 = new Leccion("Profonde voyage sur art traverse remettre demeurons precieux voyage chantant");
		palais1.agregarLeccion(palais11);
		Leccion palais12 = new Leccion("Epouse profonde sortit remettre soutenir roc cet jambes or coupoles");
		palais1.agregarLeccion(palais12);
		Leccion palais13 = new Leccion("Coupoles traverse atroce triomphe sortaient ah rendre se roc prudence");
		palais1.agregarLeccion(palais13);
		sitio.agregarCurso(palais1);

		Curso toutef2 = new Curso("Toutefois des se six voyage", frances, 3);
		Leccion toutef21 = new Leccion("Soutenir demeurons prudence massacre reprendre net resterait sur or palais");
		toutef2.agregarLeccion(toutef21);
		Leccion toutef22 = new Leccion("Preferait toutefois jusque les net coupoles jambes preferait coupoles atroce");
		toutef2.agregarLeccion(toutef22);
		Leccion toutef23 = new Leccion(
				"Devant sortit cavernes ennemies preferait jambes echauffer soutenir reprendre toutefois");
		toutef2.agregarLeccion(toutef23);
		Leccion toutef24 = new Leccion("Coupoles campagne jambes blason demeurons annees art firmament se toi");
		toutef2.agregarLeccion(toutef24);
		sitio.agregarCurso(toutef2);

		Curso prenne3 = new Curso("Prennent se ah soutenir jusque", frances, 3);
		Leccion prenne31 = new Leccion("Rendre sur blason six firmament or prennent devant prennent toi");
		prenne3.agregarLeccion(prenne31);
		Leccion prenne32 = new Leccion("Rendre six rendre campagne les toutefois firmament ah firmament ennemies");
		prenne3.agregarLeccion(prenne32);
		sitio.agregarCurso(prenne3);

		Curso onpasr4 = new Curso("On pas roc net blason", frances, 3);
		Leccion onpasr41 = new Leccion("Je prudence prennent se jambes roc toutefois jambes rendre jusque");
		onpasr4.agregarLeccion(onpasr41);
		Leccion onpasr42 = new Leccion(
				"Echauffer blason triomphe epouse demeurons pourquoi triomphe ennemies echauffer epouse");
		onpasr4.agregarLeccion(onpasr42);
		Leccion onpasr43 = new Leccion("Rendre jusque net se je chantant palais demeurons coupoles net");
		onpasr4.agregarLeccion(onpasr43);
		sitio.agregarCurso(onpasr4);
		cal.set(2016, 1, 13);
		Cursada shilaCtoutef2 = new Cursada(toutef2, cal.getTime(), shila);
		Prueba shilaTakestoutef21 = new Prueba(toutef21, 74);
		shilaCtoutef2.agregarPrueba(shilaTakestoutef21);
		Prueba shilaTakestoutef24 = new Prueba(toutef24, 63);
		shilaCtoutef2.agregarPrueba(shilaTakestoutef24);
		Prueba shilaTakestoutef23 = new Prueba(toutef23, 78);
		shilaCtoutef2.agregarPrueba(shilaTakestoutef23);
		cal.set(2014, 7, 12);
		Cursada shilaCprenne3 = new Cursada(prenne3, cal.getTime(), shila);
		Prueba shilaTakesprenne32 = new Prueba(prenne32, 64);
		shilaCprenne3.agregarPrueba(shilaTakesprenne32);
		Prueba shilaTakesprenne31 = new Prueba(prenne31, 87);
		shilaCprenne3.agregarPrueba(shilaTakesprenne31);
		cal.set(2014, 9, 17);
		Cursada shilaConpasr4 = new Cursada(onpasr4, cal.getTime(), shila);
		Prueba shilaTakesonpasr42 = new Prueba(onpasr42, 29);
		shilaConpasr4.agregarPrueba(shilaTakesonpasr42);
		Prueba shilaTakesonpasr43 = new Prueba(onpasr43, 48);
		shilaConpasr4.agregarPrueba(shilaTakesonpasr43);
		cal.set(2016, 0, 23);
		Cursada shilaCpalais1 = new Cursada(palais1, cal.getTime(), shila);
		Prueba shilaTakespalais12 = new Prueba(palais12, 62);
		shilaCpalais1.agregarPrueba(shilaTakespalais12);
		cal.set(2015, 1, 22);
		Cursada svetlanaConpasr4 = new Cursada(onpasr4, cal.getTime(), svetlana);
		Prueba svetlanaTakesonpasr42 = new Prueba(onpasr42, 90);
		svetlanaConpasr4.agregarPrueba(svetlanaTakesonpasr42);
		Prueba svetlanaTakesonpasr41 = new Prueba(onpasr41, 79);
		svetlanaConpasr4.agregarPrueba(svetlanaTakesonpasr41);
		Prueba svetlanaTakesonpasr43 = new Prueba(onpasr43, 81);
		svetlanaConpasr4.agregarPrueba(svetlanaTakesonpasr43);
		cal.set(2016, 0, 15);
		Cursada carolynCprenne3 = new Cursada(prenne3, cal.getTime(), carolyn);
		Prueba carolynTakesprenne32 = new Prueba(prenne32, 87);
		carolynCprenne3.agregarPrueba(carolynTakesprenne32);
		Prueba carolynTakesprenne31 = new Prueba(prenne31, 46);
		carolynCprenne3.agregarPrueba(carolynTakesprenne31);

		return sitio;
	}

}