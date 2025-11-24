package practicaEjemplo;

import java.util.Scanner;

import dao.DaoGrupo;
import jdbc.ConexionJdbc;
import pojos.Grupo;

public class ActualizarNombreGrupoPorId_Practica1_4 {
	
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		Grupo g = null;
		DaoGrupo dao = new DaoGrupo();
		String id_g = null;
		String nombre_g = null;

		try (Scanner tec = new Scanner(System.in)) {
			System.out.println("--> ID existente del grupo:");
			id_g = tec.nextLine();
			System.out.println("--> Nombre nuevo del grupo:");
			nombre_g = tec.nextLine();
		}

		try {
			conJdbc = new ConexionJdbc("Configuracion/propiedadesInventario.txt");
			conJdbc.conectar();
			g = new Grupo();
			g.setIdgrupo(id_g);
			g.setNombre(nombre_g);
			dao.actualizar(g);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conJdbc.desconectar();
		}
	}

}
