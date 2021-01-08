package com.amilus;

import java.util.Scanner;

public class Factorial {
    public static void main(String args[]) {

        System.out.print("Enter number to find Factorial:  ");
        int number = new Scanner(System.in).nextInt();

        //finding factorial of a number in Java using recursion - Example
        System.out.println("factorial of "+number+" using recursion: " + factorial(number));

        //finding factorial of a number in Java using Iteration - Example
        System.out.println("factorial of "+number+" using iteration: " + fact(number));
    }

    public static int factorial(int number){
        if(number == 0){
            return 1;
        }
        return number*factorial(number -1);
    }

    public static int fact(int number){
        int result = 1;
        while(number != 0){
            result = result*number;
            number--;
        }
        return result;
    }
}
