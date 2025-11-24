package pojo;

import java.util.List;
import java.util.Objects;

public class FootballPlayer {
	
		private Integer dorsal;
		private String nombre;
		private List <String> demarcation;
		private String team;
		
		
		public FootballPlayer(Integer dorsal, String nombre, List<String> demarcation, String team) {
			super();
			this.dorsal = dorsal;
			this.nombre = nombre;
			this.demarcation = demarcation;
			this.team = team;
		}
		public FootballPlayer() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Integer getDorsal() {
			return dorsal;
		}
		public void setDorsal(Integer dorsal) {
			this.dorsal = dorsal;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public List<String> getDemarcation() {
			return demarcation;
		}
		public void setDemarcation(List<String> demarcation) {
			this.demarcation = demarcation;
		}
		@Override
		public int hashCode() {
			return Objects.hash(demarcation, dorsal, nombre, team);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			FootballPlayer other = (FootballPlayer) obj;
			return Objects.equals(demarcation, other.demarcation) && Objects.equals(dorsal, other.dorsal)
					&& Objects.equals(nombre, other.nombre) && Objects.equals(team, other.team);
		}
		public String getTeam() {
			return team;
		}
		public void setTeam(String team) {
			this.team = team;
		}
	
}
