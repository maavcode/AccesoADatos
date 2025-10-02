package ParaHelp;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ConexionBaseDatos {
	public static void main(String [] args) {
		// Conexion al servidor
		MongoClient mongoCliente = MongoClients.create();
		// Conexion a la base de datos
		MongoDatabase dbT= mongoCliente.getDatabase("nombreBD");
		// Conexion a una coleccion en especifico
		MongoCollection colT = dbT.getCollection("nombreColeccion"); // Tantos como colecciones haya
	}
}
