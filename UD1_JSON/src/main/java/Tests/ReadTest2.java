package Tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadTest2 {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		JSONArray jArray = null;
		try {
			// Guardamos fichero en un Object ya que empieza por {
			Object obj = parser.parse(new FileReader("ficheros\\test2.json"));
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
		System.out.println("--- Mostrar URLs ---");
		jArray = (JSONArray) jObj.get("pages"); // Lo que queremos recoger es un array de campos
		for (Object object : jArray) {
			jObj = (JSONObject)object;
			System.out.println(jObj.get("pageUrl"));
		}
	}
	
	public static void ejercicio02(JSONObject jObj, JSONArray jArray) {
		System.out.println("--- Mostrar results ---");
		jArray = (JSONArray) jObj.get("pages");
		// Recorro el array pages
		for (Object object : jArray) {
			jObj = (JSONObject) object;
			System.out.println(jObj.get("pageUrl"));
			jArray = (JSONArray) jObj.get("results");
			for (Object object2 : jArray) { // Recorre el array results en cada iteracion de pages
				jObj = (JSONObject) object2;
				System.out.println(jObj.get("number"));
			}
		}
	}
	
	public static void ejercicio03(JSONObject jObj, JSONArray jArray) {
		System.out.println("--- Mostrar results de example0 ---");
		jArray = (JSONArray) jObj.get("pages");
		jObj = (JSONObject) jArray.getFirst();
		System.out.println(jObj.get("pageUrl"));
		jArray = (JSONArray) jObj.get("results");
		for (Object object : jArray) {
			jObj = (JSONObject) object;
			System.out.println(jObj.get("number"));
		}
	}

	
}
