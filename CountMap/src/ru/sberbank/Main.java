package ru.sberbank;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        CountMap<Person> counter = new CountMap<Person>();
        counter.add(new Person("Alex"));
        counter.add(new Person("Uliana"));
        counter.add(new OldPerson("Name", "Surname"));
        counter.add(new Person("Name"));
        counter.add(new Person("Name"));

        System.out.println(counter.toString());
        System.out.println(counter.getCount(new Person("Name")));
        System.out.println(counter.toString());
        System.out.println(counter.remove(new OldPerson("Name","Surname")));
        System.out.println(counter.toString());
    }
}
