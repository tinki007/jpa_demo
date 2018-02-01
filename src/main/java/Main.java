import entities.Address;
import entities.Credentials;
import entities.User;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Piopo on 14.10.2017.
 */
public class Main {
    public static void main(String args[]) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        User user = new User();
        user.setBirthsday(new GregorianCalendar(1988, 2, 24).getTime());
        user.setLastUpdated(new Date());
        user.setEmail("jakisMail@onet.pl");
        user.getContacts().add("Pierwszy");
        user.getContacts().add("Drugi");
        user.getContacts().add("Trzeci");


        Address address = new Address();
        address.setStreet("Ulica");
        address.setCity("Miasto");
        user.setAddress(address);

        Credentials credentials = new Credentials();
        credentials.setAge(10);
        credentials.setName("Imie");
        credentials.setSurname("Nazwisko");

        // tworzę tu circullar reference, by sprawdzić bidirectional mapping w JPA, ale zazwyczaj jest to zła praktyka
        user.setCredentials(credentials);
        credentials.setUser(user);

        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        JPAUtil.shutdown();
    }
}
