package Ejercicios;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLEditorKit.Parser;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;

public class Mostrar_Filtros {
	public static void main(String[] args) {
		// SIEMPRE
		// Conexion al servidor
		MongoClient mongoCliente = MongoClients.create();
		// Conexion a la base de datos
		MongoDatabase dbBiblioteca = mongoCliente.getDatabase("Biblioteca");
		// Conexion a la coleccion en especifico (EN CADA EJERCICIO)

		// Document doc"x": Contiene informacion, es un objeto, puede tener una o mas
		// cosas
		// MongoCursor cursor"x": Para recorrer documentos que tienen mas de una cosa
		// Bson bsonFilter: Sirve para hacer filtros

		// --- EJERCICIOS ---

		// Ejercicio 01: Buscar el registro del primer libro
		Ejercicio01(dbBiblioteca);

		// Ejercicio 02: Buscar todos los libros
		Ejercicio02(dbBiblioteca);

		// Ejercicio 03: Obtener la lista de socios
		Ejercicio03(dbBiblioteca);

		// Ejercicio 04: Obtener el nombre de los socios (usar método get())
		Ejercicio04(dbBiblioteca);

		// ------------------- FILTROS BSON -------------------

		// Ejercicio 05: Buscar el libro con título "El Quijote"
		Ejercicio05(dbBiblioteca);

		// Ejercicio 06: Buscar el préstamo con dos libros
		Ejercicio06(dbBiblioteca);

		// Ejercicio 07: Buscar título de libros de autor cuyo apellido es Follet
		Ejercicio07(dbBiblioteca);

		// Ejercicio 08: En préstamos, buscar el documento del préstamo del libro con
		// ISBN 446854
		Ejercicio08(dbBiblioteca);

		// Ejercicio 09: Buscar el nombre de los socios que han tenido prestado el libro
		// con ISBN 456779
		Ejercicio09(dbBiblioteca);

		// Ejercicio 10: Buscar libros con año mayor que 2000 y con más de 500 páginas
		Ejercicio10(dbBiblioteca);

		// Ejercicio 11: Buscar libros editados entre 2010 y 2020
		Ejercicio11(dbBiblioteca);

		// Ejercicio 12: Buscar los libros de la editorial "Debolsillo"
		Ejercicio12(dbBiblioteca);

		// Ejercicio 13: Mostrar el nombre del socio número 2
		Ejercicio13(dbBiblioteca);

		// Ejercicio 14: Buscar libros (título y nombre del autor) de autores de
		// nacionalidad americana o de la editorial Planeta
		Ejercicio14(dbBiblioteca);

		// Ejercicio 15: Mostrar la fecha de préstamo del libro prestado al socio con
		// num_socio 1
		Ejercicio15(dbBiblioteca);

		// Ejercicio 16: Buscar libros editados entre 1990 y 2000
		Ejercicio16(dbBiblioteca);

		// Ejercicio 17: Mostrar el título de los libros escritos por Isaac Asimov
		Ejercicio17(dbBiblioteca);

		// Ejercicio 18: Mostrar el nombre de los socios que se han llevado prestado el
		// libro con título "El Quijote"
		Ejercicio18(dbBiblioteca);

		// Ejercicio 19: Mostrar el título de los libros que tiene prestados el socio
		// con nombre "Javier García"
		Ejercicio19(dbBiblioteca);

		// Ejercicio 20: Mostrar el título y el autor de los libros de la editorial
		// "Planeta" ordenados por año de edición
		Ejercicio20(dbBiblioteca);

		// Ejercicio 21: Mostrar el título y la editorial (proyección) de los libros
		// ordenados por número de páginas
		Ejercicio21(dbBiblioteca);

		// Ejercicio 22: Mostrar el título de los libros que tienen algún préstamo
		Ejercicio22(dbBiblioteca);

	}

