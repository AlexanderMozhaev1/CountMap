package ru.sberbank;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CountMapTest {

    @Test
    public void add() {
        CountMap<Person> counter = new CountMap<Person>();
        counter.add(new Person("Alex"));
        counter.add(new Person("Uliana"));
        counter.add(new OldPerson("Name", "Surname"));
        counter.add(new Person("Name"));
        counter.add(new Person("Name"));

        String expected = "CountMap{dictionary={Person{name='Alex'}=1, " +
                "Person{name='Uliana'}=1, OldPerson{name='Name'surname='Surname'}=1," +
                " Person{name='Name'}=2}}";

        String actual = counter.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCount() {
        CountMap<Person> counter = new CountMap<Person>();
        counter.add(new Person("Alex"));
        counter.add(new Person("Uliana"));
        counter.add(new OldPerson("Name", "Surname"));
        counter.add(new Person("Name"));
        counter.add(new Person("Name"));

        int expected = 2;
        int actual = counter.getCount(new Person("Name"));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        CountMap<Person> counter = new CountMap<Person>();
        counter.add(new Person("Alex"));
        counter.add(new Person("Uliana"));
        counter.add(new OldPerson("Name", "Surname"));
        counter.add(new Person("Name"));
        counter.add(new Person("Name"));

        int expected = 2;
        int actual = counter.remove(new Person("Name"));

        Assert.assertEquals(expected, actual);

        String expectedString = "CountMap{dictionary={Person{name='Alex'}=1, " +
                "Person{name='Uliana'}=1, OldPerson{name='Name'surname='Surname'}=1}}";

        String actualString = counter.toString();

        Assert.assertEquals(expectedString, actualString);

        expected = 1;
        actual = counter.remove(new OldPerson("Name", "Surname"));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void size() {
        CountMap<Person> counter = new CountMap<Person>();
        counter.add(new Person("Alex"));
        counter.add(new Person("Uliana"));
        counter.add(new OldPerson("Name", "Surname"));
        counter.add(new Person("Name"));
        counter.add(new Person("Name"));

        int expected = 4;
        int actual = counter.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addAll() {
        CountMap<Person> counter = new CountMap<Person>();
        counter.add(new Person("Alex"));
        counter.add(new Person("Name"));

        String expected = "CountMap{dictionary={Person{name='Alex'}=1, " +
                "OldPerson{name='Name'surname='Surname'}=1," +
                " Person{name='Name'}=2}}";

        CountMap<Person> counter2 = new CountMap<Person>();
        counter2.add(new OldPerson("Name", "Surname"));
        counter2.add(new Person("Name"));
        counter.addAll(counter2);
        String actual = counter.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toMap() {
        CountMap<Person> counter = new CountMap<Person>();
        counter.add(new Person("Alex"));
        counter.add(new Person("Uliana"));
        counter.add(new OldPerson("Name", "Surname"));
        counter.add(new Person("Name"));
        counter.add(new Person("Name"));

        Map<? super Person, Integer> expected = new HashMap<>();
        expected.put(new Person("Alex"),1);
        expected.put(new Person("Uliana"),1);
        expected.put(new OldPerson("Name", "Surname"),1);
        expected.put(new Person("Name"),2);

        var actual = counter.toMap();
        Assert.assertEquals(expected, actual);

        Map<? super Person, Integer> actual2 = new HashMap<>();

        counter.toMap(actual2);

        Assert.assertEquals(expected, actual2);
    }
}