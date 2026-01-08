package interfaces;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Equipos;
import pojos.Jugadores;
import pojos.Partidos;

public class Ejercicio_A {

	public static void main(String[] args) {

		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session sesion = factory.getCurrentSession();

		sesion.beginTransaction();
		// Recogo el partido
		Partidos partido = sesion.get(Partidos.class, 33);
		// Recogo los equipos
		Equipos equipoL = partido.getEquipos_partidos_l();
		Equipos equipoV = partido.getEquipos_partidos_v();
		// Recogo los jugadores de cada equipo
		List<Jugadores> jugadoresL = equipoL.getJugadores();
		List<Jugadores> jugadoresV = equipoV.getJugadores();

		// Jugadores equipo local
		System.out.println("-----" + equipoL.getNombre() + "-----");
		for (Jugadores jugador : jugadoresL) {
			System.out.println(jugador.getNombre());
		}

		// Jugadores equipo visitante
		System.out.println("-----" + equipoV.getNombre() + "-----");
		for (Jugadores jugador : jugadoresV) {
			System.out.println(jugador.getNombre());
		}
		System.out.println("");
		System.out.println("RESULTADO DEL PARTIDO: L:" + partido.getPuntos_local() + " | V:" + partido.getPuntos_visitante());

		sesion.getTransaction().commit();

		factory.close();
	}

}
