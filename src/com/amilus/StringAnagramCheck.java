package com.amilus;

import java.util.Scanner;

public class StringAnagramCheck {

    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Please enter a first String: ");
        String first = reader.nextLine();

        System.out.print("Please enter a second String: ");
        String second = reader.nextLine();

        System.out.printf("First String: %s - Second String: %s - Is Anagram: %b", first, second, isAnagram(first,second));

        reader.close();
    }

    public static boolean isAnagram(String word, String anagram)
    {
        if(word.length() != anagram.length())
        {
            return false;
        }
        char[] chars = word.toCharArray();
        for(char c : chars)
        {
            int index = anagram.indexOf(c);
            if(index != -1)
            {
                anagram = anagram.substring(0,index) + anagram.substring(index +1, anagram.length());
            }
            else
                {
                    return false;
                }
        }
        return anagram.isEmpty();
    }

}
