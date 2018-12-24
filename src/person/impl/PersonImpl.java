package person.impl;

import person.api.Person;

public class PersonImpl implements Person {

    private final boolean man;
    private final String name;
    private Person spouse;

    public PersonImpl(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person person) {
        spouse = person;
    }

    public boolean getMan() {
        return man;
    }

    public String getName() {
        return name;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {
        if (this.man != person.getMan() && spouse == null && person.getSpouse() == null) {
            person.setSpouse(this);
            spouse = person;
            return true;
        } else return false;
    }

    /**
     * Sets spouse = null if spouse is not null
     *
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        if (spouse != null && spouse.getSpouse() != null) {
            spouse.setSpouse(null);
            spouse = null;
            return true;
        } else return false;
    }

}
