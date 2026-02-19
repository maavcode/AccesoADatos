package repasoHQL;

import java.util.List;

import dao.DaoDisco;
import hibernate.UtilesHibernate;

public class Ejercicio06 {

	public static void main(String[] args) {
		System.out.println("----- Ejercicio 6: Obtener lista con la duración total de cada Disco -----");
		
		try {
			// Abro la sesion // SIEMPRE
			UtilesHibernate.openSession();
			
			DaoDisco daoDisco = new DaoDisco(); 
			List<Object[]> lista = daoDisco.obtenerDuracionTotalDeTodos();
			
			for (Object[] fila : lista) { 
				String nombre = (String) fila[0]; 
				Double duracion = (Double) fila[1];
				System.out.println(nombre + " | " + duracion + " minutos");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally { // SIEMPRE
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}
}
