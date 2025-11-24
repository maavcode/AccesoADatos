package practica;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Ampliacion {

    public static void main(String[] args) {
        ejercicio01();
        ejercicio02();
    }

    public static void ejercicio01() {
        MongoClient mongoCliente = MongoClients.create();
        MongoDatabase dbConcesionario = mongoCliente.getDatabase("Concesionario");
        MongoCollection colPersonas = dbConcesionario.getCollection("Personas");

        Document filtro = new Document("City", "London");
        MongoCursor<Document> cursorPersonas = colPersonas.find(filtro).iterator();

        ArrayList<Persona> listaPersonas = new ArrayList<>();

        while (cursorPersonas.hasNext()) {
            Document doc = cursorPersonas.next();
            String surname = doc.getString("surname");
            int id_persona = doc.getInteger("id_persona");
            String city = doc.getString("City");

            Persona persona = new Persona(surname, id_persona, city);
            listaPersonas.add(persona);
        }

        for (Persona p : listaPersonas) {
            System.out.println(p);
        }

        mongoCliente.close();
    }

    public static void ejercicio02() {
        try {
            Gson gson = new Gson();
            Type tipoLista = new TypeToken<List<Plato>>() {}.getType();
            List<Plato> platos = gson.fromJson(new FileReader("ficheros\\cocina.json"), tipoLista);

            MongoClient mongoCliente = MongoClients.create();
            MongoDatabase dbCocina = mongoCliente.getDatabase("Cocina");
            MongoCollection<Document> coleccionPlatos = dbCocina.getCollection("platos");

            for (Plato p : platos) {
                List<Document> ingredientesDoc = new ArrayList<>();
                for (Ingrediente ing : p.getIngredientes()) {
                    ingredientesDoc.add(new Document("nombre", ing.getNombre())
                            .append("cantidad", ing.getCantidad()));
                }

                Document doc = new Document("nombre", p.getNombre())
                        .append("tipo", p.getTipo())
                        .append("ingredientes", ingredientesDoc);

                coleccionPlatos.insertOne(doc);
                System.out.println("Insertado: " + p.getNombre());
            }

            mongoCliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
