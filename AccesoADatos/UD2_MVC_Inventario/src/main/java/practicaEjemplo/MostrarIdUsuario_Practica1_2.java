package practicaEjemplo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.DaoUsuario;
import jdbc.ConexionJdbc;

public class MostrarIdUsuario_Practica1_2 {
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		DaoUsuario dao = new DaoUsuario();
		String nombre_u = null;
		String apellido1_u = null;
		String apellido2_u = null;
		List<Integer> result = new ArrayList<Integer>();
		
		try (Scanner tec = new Scanner(System.in)) {
			System.out.println("--> Nombre usuario:");
			nombre_u = tec.nextLine();
			
			System.out.println("--> Apellido 1 usuario:");
			apellido1_u = tec.nextLine();
			
			System.out.println("--> Apellido 2 usuario:");
			apellido2_u = tec.nextLine();
		}

		try {
			conJdbc = new ConexionJdbc("Configuracion/propiedadesInventario.txt");
			conJdbc.conectar();
			result = dao.filtrar_nombre_apell(nombre_u, apellido1_u, apellido2_u);
			for (Integer id : result) {
				System.out.println(id);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conJdbc.desconectar();
		}
	}
}
