package dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import excepciones.BusinessException;
import hibernate.UtilesHibernate;
import pojos.Usuario;

public class DaoUsuario extends DaoGenericoHibernate<Usuario,String> {
	
	private final static Logger LOGGER=Logger.getLogger(DaoArticulo.class.getName());
	

}