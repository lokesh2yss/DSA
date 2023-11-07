package search;

public class InfiniteArraySearch {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 9, 14, 23, 45, 65, 87, 103, 117, 134, 157, 200, 205, 250, 300, 430};
        int target = 430;
        System.out.println(findTarget(arr, target));
    }
    public static int findTarget(int[] arr, int target) {
        int start = 0;
        int end = 1;
        int val = arr[0];
        while(val < target) {
            start = end;
            if(2*end < arr.length) {
                end = 2*end;
            }
            else {
                end = arr.length-1;
            }
            val = arr[end];
        }
        return binarySearch(arr,target, start, end);
    }
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(target < arr[mid]) {
                end = mid -1;
            }
            else if(target> arr[mid]) {
                start = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
