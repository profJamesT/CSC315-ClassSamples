package edu.csp.csc315.jamestucker;

public class Professor extends Person {


    Professor(String name) {
        super(name);
    }

    String getName() {
//        return "Dr. " + getName();
        return "Dr. " + super.getName();
    }

}
