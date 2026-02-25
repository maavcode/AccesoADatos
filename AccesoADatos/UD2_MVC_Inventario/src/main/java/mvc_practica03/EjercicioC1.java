package mvc_practica03;

import java.util.Scanner;

import dao.DaoArticulo;
import dao.DaoSalida;
import jdbc.ConexionJdbc;
import pojos.Articulo;

public class EjercicioC1 {

	public static void main(String[] args) {
		// Conexion JDBC
		ConexionJdbc conJdbc = null;
		// Declaracion de DAOs
		DaoSalida daoSalida = new DaoSalida();

		try {
			// SIEMPRE
			conJdbc = new ConexionJdbc("Configuracion/propiedadesInventario.txt");
			conJdbc.conectar();
			
			// CONTENIDO
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Que articulo quieres prestar? (Ejemplo 50)");
			Integer idArticulo = sc.nextInt();
			
			System.out.println("Que usuario lo presta? (Ejemplo 481)");
			Integer idUsuario = sc.nextInt();
			
			daoSalida.realizarPrestamo(idArticulo, idUsuario);
			
			System.out.println("Prestamo realizado correctamente");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conJdbc.desconectar();
		}

	}

}
