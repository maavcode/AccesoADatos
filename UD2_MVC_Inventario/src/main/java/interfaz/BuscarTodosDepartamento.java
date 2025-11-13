package interfaz;

import java.util.List;

import dao.DaoDepartamento;
import jdbc.ConexionJdbc;
import pojos.Departamento;

public class BuscarTodosDepartamento {
	
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		DaoDepartamento dao = new DaoDepartamento();

		try {
		    conJdbc = new ConexionJdbc("Configuracion/propiedadesInventario.txt");
		    conJdbc.conectar();

		    List<Departamento> departamentos = dao.buscarTodos();

		    System.out.println("--> Todos los departamentos:");
		    for (Departamento d : departamentos) {
		        System.out.println(d.getIddepartamento() + " - " + d.getNombre());
		    }

		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    conJdbc.desconectar();
		}
	}

}
