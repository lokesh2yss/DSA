package sortingalgorithms;

public class MergeSortAlgo {
    public static void main(String[] args) {
        int[] a = {9, 3, 7,7, -1, 0,2, 2, 14, 6};
        mergeSort(a,0, a.length-1);
        for(int e:a) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
    public static void mergeSort(int[] a, int l, int h) {
        if(l>=h) return;
        int mid = l + (h-l)/2;
        mergeSort(a, l, mid);
        mergeSort(a, mid+1, h);
        merge(a, l, mid, h);
    }
    public static void merge(int[] a, int l, int m, int h) {
        int n1 = m - l + 1;
        int n2 = h-m;
        int[] a1 = new int[n1];
        int[] a2 = new int[n2];
        for(int i=0;i<n1;i++) {
            a1[i] = a[l+i];
        }
        for(int i= 0; i< n2;i++) {
            a2[i] = a[m+i+1];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while(i<n1 && j<n2) {
            if(a1[i] <= a2[j]) {
                a[k] = a1[i];
                i++;
                k++;
            }
            else {
                a[k] = a2[j];
                j++;
                k++;
            }
        }
        while(i<n1) {
            a[k++] = a1[i++];
        }
        while(j<n2) {
            a[k++] = a2[j++];
        }
    }
}
