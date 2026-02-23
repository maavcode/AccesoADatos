package dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojos.Departamento;

public class DaoDepartamento extends DaoGenericoHibernate<Departamento, String> {
	private final static Logger LOGGER = Logger.getLogger(DaoDepartamento.class.getName());

	// Obtener lista con varios parametros (nombre, edad, etc)
	public List<Object[]> obtenerInformeArticulosDadosAltaPorDepartamento(String nomDepartamento) {

		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		List<Object[]> resultados = null;

		try {
			s.beginTransaction();

			String hqlDepartamento = "select a.estado, a.usuarioByUsuarioalta.nombre, a.usuarioByUsuarioalta.apellido1 from Departamento d join d.articulos a where d.nombre =: nom";
			Query qDepartamento = s.createQuery(hqlDepartamento);
			qDepartamento.setParameter("nom", nomDepartamento);

			resultados = qDepartamento.getResultList();
			
			s.getTransaction().commit();

		} catch (Exception e) {
			s.getTransaction().rollback();
			e.printStackTrace();
		}

		return resultados;
	}
}
