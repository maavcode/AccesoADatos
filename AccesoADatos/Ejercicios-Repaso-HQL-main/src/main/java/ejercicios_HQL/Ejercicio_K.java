package ejercicios_HQL;

import java.util.List;

import dao.DaoGrupo;
import hibernate.UtilesHibernate;
import pojos.Grupo;

public class Ejercicio_K {

	// DaoGrupo Mostrar los grupos de la Base de Datos que no
	// tocan en ningún club. 
	
	public static void main(String[] args) {
		try {
			UtilesHibernate.openSession();
			DaoGrupo daoGrupo = new DaoGrupo();
			
			/* FORMA CUTRE
			 
			List<Grupo> listaGrupos = daoGrupo.buscarTodos();
			
			System.out.println("-- GRUPOS QUE NO TOCAN EN NINGÚN CLUB --\n");
			for (Grupo grupo : listaGrupos) {
				if(grupo.getClubs().isEmpty()) {
					System.out.println(grupo.getNombre());
				}
			}
			
			*/
			
			List<String> listaGruposSinClubs = daoGrupo.buscarGrupos_Sin_Clubs(daoGrupo.buscarTodos());
			
			for (String string : listaGruposSinClubs) {
				System.out.println(string);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			UtilesHibernate.closeSession();
			UtilesHibernate.closeSessionFactory();
		}
	}
}
