package edu.csp.csc315.jamestucker;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello CSC 315 - Week One");
        //uncomment out to call the functions
        classDivBy5();
//        divBy5();
//        printStars();
//        printDiamond();
    }

    //Class solution avoiding the mod operation
    public static void classDivBy5() {
        for (int i = 0; i <= 100; i+=5) {
            System.out.println(i + " is divisible by 5");
        }
    }

    //Solution including the mod operation
    public static void divBy5() {
        for (int i = 0; i <= 100; i++) {
            if (i%5 == 0) {
                System.out.println(i + " is divisible by 5");
            }
        }
    }

    //Print the stars
    public static void printStars() {
        for(int i=1; i<=9; i++){
            System.out.print(i+":");
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }

    //Print the diamond
    public static void printDiamond() {
        for(int i=1; i<=9; i++){
            System.out.print(i+":");
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=8; i>0; i--){
            System.out.print(i+":");
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
