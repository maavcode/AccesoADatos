package restriccionesHQL;

import java.util.Scanner;

import dao.DaoDisco;
import dao.DaoCancion;
import hibernate.UtilesHibernate;
import pojosEsther.Disco;
import pojosEsther.Cancion;

public class EjercicioA {

    public static void main(String[] args) {
        System.out.println("----- Ejercicio A: Añadir canción a un disco (máx 60 min) -----");

        try {
            UtilesHibernate.openSession();

            Scanner sc = new Scanner(System.in);

            DaoDisco daoDisco = new DaoDisco();
            DaoCancion daoCancion = new DaoCancion();

            System.out.println("Introduce el código del disco:");
            String nombreDisco = sc.nextLine();

            System.out.println("Introduce el código de la canción:");
            String nombreCancion = sc.nextLine();
            
            Disco disco = daoDisco.buscarPorNombre(nombreDisco); 
            if (disco == null) { 
            	System.out.println("No existe ningún disco con ese nombre."); 
            	return; 
            } 
            Cancion cancion = daoCancion.buscarPorNombre(nombreCancion); 
            if (cancion == null) { 
            	System.out.println("No existe ninguna canción con ese nombre."); 
            	return; 
            }

            daoDisco.addCancionADisco(disco, cancion);
            

            System.out.println("Canción añadida correctamente.");

            
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            UtilesHibernate.closeSession();
            UtilesHibernate.closeSessionFactory();
        }
    }
}
