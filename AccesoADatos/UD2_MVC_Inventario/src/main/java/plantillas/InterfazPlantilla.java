package plantillas;

import jdbc.ConexionJdbc;

public class InterfazPlantilla {
	
	public static void main(String[] args) {
		// Conexion JDBC
		ConexionJdbc conJdbc = null;
		// Declaracion de DAOs
		
		try {
			// SIEMPRE
		    conJdbc = new ConexionJdbc("Configuracion/propiedadesInventario.txt");
		    conJdbc.conectar();
		    
		    // CONTENIDO
		    

		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    conJdbc.desconectar();
		}

	}
}
