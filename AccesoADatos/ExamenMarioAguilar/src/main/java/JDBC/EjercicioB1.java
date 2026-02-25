package JDBC;

import java.util.List;
import java.util.Scanner;

import dao.DaoGrupoMatri;
import jdbc.ConexionJdbc;

public class EjercicioB1 {
	public static void main(String[] args) {
		// Conexion JDBC
		ConexionJdbc conJdbc = null;
		DaoGrupoMatri daoGrupoMati = new DaoGrupoMatri();
		try {
			// SIEMPRE
			conJdbc = new ConexionJdbc("Configuracion/propiedadesExamen.txt");
			conJdbc.conectar();
			
			Scanner sc = new Scanner(System.in);
			
			// PEDIR DATOS
			System.out.println("Codigo de la asignatura:");
			String codAsig = sc.nextLine();
			
			List<Object[]> informe = daoGrupoMati.consultarEstadoOcupacionPorAsignatura(codAsig);
			
			for (Object[] object : informe) {
				Integer numMatriculas = (Integer) object[1];
				if (numMatriculas < 5) {
					System.out.println(object[0] + "-" + object[2] + "-ocupacion BAJA");
				} else {
					System.out.println(object[0] + "-" + object[2] + "-ocupacion ALTA");
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conJdbc.desconectar();
		}
	}
}
