package recursion;

public class isArraySorted {
    public static void main(String[] args) {
        //int[] arr = {-4, 0, 1, 5, 8, 13, 45, 78};
        int[] arr = {-4, 0, 1, 5, 8, 13, 45, 79};
        boolean isSorted=  isSorted(arr, 0);
        System.out.println(isSorted);
    }
    public static boolean isSorted(int[] arr, int index) {
        if(index == arr.length-1) return true;
        return arr[index] <= arr[index+1] && isSorted(arr, index+1);
    }
}
