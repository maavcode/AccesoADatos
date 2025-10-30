package Practicas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class productos {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
			// Transformo el fichero de texto productos en un objeto
			Object objProductos = parser.parse(new FileReader("ficheros\\productos.json"));
			// Convertimos el Object en JSONArray ( Empieza por [ )
			JSONArray jArrayProductos = (JSONArray) objProductos;

			// Ejercicios
			ejercicio01(jArrayProductos);
			ejercicio02(jArrayProductos);
			ejercicio03(jArrayProductos);
			ejercicio04(jArrayProductos);
			ejercicio05(jArrayProductos);
			ejercicio06(jArrayProductos);
			ejercicio07(jArrayProductos);
			ejercicio08(jArrayProductos);

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

	public static void ejercicio01(JSONArray jArrayProductos) {
		System.out.println("--- Ejercicio 1: Obten el nombre de todos los productos ---");
		
		for (Object object : jArrayProductos) {
			JSONObject jObjProducto = (JSONObject) object;
			System.out.println("Nombre producto: " + jObjProducto.get("nombre_producto"));
		}
		
		System.out.println("");
	}

	public static void ejercicio02(JSONArray jArrayProductos) {
		System.out.println("--- Ejercicio 2: Obtener el nombre y el precio de los productos de la tipo «Ropa» ---");
		
		for (Object object : jArrayProductos) {
			JSONObject jObjProducto = (JSONObject) object;
			if (jObjProducto.get("tipo_producto").equals("Ropa")) {
				System.out.println(
						"Tipo: " + jObjProducto.get("tipo_producto") +
						" | Nombre producto: " + jObjProducto.get("nombre_producto") + 
						" | Precio: " + jObjProducto.get("precio")
						);				
			}
		}
		
		System.out.println("");
	}

	public static void ejercicio03(JSONArray jArrayProductos) {
		System.out.println("--- Ejercicio 3: Mostrar toda la información del «Pantalones Levi's 501» ---");

		for (Object object : jArrayProductos) {
			JSONObject jObjProducto = (JSONObject) object;
			if (jObjProducto.get("nombre_producto").equals("Pantalones Levi's 501")) {
				System.out.println(jObjProducto.toJSONString());
			}
		}
		
		System.out.println("");
	}

	public static void ejercicio04(JSONArray jArrayProductos) {
		System.out.println("--- Ejercicio 4: Mostrar el nombre y el stock de los productos que están en el «Almacén 1» y que su precio es inferior a 15 ---");

		for (Object object : jArrayProductos) {
			JSONObject jObjProducto = (JSONObject) object;
			JSONObject jObjUbicacion = (JSONObject) jObjProducto.get("ubicacion");
			if (jObjUbicacion.get("almacen").equals("Almacén 1")) {				
				System.out.println("Nombre: " + jObjProducto.get("nombre_producto") + " | Stock: " + jObjProducto.get("stock") + " | " + jObjUbicacion.get("almacen"));
			}
		}
		
		System.out.println("");
	}

	public static void ejercicio05(JSONArray jArrayProductos) {
		System.out.println("--- Ejercicio 5: Mostrar el nombre y la ubicación completa de los productos con un stock menor de 50 ---");

		for (Object object : jArrayProductos) {
			JSONObject jObjProducto = (JSONObject) object;
			if ((Long)jObjProducto.get("stock")<50) {
				System.out.println("Nombre: " + jObjProducto.get("nombre_producto") + " | Ubicacion: " +jObjProducto.get("ubicacion").toString());				
			}
		}
		
		System.out.println("");
	}

	public static void ejercicio06(JSONArray jArrayProductos) {
		System.out.println("--- Ejercicio 6: Mostra los productos nombre y tipo de los productos que están en el Pasillo 3 del Amacen 3 ---");

		for (Object object : jArrayProductos) {
			JSONObject jObjProducto = (JSONObject) object;
			JSONObject jObjUbicacion = (JSONObject) jObjProducto.get("ubicacion");
			if (jObjUbicacion.get("pasillo").equals("Pasillo 3") & jObjUbicacion.get("almacen").equals("Almacén 3")) {
				System.out.println(
						"Nombre: " + jObjProducto.get("nombre_producto") + 
						" | Tipo: " + jObjProducto.get("tipo_producto") + 
						" | " + jObjUbicacion.get("almacen") + 
						" | " + jObjUbicacion.get("pasillo"));				
			}
		}
		
		System.out.println("");
	}

	public static void ejercicio07(JSONArray jArrayProductos) {
		System.out.println("--- Ejercicio 7: Mostrar cuantos productos hay de las Categoria Deportes ---");

		int contador = 0;
		for (Object object : jArrayProductos) {
			JSONObject jObjProducto = (JSONObject) object;
			JSONArray jArrayCategorias = (JSONArray) jObjProducto.get("categorias");
			if (jArrayCategorias.contains("Deportes")) {
				contador++;
			}
		}
		System.out.println("Hay " + contador + " productos con categoria 'Deportes'");
		
		System.out.println("");
	}

	public static void ejercicio08(JSONArray jArrayProductos) {
		System.out.println("--- Ejercicio 8: Pide los datos de un nuevo producto al usurio e insertalo en el documentos ---");

		try {
			FileWriter productosWriter = new FileWriter("ficheros\\productos.json", true);
			
			JSONObject jObjNuevo = new JSONObject();
			
			String nombre_producto = "Ordenador";
			jObjNuevo.put("nombre_producto", nombre_producto);
			
			double precio = 1200;
			jObjNuevo.put("precio", precio);
			
			JSONArray jArrayCategorias = new JSONArray();
			jArrayCategorias.add("Informatica");
			jObjNuevo.put("categorias", jArrayCategorias);
			
			int stock = 1200;
			jObjNuevo.put("stock", stock);
			
			JSONObject jObjUbicacion = new JSONObject();
			String almacen = "Almacén 1";
			String estanteria = "Estanteria 2";
			String pasillo = "Pasillo 4";
			jObjUbicacion.put("almacen", almacen);
			jObjUbicacion.put("estanteria", estanteria);
			jObjUbicacion.put("pasillo", pasillo);
			jObjNuevo.put("ubicacion", jObjUbicacion);
			
			String tipo_producto = "Tecnologia";
			jObjNuevo.put("tipo_producto", tipo_producto);
			
			productosWriter.write(jObjNuevo.toJSONString());
			
			productosWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("");
	}

}
