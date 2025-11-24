import java.util.Arrays;

import org.bson.Document;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import org.bson.conversions.Bson;

public class Concesionario {

	public static void main(String[] args) {

		MongoClient cliente = MongoClients.create();
		MongoDatabase db = cliente.getDatabase("Concesionario");
		MongoCollection<Document> coleccionPersonas = db.getCollection("Personas");
		MongoCollection<Document> coleccionCoches = db.getCollection("Coches");
		MongoCursor<Document> cursor;

		// 1. Buscar los coches Rolls en json
		System.out.println("1. Coches Rolls:");
		cursor = coleccionCoches.find(Filters.eq("Model", "Rolls")).iterator();
		while (cursor.hasNext()) {
			System.out.println(cursor.next().toJson());
		}
		System.out.println();

		// 2. Buscar los coches Ford y mostrar surname del propietario
		System.out.println("2. Coches Ford con propietario:");
		cursor = coleccionCoches.find(Filters.eq("Model", "Ford")).iterator();
		while (cursor.hasNext()) {
			Document coche = cursor.next();
			int idCar = coche.getInteger("id_car");
			Document propietario = coleccionPersonas.find(Filters.in("coches", idCar)).first();
			if (propietario != null) {
				System.out.println("Ford " + idCar + " -> Propietario: " + propietario.getString("surname"));
			}
		}
		System.out.println();

		// 3. Coches Ford entre 1995 y 2000, ordenar por Value
		System.out.println("3. Coches Ford entre 1995 y 2000 ordenados por Value:");
		Bson filtroEj3 = Filters.and(Filters.eq("Model", "Ford"), Filters.gte("Year", 1995), Filters.lte("Year", 2000));
		cursor = coleccionCoches.find(filtroEj3).sort(Sorts.ascending("Value")).iterator();
		while (cursor.hasNext()) {
			System.out.println(cursor.next().toJson());
		}
		System.out.println();

		// 4. Coches Ford o Rolls de persona Juan, mostrar matrícula
		System.out.println("4. Coches Ford o Rolls de Juan, matrícula:");
		Document personaJuan = coleccionPersonas.find(Filters.eq("surname", "Juan")).first();
		if (personaJuan != null && personaJuan.containsKey("coches")) {
		    for (Object idObj : personaJuan.getList("coches", Object.class)) {
		        int idCar = (idObj instanceof Integer) ? (Integer) idObj : Integer.parseInt(idObj.toString());
		        Document coche = coleccionCoches.find(
		            Filters.and(
		                Filters.eq("id_car", idCar),
		                Filters.in("Model", Arrays.asList("Ford", "Rolls"))
		            )
		        ).first();
		        if (coche != null) {
		            System.out.println("Coche " + idCar + " Matrícula: " + coche.getString("Matrícula"));
		        }
		    }
		}


		System.out.println();

		// 5. Coches de dueños de London y Year < 1994, proyección Model, Matrícula,
		// Value, ordenar por Year
		System.out.println("5. Coches dueños London y Year < 1994:");
		cursor = coleccionPersonas.find(Filters.eq("City", "London")).iterator();
		while (cursor.hasNext()) {
		    Document persona = cursor.next();
		    if (!persona.containsKey("coches")) continue;
		    for (Object idObj : persona.getList("coches", Object.class)) {
		        int idCar = (idObj instanceof Integer) ? (Integer) idObj : Integer.parseInt(idObj.toString());
		        Document coche = coleccionCoches.find(Filters.and(
		                Filters.eq("id_car", idCar),
		                Filters.lt("Year", 1994)
		        ))
		        .projection(Projections.include("Model", "Matrícula", "Value", "Year"))
		        .sort(Sorts.ascending("Year"))
		        .first();

		        if (coche != null) {
		            System.out.println(coche.toJson());
		        }
		    }
		}
		System.out.println();

		// 6. Ciudades de personas que tienen 2 coches
		System.out.println("6. Ciudades de personas con 2 coches:");
		cursor = coleccionPersonas.find(Filters.size("coches", 2)).projection(Projections.include("City")).iterator();
		while (cursor.hasNext()) {
			System.out.println(cursor.next().getString("City"));
		}
		System.out.println();

		// 7. Coches con 'r' en modelo, ordenar por Model
		System.out.println("7. Coches con 'r' en Model:");
		cursor = coleccionCoches.find(Filters.regex("Model", "r", "i")).sort(Sorts.ascending("Model")).iterator();
		while (cursor.hasNext()) {
			System.out.println(cursor.next().toJson());
		}
		System.out.println();

		// 8. Persona propietaria del coche 107, mostrar surname, nombre y ciudad
		System.out.println("8. Propietario coche 107:");
		Document coche107 = coleccionCoches.find(Filters.eq("id_car", 107)).first();
		if (coche107 != null) {
			Document propietario107 = coleccionPersonas.find(Filters.in("coches", 107)).first();
			if (propietario107 != null) {
				System.out.println("Surname: " + propietario107.getString("surname"));
				System.out.println("City: " + propietario107.getString("City"));
			}
		}
		System.out.println();

		// 9. Personas con 2 coches, proyectar surname
		System.out.println("9. Personas con 2 coches (surname):");
		cursor = coleccionPersonas.find(Filters.size("coches", 2)).projection(Projections.include("surname"))
				.iterator();
		while (cursor.hasNext()) {
			System.out.println(cursor.next().getString("surname"));
		}
		System.out.println();

		// 10. Modificar Value del coche 101 a 2000
		System.out.println("10. Modificar Value coche 101 a 2000:");
		coleccionCoches.updateOne(Filters.eq("id_car", 101), Updates.set("Value", 2000));
		Document mod101 = coleccionCoches.find(Filters.eq("id_car", 101)).first();
		System.out.println(mod101.toJson());
		System.out.println();

		// 11. Añadir coche Mercedes 2001 id 200 Value 3500
		System.out.println("11. Añadir coche Mercedes 2001:");
		Document nuevoCoche = new Document("Model", "Mercedes").append("Year", 2001).append("id_car", 200)
				.append("Value", 3500);
		coleccionCoches.insertOne(nuevoCoche);
		System.out.println("Coche añadido: " + nuevoCoche.toJson());
		System.out.println();

		// 12. Añadir coche 200 a persona id_persona 4
		System.out.println("12. Añadir coche 200 a persona 4:");
		coleccionPersonas.updateOne(Filters.eq("id_persona", 4), Updates.push("coches", 200));
		Document persona4 = coleccionPersonas.find(Filters.eq("id_persona", 4)).first();
		System.out.println(persona4.toJson());
	
	}

}