	public static void Ejercicio01(MongoDatabase dbBiblioteca) {
		System.out.println("--- Ejercicio 01: Buscar el registro del primer libro ---");
		// Recogo las colecciones necesarias
		MongoCollection colLibros = dbBiblioteca.getCollection("Libros");

		// Recogo el primer libro
		Document docLibro = (Document) colLibros.find().first();
		System.out.println("Libro: " + docLibro.toJson());
	}

	public static void Ejercicio02(MongoDatabase dbBiblioteca) {
		System.out.println("--- Ejercicio 02: Buscar todos los libros ---");
		// Recogo las colecciones necesarias
		MongoCollection colLibros = dbBiblioteca.getCollection("Libros");

		// Recogo todos los libros
		MongoCursor<Document> cursorLibros = colLibros.find().iterator(); // ITERATOR SIEMPRE QUE SEA CURSOR, ASI SE
																			// PODRA ITERAR
		// Recorro el cursor de libros
		while (cursorLibros.hasNext()) {
			Document docLibro = (Document) cursorLibros.next();
			System.out.println("Libro: " + docLibro.toJson());
		}
	}

	public static void Ejercicio03(MongoDatabase dbBiblioteca) {
		System.out.println("--- Ejercicio 03: Obtener la lista de socios ---");
		// Recogo las colecciones necesarias
		MongoCollection colSocios = dbBiblioteca.getCollection("Socios");

		// Recogo en un cursor todos los socios
		MongoCursor<Document> cursorSocios = colSocios.find().iterator();
		// Recorro el cursor de socios
		while (cursorSocios.hasNext()) {
			Document docSocio = (Document) cursorSocios.next();
			System.out.println("Socio: " + docSocio.toJson());
		}
	}

	public static void Ejercicio04(MongoDatabase dbBiblioteca) {
		System.out.println("--- Ejercicio 04: Obtener el nombre de los socios (usar get()) ---");
		// Recogo las colecciones necesarias
		MongoCollection colSocios = dbBiblioteca.getCollection("Socios");

		// Recogo uncursor con todos los socios
		MongoCursor<Document> cursorSocios = colSocios.find().iterator();
		// Recorro el cursor de socios
		while (cursorSocios.hasNext()) {
			Document docSocio = (Document) cursorSocios.next();
			System.out.println("Socio: " + docSocio.get("Nombre"));
		}

	}

	public static void Ejercicio05(MongoDatabase dbBiblioteca) {
		System.out.println("--- Ejercicio 05: Buscar el libro con título \"El Quijote\" ---");
		// Recogo las colecciones necesarias
		MongoCollection colLibros = dbBiblioteca.getCollection("Libros");

		// Creo el filtro para encontrar el libro "El Quijote"
		Bson bsonFilter = Filters.eq("titulo", "El Quijote");

		// Recogo el libro que coincida con el filtro
		Document docLibro = (Document) colLibros.find(bsonFilter).first(); // SOLO 1 = .FIRST() | +1 = .ITERATOR()
		System.out.println("Libro: " + docLibro.toJson());
	}

	public static void Ejercicio06(MongoDatabase dbBiblioteca) {
		// Ejercicio A
		System.out.println("--- Ejercicio 06_1: Buscar el préstamo con dos libros ---");
		// Recogo las colecciones necesarias
		MongoCollection colPrestamos = dbBiblioteca.getCollection("Prestamos");
		MongoCollection colLibros = dbBiblioteca.getCollection("Libros");

		// Creo el filtro para encontrar el prestamo con 2 libros
		Bson bsonFilter = Filters.size("libro", 2);

		// Recogo el prestamo que coincida con el filtro
		Document docPrestamo = (Document) colPrestamos.find(bsonFilter).first();
		System.out.println("Prestamo con 2 libros: " + docPrestamo.toJson());

		// Ejercicio B
		System.out.println("-- Ejercicio 06_2: Libros con isbn > 45000 --");

		// Creo el filtro para encontrar los libros con isbn > 45.000
		bsonFilter = Filters.gt("isbn", 45000);

		// Recogo en un cursor los libros que cumplan con el filtro
		MongoCursor<Document> cursorLibros = colLibros.find(bsonFilter).iterator();
		// Recorro el cursor de libros
		while (cursorLibros.hasNext()) {
			Document docLibro = (Document) cursorLibros.next();
			System.out.println("Libro: " + docLibro.toJson());

		}
	}

