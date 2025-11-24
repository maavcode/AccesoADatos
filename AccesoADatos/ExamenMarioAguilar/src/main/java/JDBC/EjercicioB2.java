package JDBC;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.DaoPractica;
import dao.DaoPresentan;
import excepciones.BusinessException;
import jdbc.ConexionJdbc;
import pojos.Presentan;


public class EjercicioB2 {
	public static void main(String [] args) {
		// Presentar una practica
		// Conexion a la base de datos
		ConexionJdbc conJdbc = null;
		// Creo el dao para usar sus funciones
		DaoPresentan daoPresentan = new DaoPresentan();
	    
	    Presentan presentan = new Presentan();
	    Scanner sc = new Scanner(System.in);
	    
	    // PEDIR DATOS
	    System.out.println("Codigo de la practica:");
	    presentan.setCodP(sc.nextLine());

	    System.out.println("Nombre del alumno (Pon el codigo):");
	    presentan.setCodAl(Integer.parseInt(sc.nextLine())); // Cambiar al nombre del alumno luego

	    System.out.println("Fecha de presentacion (yyyy/mm/dd):");
	    Date f;
		try {
			f = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
			presentan.setFechaEntrega(f);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    System.out.println("Nota (0 ... 10):");
	    String respuesta = sc.nextLine();
		while (Integer.parseInt(respuesta)<0 || Integer.parseInt(respuesta)>10) {
			if (Integer.parseInt(respuesta)<0 || Integer.parseInt(respuesta)>10) {
				System.out.println("Pon un numero del 1 al 10");
				respuesta = sc.nextLine();
			}else {
				presentan.setNota(Integer.parseInt(sc.nextLine()));
			}
		}
		
		
		try {
	        conJdbc = new ConexionJdbc("Configuracion/propiedadesExamen.txt");
	        conJdbc.conectar();
	        daoPresentan.grabar(presentan);
	        System.out.println("Presentan insertado correctamente.");
	    } 
	    catch (BusinessException e) {
	        System.out.println("Error de presentacion: " + e.getMessage());
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	    finally {
	        conJdbc.desconectar();
	    }
		
	    
	    

	}
}
