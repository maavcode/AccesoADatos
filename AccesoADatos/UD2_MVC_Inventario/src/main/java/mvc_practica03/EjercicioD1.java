package mvc_practica03;

import java.util.List;
import java.util.Scanner;

import dao.DaoArticulo;
import dao.DaoSalida;
import jdbc.ConexionJdbc;
import pojos.Articulo;
import pojos.Salida;

public class EjercicioD1 {

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
		    // Scanner sc = new Scanner(System.in);
		    
		    List<Salida> listaPrestamosActivos = daoSalida.listarPrestamosActivos();
		    
		    
		    for (Salida s : listaPrestamosActivos) {
				System.out.println("Salida " + s.getIdSalida() + " | Fecha salida: " + s.getFechaSalida().toLocalDate() + " | Fecha devolucion: " + s.getFechaDevolucion().toLocalDate());
				System.out.println("Articulo - " + s.getArticulo() + " | Usuario - " + s.getUsuario());
				
				
			}
		    
		    System.out.println("correctamente");
		    
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    conJdbc.desconectar();
		}

	}

}
