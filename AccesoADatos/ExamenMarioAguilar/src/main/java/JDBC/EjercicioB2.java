package JDBC;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import dao.DaoPractica;
import jdbc.ConexionJdbc;

public class EjercicioB2 {
	public static void main(String[] args) {
		// Conexion JDBC
		ConexionJdbc conJdbc = null;
		DaoPractica daoPractica = new DaoPractica();

		try {
			// SIEMPRE
			conJdbc = new ConexionJdbc("Configuracion/propiedadesExamen.txt");
			conJdbc.conectar();
			
			Scanner sc = new Scanner(System.in);
			
			// PEDIR DATOS
			System.out.println("Codigo de la practica:");
			String codP = sc.nextLine();
			
			System.out.println("Nombre del alumno:");
			String nomAlumno = sc.nextLine();
			
			System.out.println("Fecha de la presentacion:");
			String fechaPresentacion = sc.nextLine();
			Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaPresentacion);
			
			System.out.println("Nota:");
			Integer nota = sc.nextInt();
			
			daoPractica.presentarPractica(codP, nomAlumno, fecha, nota);
			
			System.out.println("Practica presentada correctamente");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conJdbc.desconectar();
		}

	}
}
