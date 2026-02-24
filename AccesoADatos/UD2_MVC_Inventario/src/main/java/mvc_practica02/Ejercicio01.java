package mvc_practica02;

import dao.DaoArticulo;
import jdbc.ConexionJdbc;
import pojos.Articulo;

public class Ejercicio01 {

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
		    // Crear artículo 
		    Articulo nuevoArticulo = new Articulo(); 
		    nuevoArticulo.setIdArticulo(60001); // Aumenar para probar
		    nuevoArticulo.setNumserie("SN-12345"); 
		    nuevoArticulo.setModelo(2600); 
		    nuevoArticulo.setDepartamento(3); 
		    nuevoArticulo.setEspacio(5); 
		    nuevoArticulo.setUsuarioalta(481);
		    
		    // Insertar Articulo
		    daoArticulo.grabar(nuevoArticulo);
		    
		    System.out.println("Artículo insertado correctamente");
		    
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    conJdbc.desconectar();
		}

	}

}
