package Ejercicio_01;



import java.util.ArrayList;
import java.util.Date;

import org.bson.Document; // Documento con formato deseado por mongoDB

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Instertar {
	
	public static void main(String [] args) {
		// Conexion al servidor
		MongoClient mongoCliente = MongoClients.create();
		// Conexion a la base de datos
		MongoDatabase dbBiblioteca= mongoCliente.getDatabase("Biblioteca");
		// Conexion a una coleccion en especifico
		MongoCollection colLibros = dbBiblioteca.getCollection("Libros");
		MongoCollection colPrestamos = dbBiblioteca.getCollection("Prestamos");
		MongoCollection colSocios = dbBiblioteca.getCollection("Socios");
		
		// Libro
		Document docLibro1 = new Document("ISBN", 456779)
				.append("Titulo", "La sombra del viento")
				.append("Autor", new Document("Nombre", "Carlos")
									.append("Apellidos", "Zafon"));
		
		Document docLibro2 = new Document("ISBN", 46885)
				.append("Titulo", "Sira")
				.append("Autor", new Document("Nombre", "Maria")
									.append("Apellidos", "Dueñas Vinuesa"));
		// Socio
		Document docSocio1 = new Document("Nombre", "Luis")
								.append("Apellidos", new Document("Apellido1", "Garcia")
														.append("Apellido2", "Martin"))
								.append("Num_socio", 12345);
		// Prestamo
		ArrayList<Document> arrayLibros = new ArrayList<Document>();
		Document libro1 = new Document("ISBN", "446854");
		Document libro2 = new Document("ISBN", "456779");
		arrayLibros.add(libro1);
		arrayLibros.add(libro2);
		
		Document docPrestamo1 = new Document("fecha_dev", new Date(2025-9-29))
									.append("fecha_pres", new Date(2025-9-1))
									.append("socio", new Document("num_socio", 2))
									.append("libro", arrayLibros);
														

//		Document docLibro = crearLibro();
		
//		colLibros.insertOne(docLibro1);
//		colLibros.insertOne(docLibro2);
//		colSocios.insertOne(docSocio1);
//		colPrestamos.insertOne(docPrestamo1);
		
		
		
	}
	
	public static Document crearLibro() {
		int isbn = 46885;
		String titulo = "Sira";
		String [] nombre = {"Maria", "Dueñas Vinuesa"};
		
		Document docLibro = new Document("ISBN", isbn)
								.append("Titulo", titulo)
								.append("Autor", new Document("Nombre", nombre[0])
													.append("Apellidos", nombre[1]));	
		return docLibro;
	}
	
	public static Document crearSocio() {
		int isbn = 46885;
		String titulo = "Sira";
		String [] nombre = {"Maria", "Dueñas Vinuesa"};
		
		Document docSocio = new Document("Nombre", "Luis")
				.append("Apellidos", new Document("Apellido1", "Garcia")
										.append("Apellido2", "Martin"))
				.append("Num_socio", 12345);	
		return docSocio;
	}
	
	public static Document crearPrestamo() {
		ArrayList<Document> arrayLibros = new ArrayList<Document>();
		Document libro1 = new Document("ISBN", "446854");
		Document libro2 = new Document("ISBN", "456779");
		arrayLibros.add(libro1);
		arrayLibros.add(libro2);
		
		Document docPrestamo = new Document("fecha_dev", new Date(2025-9-29))
									.append("fecha_pres", new Date(2025-9-1))
									.append("socio", new Document("num_socio", 2))
									.append("libro", arrayLibros);
		return docPrestamo;
	}
}
