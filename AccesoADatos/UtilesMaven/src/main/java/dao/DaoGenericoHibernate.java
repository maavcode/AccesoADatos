package dao;

import hibernate.UtilesHibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

import excepciones.BusinessException;

public class DaoGenericoHibernate<T, ID extends Serializable> extends
		DaoGenerico<T, ID> {
	private final static Logger LOGGER = Logger
			.getLogger(DaoGenericoHibernate.class.getName());

	@Override
	public void grabar(T objeto) throws BusinessException {
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			s.save(objeto);
			s.getTransaction().commit();
		} catch (ConstraintViolationException cve) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en rollback");
			}

			throw new BusinessException(cve);
		} catch (Exception ex){
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en rollback");
			}
			throw ex;
		}
	}

	@Override
	public void actualizar(T objeto) throws BusinessException {
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			s.update(objeto);
			s.getTransaction().commit();
		} catch (ConstraintViolationException cve) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en rollback");
			}

			throw new BusinessException(cve);
		} catch (Exception ex){
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en rollback");
			}
			throw ex;
		}
	}

	@Override
	public void grabarOActualizar(T objeto) throws BusinessException {
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			s.saveOrUpdate(objeto);
			s.getTransaction().commit();
		} catch (ConstraintViolationException cve) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en rollback");
			}

			throw new BusinessException(cve);
		} catch (Exception ex){
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en rollback");
			}
			throw ex;
		}
	}

	@Override
	public void borrar(T objeto) throws BusinessException {
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			s.delete(objeto);
			s.getTransaction().commit();
		} catch (ConstraintViolationException cve) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en rollback");
			}

			throw new BusinessException(cve);
		} catch (Exception ex){
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en rollback");
			}
			throw ex;
		}
	}

	public void borrar(ID id) throws BusinessException {
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			T objeto = (T) s.get(getEntityClass(), id);
			if (objeto != null) {
				s.delete(objeto);
			}
			s.getTransaction().commit();
		} catch (ConstraintViolationException cve) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en rollback");
			}

			throw new BusinessException(cve);
		} catch (Exception ex){
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en rollback");
			}
			throw ex;
		}
	}

	@Override
	public T buscarPorId(ID id) throws BusinessException {
		T objeto = null;
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			objeto = (T) s.get(getEntityClass(), id);
			s.getTransaction().commit();
		} catch (ConstraintViolationException cve) {
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en rollback");
			}

			throw new BusinessException(cve);
		} catch (Exception ex){
			try {
				s.getTransaction().rollback();
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Fallo en rollback");
			}
			throw ex;
		}
		return objeto;
	}

	@Override
	public List<T> buscarTodos() throws BusinessException {
		String hql = "from " + getEntityClass().getName();
		Session s = UtilesHibernate.getSessionFactory().getCurrentSession();
		try {
			List<T> l = s.createQuery(hql).list();
			return l;
		} catch (ConstraintViolationException cve) {
			throw new BusinessException(cve);
		} catch (Exception ex){
			throw ex;
		}
	}

	private Class<T> getEntityClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
}
