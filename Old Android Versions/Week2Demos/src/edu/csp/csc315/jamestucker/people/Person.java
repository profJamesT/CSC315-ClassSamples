package edu.csp.csc315.jamestucker.people;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    int funnyMethod(int x, String string) {
        System.out.println("Funny Method in Person");
        return 0;
    }

}
