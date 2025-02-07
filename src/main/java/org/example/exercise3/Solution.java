package org.example.exercise3;

import java.util.*;

public class Solution {

    public int solution(int[] A) {
        // Map to store the numbers by their (firstDigit, lastDigit)
        Map<String, List<Integer>> map = new HashMap<>();

        // Fill the map with (firstDigit, lastDigit) -> List of numbers
        for (int num : A) {
            String numStr = String.valueOf(num);
            char firstDigit = numStr.charAt(0);
            char lastDigit = numStr.charAt(numStr.length() - 1);
            String key = "" + firstDigit + lastDigit;

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(num);
        }

        int maxSum = -1;

        // For each key in the map, check if there are at least two numbers
        for (List<Integer> numbers : map.values()) {
            if (numbers.size() > 1) {
                // Sort the numbers in descending order to get the two largest easily
                numbers.sort(Collections.reverseOrder());

                // Sum the two largest numbers
                int sum = numbers.get(0) + numbers.get(1);
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

}
