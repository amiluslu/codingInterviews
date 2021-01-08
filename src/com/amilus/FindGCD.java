package com.amilus;

import java.util.Scanner;

public class FindGCD {

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter first number : ");
        int x = s.nextInt();

        s = new Scanner(System.in);
        System.out.print("Enter second number : ");
        int y = s.nextInt();


        int gcd = 1;
        for(int i = 1; i <= x && i <= y; i++)
        {
            if(x%i==0 && y%i==0)
                gcd = i;
        }
        System.out.printf("GCD of %d and %d is: %d", x, y, gcd);
    }
}
