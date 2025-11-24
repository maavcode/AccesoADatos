package MongoDB_JSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EjercicioA2 {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
			// Transformo el fichero de texto productos en un objeto
			Object objEventos = parser.parse(new FileReader("ficheros\\evento.json"));
			// Convertimos el Object en JSONArray ( Empieza por [ )
			JSONArray jArrayEventos = (JSONArray) objEventos;

			for (Object objEvento : jArrayEventos) {
				JSONObject jObjEvento = (JSONObject) objEvento;
				// Recogo el tipo de evento
				JSONArray jArrayTipo = (JSONArray) jObjEvento.get("tipo_evento");
				if (jArrayTipo.contains("música") && ((Long)jObjEvento.get("aforo")>400)) {
					System.out.println("Evento: " + jObjEvento.get("nombre_evento")); // Muestro el evento
				}
			}
			
			// Creo el archivo JSON
			
			
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
}
