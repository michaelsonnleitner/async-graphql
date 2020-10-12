package at.raiffeisen.graphql;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BackendService {

    private static final Map<Long, Person> people = new HashMap<>();

    private static final Map<Long, List<Adress>> adresses = new HashMap<>();

    private static final Map<Long, DetailAdress> detailadresses = new HashMap<>();

    private static final Map<Long, List<Phonenumber>> phonenumbers = new HashMap<>();

    static {
        people.put(1L, new Person(1, "Kruger", "Kruger"));
        people.put(2L, new Person(2, "Sonnleitner", "Michael"));

        adresses.put(1L, Collections.singletonList(new Adress(1, "1967", "1 Kerk straat", "Groenkloof", "Pretoria", "Suid Afrika")));
        adresses.put(2L, Collections.singletonList(new Adress(2, "1234", "5 Falkestraße", "Wien", "Austria")));

        detailadresses.put(1L,
              new DetailAdress(1, "stuff", "1967", "1 Kerk straat", "Groenkloof", "Pretoria", "Suid Afrika"));
        detailadresses.put(2L,
              new DetailAdress(2, "stuff", "1967", "1 Kerk straat", "Groenkloof", "Pretoria", "Suid Afrika"));

        phonenumbers.put(1L, Collections.singletonList(new Phonenumber(27, 833906859)));
        phonenumbers.put(2L, Collections.singletonList(new Phonenumber(43, 956321449)));
    }

    public Person getPerson(long id) {
        try {
            System.err.println(">>>>>>>>> Getting person " + id);
            Thread.sleep(2000);
            System.err.println("<<<<<<<<< Got person " + id);
            return people.get(id);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Adress> getAdressesForPerson(long personId) {
        try {
            System.err.println(">>>>>>>>> Getting adresses " + personId);
            Thread.sleep(2000);
            System.err.println("<<<<<<<<< Got adresses " + personId);
            return adresses.get(personId);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public DetailAdress getDetailAdressesForAdress(long adressId) {
        try {
            System.err.println(">>>>>>>>> Getting detailadresses " + adressId);
            Thread.sleep(2000);
            System.err.println("<<<<<<<<< Got detailadresses " + adressId);
            return detailadresses.get(adressId);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Phonenumber> getPhonenumbersForPerson(long personId) {
        try {
            System.err.println(">>>>>>>>> Getting phonenumbers " + personId);
            Thread.sleep(2000);
            System.err.println("<<<<<<<<< Got phonenumbers " + personId);
            return phonenumbers.get(personId);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
