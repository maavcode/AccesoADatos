package plantillasHQL;

import hibernate.UtilesHibernate;

public class InterfacePlantilla {
	public static void main(String[] args) {
		try {
            UtilesHibernate.openSession();

            // Scanner sc = new Scanner(System.in);
            
            // Recogo DAOs necesarios

            

            
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            UtilesHibernate.closeSession();
            UtilesHibernate.closeSessionFactory();
        }

	}
}
