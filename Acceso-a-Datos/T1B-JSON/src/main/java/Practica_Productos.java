
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Practica_Productos {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("ficheros\\Productos.json"));

		// Es un Array
		JSONArray productos = (JSONArray) obj;

		// 1. Obten el nombre de todos los productos
		System.out.println("------------------------------------------------------------");
		System.out.println("1. Nombre de todos los productos:\n");

		for (Object cad : productos) {
			JSONObject producto = (JSONObject) cad;
			String nombre = (String) producto.get("nombre_producto");
			System.out.println("- " + nombre);
		}

		// 2. Obtener el nombre y el precio de los productos de la tipo «Ropa»
		System.out.println("------------------------------------------------------------");
		System.out.println("2. Nombre y precio de los productos de tipo Ropa\n");

		for (Object cad : productos) {
			JSONObject producto = (JSONObject) cad;
			String tipo = (String) producto.get("tipo_producto");

			if (tipo.equals("Ropa")) {
				System.out.println("------------------------------");
				String nombre = (String) producto.get("nombre_producto");
				Double precio = (Double) producto.get("precio");
				System.out.println("Nombre Producto: " + nombre);
				System.out.println("Precio Producto: " + precio + " €");
				System.out.println("------------------------------");
			}
		}

		// 3. Mostrar toda la información del «Pantalones Levi's 501»
		System.out.println("------------------------------------------------------------");
		System.out.println("3. Toda la información de Pantalones Levi's 501:\n");

		for (Object cad : productos) {
			JSONObject producto = (JSONObject) cad;
			String nombre = (String) producto.get("nombre_producto");

			if (nombre.equals("Pantalones Levi's 501")) {
				System.out.println("------------------------------");
				System.out.println(producto);
				System.out.println("------------------------------");
			}
		}

		// 4. Mostrar el nombre y el stock de los productos que están en el «Almacén 1»
		// y que su precio es inferior a 15
		System.out.println("------------------------------------------------------------");
		System.out.println("4. Nombre y stock de productos que están en el almacén 1 y su precio es inferior a 15:\n");

		for (Object cad : productos) {
			JSONObject producto = (JSONObject) cad;
			JSONObject ubicacion = (JSONObject) producto.get("ubicacion");
			String almacen = (String) ubicacion.get("almacen");

			double precio = ((double) producto.get("precio"));

			if (almacen.equals("Almacén 1") && precio < 15.00) {
				System.out.println("------------------------------");
				System.out.println("Nombre: " + producto.get("nombre_producto"));
				System.out.println("Stock: " + producto.get("stock"));
				System.out.println("Precio: " + precio + " €");
				System.out.println("------------------------------");
			}
		}

		// 5. Mostrar el nombre y la ubicación completa de los productos con un stock
		// menor de 50
		System.out.println("------------------------------------------------------------");
		System.out.println("5. Nombre y ubicación completa de productos que su stock es menor a 50:\n");

		for (Object cad : productos) {
			JSONObject producto = (JSONObject) cad;

			long stock = (long) producto.get("stock");

			if (stock < 50) {
				System.out.println("------------------------------");
				JSONObject ubicacion = (JSONObject) producto.get("ubicacion");
				System.out.println(ubicacion);
				System.out.println("------------------------------");
			}

		}

		// 6. Mostra los productos nombre y tipo de los productos que están en el
		// Pasillo 3 del Amacen 3
		System.out.println("------------------------------------------------------------");
		System.out.println("6. Nombre y tipos de productos que están en el pasillo 3 del almacen 3:\n");
		
		for (Object cad : productos) {
			JSONObject producto = (JSONObject) cad;
			JSONObject ubicacion = (JSONObject) producto.get("ubicacion");
			String almacen = (String) ubicacion.get("almacen");
			String pasillo = (String) ubicacion.get("pasillo");

			if (almacen.equals("Almacén 3") && pasillo.equals("Pasillo 3")) {				
				System.out.println("------------------------------");
				System.out.println("Nombre: " + producto.get("nombre_producto"));
				System.out.println("Tipo: " + producto.get("tipo_producto"));
				System.out.println("------------------------------");
			}
		}
		
		// 8. Mostrar cuantos productos hay de las Categoria Deportes
		System.out.println("------------------------------------------------------------");
		System.out.println("8. Productos categoría deportes:\n");
		int cont = 0;
		
		for(Object cad : productos) {
			JSONObject producto = (JSONObject) cad;
			JSONArray jArray = (JSONArray) producto.get("categorias");
			
			if(jArray.contains("Deportes")) {
				cont++;
			}
		}
		
		System.out.println("Hay un total de "+cont+" producto/s de la categoría Deportes.");
		
		// 9. Pide los datos de un nuevo producto al usurio e insertalo en el documentos
		System.out.println("------------------------------------------------------------");
		System.out.println("9. El usuario añade un producto:\n");

	}

}
