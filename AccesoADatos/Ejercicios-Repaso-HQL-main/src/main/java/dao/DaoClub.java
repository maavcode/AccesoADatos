package dao;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojos.Club;
import pojos.Grupo;

public class DaoClub 
	extends DaoGenericoHibernate<Club, Integer> {
	private final static Logger
	LOGGER = Logger.getLogger(DaoClub.class.getName());
	
	public void insertarClubGrupoExistente(Club club, String nombreGrupo) {
		
		Session sesion = UtilesHibernate.getSessionFactory().getCurrentSession();
		
		try {
			
			sesion.beginTransaction();
			String hql = "from Grupo g where g.nombre =:nom";
			Grupo grupo = sesion.createQuery(hql, Grupo.class)
					.setParameter("nom", nombreGrupo)
					.uniqueResult();
			
			if(grupo == null) {
				throw new RuntimeException("El grupo no existe");
			}
			
			club.setGrupo(grupo);
			grupo.getClubs().add(club);
			
			sesion.persist(club);
			
			sesion.getTransaction().commit();
		
		} catch (Exception e) {
			
			sesion.getTransaction().rollback();
	        e.printStackTrace();
		}
	}
	
}
