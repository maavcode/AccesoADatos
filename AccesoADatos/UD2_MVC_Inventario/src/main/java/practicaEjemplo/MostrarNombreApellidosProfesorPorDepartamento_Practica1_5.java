package practicaEjemplo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.DaoUsuario;
import jdbc.ConexionJdbc;
import pojos.Usuario;

public class MostrarNombreApellidosProfesorPorDepartamento_Practica1_5 {
	
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		DaoUsuario dao = new DaoUsuario();
		Integer id_d = null;
		List<Usuario> result = new ArrayList<Usuario>();

		try (Scanner tec = new Scanner(System.in)) {
			System.out.println("--> ID departamento:");
			id_d = tec.nextInt();
		}

		try {
			conJdbc = new ConexionJdbc("Configuracion/propiedadesInventario.txt");
			conJdbc.conectar();
			result = dao.buscarPorDepartamento(id_d);
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
