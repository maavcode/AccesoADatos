package interfaz;

import java.util.Scanner;

import dao.DaoDepartamento;
import jdbc.ConexionJdbc;
import pojos.Departamento;

public class ActualizarDepartamento {
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		Departamento d = null;
		DaoDepartamento dao = new DaoDepartamento();
		String nombre_d = null;
		Integer id_d = null;

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("--> Nombre nuevo del departamento:");
			nombre_d = sc.nextLine();
			System.out.println("--> Id del departamento:");
			id_d = sc.nextInt();
		}

		try {
			conJdbc = new ConexionJdbc("Configuracion/propiedadesInventario.txt");
			conJdbc.conectar();
			d = new Departamento();
			d.setNombre(nombre_d);
			d.setIddepartamento(id_d);
			dao.actualizar(d);
			System.out.println("--> Actualizado correctamente");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conJdbc.desconectar();
		}
	}
}
