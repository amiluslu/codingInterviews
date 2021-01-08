package com.amilus;

import java.util.Scanner;

public class Fibonacci {

    public static int fibonacci(int number)
    {
        if(number == 1 || number == 2)
        {
            return 1;
        }
        return fibonacci(number-1) + fibonacci(number -2);
    }

    public static int fibonacci2(int number)
    {
        if(number == 1 || number == 2)
        {
            return 1;
        }
        int fibo1=1, fibo2=1, fibonacci=1;
        for(int i= 3; i<= number; i++)
        {
            fibonacci = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = fibonacci;
        }
        return fibonacci;
    }


    public static void main(String[] args) {
        System.out.println("Enter number upto which Fibonacci series to print: ");
        int number = new Scanner(System.in).nextInt();
        int result = fibonacci(number);
        int result2 = fibonacci2(number);
        System.out.println("Fibonacci result: "+result);
        System.out.println("Fibonacci series up to " + number +" numbers: ");
        for(int i=1; i<=number; i++)
        {
            System.out.print(fibonacci2(i) +" ");
        }
    }

}
