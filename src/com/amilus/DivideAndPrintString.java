package com.amilus;

import java.util.Scanner;

public class DivideAndPrintString {

    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Please enter a String: ");
        String input = reader.nextLine();
        System.out.printf("Enter number to divide to string: ");
        int division = reader.nextInt();
        String result = divideString(input,division);
        System.out.println(result);
        reader.close();
    }

    public static String divideString(String s, int numRows) {
        if (numRows == 1)
            return s;

        StringBuilder sb = new StringBuilder();
        // step
        int step = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            //first & last rows
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < s.length(); j = j + step) {
                    sb.append(s.charAt(j));
                }
                //middle rows
            } else {
                int j = i;
                boolean flag = true;
                int step1 = 2 * (numRows - 1 - i);
                int step2 = step - step1;

                while (j < s.length()) {
                    sb.append(s.charAt(j));
                    if (flag)
                        j = j + step1;
                    else
                        j = j + step2;
                    flag = !flag;
                }
            }
        }

        return sb.toString();
    }
}
