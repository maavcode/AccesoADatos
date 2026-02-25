package mvc_practica03;

import java.util.List;
import java.util.Scanner;

import dao.DaoArticulo;
import dao.DaoSalida;
import jdbc.ConexionJdbc;
import pojos.Articulo;
import pojos.Salida;

public class EjercicioD3 {

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
			System.out.print("Introduce el ID del usuario: (Ejemplo 511)"); 
			Integer idUsuario = sc.nextInt();
			List<Salida> lista = daoSalida.listarPrestamosPorUsuario(idUsuario);

			for (Salida s : lista) {
				System.out.println("ID Salida: " + s.getIdSalida());
				System.out.println("Artículo: " + s.getArticulo());
				System.out.println("Fecha salida: " + s.getFechaSalida().toLocalDate());

				if (s.getFechaDevolucion() != null) {
					System.out.println("Fecha devolución: " + s.getFechaDevolucion().toLocalDate());
				} else {
					System.out.println("Fecha devolución: (sin devolver)");
				}

				System.out.println("---------------------------");
			}

			System.out.println("Informa correcto");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conJdbc.desconectar();
		}

	}

}
