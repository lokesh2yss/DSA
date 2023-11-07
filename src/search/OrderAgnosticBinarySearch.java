package search;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] arr = {-19, -14, -5, 0, 2, 4, 9, 23, 25, 44, 67, 98};
        int[] arr2 = {190, 89, 56, 34, 19, 4, 0, -1, -11, -34, -78};
        System.out.println(orderAgnosticBinarySearch(arr,67));
        System.out.println(orderAgnosticBinarySearch(arr2,-34));

    }
    public static int orderAgnosticBinarySearch(int[] arr, int target) {
        boolean asc = false;
        int start = 0;
        int end = arr.length -1;
        if(arr[start] < arr[end]) {
            asc = true;
        }
        while(start <=end) {
            int mid = start + (end - start) / 2;
            if(target > arr[mid]) {
                if(asc) {
                    start = mid + 1;
                }
                else {
                    end = mid -1;
                }
            }
            else if(target < arr[mid]) {
                if(asc) {
                    end = mid -1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
