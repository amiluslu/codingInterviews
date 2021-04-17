package com.amilus;

import java.util.HashMap;
import java.util.Map;

public class OrganizeItineray {

    public static void main(String[] args)
    {
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("OH", "GA");
        dataSet.put("NY", "WA");
        dataSet.put("NJ", "CA");
        dataSet.put("GA", "NY");
        dataSet.put("CA", "OH");

        printResult(dataSet);
    }

    // This function populates 'result' for given input 'dataset'
    private static void printResult(Map<String, String> dataSet)
    {
        // To store reverse of given map
        Map<String, String> reverseMap = new HashMap<String, String>();

        // To fill reverse map, iterate through the given map
        for (Map.Entry<String,String> entry: dataSet.entrySet())
            reverseMap.put(entry.getValue(), entry.getKey());

        // Find the starting point of itinerary
        String start = null;
        for (Map.Entry<String,String> entry: dataSet.entrySet())
        {
            if (!reverseMap.containsKey(entry.getKey()))
            {
                start = entry.getKey();
                break;
            }
        }

        // If we could not find a starting point, then something wrong
        // with input
        if (start == null)
        {
            System.out.println("Invalid Input");
            return;
        }

        // Once we have starting point, we simple need to go next, next
        // of next using given hash map
        String to = dataSet.get(start);
        while (to != null)
        {
            System.out.print(start +  "->" + to + ", ");
            start = to;
            to = dataSet.get(to);
        }
    }
}
