package interfaz;

import java.util.Scanner;

import dao.DaoDepartamento;
import jdbc.ConexionJdbc;
import pojos.Departamento;

public class InsertarDepartamento {

	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		Departamento d = null;
		DaoDepartamento dao = new DaoDepartamento();
		String nombre_d = null;

		try (Scanner tec = new Scanner(System.in)) {
			System.out.println("--> Nombre nuevo departamento:");
			nombre_d = tec.nextLine();
		}

		try {
			conJdbc = new ConexionJdbc("Configuracion/propiedadesInventario.txt");
			conJdbc.conectar();
			d = new Departamento();
			d.setNombre(nombre_d);
			dao.grabar(d);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conJdbc.desconectar();
		}
	}
}
