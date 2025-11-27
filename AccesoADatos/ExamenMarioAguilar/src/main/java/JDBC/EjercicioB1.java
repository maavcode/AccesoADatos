package JDBC;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import jdbc.ConexionJdbc;


public class EjercicioB1 {
	public static void main(String [] args) {
		// PEDIR DATOS
	    System.out.println("Codigo de la asignatura:");
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
	}
}
