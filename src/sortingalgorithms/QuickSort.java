package sortingalgorithms;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {3,6,1,4,2,9};
        quickSort1(a,0, a.length-1);
        for(int e: a) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
    public static void quickSort1(int[] a, int l, int h) {
        if(l < h) {
            int pivot = partition(a, l, h);
            quickSort1(a, l, pivot - 1);
            quickSort1(a, pivot + 1, h);
        }
    }
    public static int partition(int[] a, int l, int h) {
        int pivot = a[l];
        int i = l, j = h;
        while(i<=j) {
            while(i <= h && a[i] <= pivot) i++;
            while(j >= l && a[j] > pivot) j--;
            if(i < j) swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
