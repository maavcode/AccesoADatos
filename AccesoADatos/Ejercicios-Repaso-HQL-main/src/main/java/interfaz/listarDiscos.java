package interfaz;

import java.util.ArrayList;
import java.util.List;

import dao.DaoDisco;
import dao.DaoGenericoHibernate;
import hibernate.UtilesHibernate;
import pojos.Disco;

public class listarDiscos {

	public static void main(String[] args) {
		
		List <Disco> listaDiscos = new ArrayList<Disco>();
		
		try { // Conectamos con la BD
			UtilesHibernate.openSession();
			DaoDisco daoDisco = new DaoDisco();
			
			// Buscar en la BD
			listaDiscos = daoDisco.buscarTodos();
			
			// Mostrar resultados
			for (Disco disco : listaDiscos) {
				System.out.println("Nombre: " + disco.getNombre() + "\n"
						+ "Companyia: " + disco.getCompanyia().getNombre() + "\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}
}
