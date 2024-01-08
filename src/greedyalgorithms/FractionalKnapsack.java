package greedyalgorithms;

import java.util.HashMap;

public class FractionalKnapsack {
    public static double fractionalKnapsack(int[] values, int[] weights, int capacity) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int n = values.length;
        double maxValue = 0;
        while(capacity > 0) {
            int maxValIndex = findMaxValIndex(values, weights, hmap);
            if(capacity >= weights[maxValIndex]) {
                capacity -= weights[maxValIndex];
                maxValue += values[maxValIndex];
            }
            else {
                double k = (double)capacity/weights[maxValIndex];
                capacity = 0;
                maxValue += k*values[maxValIndex];
            }
            System.out.print("maxValue" +maxValue+"  ");
        }
        return maxValue;

    }
    public static int findMaxValIndex(int[] values, int[] weights, HashMap<Integer,Integer> hmap) {
        int maxIndex = -1;
        double maxVal = Double.MIN_VALUE;
        for(int i=0;i<values.length;i++) {
            double ratio = (double)values[i]/weights[i];
            if(maxVal < ratio) {
                if(!hmap.containsKey(i)) {
                    maxVal = ratio;
                    maxIndex = i;
                }

            }
        }
        hmap.put(maxIndex,maxIndex);
        System.out.print(maxIndex+" ");
        return maxIndex;
    }
}
