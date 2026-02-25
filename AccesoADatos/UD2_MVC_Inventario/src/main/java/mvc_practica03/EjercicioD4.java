package mvc_practica03;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.DaoSalida;
import pojos.Usuario;

public class EjercicioD4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Introduce la fecha inicio (dd/MM/yyyy): ");
            String f1 = sc.nextLine();

            System.out.print("Introduce la fecha fin (dd/MM/yyyy): ");
            String f2 = sc.nextLine();

            // Convertir String → Date
            Date fechaInicio = new SimpleDateFormat("dd/MM/yyyy").parse(f1);
            Date fechaFin = new SimpleDateFormat("dd/MM/yyyy").parse(f2);

            DaoSalida dao = new DaoSalida();
            List<Usuario> lista = dao.listarUsuariosConPrestamosEntreFechas(fechaInicio, fechaFin);

            for (Usuario u : lista) {
                System.out.println("Nombre: " + u.getNombre());
                System.out.println("Grupo/Departamento: " + u.getGrupo());
                System.out.println("---------------------------");
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
