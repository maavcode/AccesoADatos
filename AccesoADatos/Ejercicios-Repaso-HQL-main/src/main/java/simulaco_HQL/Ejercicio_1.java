package simulaco_HQL;

import java.util.List;
import java.util.Scanner;

import dao.DaoGrupo;
import hibernate.UtilesHibernate;

// Listar el nombre y país de todos los grupos ordenados por fecha de creación descendente.

public class Ejercicio_1 {

	public static void main(String[] args) {
		
		try {
			
			UtilesHibernate.openSession();
			
			DaoGrupo daoGrupo = new DaoGrupo();
			List<Object[]>lista = daoGrupo.listarNombrePaisDescFecha();
			
			for (Object[] fila : lista) {
				System.out.println("\nNombre: " + fila[0]);
				System.out.println("Pais: " + fila[1]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}
}
