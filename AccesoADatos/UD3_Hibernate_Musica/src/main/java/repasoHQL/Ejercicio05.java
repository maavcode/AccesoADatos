package repasoHQL;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.DaoCompanyia;
import dao.DaoDisco;
import dao.DaoGrupo;
import hibernate.UtilesHibernate;
import pojosEsther.Companyia;
import pojosEsther.Disco;
import pojosEsther.Grupo;

public class Ejercicio05 {

	public static void main(String[] args) {
		System.out.println("----- Ejercicio 5: Comprobar al crear un Disco de un Grupo, la fecha sea posterior a la creacion del Grupo -----");
		
		try {
			// Abro la sesión SIEMPRE
			UtilesHibernate.openSession();

			DaoGrupo daoGrupo = new DaoGrupo();
			DaoDisco daoDisco = new DaoDisco();
			DaoCompanyia daoCompanyia = new DaoCompanyia();

			Scanner sc = new Scanner(System.in);

			// 1. Nombre del disco
			System.out.println("Introduce el nombre del disco:");
			String nombreDisco = sc.nextLine();

			// 2. Nombre del grupo
			System.out.println("Introduce el nombre del grupo:");
			String nomGrupo = sc.nextLine();
			Grupo grupo = daoGrupo.buscarPorNombre(nomGrupo);

			if (grupo == null) {
			    System.out.println("No existe ese grupo.");
			    return;
			}

			// 3. Fecha de creación del disco
			System.out.println("Introduce la fecha de creación (dd/MM/yyyy):");
			String fechaStr = sc.nextLine();

			Date fechaCreacion = null;
			try {
			    fechaCreacion = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
			} catch (Exception e) {
			    System.out.println("Formato de fecha incorrecto.");
			    return;
			}

			Companyia comp = daoCompanyia.buscarPorNombre("Island");
			
			// 4. Crear el disco
			Disco nuevoDisco = new Disco(comp, grupo, nombreDisco, fechaCreacion, null);
			
			daoDisco.addDiscoAGrupo(grupo, nuevoDisco);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}