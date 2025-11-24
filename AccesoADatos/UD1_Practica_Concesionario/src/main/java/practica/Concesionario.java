package practica;

import java.util.ArrayList;
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

public class Concesionario {

	public static void main(String[] args) {
		// Conexion al servidor
		MongoClient mongoCliente = MongoClients.create();
		// Conexion a la base de datos
		MongoDatabase dbConcesionario = mongoCliente.getDatabase("Concesionario");

		Bson bsonFilter = null;

		// Llamadas a los ejercicios
		Ejercicio01(bsonFilter, dbConcesionario);
		Ejercicio02(bsonFilter, dbConcesionario);
		Ejercicio03(bsonFilter, dbConcesionario);
		Ejercicio04(bsonFilter, dbConcesionario);
		Ejercicio05(bsonFilter, dbConcesionario);
		Ejercicio06(bsonFilter, dbConcesionario);
		Ejercicio07(bsonFilter, dbConcesionario);
		Ejercicio08(bsonFilter, dbConcesionario);
		Ejercicio09(bsonFilter, dbConcesionario);
		Ejercicio10(bsonFilter, dbConcesionario);
		Ejercicio11(bsonFilter, dbConcesionario);
		Ejercicio12(bsonFilter, dbConcesionario);
	}

	// EJERCICIO 1
	public static void Ejercicio01(Bson bsonFilter, MongoDatabase dbConcesionario) {
		System.out.println("Ejercicio 1: Buscar los coche de modelo Rolls, obtener el json con la información del coche.");
		MongoCollection<Document> colCoches = dbConcesionario.getCollection("Coches");
		bsonFilter = Filters.eq("Model", "Rolls");
		MongoCursor<Document> cursor = colCoches.find(bsonFilter).iterator();
		while (cursor.hasNext()) {
			Document doc = cursor.next();
			System.out.println(doc.toJson());
		}
		System.out.println("-------------------------------");
	}

	// EJERCICIO 2
	public static void Ejercicio02(Bson bsonFilter, MongoDatabase dbConcesionario) {
		System.out.println("Ejercicio 2: Buscar los coches modelo Ford,obtener de la colección coche el surname de la persona propietaria.");

		MongoCollection<Document> colCoches = dbConcesionario.getCollection("Coches");
		MongoCollection<Document> colPersonas = dbConcesionario.getCollection("Personas");

		bsonFilter = Filters.eq("Model", "Ford");
		MongoCursor<Document> cursorCoches = colCoches.find(bsonFilter).iterator();

		while (cursorCoches.hasNext()) {
			Document coche = cursorCoches.next();
			String idPersona = (String) coche.get("id_person");
			Bson filtroPersona = Filters.eq("id_person", idPersona);
			Document persona = colPersonas.find(filtroPersona).first();
			if (persona != null) {
				System.out.println("Modelo: " + coche.get("Model") + " | Propietario: " + persona.get("surname"));
			}
		}
		System.out.println("-------------------------------");
	}

	// EJERCICIO 3
	public static void Ejercicio03(Bson bsonFilter, MongoDatabase dbConcesionario) {
		System.out.println("Ejercicio 3: Busca de los coches Ford del Year anterior al 2000 y posterior al 1995, su Value y ordenarlos por este campo.");
		MongoCollection<Document> colCoches = dbConcesionario.getCollection("Coches");
		bsonFilter = Filters.and(Filters.eq("Model", "Ford"), Filters.gte("Year", 1995), Filters.lte("Year", 2000));
		MongoCursor<Document> cursorCoches = colCoches.find(bsonFilter).sort(Sorts.ascending("Value")).iterator();
		while (cursorCoches.hasNext()) {
			Document doc = cursorCoches.next();
			System.out.println(
					"Modelo: " + doc.get("Model") + " | Año: " + doc.get("Year") + " | Valor: " + doc.get("Value"));
		}
		System.out.println("-------------------------------");
	}

