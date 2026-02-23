package simulaco_HQL;

import java.util.List;

import dao.DaoDisco;
import hibernate.UtilesHibernate;

// Listar el nombre del disco y la duración total del disco
// (la suma de la duración de sus canciones).


public class Ejercicio_4 {

	public static void main(String[] args) {
		try {
			
			UtilesHibernate.openSession();
			
			DaoDisco daoDisco = new DaoDisco();
			
			List<Object[]> lista = daoDisco.nombreDuracionDisco();
			
			for (Object[] fila : lista) {
				System.out.println("\nNombre: " + fila[0]);
				System.out.println("Duracion: " + fila[1] + "minutos.\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