	public static void Ejercicio07(MongoDatabase dbBiblioteca) {
		System.out.println("--- Ejercicio 07: Buscar título de libros de autor con apellido Follet ---");
		// Recogo las colecciones necesarias
		MongoCollection colLibros = dbBiblioteca.getCollection("Libros");

		// Creo el filtro para encontrar los libros con autor con apellido Follet
		Bson bsonFilter = Filters.eq("autor.apellido", "Follet");

		// Recogo en un cursor todos los libros que coincidan con el filtro
		MongoCursor<Document> cursorLibros = colLibros.find(bsonFilter).iterator();
		while (cursorLibros.hasNext()) {
			Document docLibro = (Document) cursorLibros.next();
			System.out.println("Libro: " + docLibro.toJson());
		}
	}

	public static void Ejercicio08(MongoDatabase dbBiblioteca) {
		System.out.println("--- Ejercicio 08: Buscar el préstamo del libro con ISBN 446854 ---");
		// Recogo las colecciones necesarias
		MongoCollection colPrestamos = dbBiblioteca.getCollection("Prestamos");

		// Creo el filtro para encontrar el libro con isbn 448954
		Bson bsonFilter = Filters.eq("libro.isbn", "446854");

		// Recogo en un cursor todos los prestamos que coincidadn con el filtro
		MongoCursor<Document> cursorPrestamos = colPrestamos.find(bsonFilter).iterator();
		while (cursorPrestamos.hasNext()) {
			Document docPrestamo = (Document) cursorPrestamos.next();
			System.out.println("Prestamo: " + docPrestamo.toJson());
		}
	}

	public static void Ejercicio09(MongoDatabase dbBiblioteca) {
		System.out.println("--- Ejercicio 09: Buscar socios que han tenido prestado el libro ISBN 456779 ---");
		// Recogo las colecciones necesarias
		MongoCollection colSocios = dbBiblioteca.getCollection("Socios");
		MongoCollection colPrestamos = dbBiblioteca.getCollection("Prestamos");

		// Creo los filtros necesarios
		Bson bsonFilterLibroPrestado = Filters.eq("libro.isbn", "456779");

		// Recogo en un cursor todos los prestamos que cumplan con el filtro
		MongoCursor<Document> cursorPrestamos = colPrestamos.find(bsonFilterLibroPrestado).iterator();
		while (cursorPrestamos.hasNext()) {
			Document docPrestamo = cursorPrestamos.next();

			// Recogo el socio dentro de prestamo y recogo su num_socio
			Document docNumSocioDocument = (Document) docPrestamo.get("socio");
			String numSocioStr = docNumSocioDocument.getString("num_socio");
			// Parseo a Integer, ya que esta en String en prestamo pero en Integer en socio
			Integer numSocio = Integer.parseInt(numSocioStr);

			// Filtro para encontrar el socio
			Bson bsonFilterSocio = Filters.eq("Num_socio", numSocio);
			Document docSocio = (Document) colSocios.find(bsonFilterSocio).first();

			System.out.println("Socio: " + docSocio.get("Nombre"));

		}

	}

