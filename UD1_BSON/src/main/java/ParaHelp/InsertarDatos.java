package ParaHelp;

import java.util.ArrayList;
import java.util.Date;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InsertarDatos {

	public static void main(String[] args) {
		// Conexion al servidor
		MongoClient mongoCliente = MongoClients.create();
		// Conexion a la base de datos
		MongoDatabase dbT = mongoCliente.getDatabase("nombreBD");
		// Conexion a una coleccion en especifico
		MongoCollection colT = dbT.getCollection("nombreColeccion"); // Tantos como colecciones haya
		
		/* Para insertar un dato, tendremos que insertar un document tipo Document */
		ArrayList<Document> arrayLibros = new ArrayList<Document>();
		Document libro1 = new Document("ISBN", "446854");
		Document libro2 = new Document("ISBN", "456779");
		arrayLibros.add(libro1);
		arrayLibros.add(libro2);
		
		Document docPrestamo1 = new Document("fecha_dev", new Date(2025-9-29))
									.append("fecha_pres", new Date(2025-9-1))
									.append("socio", new Document("num_socio", 2))
									.append("libro", arrayLibros);
		
	}

}
