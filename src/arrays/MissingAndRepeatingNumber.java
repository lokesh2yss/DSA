package arrays;

import java.util.Vector;

public class MissingAndRepeatingNumber {
    public static Vector<Integer> findNumbers(int[] a)
    {
        Vector<Integer> ans = new Vector<Integer>();
        //cyclic sort
        int n = a.length;
        int i = 0;
        while(i<n) {
            int correctIndex = a[i] - 1;
            if(a[i] != a[correctIndex]) {
                swap(a, i, correctIndex);
            }
            else {
                i++;
            }
        }
        printArray(a);
        i = 0;
        while(i<n) {
            if(a[i] != i+1) {
                ans.add(i+1);
                ans.add(a[i]);
                return ans;
            }
            i++;
        }
        ans.add(-1);
        ans.add(-1);
        return ans;
    }
    public static void printArray(int[] a) {
        for(int e: a) {
            System.out.print(e+" ");
        }
    }
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