	public static void Ejercicio10(MongoDatabase dbBiblioteca) {
		// Ejercicio A
		System.out.println("--- Ejercicio 10_1: Buscar libros con año > 2000 y más de 500 páginas ---");
		// Recogo las colecciones necesarias
		MongoCollection colLibros = dbBiblioteca.getCollection("Libros");

		// Creo los filtros necesarios (MAS DE UNO)
		Bson bsonFilterA = Filters.and(Filters.gt("páginas", 500), Filters.gt("año_publicacion", 2000));

		// Recogo los libros que cumplan el filtro
		MongoCursor<Document> cursorLibrosA = colLibros.find(bsonFilterA).iterator();
		while (cursorLibrosA.hasNext()) {
			Document docLibro = (Document) cursorLibrosA.next();
			System.out.println("Libro: " + docLibro.toJson());
		}

		// Ejercicio B
		System.out.println("--- Ejercicio 10_2: Libro de mas de 500 paginas y que son de la editorial Plaza&Janes ---");

		// Creo los filtros necesarios (MAS DE UNO)
		Bson bsonFilterB = Filters.and(Filters.gt("páginas", 500), Filters.eq("editorial", "Plaza&Janes"));

		// Recogo los libros que cumplan el filtro
		MongoCursor<Document> cursorLibrosB = colLibros.find(bsonFilterB).iterator();
		while (cursorLibrosB.hasNext()) {
			Document docLibro = (Document) cursorLibrosB.next();
			System.out.println("Libro: " + docLibro.toJson());
		}
	}

	public static void Ejercicio11(MongoDatabase dbBiblioteca) {
		System.out.println("--- Ejercicio 11: Buscar libros editados entre 2010 y 2020 ---");
		// Recogo las colecciones necesarias
		MongoCollection colLibros = dbBiblioteca.getCollection("Libros");

		// Creo los filtros necesarios
		Bson bsonFilter = Filters.and(Filters.gte("año_publicacion", 2010), // Mayor o igual >=
				Filters.lte("año_publicacion", 2020) // Menor o igual <=
		);

		// Recogo en un cursor los libros que cumplan con el filtro
		MongoCursor<Document> cursorLibros = colLibros.find(bsonFilter).iterator();
		while (cursorLibros.hasNext()) {
			Document docLibro = (Document) cursorLibros.next();
			System.out.println(docLibro.toJson());
		}

	}

	public static void Ejercicio12(MongoDatabase dbBiblioteca) {
		System.out.println("--- Ejercicio 12: Buscar libros de la editorial Debolsillo ---");
		// Recogo las colecciones necesarias
		MongoCollection colLibros = dbBiblioteca.getCollection("Libros");

		// Creo los filtros necesarios
		Bson bsonFilter = Filters.eq("editorial", "Debolsillo");

		// Creo un cursor con los libros que cumplan el filtro
		MongoCursor<Document> cursorLibros = colLibros.find(bsonFilter).iterator();
		while (cursorLibros.hasNext()) {
			Document docLibro = (Document) cursorLibros.next();
			System.out.println(docLibro.toJson());
		}
	}

	public static void Ejercicio13(MongoDatabase dbBiblioteca) {
		System.out.println("--- Ejercicio 13: Mostrar el nombre del socio número 2 ---");
		// Recogo las colecciones necesarias
		MongoCollection colSocios = dbBiblioteca.getCollection("Socios");

		// Creo los filtros necesarios
		Bson bsonFilter = Filters.eq("Num_socio", 2);

		// Recogo al Socio que cumpla con el filtro
		Document docSocio = (Document) colSocios.find(bsonFilter).first();
		System.out.println("Socio: " + docSocio.get("Nombre"));
	}

	public static void Ejercicio14(MongoDatabase dbBiblioteca) {
		System.out.println(
				"--- Ejercicio 14: Titulo y nombre de autor de los libros de autores americanos o de la editorial Planeta ---");
		// Recogo las colecciones necesarias
		MongoCollection colLibros = dbBiblioteca.getCollection("Libros");

		// Creo los filtros necesarios
		Bson bsonFilter = Filters.or(Filters.eq("editorial", "Planeta"), Filters.eq("autor.nacionalidad", "Americana") // "autor.nacionalidad"
																														// EN
																														// FILTROS
																														// SE
																														// PUEDE
																														// HACER,
																														// EN
																														// GETs
																														// NO
		);

		// Recogo en un cursor los libros que cumplan con el filtro
		MongoCursor<Document> cursorLibros = colLibros.find(bsonFilter).iterator();
		while (cursorLibros.hasNext()) {
			Document docLibro = (Document) cursorLibros.next();

			// Recogo el autor del libro seleccionado
			Document docAutor = (Document) docLibro.get("autor");
			System.out.println("Libro: " + docLibro.get("titulo") + " | Autor: " + docAutor.get("nombre") + " "
					+ docAutor.get("apellido"));
		}
	}

