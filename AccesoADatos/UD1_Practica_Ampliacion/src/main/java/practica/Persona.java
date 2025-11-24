package practica;

public class Persona {

    private String surname;
    private int id_persona;
    private String city;

    public Persona(String surname, int id_persona, String city) {
        this.surname = surname;
        this.id_persona = id_persona;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "surname='" + surname + '\'' +
                ", id_persona=" + id_persona +
                ", city='" + city + '\'' +
                '}';
    }
}
