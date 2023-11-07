package sortingalgorithms;

public class bubblesort {
    public static void main(String[] args) {
        //int[] arr = {7, 4, 1, -6, 13, 0, 8};
        int[] arr = {-1,-3,-4, 0};
        bubbleSort(arr);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }

    }
    public static void bubbleSort(int[] arr) {
        for(int i=0; i< arr.length;i++) {
            boolean isSwapped = false;
            for(int j=1; j<= arr.length-i-1;j++) {
                if(arr[j] < arr[j-1]) {
                    isSwapped = true;
                    swap(arr,j-1,j);
                }
            }
            if(!isSwapped) break;
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
