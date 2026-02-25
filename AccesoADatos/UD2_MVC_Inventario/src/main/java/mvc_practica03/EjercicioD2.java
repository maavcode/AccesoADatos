package mvc_practica03;

import java.util.List;
import java.util.Scanner;

import dao.DaoArticulo;
import dao.DaoSalida;
import jdbc.ConexionJdbc;
import pojos.Articulo;
import pojos.Salida;

public class EjercicioD2 {

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

			List<Salida> lista = daoSalida.listarPrestamosDevueltos();

			for (Salida s : lista) {
				System.out.println("ID Salida: " + s.getIdSalida());
				System.out.println("Artículo: " + s.getArticulo());
				System.out.println("Usuario: " + s.getUsuario());
				System.out.println("Fecha salida: " + s.getFechaSalida().toLocalDate());
				System.out.println("Fecha devolución: " + s.getFechaDevolucion().toLocalDate());
				System.out.println("---------------------------");
			}

			System.out.println("Informe correcto");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conJdbc.desconectar();
		}

	}

}
