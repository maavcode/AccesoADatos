package practica;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Cocina {

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
        	// Transformo el fichero de texto productos en un objeto
        	Object objPlatos = parser.parse(new FileReader("ficheros\\Platos.json"));
        				
        	// Convertimos el Object en JSONArray ( Empieza por [ )
        	JSONArray jArrayPlatos = (JSONArray) objPlatos;

        	// Llamamos a los ejercicios
            ejercicioA(jArrayPlatos);
            ejercicioB(jArrayPlatos);
            ejercicioC(jArrayPlatos);
            ejercicioD(jArrayPlatos);
            ejercicioE(jArrayPlatos);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    // Ejercicio A
    public static void ejercicioA(JSONArray jArrayPlatos) {
        System.out.println("--- Ejercicio A: Obtener los ingredientes del gazpacho  ---");
        
        for (Object object : jArrayPlatos) {
            JSONObject jObjPlato = (JSONObject) object;
            
            if (jObjPlato.get("nombre").equals("Gazpacho")) {
                JSONArray jArrayIngredientes = (JSONArray) jObjPlato.get("ingredientes");
                
                for (Object ing : jArrayIngredientes) {
                    JSONObject jObjIngrediente = (JSONObject) ing;
                    System.out.println("Ingrediente: " + jObjIngrediente.get("nombre") + " | Cantidad: " + jObjIngrediente.get("cantidad"));
                }
            }
        }
        System.out.println();
    }

    // Ejercicio B
    public static void ejercicioB(JSONArray jArrayPlatos) {
        System.out.println("--- Ejercicio B: Obtener todos los platos (nombre) que tiene el ingrediente tomate  ---");
        
        for (Object object : jArrayPlatos) {
            JSONObject jObjPlato = (JSONObject) object;
            JSONArray jArrayIngredientes = (JSONArray) jObjPlato.get("ingredientes");
            
            for (Object ing : jArrayIngredientes) {
                JSONObject jObjIngrediente = (JSONObject) ing;
                if ("Tomate".equalsIgnoreCase((String) jObjIngrediente.get("nombre"))) {
                    System.out.println("Plato: " + jObjPlato.get("nombre"));
                }
            }
        }
        System.out.println();
    }

    // Ejercicio C
    public static void ejercicioC(JSONArray jArrayPlatos) {
        System.out.println("--- Ejercicio C: Obtener que platos se ofrecen como primero y que ingredientes tienen  ---");
        for (Object object : jArrayPlatos) {
            JSONObject jObjPlato = (JSONObject) object;
            if (jObjPlato.get("tipo").equals("Primero")) {
                System.out.println("Plato: " + jObjPlato.get("nombre"));
                JSONArray jArrayIngredientes = (JSONArray) jObjPlato.get("ingredientes");
                for (Object ing : jArrayIngredientes) {
                    JSONObject jObjIngrediente = (JSONObject) ing;
                    System.out.println("  Ingrediente: " + jObjIngrediente.get("nombre") + " | Cantidad: " + jObjIngrediente.get("cantidad"));
                }
            }
        }
        System.out.println();
    }

    // Ejercicio D
    public static void ejercicioD(JSONArray jArrayPlatos) {
        System.out.println("--- Ejercicio D: Obtener que cantidad de huevos necesito tener para poder ofrecer al menos 3 platos de los que necesitan huevo, ¿ Puedes extraer esta información, cual es el problema, lo podrías solucionar?  ---");

        int huevosTotales = 0;
        int platosContados = 0;

        for (Object object : jArrayPlatos) {
            if (platosContados >= 3) break;

            JSONObject jObjPlato = (JSONObject) object;
            JSONArray jArrayIngredientes = (JSONArray) jObjPlato.get("ingredientes");
            for (Object ing : jArrayIngredientes) {
                JSONObject jObjIngrediente = (JSONObject) ing;
                if (jObjIngrediente.get("nombre").equals("Huevo")) {
                    String cantidadStr = (String) jObjIngrediente.get("cantidad"); 
                    cantidadStr = cantidadStr.replaceAll("[^0-9]", "");
                    if (!cantidadStr.isEmpty()) {
                        int cantidad = Integer.parseInt(cantidadStr);
                        huevosTotales += cantidad;
                        platosContados++;
                    }
                }
            }
        }

        System.out.println("Huevos necesarios para 3 platos: " + huevosTotales);
        System.out.println("Problema: algunas cantidades están en strings con formato distinto y hay que parsearlas a int para sumarlas correctamente.");
        System.out.println();
    }
    
    // Ejercicio E
    public static void ejercicioE(JSONArray jArrayPlatos) {
        System.out.println("--- Ejercicio E: Consultas tipo JsonPath usando org.json.simple ---");

        // a. Ingredientes del Gazpacho
        for (Object obj : jArrayPlatos) {
            JSONObject jObjPlato = (JSONObject) obj;
            if (jObjPlato.get("nombre").equals("Gazpacho")) {
                JSONArray jArrayIngredientes = (JSONArray) jObjPlato.get("ingredientes");
                System.out.print("Ingredientes del Gazpacho: ");
                for (Object ing : jArrayIngredientes) {
                    JSONObject jObjIngrediente = (JSONObject) ing;
                    System.out.print(jObjIngrediente.get("nombre") + " ");
                }
                System.out.println();
            }
        }

        // b. Platos que contienen Tomate
        System.out.print("Platos que tienen Tomate: ");
        for (Object obj : jArrayPlatos) {
            JSONObject jObjPlato = (JSONObject) obj;
            JSONArray jArrayIngredientes = (JSONArray) jObjPlato.get("ingredientes");
            for (Object ing : jArrayIngredientes) {
                JSONObject jObjIngrediente = (JSONObject) ing;
                if (jObjIngrediente.get("nombre").equals("Tomate")) {
                    System.out.print(jObjPlato.get("nombre") + " ");
                }
            }
        }
    }


	
}
