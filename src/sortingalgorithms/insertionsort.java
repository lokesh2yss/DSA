package sortingalgorithms;

import java.util.Arrays;

public class insertionsort {
    public static void main(String[] args) {
        //int[] arr = {15, 59, 0, -5, 33};
        int[] arr = {};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
        for(int a: arr) {
            System.out.print(a+" ");
        }

    }
    public static void insertionSort(int[] arr) {
        for(int i=0; i<= arr.length-2; i++) {
            for(int j = i+1; j>0; j--) {
                if(arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                }
                else {
                    break;
                }
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
