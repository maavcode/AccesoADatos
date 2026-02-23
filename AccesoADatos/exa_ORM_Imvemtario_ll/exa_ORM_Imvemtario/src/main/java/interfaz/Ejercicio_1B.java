package interfaz;

import java.util.ArrayList;
import java.util.List;

import dao.DaoGrupo;
import excepciones.BusinessException;
import hibernate.UtilesHibernate;

public class Ejercicio_1B {

	public static void main(String[] args) throws BusinessException {
		
		List<Object[]> resultado = new ArrayList<Object[]>();
		
		try {
			//Creamos la conexion con el Pojo
			DaoGrupo daoGrupo = new DaoGrupo();
			
			//Conectamos con la base de datos
			UtilesHibernate.openSession();
			
			resultado = daoGrupo.buscarSalidasAlumnosGrupos();
			
			System.out.println("\n\n Coincidencias ("+resultado.size()+"): ");
			if(resultado.size() != 0) {
				for(Object[] fila : resultado) {
					System.out.println("  - - - - - - - - - - - - ");
					System.out.println("  - Nombre grupo: "+fila[0]);
					System.out.println("  - Nombre alumno: "+fila[1]);
					System.out.println("  - Fecha salida: "+fila[2]);
					System.out.println("  - Número serie: "+fila[3]);
				}
				System.out.println("  - - - - - - - - - - - - ");
			} else {
				System.err.println("No se ha encontrado");
			}
		} catch (Exception e) {
			throw new BusinessException("Se ha encontrado un error: "+e );
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