	public static void Ejercicio15(MongoDatabase dbBiblioteca) {
		System.out.println("--- Ejercicio 15: Fecha de préstamo del socio número 1 ---");
		// Recogo las colecciones necesarias
		MongoCollection colPrestamos = dbBiblioteca.getCollection("Prestamos");

		// Creo los filtros necesarios
		Bson bsonFilters = Filters.eq("socio.num_socio", "1");

		Document docPrestamo = (Document) colPrestamos.find(bsonFilters).first();

		System.out.println("Fecha del prestamo del socio 1: " + docPrestamo.get("fecha_pres"));
	}

	public static void Ejercicio16(MongoDatabase dbBiblioteca) {
		System.out.println("--- Ejercicio 16: Buscar libros editados entre 1990 y 2000 ---");
		// Recogo las colecciones necesarias
		MongoCollection colLibros = dbBiblioteca.getCollection("Libros");

		// Creo los filtros necesarios
		Bson bsonFilter = Filters.and(Filters.gte("año_publicacion", 1990), // Mayor o igual >=
				Filters.lte("año_publicacion", 2000) // Menor o igual <=
		);

		// Recogo en un cursor los libros que cumplan con el filtro
		MongoCursor<Document> cursorLibros = colLibros.find(bsonFilter).iterator();
		while (cursorLibros.hasNext()) {
			Document docLibro = (Document) cursorLibros.next();
			System.out.println(docLibro.toJson());
		}

	}

	public static void Ejercicio17(MongoDatabase dbBiblioteca) {
		System.out.println("--- Ejercicio 17: Títulos de libros escritos por Isaac Asimov ---");
		// Recogo las colecciones necesarias
		MongoCollection colLibros = dbBiblioteca.getCollection("Libros");

		// Creo los filtros necesarios
		Bson bsonFilter = Filters.and(Filters.eq("autor.nombre", "Isaac"), Filters.eq("autor.apellido", "Asimov"));

		// Recogo en un cursor los libros que cumplan el filtro
		MongoCursor<Document> cursorLibros = colLibros.find(bsonFilter).iterator();
		while (cursorLibros.hasNext()) {
			Document docLibro = (Document) cursorLibros.next();
			System.out.println("Libro Isaac Asimov: " + docLibro.toJson());
		}
	}

	public static void Ejercicio18(MongoDatabase dbBiblioteca) {
		System.out.println("--- Ejercicio 18: Nombre de los socios que han prestado \"El Quijote\" ---");
		// Recogo las colecciones necesarias
		MongoCollection colLibros = dbBiblioteca.getCollection("Libros");
		MongoCollection colPrestamos = dbBiblioteca.getCollection("Prestamos");
		MongoCollection colSocios = dbBiblioteca.getCollection("Socios");

		// Creo el filtro para encontrar el isbn de El Quijote
		Bson bsonFilterIsbn = Filters.eq("titulo", "El Quijote"); // 
		
		// Recogo el libro del Quijote y lo parseo a String para usarlo en prestamo
		Document docLibroQuijote = (Document) colLibros.find(bsonFilterIsbn).first();
		String isbnQuijote = docLibroQuijote.getInteger("isbn").toString();
		
		// Creo el filtro para encontrar los prestamos que han prestado El Quijote
		Bson bsonFilterQuijote = Filters.eq("libro.isbn", isbnQuijote);
		
		// Recogo en un cursor los prestamos que tengan El Quijote prestado
		MongoCursor<Document> cursorPrestamos = colPrestamos.find(bsonFilterQuijote).iterator();
		while (cursorPrestamos.hasNext()) {
			Document docPrestamo = (Document) cursorPrestamos.next();
			
			// Recogo el num_socio del socio del prestamo seleccionado y lo parseo a Integer
			Document docSocioSelec = (Document) docPrestamo.get("socio");
			String numSocioStr = docSocioSelec.getString("num_socio");
			Integer numSocio = Integer.parseInt(numSocioStr);
			
			// Creo el filtro para encontrar el socio que ha prestado El Quijote
			Bson bsonFilterSocio = Filters.eq("Num_socio", numSocio);
			
			// Recogo el Socio que tiene el prestamo selecionado
			Document docSocio = (Document) colSocios.find(bsonFilterSocio).first();
			System.out.println("Socio: " + docSocio.get("Nombre"));
		}
	}

