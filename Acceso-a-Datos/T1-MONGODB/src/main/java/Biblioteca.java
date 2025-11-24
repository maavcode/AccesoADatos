import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;

public class Biblioteca {
	public static void main(String[] args) {

		// Conectamos al servidor
		MongoClient mongoCliente = MongoClients.create();

		// Conectamos a la base de datos
		MongoDatabase DBBiblioteca = mongoCliente.getDatabase("Biblioteca");

		// Conectamos a la conexión las colecciones
		MongoCollection<Document> colLibros = DBBiblioteca.getCollection("Libros");
		MongoCollection<Document> colPrestamos = DBBiblioteca.getCollection("Prestamos");
		MongoCollection<Document> colSocios = DBBiblioteca.getCollection("Socios");

		// 1. Buscar el registro del primer libro (clase)

		Document dLibro = (Document) colLibros.find().first();
		System.out.println("--1. Primer registro de la colección Libros:\n" + dLibro.toJson());

		// 2. Buscar todos los libros (clase)

		MongoCursor<Document> cursor_libros = colLibros.find().iterator();
		System.out.println("\n--2. Todos los libros:");
		while (cursor_libros.hasNext()) {
			System.out.println(cursor_libros.next().toJson());
		}

		// 3. Obtener la lista de socios (clase)

		MongoCursor<Document> cursor_socios = colLibros.find().iterator();
		System.out.println("\n--3. Todos los socios:");
		while (cursor_socios.hasNext()) {
			System.out.println(cursor_socios.next().toJson());
		}

		// 4. Obtener el nombre de los socios (usar método get()) (clase)

		MongoCursor<Document> cursor_socios1 = colSocios.find().iterator();
		System.out.println("\n--4. El nombre de todos los socios:");
		while (cursor_socios1.hasNext()) {
			System.out.println("Nombre: " + cursor_socios1.next().get("Nombre"));
		}

		// 5. Buscar el libro con titulo "El Quijote" (clase)

		Bson bsonFilter = Filters.eq("titulo", "El Quijote");
		dLibro = (Document) colLibros.find(bsonFilter).first();
		System.out.println("\n--5. Libro con el título de \"El Quijote\":\n " + dLibro);

		// 6. Buscar el préstamo con dos libros (clase)

		MongoCursor<Document> cursor;
		Bson bsonFilter1 = Filters.size("libro", 2);
		cursor = colPrestamos.find(bsonFilter1).iterator();
		System.out.println("\n--6. Préstamo/s con 2 libros:");
		while (cursor.hasNext()) {
			System.out.println(cursor.next().toJson());
		}

		// 7. Buscar título de libros de autor que se apellida Follet (clase)

		Bson bsonFilter2 = Filters.eq("autor.apellido", "Follet");
		cursor = colLibros.find(bsonFilter2).iterator();
		System.out.println("\n--7. Libros de autor que se apellida Follet:");
		while (cursor.hasNext()) {
			System.out.println(cursor.next().toJson());
		}

		// 8. En prestamos buscar el documento del prestamo del libro con ISBN 446854
		// (clase)

		// 9. Buscar el nombre de los socios que han tenido prestado 456779 (clase)

		Bson bsonFilter3 = Filters.eq("libro.isbn", "446854");
		cursor = colPrestamos.find(bsonFilter3).iterator();
		System.out.println("\n--9. El nombre de los socios que han tenido prestado 456779:");
		while (cursor.hasNext()) {

			Document doc = (Document) cursor.next().get("socio");
			String cad = (String) doc.get("num_socio");
			Integer numero = Integer.parseInt(cad);
			Bson bsonFilter4 = Filters.eq("Num_socio", numero);
			Document doc2 = (Document) colSocios.find(bsonFilter4).first();
			System.out.println(doc2.get("Nombre"));

		}

		// 10. Buscar libros con año mayor que 2000 y más de 500 páginas

		Bson bsonFilter5 = Filters.and(Filters.gt("páginas", 500), Filters.gt("año_publicacion", 2000));
		cursor = colLibros.find(bsonFilter5).iterator();
		System.out.println("\n--10. Libros con el año de publicación mayor a 2000 y más de 500 páginas:");
		while (cursor.hasNext()) {
			System.out.println(cursor.next().toJson());
		}

		// 11. Buscar los libros editados entre 2010 y 2020

		Bson bsonFilter6 = Filters.and(Filters.gt("año_publicacion", 2010), Filters.lt("año_publicacion", 2020));
		cursor = colLibros.find(bsonFilter6).iterator();
		System.out.println("\n--11. Libros publicados entre 2010 y 2020:");
		while (cursor.hasNext()) {
			System.out.println(cursor.next().toJson());
		}

		// 12. Buscar los libros de la editorial "Debolsillo"

		Bson bsonFilter7 = Filters.eq("editorial", "Debolsillo");
		cursor = colLibros.find(bsonFilter7).iterator();
		System.out.println("\n--12. Libros de la editorial \"Debolsillo\":");
		while (cursor.hasNext()) {
			System.out.println(cursor.next().toJson());
		}

		// 13. Muestra el nombre del socio 2

		Bson bsonFilter8 = Filters.eq("Num_socio", 2);
		cursor = colSocios.find(bsonFilter8).iterator();
		System.out.println("\n--13. El nombre del socio con número 2:");
		while (cursor.hasNext()) {
			System.out.println(cursor.next().get("Nombre"));
		}

		// 14. Buscar los libros (titulo, nombre autor) que sean de autores de
		// nacionalidad americana o de la editorial planeta

		Bson bsonFilter9 = Filters.or(Filters.eq("autor.nacionalidad", "Americano"),
				Filters.eq("editorial", "Planeta"));
		cursor = colLibros.find(bsonFilter9).iterator();
		System.out.println("\n--14. Libros con autor de nacionalidad americana o de editorial planeta:");
		while (cursor.hasNext()) {
			System.out.println(cursor.next().get("titulo"));
		}

		// 15. Mostrar la fecha de préstamo del libro prestado al socio num_socio 1
		System.out.println("\n--15. Fecha(s) de préstamo para socio num_socio = 1:");
        Bson f15a = Filters.eq("socio.num_socio", "1");
        Bson f15b = Filters.eq("socio.num_socio", 1);
        Bson f15c = Filters.eq("num_socio", 1);
        try (MongoCursor<Document> c = colPrestamos.find(Filters.or(f15a, f15b, f15c)).iterator()) {
            while (c.hasNext()) {
                Document prest = c.next();
                Object fecha = prest.get("fecha_prestamo");
                System.out.println("Fecha préstamo: " + (fecha != null ? fecha.toString() : "Campo fecha_prestamo no existe"));
            }
        }
		
		
		// 16. Buscar los libros editados entre 1990 y 2000

		Bson bsonFilter10 = Filters.and(Filters.gt("año_publicacion", 1990), Filters.lt("año_publicacion", 2000));
		cursor = colLibros.find(bsonFilter10).iterator();
		System.out.println("\n--16. Libros publicados entre 1990 y 2000:");
		while (cursor.hasNext()) {
			System.out.println(cursor.next().toJson());
		}

		// 17. Mostrar el título de los libros escritos por Isaac Asimov

		Bson bsonFilter11 = Filters.and(Filters.eq("autor.nombre", "Isaac"), Filters.eq("autor.apellido", "Asimov"));
		cursor = colLibros.find(bsonFilter11).iterator();
		System.out.println("\n--17. Libros del autor Isaac Asimov:");
		while (cursor.hasNext()) {
			System.out.println(cursor.next().get("titulo"));
		}

		// 18. Mostrar el nombre de los socios que se ha llevado el prestado el libro de
		// título "El Quijote"

		Bson bsonFilter12 = Filters.eq("libro.titulo", "El Quijote");
		cursor = colLibros.find(bsonFilter12).iterator();
		System.out.println("\n--18. El nombre de los socios que han tenido prestado \"El Quijote\":");
		while (cursor.hasNext()) {

			Document doc = (Document) cursor.next().get("isbn");
			Bson bsonFilter13 = Filters.eq("isbn", doc);
			Document doc2 = (Document) colPrestamos.find(bsonFilter13).first().get("num_socio");
			Bson bsonFilter14 = Filters.eq("Num_socio",doc2);
			Document doc3 = (Document) colSocios.find(bsonFilter14).first().get("Nombre");
			System.out.println(doc3);
		}
		
		// 19. Mostrar el título de los libros que tiene prestados el socio con nombre «Javier García»
        System.out.println("\n--19. Títulos prestados al socio \"Javier García\":");
        Document socioJavier = colSocios.find(Filters.eq("Nombre", "Javier García")).first();
        if (socioJavier != null) {
            Object numSoc = socioJavier.get("Num_socio");
            if (numSoc == null) numSoc = socioJavier.get("num_socio");
            if (numSoc != null) {
                String numStr = numSoc.toString();
                Bson filtroPrestJ = Filters.or(Filters.eq("socio.num_socio", numStr), Filters.eq("num_socio", numStr));
                try (MongoCursor<Document> c = colPrestamos.find(filtroPrestJ).iterator()) {
                    while (c.hasNext()) {
                        Document prest = c.next();
                        Object libroField = prest.get("libro");
                        if (libroField instanceof List) {
                            List<?> lista = (List<?>) libroField;
                            for (Object lo : lista) {
                                if (lo instanceof Document) System.out.println(((Document) lo).get("titulo"));
                            }
                        } else if (libroField instanceof Document) {
                            System.out.println(((Document) libroField).get("titulo"));
                        }
                    }
                }
            } else {
                System.out.println("El socio 'Javier García' no tiene Num_socio en su documento.");
            }
        } else {
            System.out.println("No existe el socio 'Javier García'.");
        }
        
     // 20. Mostrar el título y el autor de los libros de la editorial «Planeta» ordenados por año de edición
        System.out.println("\n--20. Título y autor de libros de editorial \"Planeta\" ordenados por año:");
        try (MongoCursor<Document> c = colLibros.find(Filters.eq("editorial", "Planeta"))
                .projection(Projections.include("titulo", "autor", "año_publicacion"))
                .sort(Sorts.ascending("año_publicacion"))
                .iterator()) {
            while (c.hasNext()) {
                Document lb = c.next();
                Object autorObj = lb.get("autor");
                String autorStr = "N/D";
                if (autorObj instanceof Document) {
                    Document a = (Document) autorObj;
                    autorStr = (a.getString("nombre") != null ? a.getString("nombre") + " " : "") + (a.getString("apellido") != null ? a.getString("apellido") : "");
                } else if (autorObj != null) autorStr = autorObj.toString();
                System.out.println("Título: " + lb.get("titulo") + " — Autor: " + autorStr);
            }
        }
        
     // 21. Mostrar el título y la editorial (proyección) de los libros ordenados por número de páginas.
        System.out.println("\n--21. Título y editorial de libros ordenados por número de páginas (desc):");
        try (MongoCursor<Document> c = colLibros.find()
                .projection(Projections.fields(Projections.include("titulo", "editorial", "páginas"), Projections.excludeId()))
                .sort(Sorts.descending("páginas"))
                .iterator()) {
            while (c.hasNext()) {
                System.out.println("EJER21 libro: " + c.next().toJson());
            }
        }
		
	}

}