	// EJERCICIO 4
	public static void Ejercicio04(Bson bsonFilter, MongoDatabase dbConcesionario) {
		System.out.println("Ejercicio 4: Buscar el coche Ford o Rolls y de la persona Juan, obtener la matrícula de los coches.");
		MongoCollection<Document> colCoches = dbConcesionario.getCollection("Coches");
		MongoCollection<Document> colPersonas = dbConcesionario.getCollection("Personas");

		Bson filtroPersona = Filters.eq("surname", "Juan"); // Con Luis no funciona porque el array es de 1
		Document persona = colPersonas.find(filtroPersona).first(); // Solo una persona llamada Juan

		bsonFilter = Filters.in("Model", "Ford", "Rolls");
		MongoCursor<Document> cursorCoches = colCoches.find(bsonFilter).iterator();
		
		List<Integer> cochesPersona = (List<Integer>) persona.get("coches"); // Para guardar los coches de una persona
		
		if (persona.get("coches") != null) {
			 while (cursorCoches.hasNext()) {
			        Document docCoche = cursorCoches.next();
			        Integer id_car = (Integer) docCoche.get("id_car");

			        if (cochesPersona.contains(id_car)) {
			            System.out.println("id_car: " + id_car
			                + " | Matrícula: " + docCoche.get("Matrícula")
			                + " | surname: " + persona.get("surname"));
			        }
			    }
		} else {
			System.out.println("La persona " + persona.get("surname") + " no tiene coches.");
		}
		


		System.out.println("-------------------------------");
	}

	// EJERCICIO 5
	public static void Ejercicio05(Bson bsonFilter, MongoDatabase dbConcesionario) {
	    System.out.println(
	            "Ejercicio 5: Coches, obtener una proyección con la Model, Matrícula y Value, cuyos dueños (colección persona) son de la ciudad de «London» y del año menor 1994, ordenados por año.");
	    
	    MongoCollection<Document> colPersonas = dbConcesionario.getCollection("Personas");
	    Bson filtroPersona = Filters.eq("City", "London");
	    MongoCursor<Document> cursorPersonas = colPersonas.find(filtroPersona).iterator();
	    
	    MongoCollection<Document> colCoches = dbConcesionario.getCollection("Coches");

	    while (cursorPersonas.hasNext()) {
	        Document docPersona = cursorPersonas.next();
	        List<Integer> coches = (List<Integer>) docPersona.get("coches");

	        if (coches == null) {
	        	continue; // Si no tiene coches, saltamos
	        }
	        // Creamos el cursor de coches filtrados por año dentro del bucle, sino no se resetea por iteracion
	        Bson filtroCoches = Filters.lt("Year", 1994);
	        MongoCursor<Document> cursorCoches = colCoches.find(filtroCoches).iterator();

	        while (cursorCoches.hasNext()) {
	            Document docCoche = cursorCoches.next();
	            int idCoche = (int) docCoche.get("id_car"); // Forzar a int

	            if (coches.contains(idCoche)) {
	                System.out.println("Modelo: " + docCoche.get("Model")
	                        + " | Matricula: " + docCoche.get("Matrícula")
	                        + " | Value: " + docCoche.get("Value"));
	            }
	        }
	        cursorCoches.close();
	    }
	    cursorPersonas.close();

	    System.out.println("-------------------------------");
	}

	// EJERCICIO 6
	public static void Ejercicio06(Bson bsonFilter, MongoDatabase dbConcesionario) {
		System.out.println("Ejercicio 6: Obtener la ciudad de las personas que tienen dos coches.");
		
		MongoCollection<Document> colPersonas = dbConcesionario.getCollection("Personas");
		MongoCursor cursorPersonas = colPersonas.find().iterator();
		
		 while (cursorPersonas.hasNext()) {
		        Document docPersona = (Document) cursorPersonas.next();
		        List<Integer> coches = (List<Integer>) docPersona.get("coches");
		        if (coches != null && coches.size()==2) {
		        	System.out.println("surname: " + docPersona.get("surname") + " | Coches: " + coches.size() + " | Ciudad: " + docPersona.get("City"));					
				}
		        
		 }
		
		System.out.println("-------------------------------");
	}

	// EJERCICIO 7
	public static void Ejercicio07(Bson bsonFilter, MongoDatabase dbConcesionario) {
	    System.out.println("Ejercicio 7: Buscar el coche, obtener json con toda la información, que contiene el modelo una «r» (investiga con que función puedes buscar en una cadena), ordenados por marca.");

	    MongoCollection<Document> colCoches = dbConcesionario.getCollection("Coches");

	    bsonFilter = Filters.regex("Model", "r", "i");
	    MongoCursor<Document> cursorCoches = colCoches.find(bsonFilter)
	            .sort(new Document("Model", 1)) // Orden ascendente por Model
	            .iterator();

	    while (cursorCoches.hasNext()) {
	        Document docCoche = cursorCoches.next();
	        System.out.println(docCoche.toJson());
	    }

	    System.out.println("-------------------------------");
	}


