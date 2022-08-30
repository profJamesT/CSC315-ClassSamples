package edu.csp.csc315.jamestucker.people;

import edu.csp.csc315.jamestucker.people.Person;

public class Professor extends Person {


    public Professor(String name) {
        super(name);
    }

    public String getName() {

//        return "Dr. " + getName();
        funnyMethod(9, "James");
        return "Dr. " + super.getName();
    }

    int funnyMethod(int x, String string) {
        System.out.println("Funny Method in Professor");
        return x;
    }

}
