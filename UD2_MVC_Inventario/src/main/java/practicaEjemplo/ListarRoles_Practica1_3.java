package practicaEjemplo;

import java.util.ArrayList;
import java.util.List;

import dao.DaoRol;
import jdbc.ConexionJdbc;
import pojos.Rol;

public class ListarRoles_Practica1_3 {
	
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		DaoRol dao = new DaoRol();
		List<Rol> result = new ArrayList<Rol>();

		try {
			conJdbc = new ConexionJdbc("Configuracion/propiedadesInventario.txt");
			conJdbc.conectar();
			result = dao.buscarTodos();
			for(Rol id : result) {
				System.out.println(id.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conJdbc.desconectar();
		}
	}

}
