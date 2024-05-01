package org.example;

public class Person {
    private String name;

    private Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Person createPerson() {
        return new Person();
    }
}
