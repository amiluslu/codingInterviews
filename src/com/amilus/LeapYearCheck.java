package com.amilus;

import java.util.Scanner;

public class LeapYearCheck {

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        System.out.print("Enter a Year to check Leap or Not : ");
        int n = s.nextInt();

        System.out.println("Does "+n+" a leap year : " + doesLeapYear(n));
    }

    public static boolean doesLeapYear(int year){
        return (year%400 == 0) || ((year%100) != 0 && (year%4 == 0));
    }

}
