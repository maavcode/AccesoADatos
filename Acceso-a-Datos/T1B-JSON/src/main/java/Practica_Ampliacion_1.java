import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.google.gson.Gson;
import org.bson.Document;

import java.util.ArrayList;

public class Practica_Ampliacion_1 {

    public static void main(String[] args) {

        MongoClient cliente = MongoClients.create();
        MongoDatabase bd = cliente.getDatabase("Concesionario");
        MongoCollection<Document> coleccionPersonas = bd.getCollection("Personas");

        ArrayList<Persona> listaPersonas = new ArrayList<>();
        Gson gson = new Gson();

        MongoCursor<Document> cursor = coleccionPersonas.find(Filters.eq("City", "London")).iterator();

        while(cursor.hasNext()) {
            Document doc = cursor.next();
            Persona p = gson.fromJson(doc.toJson(), Persona.class);
            listaPersonas.add(p);
        }

        for(Persona p : listaPersonas) {
            System.out.println(p);
        }

        cliente.close();
    }
}
