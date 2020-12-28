package workman.model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PublicCommon {
	private static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("workman_blind");
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public static void close() {
		emf.close();
	}
}
