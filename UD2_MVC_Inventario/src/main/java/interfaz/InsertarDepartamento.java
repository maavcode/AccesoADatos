package interfaz;

import java.util.Scanner;

import dao.DaoDepartamento;
import jdbc.ConexionJdbc;
import pojo.Departamento;

public class InsertarDepartamento {
	public static void main(String[]args) {
		ConexionJdbc conJdbc = null;
		Departamento d = null;
		DaoDepartamento daoD= new DaoDepartamento();
		String nombreD = null;
		
		Scanner tec = new Scanner(System.in);
		System.out.println("nombre departamento");
		nombreD = tec.nextLine();
		
		try {
			// Conextar a la base de datos 
			conJdbc = new ConexionJdbc("Configuracion/propiedadesInventario.txt");
			conJdbc.conectar();
			// Crear el departamento
			d = new Departamento();
			d.setNombre(nombreD);
			daoD.grabar(d);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			conJdbc.desconectar();
		}
	}
}
