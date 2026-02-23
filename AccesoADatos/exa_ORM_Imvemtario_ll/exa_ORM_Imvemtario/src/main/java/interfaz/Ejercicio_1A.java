package interfaz;

import java.util.ArrayList;
import java.util.List;

import dao.DaoArticulo;
import excepciones.BusinessException;
import hibernate.UtilesHibernate;

public class Ejercicio_1A {

	public static void main(String[] args) throws BusinessException {
		
		List<Object[]> articulosEncontrados = new ArrayList<Object[]>();
		
		try {
			//Creamos la conexion con el Pojo
			DaoArticulo daoArticulo = new DaoArticulo();
			
			//Conectamos con la base de datos
			UtilesHibernate.openSession();
			
			//Leer datos de entrada del usuario
			String nombreDepartamento = UtilsJV.promptForString("Introduzca el nombre del departamento: ");
			// Ejemplo: Comunicación, Imagen y Sonido
			
			articulosEncontrados = daoArticulo.buscarArticulosPorNombreDepartamento(nombreDepartamento);
			
			System.out.println("\n\n Artículos dados de baja de "+nombreDepartamento+": ");
			if(articulosEncontrados.size() != 0) {
				for(Object[] articulo : articulosEncontrados) {
					System.out.println("  - - - - - - - - - - - - ");
					System.out.println("  - Usuario baja: "+articulo[0]);
					System.out.println("  - ID artículo: "+articulo[1]);
					System.out.println("  - Fecha de baja: "+articulo[2]);
					System.out.println("  - Tipo artículo: "+articulo[3]);
				}
				System.out.println("  - - - - - - - - - - - - ");
			} else {
				System.err.println("No se ha encontrado ningun grupo");
			}
		} catch (Exception e) {
			throw new BusinessException("Se ha encontrado un error: "+e );
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
