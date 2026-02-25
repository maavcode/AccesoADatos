package mvc_practica02;

import dao.DaoArticulo;
import jdbc.ConexionJdbc;
import pojos.Articulo;

public class EjercicioB4 {

	public static void main(String[] args) {
		// Conexion JDBC
				ConexionJdbc conJdbc = null;
				// Declaracion de DAOs
				DaoArticulo daoArticulo = new DaoArticulo();
				
				try {
					// SIEMPRE
				    conJdbc = new ConexionJdbc("Configuracion/propiedadesInventario.txt");
				    conJdbc.conectar();
				    
				    // CONTENIDO
				    daoArticulo.actualizarRetiradosMasivo();
				    
				    
				    System.out.println("Artículos Retirados correctamente");
				    
				} catch (Exception e) {
				    e.printStackTrace();
				} finally {
				    conJdbc.desconectar();
				}

	}

}
