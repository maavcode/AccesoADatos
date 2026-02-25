package mvc_practica03;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.DaoArticulo;
import dao.DaoSalida;
import jdbc.ConexionJdbc;
import pojos.Articulo;

public class EjercicioC2 {

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
		    
		    System.out.println("Que prestamo quieres actualizar? (Ejemplo 800)");
		    Integer idSalida = sc.nextInt();
		    sc.nextLine();
		    
		    System.out.println("Que fecha de devolucion? dd/MM/yyyy (Ejemplo 28/01/2010)");
		    String fechaDevolucion= sc.nextLine();
		    
		    Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaDevolucion);
		    
		    daoSalida.actualizarFechaDevolucion(idSalida, fecha);
		    
		    System.out.println("Fecha de devolucion cambiada correctamente");
		    
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    conJdbc.desconectar();
		}

	}

}
