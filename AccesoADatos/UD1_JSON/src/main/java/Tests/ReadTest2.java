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
		try {
			// Guardamos fichero en un Object ya que empieza por {
			Object objTest2 = parser.parse(new FileReader("ficheros\\test2.json"));
			JSONObject jObjTest2 = (JSONObject)objTest2; // Convertimos el Object en JSONObject
			
			// Ejercicios
			ejercicio01(jObjTest2);
			ejercicio02(jObjTest2);
			ejercicio03(jObjTest2);
			
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
	
	public static void ejercicio01(JSONObject jObjTest2) {
		System.out.println("--- Mostrar URLs ---");
		JSONArray jArrayPages = (JSONArray) jObjTest2.get("pages"); // Lo que queremos recoger es un array de campos
		for (Object object : jArrayPages) {
			JSONObject jObjPage = (JSONObject)object;
			System.out.println(jObjPage.get("pageUrl"));
		}
	}
	
	public static void ejercicio02(JSONObject jObjTest2) {
		System.out.println("--- Mostrar results ---");
		JSONArray jArrayPages = (JSONArray) jObjTest2.get("pages");
		// Recorro el array pages
		for (Object object : jArrayPages) {
			JSONObject jObjPage = (JSONObject) object;
			System.out.println(jObjPage.get("pageUrl"));
			JSONArray jArrayResults = (JSONArray) jObjPage.get("results");
			for (Object object2 : jArrayResults) { // Recorre el array results en cada iteracion de pages
				JSONObject jObjResult = (JSONObject) object2;
				System.out.println(jObjResult.get("number"));
			}
		}
	}
	
	public static void ejercicio03(JSONObject jObjTest2) {
		System.out.println("--- Mostrar results de example0 ---");
		JSONArray jArrayPages = (JSONArray) jObjTest2.get("pages");
		JSONObject jObjFirstPage = (JSONObject) jArrayPages.getFirst();
		System.out.println(jObjFirstPage.get("pageUrl"));
		JSONArray jArrayrResults = (JSONArray) jObjFirstPage.get("results");
		for (Object object : jArrayrResults) {
			JSONObject jObjResult = (JSONObject) object;
			System.out.println(jObjResult.get("number"));
		}
	}
	
	public static void ejercicio04() {
		
	}

	
}
