package edu.csp.csc315.jamestucker;

public class Professor extends Person {


    Professor(String name) {
        super(name);
    }

    String getName() {

//        return "Dr. " + getName();
        funnyMethod(9, "James");
        return "Dr. " + super.getName();
    }

    int funnyMethod(int x, String string) {
        System.out.println("Funny Method in Professor");
        return x;
    }

}
