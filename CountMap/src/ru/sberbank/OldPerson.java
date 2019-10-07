package ru.sberbank;

class OldPerson extends Person{

    private String surname;

    public OldPerson(String name, String surname) {
        super(name);
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "OldPerson{" +
                "name='" + getName() + '\'' +
                "surname='" + surname + '\'' +
                '}';
    }
}
