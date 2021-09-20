package edu.csp.csc315.jamestucker;

public class Person {
    private String name;

    protected Person(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    int funnyMethod(int x, String string) {
        System.out.println("Funny Method in Person");
        return 0;
    }

}
