package consultasHQL;

import java.util.List;
import java.util.Scanner;

import dao.DaoClub;
import dao.DaoCompanyia;
import dao.DaoGrupo;
import hibernate.UtilesHibernate;
import pojosEsther.Club;
import pojosEsther.Companyia;
import pojosEsther.Grupo;

public class EjercicioD {
	public static void main(String[] args) {
		System.out.println("----- Ejercicio D: Listar nombre y telefono de todas las companyias -----");
		try {
			// Abro la sesion // SIEMPRE
			UtilesHibernate.openSession();

			DaoCompanyia daoCompanyia = new DaoCompanyia();
			
			List<Companyia> listaCompanyias = daoCompanyia.buscarTodos();
			
			for (Companyia companyia : listaCompanyias) {
				System.out.println("Companyia: " + companyia.getNombre() + " | Telefono: " + companyia.getTfno());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // SIEMPRE
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}
}
