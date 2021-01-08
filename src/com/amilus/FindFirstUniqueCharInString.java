package com.amilus;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FindFirstUniqueCharInString {

    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter a String");
        String input = reader.nextLine();
        char result = getFirstNonRepeatedChar(input);
        System.out.println("Result : "+result);
        reader.close();
    }


    public static char getFirstNonRepeatedChar(String str)
    {
        Map<Character,Integer> counts = new LinkedHashMap<>(str.length());
        for (char c : str.toCharArray())
        {
            counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
        }
        for (Map.Entry<Character,Integer> entry : counts.entrySet())
        {
            if (entry.getValue() == 1)
            {
                return entry.getKey();
            }
        }
        throw new RuntimeException("didn't find any non repeated Character");
    }

}
