package bd2.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bd2.model.*;

/**
 * The Class Queries.
 */
public class Queries {

  /** The sessions. */
  private static SessionFactory sessions;

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
      Configuration cfg = new Configuration();
      cfg.configure("hibernate/hibernate.cfg.xml");
      sessions = cfg.buildSessionFactory();
      Session session = sessions.openSession();
      try {
          consultaA(session);
          consultaB(session);
          consultaC(session);
          Calendar fechaInicio = Calendar.getInstance();
          fechaInicio.set(2015, 7, 1);
          Calendar fechaFin = Calendar.getInstance();
          fechaFin.set(2015, 12, 31);
          consultaD(session, fechaInicio.getTime(), fechaFin.getTime());
          consultaE(session);
          consultaF(session);
          consultaG(session, "Leuchtturm");
          consultaH(session);
          consultaI(session, "Alemán");
      } catch (Exception e) {
          e.printStackTrace();
          session.close();
      }
      finally {
          session.disconnect() ;}
  }

  /**
   * Consulta a.
   *
   * @param session the session
   *
   */
  private static void consultaA(Session session) {
      Transaction tx = null;
      System.out.println("A. Listar los nombres de todos los documentos ");

      Query query = session.createQuery("from Documento");

      try {
          tx = session.beginTransaction();
          List<Documento> documentos = query.list();
          tx.commit();
          session.flush();

          for (Documento documento: documentos) {
              String output = "Documento: " + documento.getNombre();
              System.out.println(output);
          }
          System.out.println();

      } catch (HibernateException e) {
          e.printStackTrace();
      } catch (Exception e) {
          e.printStackTrace();
          if (tx != null) {
              tx.rollback();}
      }
  }

  /**
   * Consulta b: Lista emails de los moderadores que hayan evaluado traducciones al ingles.
   *
   * @param session: Objeto SessionFactory
   */
  private static void consultaB(Session session) {
    Transaction tx = null;
    System.out.println("B. Listar los emails de los moderadores que hayan evaluado traducciones al inglés.");

    Query query = session.createQuery("select email from Moderador m"
        + " where exists ( from Evaluacion e"
        + " where e in elements(m.evaluaciones) "
        + " and e.traduccion.idioma.nombre = 'Inglés') ");

    try {
      tx = session.beginTransaction();
      List<String> emails = query.list();
      tx.commit();
      session.flush();
      for (String email: emails) {
        System.out.println("Email: "+email);
      }
      System.out.println();

    } catch (HibernateException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
      if (tx != null) {
        tx.rollback();}
    }
  }

  /**
   * Consulta c: Lista usuarios que hayan iniciado una cursada del idioma Frances de nivel 3 o superior.
   *
   * @param session: Objeto SessionFactory
   */
  private static void consultaC(Session session) {
    Transaction tx = null;
    System.out.println("C. Listar los usuarios que hayan iniciado una cursada de Frances de nivel 3 como minimo.");

    Query query = session.createQuery("from " + Usuario.class.getName() + " u "
        + " where exists ( from " + Cursada.class.getName() + " c"
        + " where c in elements(u.cursadasRealizadas) "
        + " and c.curso.idioma.nombre = 'Francés' "
        + " and c.curso.nivel >= 3) ");

    try {
      tx = session.beginTransaction();
      List<Usuario> usuarios = query.list();
      tx.commit();
      session.flush();

      for (Usuario usuario: usuarios) {
          String output = "Nombre: "+usuario.getNombre();
          System.out.println(output);
      }
      System.out.println();

    } catch (HibernateException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
      if (tx != null) {
        tx.rollback();}
    }
  }

  /**
   * Consulta d: Lista los moderadores que hayan revisado alguna traduccion entre dos fechas recibidas por parametro.
   *
   * @param session: Objeto SessionFactory
   * @param fechaInicio: Objeto Date que representa el inicio del rango a buscar las traducciones.
   * @param fechaFin: Objeto Date que representa el fin del rango a buscar las traducciones.
   */
  private static void consultaD(Session session, Date fechaInicio, Date fechaFin) {
    Transaction tx = null;
    System.out.println("D. Listar moderadores que hayan revisado alguna traducción entre dos fechas pasadas como argumento.");
    System.out.println("Resultado para los parámetros: "+fechaInicio+" hasta "+fechaFin);

    Query query = session.createQuery("from " + Moderador.class.getName() + " m "
            + " where exists ( from " + Evaluacion.class.getName() + " e"
            + " where e in elements(m.evaluaciones) "
            + "and e.fecha between :fechaInicio and :fechaFin) ")
        .setParameter("fechaInicio", fechaInicio)
        .setParameter("fechaFin", fechaFin);

    try {
      tx = session.beginTransaction();
      List<Moderador> moderadores = query.list();
      tx.commit();
      session.flush();

      for (Moderador moderador: moderadores) {
          String output = "Nombre: "+moderador.getNombre();
          System.out.println(output);
      }
      System.out.println();

    } catch (HibernateException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
      if (tx != null) {
        tx.rollback();}
    }
  }

  /**
   * Consulta e: Lista traducciones completas del Ingles al Frances.
   *
   * @param session: Objeto SessionFactory
   *
   */
  private static void consultaE(Session session) {
    Transaction tx = null;
    System.out.println("E. Listar traducciones completas del Inglés al Francés.");

    Query query = session.createQuery("from " + Traduccion.class.getName() + " t "
            + " where t.idioma.nombre = 'Francés' "
            + " and t.parrafo.documento.idioma.nombre = 'Inglés' "
            + " and t.completa = true");

    try {
      tx = session.beginTransaction();
      List<Traduccion> traducciones = query.list();
      tx.commit();
      session.flush();

      for (Traduccion traduccion: traducciones) {
          String output = "Nombre: " + traduccion.getDescripcion();
          System.out.println(output);
      }
      System.out.println();

    } catch (HibernateException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
      if (tx != null) {
        tx.rollback();}
    }
  }

  /**
   * Consulta f: Lista los emails de los usuarios que tengan al menos una cursada aprobada.
   *
   * @param session: Objeto SessionFactory
   */
  private static void consultaF(Session session) {
    Transaction tx = null;
    System.out.println("F. Obtener los emails de los usuarios con alguna cursada aprobada.");

    Query query = session.createQuery(" from " + Usuario.class.getName() + " u "
            + " where exists ( "
            + " from " + Cursada.class.getName() + " cursada"
            + " where cursada in elements(u.cursadasRealizadas)"
            + " and not exists ( "
            + " from " + Leccion.class.getName() + " l "
            + " where l in elements(cursada.curso.lecciones) "
            + " and l not in ( "
            + " from " + Leccion.class.getName() + " l2 "
            + " where exists ( "
            + " from " + Prueba.class.getName() + " p "
            + " where p.puntaje >= 60 "
            + " and p.leccion = l2 "
            + " and p in elements(cursada.pruebas)"
            + " and p.leccion in elements(cursada.curso.lecciones) )  "
            + ") ) )");

    try {
      tx = session.beginTransaction();
      List<Usuario> usuarios = query.list();
      tx.commit();
      session.flush();

      for (Usuario usuario: usuarios) {
          String output = "Usuario con cursada aprobada: " + usuario.getEmail();
          System.out.println(output);
      }
      System.out.println();

    } catch (HibernateException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
      if (tx != null) {
        tx.rollback();}
    }
  }

  /**
   * Consulta g: Lista el idioma que define la palabra recibida por parametro en su diccionario.
   *
   * @param session: Objeto SessionFactory
   * @param palabra: Objeto String que representa la palabra de la cual vamos a buscar su idioma.
   */
  private static void consultaG(Session session, String palabra) {
    Transaction tx = null;
    System.out.println("G. Obtener el idioma que define la palabra enviada como parámetro en su diccionario.");
    System.out.println("Resultados para el parámetro: " + palabra);

    Query query = session.createQuery("select d.idioma from Diccionario d "
            + " where :palabra in indices(d.definiciones)")
            .setParameter("palabra", palabra);

    try {
      tx = session.beginTransaction();
      List<Idioma> idiomas = query.list();
      tx.commit();
      session.flush();

      for (Idioma idioma: idiomas) {
          String output = "El idioma " + idioma.getNombre() + " define la palabra " + palabra;
          System.out.println(output);
      }
      System.out.println();

    } catch (HibernateException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
      if (tx != null) {
        tx.rollback();}
    }
  }

  /**
   * Consulta h: Lista nombre de los documentos que no tengan parrafos traducidos.
   *
   * @param session: Objeto SessionFactory
   */
  private static void consultaH(Session session) {
    Transaction tx = null;
    System.out.println(" H. Obtener los nombres de los documentos que no tengan ningún párrafo traducido (en ningún idioma) ");

    Query query = session.createQuery("from Documento d "
            + " where d not in (select t.parrafo.documento from " + Traduccion.class.getName() + " t)");

    try {
      tx = session.beginTransaction();
      List<Documento> documentos = query.list();
      tx.commit();
      session.flush();

      for (Documento documento: documentos) {
          String output = "El documento " + documento.getNombre() + " no tiene ninguna traducción.";
          System.out.println(output);
      }
      System.out.println();

    } catch (HibernateException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
      if (tx != null) {
        tx.rollback();}
    }
  }

  /**
   * Consulta i: Lista nombre de los documentos que tengan parrafos sin traducir en el idioma recibido como parametro.
   *
   * @param session: Objeto SessionFactory
   * @param idioma: Objeto String que representa el idioma por el cual vamos a buscar documentos sin traducir.
   */
  private static void consultaI(Session session, String idioma) {
        Transaction tx = null;
        System.out.println("I. Obtener los nombres de los documentos que tengan párrafos sin traducir al idioma de nombre enviado como parámetro.");
        System.out.println("Resultados para el parámetro: "+idioma);

        Query query = session.createQuery("select distinct p.documento from " + Parrafo.class.getName() + " p"
                + " where p not in ( select t.parrafo from " + Traduccion.class.getName() + " t"
                + " where :idioma = t.idioma.nombre)").setParameter("idioma", idioma);

        try {
            tx = session.beginTransaction();
            List<Documento> documentos = query.list();
            tx.commit();
            session.flush();

            for (Documento documento: documentos) {
                String output = "El documento "+documento.getNombre()+" no esta totalmente traducido.";
                System.out.println(output);
            }
            System.out.println();

        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();}
        }
    }
}
