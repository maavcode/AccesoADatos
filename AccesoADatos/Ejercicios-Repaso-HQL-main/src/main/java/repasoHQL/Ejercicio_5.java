package repasoHQL;

import java.util.Date;
import java.util.Scanner;

import dao.DaoCompanyia;
import dao.DaoGrupo;
import hibernate.UtilesHibernate;
import pojos.Companyia;
import pojos.Disco;
import pojos.Grupo;

// Comprueba que al crear un nuevo disco de un grupo, la fecha de creación del disco a de ser
// posterior a la fecha de creación del grupo.

public class Ejercicio_5 {

	public static void main(String[] args) {
		
		try {
			
			UtilesHibernate.openSession();
			
			DaoGrupo daoGrupo = new DaoGrupo();
			DaoCompanyia daoCompanyia = new DaoCompanyia();
			
			Grupo grupo = daoGrupo.buscarPorId(1);
			Companyia companyia = daoCompanyia.buscarPorId(1);
			
			Disco disco = new Disco(companyia, grupo, "Disco ejemplo", new Date(), null);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Introduce el grupo al que vas a introducir el disco: ");
			String nombreGrupo = sc.nextLine();
			
			daoGrupo.insertarDiscoFechaAnteriorAGrupo(nombreGrupo, disco);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
