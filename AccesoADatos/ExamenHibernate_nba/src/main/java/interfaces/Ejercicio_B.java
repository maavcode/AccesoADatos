package interfaces;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.UtilesHibernate;
import pojos.Equipos;
import pojos.Jugadores;
import pojos.Partidos;

public class Ejercicio_B {

	public static void main(String[] args) {
		
		SessionFactory factory = UtilesHibernate.getSessionFactory();
		Session sesion = factory.getCurrentSession();

		sesion.beginTransaction();
		
		// Recogo el jugador pedido
		Jugadores jugador = sesion.get(Jugadores.class, 11);
		// Recogo el equipo pedido
		Equipos equipo = sesion.get(Equipos.class, "Miami Heat");
		
		// Le pongo al jugador seleccionado el nuevo equipo
		jugador.setEquipos_jugadores(equipo);

		sesion.getTransaction().commit();

		factory.close();
	}

}
