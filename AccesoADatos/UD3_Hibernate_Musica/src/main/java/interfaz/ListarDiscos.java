package interfaz;

import java.util.List;

import dao.DaoDisco;
import hibernate.UtilesHibernate;
import pojosEsther.Disco;

public class ListarDiscos {

	public static void main(String[] args) {
		try {
			// Abro la sesion y declaro el dao a usar // SIEMPRE
			UtilesHibernate.openSession();
			DaoDisco daoDisco = new DaoDisco();
			
			// Recogo todos los discos
			List<Disco> listaDiscos = daoDisco.buscarTodos();
			
			// Recorro los discos
			for (Disco disco : listaDiscos) {
				System.out.println("Disco: " + disco.getNombre() + " | Companyia: " + disco.getCompanyia().getNombre());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // SIEMPRE
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