	public static void Ejercicio19(MongoDatabase dbBiblioteca) {
		System.out.println("--- Ejercicio 19: Libros prestados al socio Javier García ---");
		// Recogo las colecciones necesarias
		MongoCollection colLibros = dbBiblioteca.getCollection("Libros");
		MongoCollection colPrestamos = dbBiblioteca.getCollection("Prestamos");
		MongoCollection colSocios = dbBiblioteca.getCollection("Socios");
		
		// Creo un filtro para el numero de socio que es Javier Garcia
		Bson bsonFilterNumSocio = Filters.eq("Nombre", "Javier Garcia");
		
		// Recogo el socio que cumpla el filtro y me guardo el num_socio como String para usarlo en Prestamos
		Document docSocio = (Document) colSocios.find(bsonFilterNumSocio).first();
		
		String numSocio = docSocio.getInteger("Num_socio").toString();
		
		// Creo un filtro para encontrar el prestamo con el numSocio filtrado
		Bson bsonFilterPrestamo = Filters.eq("socio.num_socio",numSocio);
		
		// Recogo el prestamo del socio filtrado
		Document docPrestamo = (Document) colPrestamos.find(bsonFilterPrestamo).first();
		
		// Creo una lista con todos los libros del prestamo
		List<Document> librosPrestados = (List<Document>) docPrestamo.get("libro");
		for (Document doclibroPrestado: librosPrestados) {
			// Recogo el isbn del libro prestado
			String isbnPrestadoStr = doclibroPrestado.getString("isbn");
			Integer isbnPrestado = Integer.parseInt(isbnPrestadoStr);
			
			// Creo un filtro para encontrar el libro con ese isbn
			Bson bsonFilterIsbn = Filters.eq("isbn", isbnPrestado);
			
			// Recogo el libro con ese isbn
			Document docLibro = (Document) colLibros.find(bsonFilterIsbn).first();
			System.out.println("Libro: " + docLibro.toJson());
			
		}
	}

	public static void Ejercicio20(MongoDatabase dbBiblioteca) {
		System.out.println("--- Ejercicio 20: Libros de Planeta ordenados por año de edición ---");
		// Recogo las colecciones necesarias
		MongoCollection colLibros = dbBiblioteca.getCollection("Libros");
		
		// Creo un cursor que recoge todos los libros y los ordeno con .sort(Sorts) por año de edicion
		MongoCursor<Document> cursorLibros = colLibros.find().sort(Sorts.descending("año_publicacion")).iterator();
		
		// Recorro el cursor que contiene libros
		while (cursorLibros.hasNext()) {
			Document docLibro = (Document) cursorLibros.next();
			
			// Recogo el autor del libro y muestro lo pedido 
			Document docAutor = (Document) docLibro.get("autor");
			System.out.println("Titulo: " + docLibro.get("titulo") + " | Autor: " + docAutor.get("nombre") + " " + docAutor.get("apellido") + " | Año de edicion: " + docLibro.get("año_publicacion"));
			
		}
	}

