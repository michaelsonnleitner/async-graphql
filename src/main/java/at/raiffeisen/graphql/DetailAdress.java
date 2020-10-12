package at.raiffeisen.graphql;

public class DetailAdress extends Adress {

    public String stuff;

    public DetailAdress() {
    }

    public DetailAdress(long id, String stuff, String code, String... lines) {
        super(id, code, lines);
        this.stuff = stuff;
    }
}
