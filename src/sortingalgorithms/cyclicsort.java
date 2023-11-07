package sortingalgorithms;

import java.util.Arrays;

public class cyclicsort {
    public static void main(String[] args) {
        int[] arr = {5,4,2,3,1};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void cyclicSort(int[] arr) {
        int i = 0;
        while(i<arr.length) {
            if(arr[i] != i+1) {
                swap(arr, i, arr[i] -1);
            }
            else {
                i++;
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
