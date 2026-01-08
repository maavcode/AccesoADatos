package interfaces;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Entrenadores;
import pojos.Equipos;
import pojos.Jugadores;
import pojos.Partidos;

public class Ejercicio_C {

	public static void main(String[] args) {

		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session sesion = factory.getCurrentSession();

		sesion.beginTransaction();

		// Recogo el entrenador
		Entrenadores entrenador = sesion.get(Entrenadores.class, "1133");
		// Recogo el equipo del entrenador
		Equipos equipo = entrenador.getEquipos_entrenadores();
		// Recogo los partidos jugados, locales y visitntes
		List<Partidos> partidosL = equipo.getPartidos_local();
		List<Partidos> partidosV = equipo.getPartidos_visitante();

		System.out.println("Partidos con el entrenador: " + equipo.getEntrenadores().getNombre());
		
		// Partidos locales
		System.out.println("-----" + "Partidos locales" + "-----");
		for (Partidos partido : partidosL) {
			System.out.println("RESULTADO DEL PARTIDO: L:" + partido.getPuntos_local() + " | V:" + partido.getPuntos_visitante());
		}

		// Partidos visitantes
		System.out.println("-----" + "Partidos visitantes" + "-----");
		for (Partidos partido : partidosV) {
			System.out.println("RESULTADO DEL PARTIDO: L:" + partido.getPuntos_local() + " | V:" + partido.getPuntos_visitante());
		}

		

		sesion.getTransaction().commit();

		factory.close();
	}

}
