package mvc_practica02;

import java.util.Scanner;

import dao.DaoArticulo;
import jdbc.ConexionJdbc;
import pojos.Articulo;

public class EjercicioB1 {

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
		    // Crear artículo 
		    Articulo nuevoArticulo = new Articulo(); 
		    // Pregunto los datos
		    Scanner sc = new Scanner(System.in);

		    System.out.println("Inserta un id de articulo (Ejemplo 6003)");
		    Integer idArticulo = sc.nextInt();
		    nuevoArticulo.setIdArticulo(idArticulo);
		    sc.nextLine();
		    
		    System.out.println("Inserta un numero de serie (Ejemplo SN-12345)");
		    String numSerie = sc.nextLine();
		    nuevoArticulo.setNumserie(numSerie);
		    
		    
		    System.out.println("Inserta un modelo (Ejemplo 2600)");
		    Integer idModelo = sc.nextInt();
		    nuevoArticulo.setModelo(idModelo); 
		    
		    System.out.println("Inserta un departamento (Ejemplo 3)");
		    Integer idDepartamento = sc.nextInt();
		    nuevoArticulo.setDepartamento(idDepartamento); 
		    
		    System.out.println("Inserta un espacio (Ejemplo 5)");
		    Integer idEspacio = sc.nextInt();
		    nuevoArticulo.setEspacio(idEspacio);
		    
		    System.out.println("Inserta un usuario de alta (Ejemplo 481)");
		    Integer idUsuarioAlta = sc.nextInt();
		    nuevoArticulo.setUsuarioalta(idUsuarioAlta);
		    
		    // Insertar Articulo
		    daoArticulo.grabar(nuevoArticulo);
		    
		    System.out.println("Artículo insertado correctamente");
		    
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    conJdbc.desconectar();
		}

	}

}
