package consultasHQL;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.DaoGrupo;
import hibernate.UtilesHibernate;

public class EjercicioO {

	public static void main(String[] args) {
		System.out.println(
				"----- Ejercicio O: Listar los discos de un grupo en un año -----");
		try {
			// Abro la sesion // SIEMPRE
			UtilesHibernate.openSession();

			Scanner sc = new Scanner(System.in);
			// Recogo los daos correspondientes
			DaoGrupo daoGrupo = new DaoGrupo();

			// Recogo el grupo
			System.out.println("Introduce el nombre del grupo: ");
			String nombre = sc.nextLine();
			System.out.println("Introduce el año de los discos: ");
			Integer fecha = sc.nextInt();
			
			List<String> listaDiscos = daoGrupo.buscarDiscosAñoPorGrupo(nombre, fecha);

			for (String string : listaDiscos) {
				System.out.println("Nombre: " + string);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally { // SIEMPRE
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}

	}

}
