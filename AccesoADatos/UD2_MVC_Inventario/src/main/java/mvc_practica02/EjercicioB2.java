package mvc_practica02;

import java.util.Scanner;

import dao.DaoArticulo;
import jdbc.ConexionJdbc;
import pojos.Articulo;

public class EjercicioB2 {

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
				    // Pregunto los datos
				    Scanner sc = new Scanner(System.in);

				    System.out.println("A que articulo le quieres cambiar el estado? (Ejemplo 6001)");
				    Integer idArticulo = sc.nextInt();
				    sc.nextLine(); // Salto de linea
				    
				    System.out.println("A que estado lo vas a cambiar: operativo o mantenimiento");
				    String estado = sc.nextLine();
				    
				    daoArticulo.actualizarEstado(idArticulo, estado);
				    
				    
				    System.out.println("Artículo Actualizado correctamente");
				    
				} catch (Exception e) {
				    e.printStackTrace();
				} finally {
				    conJdbc.desconectar();
				}

	}

}
