import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;

public class Practica_Cocina {
    public static void main(String[] args) {
        try {
            String contenido = new String(Files.readAllBytes(Paths.get("Ficheros/Cocina.json"))); 
            JSONArray platos = new JSONArray(contenido);

            // a. Ingredientes del Gazpacho
            System.out.println("a. Ingredientes de gazpacho:");
            for (int i = 0; i < platos.length(); i++) {
                JSONObject plato = platos.getJSONObject(i);
                if (plato.getString("nombre").equalsIgnoreCase("Gazpacho")) {
                    JSONArray ingredientes = plato.getJSONArray("ingredientes");
                    for (int j = 0; j < ingredientes.length(); j++) {
                        JSONObject ing = ingredientes.getJSONObject(j);
                        System.out.println("-" + ing.getString("nombre"));
                    }
                }
            }

            // b. Platos que tienen tomate
            System.out.println("\nb. Platos que tienen tomate:");
            for (int i = 0; i < platos.length(); i++) {
                JSONObject plato = platos.getJSONObject(i);
                JSONArray ingredientes = plato.getJSONArray("ingredientes");
                for (int j = 0; j < ingredientes.length(); j++) {
                    JSONObject ing = ingredientes.getJSONObject(j);
                    if (ing.getString("nombre").equalsIgnoreCase("Tomate")) {
                        System.out.println("-" + plato.getString("nombre"));
                        break; 
                    }
                }
            }

            // c. Platos tipo primero y sus ingredientes
            System.out.println("\nc. Platos tipo primero y sus ingredientes:");
            for (int i = 0; i < platos.length(); i++) {
                JSONObject plato = platos.getJSONObject(i);
                if (plato.getString("tipo").equalsIgnoreCase("Primero")) {
                    System.out.println("-" + plato.getString("nombre"));
                    JSONArray ingredientes = plato.getJSONArray("ingredientes");
                    for (int j = 0; j < ingredientes.length(); j++) {
                        JSONObject ing = ingredientes.getJSONObject(j);
                        System.out.println("-->" + ing.getString("nombre"));
                    }
                }
            }

            // d. Cantidad de huevos para ofrecer al menos 3 platos que los usan
            int totalHuevos = 0;
            int platosConHuevo = 0;
            for (int i = 0; i < platos.length(); i++) {
                JSONObject plato = platos.getJSONObject(i);
                JSONArray ingredientes = plato.getJSONArray("ingredientes");
                for (int j = 0; j < ingredientes.length(); j++) {
                    JSONObject ing = ingredientes.getJSONObject(j);
                    if (ing.getString("nombre").equalsIgnoreCase("Huevo")) {
                        String cantidad = ing.getString("cantidad").replace("ud", "").trim();
                        totalHuevos += Integer.parseInt(cantidad);
                        platosConHuevo++;
                        break;
                    }
                }
            }
            System.out.println("\nd. Total de huevos disponibles en los platos que los usan: " + totalHuevos);
            if (platosConHuevo >= 3) {
                System.out.println("Se puede ofrecer al menos 3 platos con huevo.");
            } else {
                System.out.println("No hay suficientes platos con huevo para ofrecer 3.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
