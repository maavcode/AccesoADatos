package consultasHQL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.DaoCancion;
import dao.DaoClub;
import dao.DaoDisco;
import dao.DaoGrupo;
import hibernate.UtilesHibernate;
import pojosEsther.Club;
import pojosEsther.Grupo;

public class EjercicioK {

	public static void main(String[] args) {
		System.out.println("----- Ejercicio K: Mostrar los grupos de la Base de Datos que no tocan en ningún club. -----");
		try {
			// Abro la sesion // SIEMPRE
			UtilesHibernate.openSession();
			// Recogo los daos correspondientes
			DaoClub daoClub = new DaoClub();
			DaoGrupo daoGrupo = new DaoGrupo();
			// Recogo los grupos y los clubes
			List<Grupo> listaGrupos = daoGrupo.buscarTodos();
			List<Club> listaClub = daoClub.buscarTodos();
			// Creo una lista para guardar los grupos que de los clubes y la relleno
			List<Grupo> listaGruposConCLub = new ArrayList<Grupo>();
			for (Club club : listaClub) {
				listaGruposConCLub.add(club.getGrupo());
			}
			// Recorro la lista de grupos y me aseguro que no este en la lista de grupos con club
			for (Grupo grupo : listaGrupos) {
				if (!listaGruposConCLub.contains(grupo)) {
					System.out.println("Grupo: " + grupo.getNombre());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // SIEMPRE
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}

}
