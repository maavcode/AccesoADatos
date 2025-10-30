package Practicas;

import java.util.Arrays;
import java.util.List;

import pojo.FootballPlayer;



public class FootballToJson {
	public static void main(String [] args) {
		List<FootballPlayer>ValenciaTeam=Arrays.asList(
				new FootballPlayer(
						1,
						"Cañizares",
						Arrays.asList("portero", "Valencia CF"), 
						"Valencia CF"
						),
				new FootballPlayer(
						2,
						"Villa",
						Arrays.asList("delantero"), 
						"Valencia CF"
						)
				);
		
	}

}
