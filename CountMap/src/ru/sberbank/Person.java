package ru.sberbank;

import java.util.Objects;

class Person {

    private String name;

    public int compare(Person p1, Person p2){
        return p1.getName().compareTo(p2.getName());
    }

    public String getName() {
        return name;
    }

    public Person(String name){
        this.name=name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
