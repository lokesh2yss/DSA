package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class LeftRotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] times = {2,3};
        ArrayList<int[]> output = leftRotate(nums, times);
        for(int[] a: output) {
            for(int x: a) {
                System.out.print(x+" ");
            }
            System.out.println();
        }
     }
    public static ArrayList<int[]> leftRotate(int[] nums, int[] times) {
        ArrayList<int[]> output = new ArrayList<>();
        for(int time: times) {
            int[] numsCopy = new int[nums.length];
            for(int j=0; j<nums.length; j++) {
                numsCopy[j] = nums[j];
            }
            int k = time;
            while(k>0) {
                int temp = numsCopy[0];
                for (int i = 0; i < numsCopy.length - 1; i++) {
                    numsCopy[i] = numsCopy[i + 1];
                }
                numsCopy[numsCopy.length - 1] = temp;
                k--;
            }
            /*int[] numsCopy = new int[nums.length];
            for(int j=0; j<nums.length; j++) {
                numsCopy[j] = nums[j];
            }*/
            output.add(numsCopy);
        }
        return output;
    }
}
