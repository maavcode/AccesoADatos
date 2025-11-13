package practicaEjemplo;

import java.util.Scanner;

import dao.DaoGrupo;
import jdbc.ConexionJdbc;
import pojos.Grupo;

public class InsertarGrupo_Practica1_1 {

	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		Grupo d = null;
		DaoGrupo dao = new DaoGrupo();
		String id_g = null;
		String nombre_g = null;

		try (Scanner tec = new Scanner(System.in)) {
			System.out.println("--> ID nuevo grupo:");
			id_g = tec.nextLine();
			System.out.println("--> Nombre nuevo grupo:");
			nombre_g = tec.nextLine();
		}

		try {
			conJdbc = new ConexionJdbc("Configuracion/propiedadesInventario.txt");
			conJdbc.conectar();
			d = new Grupo();
			d.setIdgrupo(id_g);
			d.setNombre(nombre_g);
			dao.grabar(d);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conJdbc.desconectar();
		}
	}
}
