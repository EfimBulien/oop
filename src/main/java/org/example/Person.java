package org.example;

public class Person {
    private String name;

    private Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Person createPerson(String name) {
        return new Person(name);
    }
}
