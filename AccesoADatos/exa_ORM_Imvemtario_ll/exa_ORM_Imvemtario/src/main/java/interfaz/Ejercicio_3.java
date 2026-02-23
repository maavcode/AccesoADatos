package interfaz;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dao.DaoArticulo;
import dao.DaoEspacio;
import dao.DaoGrupo;
import dao.DaoUsuario;
import excepciones.BusinessException;
import hibernate.UtilesHibernate;
import pojos.Articulo;
import pojos.Usuario;

public class Ejercicio_3 {

	public static void main(String[] args) throws BusinessException {

		// Datos nuevo artículo
		Integer idArticulo = 10000155;
		String numSerieArticulo = "222333";
		String fechaAltaArticulo = "2025-02-17";
		String estadoArticulo = "operativo";
		String espacioArticulo = "E209";
		String usuarioAltaArticulo = "usu483";
		
		// Crea el artículo
		Articulo articulo = new Articulo();
		articulo.setIdarticulo(idArticulo);
		articulo.setNumserie(numSerieArticulo);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fecha = LocalDate.parse(fechaAltaArticulo, formatter);
		Timestamp timestamp = Timestamp.valueOf(fecha.atStartOfDay());
		articulo.setFechaalta(timestamp);
		articulo.setEstado(estadoArticulo);
		
		
		
		
		
		
		try {
			//Creamos la conexion con el Pojo
			DaoArticulo daoArticulo = new DaoArticulo();
			
			//Conectamos con la base de datos
			UtilesHibernate.openSession();
			
			// Establecemos datos
			DaoUsuario daoUsuario = new DaoUsuario();
			DaoGrupo daoGrupo = new DaoGrupo();
			DaoEspacio daoEspacio = new DaoEspacio();
			
			
			Usuario usuario = daoUsuario.buscarPorId(usuarioAltaArticulo);
			Integer cantidadArticulosEspacio = daoEspacio.contarArticulos(espacioArticulo);

			
			// Comprueba cantidad
			if (cantidadArticulosEspacio <= 30) {
				
				// Comprueba estado
				if (articulo.getEstado().equals("operativo")) {

					// Comprueba tipo usuario
					if (usuario.getRol().getNombre().equals("Profesor")) {
						
						System.out.println("Grabando artículo...");
						daoArticulo.grabar(articulo);
						System.out.println("Artículo grabado.");
						
					} else {
						System.out.println("El tipo de usuario debe ser profesor");
					}
				} else {
					System.out.println("El estado no es operativo");
				}
			} else {
				System.out.println("La cantidad de artículos es mayor a 30.");
			}
			
			
			
		} catch (Exception e) {
			throw new BusinessException("Se ha encontrado un error: "+e.getMessage());
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
