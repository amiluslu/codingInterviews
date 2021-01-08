package com.amilus;

import java.util.ArrayList;

public class CountAndSay {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        for (int i = 1; i <= 7; i++) {
            int j;
            if (i==1){ list.add(1);  System.out.println(i); continue;}

            Object arr[] = list.toArray();
            list.clear();
            int continuity = 1;
            for (j=0; j<arr.length-1 ; j++){
                if((Integer)arr[j+1] == (Integer)arr[j])
                {
                    continuity++;
                }
                else
                {
                    System.out.print(continuity);
                    list.add(continuity);
                    System.out.print(arr[j]);
                    list.add((Integer)arr[j]);
                    continuity=1;
                }
            }
            if(j==arr.length-1)
            {
                System.out.print(continuity);
                list.add(continuity);
                System.out.print(arr[j]);
                list.add((Integer)arr[j]);
            }
            System.out.println("");
        }

    }
}
