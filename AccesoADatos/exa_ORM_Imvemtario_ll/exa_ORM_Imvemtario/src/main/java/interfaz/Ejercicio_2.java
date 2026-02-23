package interfaz;

import dao.DaoArticulo;
import excepciones.BusinessException;
import hibernate.UtilesHibernate;

public class Ejercicio_2 {

	public static void main(String[] args) throws BusinessException {
		
		try {
			//Creamos la conexion con el Pojo
			DaoArticulo daoArticulo = new DaoArticulo();
			
			//Conectamos con la base de datos
			UtilesHibernate.openSession();
			
			// Establecemos datos
			String nombreModelo = "PM-10";
			String nuevasObservaciones = "artículos retirados Jon";
			
			
			// Llamamos al método
			daoArticulo.modificarObservacionesArticulosPorModelo(nombreModelo, nuevasObservaciones);
			
		} catch (Exception e) {
			throw new BusinessException("Se ha encontrado un error: "+e );
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
