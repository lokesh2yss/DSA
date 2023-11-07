package sortingalgorithms;

public class mergesort {
    public static void main(String[] args) {
        int[] arr = {3,1,5,2,7,0,-5};
        mergeSort(arr,0, arr.length-1);
        for(int i=0; i< arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void mergeSort(int[] arr, int l, int r) {
        if(l>=r) return;
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);

    }
    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m-l+1;
        int n2 = r-m;
        //create two sub-arrays
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for(int i=0;i<n1;i++) {
            arr1[i] = arr[l+i];
        }
        for(int j=0; j<n2;j++) {
            arr2[j] = arr[m+j+1];
        }
        int i = 0;
        int j = 0;
        int k = l;

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
                k++;
            }
            else {
                arr[k] = arr2[j];
                k++;
                j++;
            }
        }
        while(i<arr1.length) {
            arr[k++] = arr1[i++];
        }
        while(j<arr2.length) {
            arr[k++] = arr2[j++];
        }
    }
}
