package Practicas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.google.gson.Gson;

import pojo.FootballPlayer;

public class FootballFromJson {

	public static void main(String[] args) {
		
		File archivo = null;
		FileReader reader = null;
		BufferedReader buffer = null;
		String linea, jsonAll = new String();
		Gson gson = new Gson();
		
		try {
			// Abrir fichero json y cargarlo con el buffer
			
			reader = new FileReader("ficheros\\FootballPlay.json");
			buffer = new BufferedReader(reader);
			
			// Leo el fichero json linea a linea para crear un String
			// con todo el Json en la variable jsonAll
			
			while((linea=buffer.readLine())!=null) {
				
				jsonAll=jsonAll+linea;
			}
			
			// Pasar a fromJson el string con todos los footballplayer
			// y devolver a un array de objetos FootballPlayer
			
			FootballPlayer[]footballPlayers=
					gson.fromJson(jsonAll, FootballPlayer[].class);
			
			for(FootballPlayer fplay:footballPlayers) {
				System.out.println("nombre jugador: " + fplay.getNombre());
				System.out.println("toda la inf jugador: " + fplay.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
