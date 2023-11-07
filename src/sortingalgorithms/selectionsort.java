package sortingalgorithms;

public class selectionsort {
    public static void main(String[] args) {
        //int[] arr = {13, 6, 21, -8, 0, 7};
        int[] arr = {8,7,6,5,4,3,2,1};
        selectionSort(arr);
        for(int a: arr) {
            System.out.print(a+" ");
        }
    }
    public static void selectionSort(int[] arr) {
        for(int i=0; i<arr.length;i++) {
            int endIndex = arr.length -i-1;
            int maxIndex = findMax(arr,0, endIndex);
            swap(arr, maxIndex, endIndex);

        }
    }
    public static int findMax(int[] arr, int l, int r)  {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i= l; i<=r; i++) {
            if(arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
