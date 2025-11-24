package practicaEjemplo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.DaoUsuario;
import jdbc.ConexionJdbc;
import pojos.Usuario;

public class MostrarNombreApellidosAlumnosPorGrupo_Practica1_6 {
	
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		DaoUsuario dao = new DaoUsuario();
		String nombre_g = null;
		List<Usuario> result = new ArrayList<Usuario>();

		try (Scanner tec = new Scanner(System.in)) {
			System.out.println("--> Nombre del grupo:");
			nombre_g = tec.nextLine();
		}

		try {
			conJdbc = new ConexionJdbc("Configuracion/propiedadesInventario.txt");
			conJdbc.conectar();
			result = dao.buscarPorGrupo(nombre_g);
			for(Usuario a : result) {
				System.out.println(a.getNombre()+"-"+a.getApellido1()+"-"+a.getApellido2());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conJdbc.desconectar();
		}
	}

}
