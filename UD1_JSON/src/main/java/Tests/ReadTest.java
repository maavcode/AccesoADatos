package Tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadTest {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		JSONArray jArray = null;
		try {
			// Guardamos fichero en un Object ya que empieza por {
			Object obj = parser.parse(new FileReader("ficheros\\test.json"));
			JSONObject jObj = (JSONObject)obj; // Convertimos el Object en JSONObject
			
			// Ejercicios
			ejercicio01(jObj, jArray);
			ejercicio02(jObj, jArray);
			ejercicio03(jObj, jArray);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ejercicio01(JSONObject jObj, JSONArray jArray) {
		System.out.println("--- JSON Entero ---");
		System.out.println(jObj);
	}
	
	public static void ejercicio02(JSONObject jObj, JSONArray jArray) {
		System.out.println("--- Mostrar un solo campo ---");
		System.out.println(jObj.get("name"));
	}
	
	public static void ejercicio03(JSONObject jObj, JSONArray jArray) {
		System.out.println("--- Mostrar la informacion de un mensaje ---");
		jArray = (JSONArray) jObj.get("messages"); // Lo que queremos recoger es un array de campos
		for (Object cad : jArray) {
			System.out.println("Mensaje: " + cad.toString());
		}
	}

	
}
