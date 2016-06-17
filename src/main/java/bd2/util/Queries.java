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

public class Queries {

  private static SessionFactory sessions;

  public static void main(String[] args) {
      Configuration cfg = new Configuration();
      cfg.configure("hibernate/hibernate.cfg.xml");
      sessions = cfg.buildSessionFactory();
      Session session = sessions.openSession();
      try {
          // consultaA(session);
          // consultaB(session);
          // consultaC(session);
          // Calendar fechaInicio = Calendar.getInstance();
          // fechaInicio.set(2015, 7, 1);
          // Calendar fechaFin = Calendar.getInstance();
          // fechaFin.set(2015, 12, 31);
          // consultaD(session, fechaInicio.getTime(), fechaFin.getTime());
          // consultaE(session);
          // consultaF(session); TODO: hacer!
          // consultaG(session, "Leuchtturm");
          consultaH(session);
      } catch (Exception e) {
          e.printStackTrace();
          session.close();
      }
      finally {
          session.disconnect() ;}
  }

  private static void consultaA(Session session) {
      Transaction tx = null;
      System.out.println("A.    Listar los nombres de todos los documentos ");

      Query query = session.createQuery("from Documento");

      try {
          tx = session.beginTransaction();
          List<Documento> documentos = query.list();
          tx.commit();
          session.flush();
          for (Documento d: documentos) {
              System.out.println("Documento: "+d.getNombre());
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

  private static void consultaB(Session session) {
    Transaction tx = null;
    System.out.println("B.  Listar los emails de los moderadores que hayan evaluado traducciones al inglés.");

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

  private static void consultaC(Session session) {
    Transaction tx = null;
    System.out.println("C.  Listar los usuarios que hayan iniciado una cursada de Frances de nivel 3 como minimo.");

    Query query = session.createQuery("from Usuario u "
        + " where exists ( from Cursada c"
        + " where c in elements(u.cursadasRealizadas) "
        + " and c.curso.idioma.nombre = 'Francés' "
        + " and c.curso.nivel >= 3) ");

    try {
      tx = session.beginTransaction();
      List<Usuario> usuarios = query.list();
      tx.commit();
      session.flush();
      for (Usuario usuario: usuarios) {
        System.out.println("Nombre: "+usuario.getNombre());
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

  private static void consultaD(Session session, Date fechaInicio, Date fechaFin) {
    Transaction tx = null;
    System.out.println("D.  Listar moderadores que hayan revisado alguna traducción entre dos fechas pasadas como argumento.");
    System.out.println("Resultado para los parámetros: "+fechaInicio+" hasta "+fechaFin);

    Query query = session.createQuery("from Moderador m "
        + " where exists ( from Evaluacion e"
        + " where e in elements(m.evaluaciones) "
        + "and e.fecha between :fechaInicio and :fechaFin) ")
        .setParameter("fechaInicio", fechaInicio).setParameter("fechaFin", fechaFin);

    try {
      tx = session.beginTransaction();
      List<Moderador> moderadores = query.list();
      tx.commit();
      session.flush();
      for (Moderador moderador: moderadores) {
        System.out.println("Nombre: "+moderador.getNombre());
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

  private static void consultaE(Session session) {
    Transaction tx = null;
    System.out.println("E.  Listar traducciones completas del Inglés al Francés.");

    Query query = session.createQuery("from Traduccion t "
        + " where t.idioma.nombre = 'Francés' "
        + " and t.parrafo.documento.idioma.nombre = 'Inglés' "
        + " and t.completa = true");

    try {
      tx = session.beginTransaction();
      List<Traduccion> traducciones = query.list();
      tx.commit();
      session.flush();
      for (Traduccion traduccion: traducciones) {
        System.out.println("Nombre: " + traduccion.getDescripcion());
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
        System.out.println("El idioma " + idioma.getNombre() + " define la palabra " + palabra);
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

  private static void consultaH(Session session) {
    Transaction tx = null;
    System.out.println(" H. Obtener los nombres de los documentos que no tengan ningún párrafo traducido (en ningún idioma) ");

    // Query query = session.createQuery("from Documento d "
    //         + " where not exists (from Traduccion t"
    //         + " where exists (from t.parrafo.documento))");

    Query query = session.createQuery("from Documento d "
            + " where not exists (from Traduccion.parrafo.documento)");

    try {
      tx = session.beginTransaction();
      List<Documento> documentos = query.list();
      // List<Traduccion> documentos = query.list();
      tx.commit();
      session.flush();
      // for (Traduccion documento: documentos) {
        // System.out.println("El documento " + documento.getId() + " no tiene ninguna traducción.");
      // }
      for (Documento documento: documentos) {
        System.out.println("El documento " + documento.getNombre() + " no tiene ninguna traducción.");
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
