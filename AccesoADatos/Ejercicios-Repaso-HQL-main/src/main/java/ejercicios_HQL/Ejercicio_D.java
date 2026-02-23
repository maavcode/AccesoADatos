package ejercicios_HQL;

import java.util.List;

import dao.DaoCompanyia;
import hibernate.UtilesHibernate;
import pojos.Companyia;

public class Ejercicio_D {

	public static void main(String[] args) {
		// DaoCompañia(mostrar campos) Listar el nombre y el
		// teléfono de todas las compañías 
		
		try {
			UtilesHibernate.openSession();
			DaoCompanyia daoCompanyia = new DaoCompanyia();
			
			List<Companyia> listaCompanyias = daoCompanyia.buscarTodos();
			
			for (Companyia companyia : listaCompanyias) {
				System.out.println("Nombre: " + companyia.getNombre() + "\n"
						+ "Telefono:" + companyia.getTfno() + "\n");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
