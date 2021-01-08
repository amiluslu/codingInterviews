package com.amilus;

import java.util.Scanner;

public class ReverseString {

    public static void main(String args[]) {

        Scanner reader = new Scanner(System.in);
        System.out.print("Please enter a String to see reverse using String Buffer: ");
        String input = reader.nextLine();

        String reverse = new StringBuffer(input).reverse().toString();
        System.out.printf(" original String : %s , reversed String %s  %n", input, reverse);


        System.out.print("Please enter a String to see reverse using String Builder: ");
        input = reader.nextLine();
        reverse = new StringBuilder(input).reverse().toString();
        System.out.printf(" original String : %s , reversed String %s %n", input, reverse);


        System.out.print("Please enter a String to see reverse using Reverse Java Method: ");
        input = reader.nextLine();
        reverse = reverse(input);
        System.out.printf(" original String : %s , reversed String %s %n", input, reverse);
    }


    public static String reverse(String source){
        if(source == null || source.isEmpty()){
            return source;
        }
        String reverse = "";
        for(int i = source.length() -1; i>=0; i--){
            reverse = reverse + source.charAt(i);
        }

        return reverse;
    }

}
