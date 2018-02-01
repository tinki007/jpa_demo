package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Piopo on 14.10.2017.
 */
public class JPAUtil {
    private final static String PERSISTENCE_UNIT_NAME = "MY_PERSISTENCE_UNIT";
    public static EntityManagerFactory entityManagerFactory = buildentityManagerFactory();
    private static EntityManagerFactory buildentityManagerFactory() {
            return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void shutdown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