	public static void Ejercicio21(MongoDatabase dbBiblioteca) {
		System.out.println("--- Ejercicio 21: Título y editorial de libros ordenados por páginas ---");
		// Recogo las colecciones necesarias
		MongoCollection colLibros = dbBiblioteca.getCollection("Libros");

		// Recogo en un cursor todos los libros y lo ordeno por paginas
		MongoCursor<Document> curosrLibros = colLibros.find().sort(Sorts.descending("páginas")).iterator();
	
		// Recorro el cursor que contiene los libros
		while (curosrLibros.hasNext()) {
			Document docLibro = (Document) curosrLibros.next();
			
			// Muestro lo pedido
			System.out.println("Titulo: " + docLibro.get("titulo") + " | Editorial: " + docLibro.get("editorial") + " | Num. paginas: " + docLibro.get("páginas"));
			
		}
	}
	
	// ESTA BIEN, LO QUE NO LO ESTA ES EL JSON
	public static void Ejercicio22(MongoDatabase dbBiblioteca) {
		System.out.println("--- Ejercicio 22: Libros que tienen algún préstamo ---");
		// Recogo las colecciones necesarias
		MongoCollection colLibros = dbBiblioteca.getCollection("Libros");
		MongoCollection colPrestamos = dbBiblioteca.getCollection("Prestamos");
		
		// EJERCICIO HECHO POR MI MIRANDO EL DE ESTHER
		
		// Recogo en un cursor los libros prestados
		MongoCursor<Document> cursorPrestamosSol = colPrestamos.find().iterator();
		
		// Recorro el cursor de libros
		while (cursorPrestamosSol.hasNext()) {
			Document docPrestamo = (Document) cursorPrestamosSol.next();
			// Creo un ArrayList que tendra lis objetos del libro
			ArrayList librosPrestados = (ArrayList) docPrestamo.get("libro");
			
			// Recorro el array de libros prestados
			for (Object objLibro : librosPrestados) {
				Document docLibro = (Document) objLibro;
				// Guardo el isbn del libro prestado y lo muestro
				String isbnPrestado = docLibro.get("isbn").toString();
				System.out.println("isbn: " + isbnPrestado);
				
				// Creo un filtro para encontrar el libro prestado
				Bson bsonFilterPrestado = Filters.eq("isbn", isbnPrestado);
				// Recogo el libro prestado y lo muestro
				Document docLibroPrestado = (Document) colLibros.find(bsonFilterPrestado).first();
				System.out.println(docLibroPrestado.toJson());
			}
			
		}
		
		// EJERCICIO HECHO POR MI SIN MIRAR
		
		// Creo un ArrayList para guardar los libros que estan prestados
		ArrayList <String> librosPrestados = new ArrayList<String>();
		
		// Recogo en un cursor los prestamos
		MongoCursor<Document> cursorPrestamos = colPrestamos.find().iterator();
		//Recorro el cursor de prestamos
		while (cursorPrestamos.hasNext()) {
			Document docPrestamo = (Document) cursorPrestamos.next();
		
			// Recogo en una lista los libros del prestamo ya que este es un documento
			List<Document> libros = (List<Document>) docPrestamo.get("libro");
			// Recorro la lista de libros
			for (Document docLibro : libros) {
				if (!librosPrestados.contains(docLibro.get("isbn"))) {
					librosPrestados.add(docLibro.get("isbn").toString());
				}
			}
			
		}
		
		System.out.println("Cantidad de libros prestados: " + librosPrestados.size());
		// Recorro la lista de libros prestados
		for (int i = 0; i < librosPrestados.size(); i++) {
			
			// Filtro que busca el libro con isbn correcto
			Bson bsonFilterLibroPrestado = Filters.eq("isbn",librosPrestados.get(i));
			
			// Recogo el libro prestado que cumple con el filtro y muestro lo pedido
			Document docLibroPrestado = (Document) colLibros.find(bsonFilterLibroPrestado).first();
			System.out.println("Titulo: " + docLibroPrestado.get("titulo") + " | ISBN: " + docLibroPrestado.get("isbn"));

		}
		
	}

}
