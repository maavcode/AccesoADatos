package dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.query.Query;

import hibernate.UtilesHibernate;
import pojos.Articulo;
import pojos.Modeloarticulo;
import pojos.Tipousuario;
import pojos.Usuario;

public class DaoArticulo  extends DaoGenericoHibernate<Articulo, String>{
	private final static Logger LOGGER = Logger.getLogger(DaoArticulo.class.getName());

	public Integer obtenerVecesPrestadoPorArticulo(Integer idArticulo) {

		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		Integer resultados = null;

		try {
			s.beginTransaction();

			String hqlArticulo = "from Articulo a where a.idarticulo =: id";
			Query qArticulo = s.createQuery(hqlArticulo);
			qArticulo.setParameter("id", idArticulo);
			
			Articulo articulo = (Articulo) qArticulo.uniqueResult();
			

			resultados = articulo.getSalidas().size();
			
			s.getTransaction().commit();

		} catch (Exception e) {
			s.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return resultados;
	}
	
	public void ModificarArticulosTipo36() {

		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

		try {
			s.beginTransaction();

			String hqlArticulo = "from Modeloarticulo m where m.tipoarticulo = 36";
			Query qArticulo = s.createQuery(hqlArticulo);
			
			List<Modeloarticulo> listaModelos = qArticulo.getResultList();

			for (Modeloarticulo modelo : listaModelos) {
				modelo.setMarca("MANFROTTO");
				s.update(modelo);
			}

			s.getTransaction().commit();

		} catch (Exception e) {
			s.getTransaction().rollback();
			e.printStackTrace();
		}

	}
	
	public void addArticulo(String numSerie, String nomUsuario, Integer modelo, String espacio) {

		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();

		try {
			s.beginTransaction();
			
			Articulo nuevoArticulo = new Articulo();
			
			nuevoArticulo.setNumserie(numSerie);
			nuevoArticulo.setEstado("operativo");
			
			// Usuario Alta
			String hqlUsuarioalta = "from Usuario u where u.username =: nom";
			Query qUsuarioAlta = s.createQuery(hqlUsuarioalta);
			qUsuarioAlta.setParameter("nom", nomUsuario);
			
			Usuario usuarioalta = (Usuario) qUsuarioAlta.uniqueResult();
			nuevoArticulo.setUsuarioByUsuarioalta(usuarioalta);
			
			// Modelo Articulo
			String hqlModelo = "from Modeloarticulo m where m.idmodeloarticulo =: nom";
			Query qModelo = s.createQuery(hqlModelo);
			qModelo.setParameter("nom", modelo);
			
			Modeloarticulo modeloArticulo = (Modeloarticulo) qUsuarioAlta.uniqueResult();
			
			nuevoArticulo.setModeloarticulo(modeloArticulo);
			
			String hqlTipo = "from Tipousuario t where t.nombre = Profesor";
			Query qTipo = s.createQuery(hqlTipo);
			
			Tipousuario profesor = (Tipousuario) qTipo.uniqueResult();
			
			if (modeloArticulo.getArticulos().size() < 30 
					&& nuevoArticulo.getEstado() == "operativo" 
					&& usuarioalta.getTipousuario() == profesor) {
				grabar(nuevoArticulo);
				System.out.println("Añadido correctamente");
			} else {
				throw new Exception("Algun campo incorrecto (no existe)");
			}
			
											
			
			s.getTransaction().commit();

		} catch (Exception e) {
			s.getTransaction().rollback();
			e.printStackTrace();
		}

	}
}