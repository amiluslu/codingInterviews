package com.amilus;

import java.util.Scanner;

public class IsPrime {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = s.nextInt();
        if (isPrime(n)) {
            System.out.println(n + " is a prime number");
        } else {
            System.out.println(n + " is not a prime number");
        }
        isPrimeOrNot(n);
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void isPrimeOrNot(int n) {
        int flag = 0;
        if(n==0||n==1){
            System.out.println(n+" is not prime number");
        }
        else{
            for(int i=2;i<=n/2;i++){
                if(n%i==0){
                    System.out.println(n+" is not prime number");
                    flag=1;
                    break;
                }
            }
            if(flag==0)  {
                System.out.println(n+" is prime number");
            }
        }
    }
}
