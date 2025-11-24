package MongoDB_JSON;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class EjercicioA3 {

	public static void main(String[] args) {
	
		File archivo = null;
		FileReader reader = null;
		BufferedReader buffer = null;
		String linea, jsonAll = new String();
		Gson gson = new Gson();
		
		try {
			// Abrir fichero json y cargarlo con el buffer
			
			reader = new FileReader("ficheros\\Jugador.json");
			buffer = new BufferedReader(reader);
			
			// Leo el fichero json linea a linea para crear un String
			// con todo el Json en la variable jsonAll
			
			while((linea=buffer.readLine())!=null) {
				
				jsonAll=jsonAll+linea;
			}
			
			// Pasar a fromJson el string con todos los footballplayer
			// y devolver a un array de objetos FootballPlayer
			
			Jugador jugador=
					gson.fromJson(jsonAll, Jugador.class);
			
			
				System.out.println("Nombre: " + jugador.getNombre());
				System.out.println("Genero: " + jugador.getGenero());
				System.out.println("Hobbies: " + jugador.getHobby());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
