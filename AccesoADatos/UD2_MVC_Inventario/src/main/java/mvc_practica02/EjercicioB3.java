package mvc_practica02;

import java.util.Scanner;

import dao.DaoArticulo;
import jdbc.ConexionJdbc;
import pojos.Articulo;

public class EjercicioB3 {

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

				    System.out.println("Que articulo quieres retirar? (Ejemplo 6001)");
				    Integer idArticulo = sc.nextInt();
				    sc.nextLine(); // Salto de linea
				    
				    System.out.println("Que usuario lo da de baja? (Ejemplo 481)");
				    Integer usuarioBaja = sc.nextInt();
				    
				    daoArticulo.darDeBaja(idArticulo, usuarioBaja);
				    
				    System.out.println("Artículo Retirado correctamente");
				    
				} catch (Exception e) {
				    e.printStackTrace();
				} finally {
				    conJdbc.desconectar();
				}

	}

}
