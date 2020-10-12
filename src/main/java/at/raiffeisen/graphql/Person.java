package at.raiffeisen.graphql;

public class Person {
    public long id;
    public String lastname;
    public String firstname;

    public Person() {
    }

    public Person(long id, String lastname, String firstname) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
    }    
}
