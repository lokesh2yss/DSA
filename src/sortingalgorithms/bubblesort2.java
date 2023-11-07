package sortingalgorithms;

import java.util.Arrays;

public class bubblesort2 {
    public static void main(String[] args) {
        int[] arr = {5,  7, 3, -4, 2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr) {
        for(int i =0; i < arr.length; i++) {
            boolean isSwapped = false;
            for(int j =1; j < arr.length -i; j++) {
                if(arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                    isSwapped = true;
                }
            }
            if(!isSwapped) {
                break;
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
