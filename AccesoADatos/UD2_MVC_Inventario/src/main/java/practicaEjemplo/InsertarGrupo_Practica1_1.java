package practicaEjemplo;

import java.util.Scanner;
import dao.DaoGrupo;
import jdbc.ConexionJdbc;
import pojos.Grupo;

public class InsertarGrupo_Practica1_1 {

	public static void main(String[] args) {
		
		// Declaración de referencias NECESARIAS
		ConexionJdbc conJdbc = null;  // Maneja la conexión con la base de datos
		Grupo d = null;              // Objeto que representará el grupo a insertar
		DaoGrupo dao = new DaoGrupo(); // Clase DAO responsable de las operaciones sobre la tabla grupo
		String id_g = null;          // Almacenará el ID introducido por el usuario
		String nombre_g = null;      // Almacenará el nombre introducido por el usuario

		
		// Bloque para solicitar datos al usuario (Scanner se cierra automáticamente por try-with-resources)
		try (Scanner tec = new Scanner(System.in)) {
			System.out.println("--> ID nuevo grupo:"); 
			id_g = tec.nextLine(); // Lectura del campo ID del usuario
			
			System.out.println("--> Nombre nuevo grupo:");
			nombre_g = tec.nextLine(); // Lectura del campo nombre del usuario
		}

		
		try {
			// Se crea el objeto de conexión con el archivo de configuración que contiene
			// los datos necesarios para conectar a la base de datos (URL, usuario, etc.)
			conJdbc = new ConexionJdbc("Configuracion/propiedadesInventario.txt");
			
			// Se establece la conexión con la BD
			conJdbc.conectar();
			
			// Se crea un nuevo grupo y se cargan en él los datos introducidos por el usuario
			d = new Grupo();
			d.setIdgrupo(id_g);
			d.setNombre(nombre_g);

			// Se llama al método grabar() del DAO, que inserta los datos en la tabla grupo
			dao.grabar(d);

		} catch (Exception e) {
			// Muestra el error por pantalla si ocurre algún problema durante la inserción o la conexión
			e.printStackTrace();
			
		} finally {
			// El bloque finally se ejecuta siempre.
			// Se cierra la conexión con la base de datos para liberar recursos.
			conJdbc.desconectar();
		}
	}
}
