package ejemplos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class Conectar {

	public static void main(String[] args) {
		PreparedStatement pstmt = null;
		Integer vprem = null;
		String sql;
		Scanner tec = new Scanner(System.in);
		try {
			// Cargamos los parametros del fichero de propiedades
			Properties propiedades = new Properties();
			propiedades.load (new FileInputStream("configuracion\\propCiclismo.txt"));
			
			// Creamos la conexion de DataSource con el fichero propCiclismo
			DataSource ds;
			ds = BasicDataSourceFactory.createDataSource(propiedades);
			
			// Creo la conexion
			Connection con = ds.getConnection();
			System.out.println("conectado");
			
			// Leo la informacion de entrada
			System.out.println("incremento");
			vprem = tec.nextInt();
			tec.nextLine();
			
			// Lanzo sql ? que es el parametro que sustituye por vprem
			sql = "update premios set cantidad = cantidad?";
			pstmt = con.prepareStatement(sql);
			// Metodo setxxx asigna al ? en posicion 1 el valor de la variable
			pstmt.setInt(1, vprem);
		
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
