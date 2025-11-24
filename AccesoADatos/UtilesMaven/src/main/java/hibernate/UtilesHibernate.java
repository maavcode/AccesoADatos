package hibernate;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UtilesHibernate {

	private static final SessionFactory sessionFactory;
	static{
	{ try 
	{     //conexion 4.1 der hibernate     
		//Configuration configuration = new Configuration().configure();   
		//StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()); 
		//sessionFactory = configuration.buildSessionFactory(builder.build());  
		
		//conexion 5.4 Hibernate
		sessionFactory=new Configuration().configure().buildSessionFactory();
	} 
	catch (Throwable ex) { // Log the exception. 
		System.err.println("Initial SessionFactory creation failed." + ex); 
		throw new ExceptionInInitializerError(ex); 
		} 
	}
	} 
	public static SessionFactory getSessionFactory() {
		return sessionFactory;  
	}
	
	public static void openSession() {
		Session session=sessionFactory.openSession();
		ThreadLocalSessionContext.bind(session);
	}
	
	public static void closeSession() {
		Session session=ThreadLocalSessionContext.unbind(sessionFactory);
		if (session!=null) {
			session.close();
		}
	}
	
	public static void closeSessionFactory() {
		if((sessionFactory!=null)&& !sessionFactory.isClosed()) {
			sessionFactory.close();
		}
	}
}
