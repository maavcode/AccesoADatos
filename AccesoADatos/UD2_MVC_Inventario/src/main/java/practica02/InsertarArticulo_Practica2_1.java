package practica02;

import java.util.Date;
import java.util.Scanner;

import dao.DaoArticulo;
import jdbc.ConexionJdbc;
import pojos.Articulo;

public class InsertarArticulo_Practica2_1 {

    public static void main(String[] args) {

        ConexionJdbc conJdbc = null;
        Articulo a = null;
        DaoArticulo dao = new DaoArticulo();

        int id;
        String numserie;
        int modelo;
        int departamento;
        int espacio;
        int usuarioalta;

        try (Scanner tec = new Scanner(System.in)) {

            System.out.println("--> ID nuevo artículo:");
            id = Integer.parseInt(tec.nextLine());

            System.out.println("--> Número de serie:");
            numserie = tec.nextLine();

            System.out.println("--> Modelo (ID numérico):");
            modelo = Integer.parseInt(tec.nextLine());

            System.out.println("--> Departamento (ID numérico):");
            departamento = Integer.parseInt(tec.nextLine());

            System.out.println("--> Espacio (ID numérico):");
            espacio = Integer.parseInt(tec.nextLine());

            System.out.println("--> ID del usuario que da de alta:");
            usuarioalta = Integer.parseInt(tec.nextLine());
        }

        try {
            conJdbc = new ConexionJdbc("Configuracion/propiedadesInventario.txt");
            conJdbc.conectar();

            // Crear artículo
            a = new Articulo();
            a.setIdArticulo(id);
            a.setNumserie(numserie);
            a.setModelo(modelo);
            a.setDepartamento(departamento);
            a.setEspacio(espacio);
            a.setUsuarioalta(usuarioalta);
            a.setFechaalta(new Date()); // Fecha actual del sistema

            // Llamada al DAO
            dao.grabar(a);

            System.out.println("Artículo insertado correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conJdbc.desconectar();
        }
    }
}
