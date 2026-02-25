 package MongoDB_JSON;

import java.util.List;
import java.util.Scanner;

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

public class EjercicioA1 {

	public static void main(String[] args) {
		// Conexion al servidor
		MongoClient mongoCliente = MongoClients.create();
		// Conexion a la base de datos
		MongoDatabase dbAlquiler = mongoCliente.getDatabase("Alquiler");
		// Conexion a una coleccion en especifico
		MongoCollection colMotos = dbAlquiler.getCollection("Motos");
		MongoCollection colClientes = dbAlquiler.getCollection("Clientes");

		// EJERCICIO A1
		System.out.println("--- Proyeccion JSON: Matricula Propiedad moto num motos devueltas en dicha ciudad ---");
		Scanner sc = new Scanner(System.in);
		Document docA1Clientes = null;
		Document docA1Motos = null;

		String ciudad = sc.nextLine();// Inserto datos
		// Cursor de CLientes
		MongoCursor<Document> cursorClientes = colClientes.find().iterator();
		// Recorro los clientes
		while (cursorClientes.hasNext()) {
			Document docCliente = (Document) cursorClientes.next();
			// Cursor para ver los alquileres
			MongoCursor<Document> alquileres = (MongoCursor<Document>) docCliente.get("alquileres");
			// Recorro los alquileres
			while (alquileres.hasNext()) { 
				Document docAlquileres = (Document) alquileres.next();
				// Verifico la ciudad
				if (docAlquileres.get("origen_alquiler").equals(ciudad)) {
					int idMoto = (int) docAlquileres.get("moto");
					// Creo el cursor de Motos
					MongoCursor<Document> cursorMotos = colMotos.find()
							.projection(
									Projections.fields(
											Projections.include("matricula", "propiedades.tipo"), 
											Projections.excludeId()
											)
									)
							.iterator();
					// Recorro el cursor de motos
					while (cursorMotos.hasNext()) {
						Document docMoto = (Document) cursorMotos.next();
						if (docMoto.get("id").equals(idMoto)) {
							// Muestro la informacion
							System.out.println(docMoto.toJson());
						}
					}

				}

			}
		}

		sc.close();
		}
			
}

