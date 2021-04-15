package com.amilus;

import java.util.Arrays;

public class BubbleSort {

    /*
    * Bubble Sort
     */
    public static void main(String args[])
    {
        bubbleSort(new int[] { 20, 12, 45, 19, 91, 55 });
        bubbleSort(new int[] { -1, 0, 1 });
        bubbleSort(new int[] { -3, -9, -2, -1 });
    }

    public static void bubbleSort(int[] numbers)
    {
        System.out.printf("Unsorted array in Java :%s %n", Arrays.toString(numbers));
        for (int i = 0; i < numbers.length; i++)
        {
            for (int j = numbers.length -1; j > i; j--)
            {
                if (numbers[j] < numbers[j - 1])
                {
                    swap(numbers, j, j-1);
                }
            }
        }
        System.out.printf("Sorted Array using Bubble sort algorithm :%s %n", Arrays.toString(numbers));
    }

    public static void swap(int[] array, int from, int to)
    {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }

}
