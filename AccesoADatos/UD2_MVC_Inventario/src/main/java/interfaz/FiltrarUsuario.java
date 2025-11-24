package interfaz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.DaoUsuario;
import jdbc.ConexionJdbc;

public class FiltrarUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConexionJdbc conJdbc = null;
		String nombre, ape1, ape2 ="";
		List<Integer> result = new ArrayList<Integer>();
		
		DaoUsuario daoUsuario = new DaoUsuario();
		
		String nombre_d = null;
		
		// Valores de entrada
		Scanner tec = new Scanner(System.in);
		System.out.println("nombre Usuario");
		nombre = tec.nextLine();
		
		System.out.println("apellido1 Usuario");
		ape1 = tec.nextLine();
		
		System.out.println("apellido2 Usuario");
		ape2 = tec.nextLine();
		
		try {
			conJdbc = new ConexionJdbc("Configuracion/propiedadesInventario.txt");
			conJdbc.conectar();
			
			result = daoUsuario.filtrar_nombre_apell(nombre, ape1, ape2);
			for (Integer id:result) {
				System.out.println(id);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conJdbc.desconectar();
		}
		
	}

}
