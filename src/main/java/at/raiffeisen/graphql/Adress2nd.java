package at.raiffeisen.graphql;

public class Adress2nd implements AdressCode {
    public long id;

    public String[] lines;
    public String code;

    public Adress2nd() {
    }

    public Adress2nd(long id, String code, String... lines) {
        this.id = id;
        this.lines = lines;
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
