package com.amilus;

import java.util.Arrays;

public class FindMaxAndMinNumberInUnsortedArray {

    public static void main(String args[])
    {
        minAndMax(new int[]{-20, 34, 21, -87, 92, 100});
        minAndMax(new int[]{10, -58, 58, -2});
        minAndMax(new int[]{1, -1, 0}); }

        public static void minAndMax(int[] numbers)
        {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int number : numbers)
            {
                if (number > max) { max = number;
                }
                else if (number < min)
                {
                    min = number;
                }
            }
            System.out.println("Given integer array : " + Arrays.toString(numbers));
            System.out.println("Max number in array is : " + max);
            System.out.println("Min number in array is : " + min);
        }
}
