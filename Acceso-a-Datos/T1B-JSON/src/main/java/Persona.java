public class Persona {
	private String surname;
	private int id_persona;
	private String City;

	public Persona(String surname, int id_persona, String City) {
		this.surname = surname;
		this.id_persona = id_persona;
		this.City = City;
	}

	public String getSurname() {
		return surname;
	}

	public int getId_persona() {
		return id_persona;
	}

	public String getCity() {
		return City;
	}

	@Override
	public String toString() {
		return "Persona{" + "surname='" + surname + '\'' + ", id_persona=" + id_persona + ", City='" + City + '\''
				+ '}';
	}
}