	// EJERCICIO 8
	public static void Ejercicio08(Bson bsonFilter, MongoDatabase dbConcesionario) {
	    System.out.println("Ejercicio 8: Buscar la persona «surname» propietaria, nombre y ciudad del coche 107.");

	    MongoCollection<Document> colPersonas = dbConcesionario.getCollection("Personas");
	    MongoCursor<Document> cursorPersonas = colPersonas.find().iterator();

	    int idCocheBuscado = 107;

	    while (cursorPersonas.hasNext()) {
	        Document docPersona = cursorPersonas.next();
	        List<Integer> coches = (List<Integer>) docPersona.get("coches");
	        if (coches != null && coches.contains(idCocheBuscado)) {
	            System.out.println("Surname: " + docPersona.get("surname")
	                    + " | id_persona: " + docPersona.get("id_persona")
	                    + " | City: " + docPersona.get("City"));
	        }
	    }

	    System.out.println("-------------------------------");
	}


	// EJERCICIO 9
	public static void Ejercicio09(Bson bsonFilter, MongoDatabase dbConcesionario) {
	    System.out.println("Ejercicio 9: Buscar personas con 2 coches, muestra una proyección con el surname.");

	    MongoCollection<Document> colPersonas = dbConcesionario.getCollection("Personas");
	    MongoCursor<Document> cursorPersonas = colPersonas.find().iterator();

	    while (cursorPersonas.hasNext()) {
	        Document docPersona = cursorPersonas.next();
	        List<Integer> coches = (List<Integer>) docPersona.get("coches");
	        if (coches != null && coches.size() == 2) {
	            System.out.println("Surname: " + docPersona.get("surname"));
	        }
	    }

	    System.out.println("-------------------------------");
	}


	// EJERCICIO 10
	public static void Ejercicio10(Bson bsonFilter, MongoDatabase dbConcesionario) {
	    System.out.println("Ejercicio 10: Modificar el modelo del coche_id 101 valor 2000.");

	    MongoCollection<Document> colCoches = dbConcesionario.getCollection("Coches");
	    bsonFilter = Filters.eq("id_car", 101);
	    Document docCoche = colCoches.find(bsonFilter).first();

	    if (docCoche != null) {
	        System.out.println("Antes: " + docCoche.toJson());
	        
	        docCoche.put("Model", "2000");
	        System.out.println("Después: " + docCoche.toJson());
	    }

	    System.out.println("-------------------------------");
	}


	// EJERCICIO 11
	public static void Ejercicio11(Bson bsonFilter, MongoDatabase dbConcesionario) {
	    System.out.println("Ejercicio 11: Añadir un coche Modelo Mercedes año:2001 id_coche:200 valor:3500.");

	    MongoCollection<Document> colCoches = dbConcesionario.getCollection("Coches");

	    // Creamos el documento del nuevo coche
	    Document nuevoCoche = new Document("Model", "Mercedes")
	            .append("Year", 2001)
	            .append("id_car", 200)
	            .append("Value", 3500)
	            .append("Matrícula", "00000M");

	    // Insertamos el coche en la colección
	    colCoches.insertOne(nuevoCoche);

	    System.out.println("Coche insertado: " + nuevoCoche.toJson());
	    System.out.println("-------------------------------");
	}


	// EJERCICIO 12
	public static void Ejercicio12(Bson bsonFilter, MongoDatabase dbConcesionario) {
	    System.out.println("Ejercicio 12: Modificarla persona con id_persona:4 y añade a su array de coches el nuevo coche con id_coche:200.");

	    MongoCollection<Document> colPersonas = dbConcesionario.getCollection("Personas");

	    // Buscamos la persona
	    bsonFilter = Filters.eq("id_persona", 4);
	    Document persona = colPersonas.find(bsonFilter).first(); // Solo una persona con ese id

	    if (persona != null) {
	        // Obtenemos su array de coches (si no existe, lo crea)
	        List<Integer> coches = (List<Integer>) persona.get("coches");
	        if (coches == null) {
	            coches = new ArrayList<Integer>();
	        }

	        // Añadimos el nuevo coche
	        coches.add(200);
	        persona.put("coches", coches);

	        // Mostramos la persona actualizada
	        System.out.println("Persona actualizada: " + persona.toJson());

	        colPersonas.replaceOne(Filters.eq("id_persona", 4), persona);
	    } else {
	        System.out.println("No se encontró la persona con id_persona 4.");
	    }

	    System.out.println("-------------------------------");
	}


}
