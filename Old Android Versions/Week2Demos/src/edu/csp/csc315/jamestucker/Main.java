package edu.csp.csc315.jamestucker;

import com.target.stuff.Car;
import edu.csp.csc315.jamestucker.people.Professor;

public class Main {

    public static void main(String[] args) {

        //Testing calling supers
        Professor p = new Professor("James");
        System.out.println(p.getName());

        Car c = new Car();
        c.honk();

//        Animal mouse = new Mouse("Jerry");


    }
}
