package ultis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUltis {

	private static EntityManagerFactory factory;
	
	public static EntityManager getEntityManager() {
		if(factory == null || !factory.isOpen()) {
			factory=Persistence.createEntityManagerFactory("cinemadb");
		}
		return factory.createEntityManager();
	}
	
	public static void shutdown() {
		if(factory !=null && factory.isOpen()) {
			factory.close();
		}
		factory=null;
	}
}
