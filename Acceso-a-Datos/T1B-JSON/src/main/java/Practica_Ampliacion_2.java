import com.google.gson.Gson;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.FileReader;
import java.io.Reader;

public class Practica_Ampliacion_2 {
	public static void main(String[] args) {
		try {
			Gson gson = new Gson();
			Reader reader = new FileReader("Ficheros\\Cocina.json");
			Plato[] listaPlatos = gson.fromJson(reader, Plato[].class);

			MongoClient mongoClient = MongoClients.create();
			MongoDatabase dbCocina = mongoClient.getDatabase("Cocina");
			MongoCollection<Document> coleccionPlatos = dbCocina.getCollection("Platos");

			for (Plato plato : listaPlatos) {
				Document doc = new Document();
				doc.append("nombre", plato.getNombre());
				doc.append("tipo", plato.getTipo());

				for (Ingrediente ing : plato.getIngredientes()) {
					doc.append("ingredientes", new Document("nombre", ing.getNombre()).append("cantidad", ing.getCantidad()));
				}

				coleccionPlatos.insertOne(doc);
			}

			reader.close();
			mongoClient.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
