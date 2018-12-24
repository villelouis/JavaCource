package person.api;

public interface Person {
    Person getSpouse();

    // specifies gender of the person
    boolean getMan();

    // name-getter
    String getName();

    // spouse-setter
    void setSpouse(Person person);

    // trying to marry one to another
    boolean marry(Person person);

    boolean divorce();
}
