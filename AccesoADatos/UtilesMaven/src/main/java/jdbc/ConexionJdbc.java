package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import excepciones.ConnectionException;

public class ConexionJdbc {
	
	// La conexión que se mantiene abierta
	private static Connection con;
	
	//parámetros de conexion
	private String driver;
	private String url;
	private String usr;
	private String pwd;
	// fichero configuración de conexión
	private String ficheroConfiguracion;
	
	//Constructor conexion con parametros
	public ConexionJdbc(String driver, String url, String usr, String pwd)
	{
	this.driver=driver;
	this.url=url;
	this.usr=usr;
	this.pwd=pwd;
	}
	
	

	
	// método conectar con fichero
	
	public ConexionJdbc(String fichero) {
		// TODO Auto-generated constructor stub
		this.ficheroConfiguracion=fichero;
	}

	private void conectar(String ficheroConfiguracion) throws ConnectionException{
		con=null;
		try {
			Properties propiedades = new Properties();  
			propiedades.load(new FileInputStream(ficheroConfiguracion));
			DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
		
	} catch (SQLException e){
			e.printStackTrace();  
	} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new ConnectionException();
	}catch (IOException e) {
			e.printStackTrace();
			throw new ConnectionException();
	}catch (Exception e) {
			e.printStackTrace();
			throw new ConnectionException();

	}
		
	}
	
	
	//metodo conectar con parámetros
	private void conectar(String driver, String url, String usr, String pwd) throws ConnectionException
	{
		con=null;
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(usr);
		ds.setPassword(pwd);
		try {
			con= ds.getConnection();
		}catch (SQLException e) {
			throw new ConnectionException();
		}
	}
	//Metodo conectar publico
	public void conectar() {
		if(con==null) {
			if(ficheroConfiguracion!=null) 
				conectar(ficheroConfiguracion);
			else 
				conectar(driver,url,usr,pwd);
		}
	}
	
	//Método público que devuelve la conexión creada en el método privado conectar
	public static Connection getConnection() {
		return con;
		
		}
	//desconectar de la BD
	public void desconectar() {
		try {
			if (con!=null && !con.isClosed()) con.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//Cerrar un PreparedStatement
	public static void cerrar(PreparedStatement pstm)
	{
	try {
		if(pstm!=null && !pstm.isClosed()) pstm.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	}
	//Cerrar un resultSet
	public static void cerrar(ResultSet rs)
	{
	try {
		if(rs!=null && !rs.isClosed()) rs.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	}

}
