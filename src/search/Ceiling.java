package search;

public class Ceiling {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 13, 18, 23};
        int target = 25;
        System.out.println(findCeiling(arr, target));
    }
    public static int findCeiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length -1;
        if(target > arr[arr.length-1]) return -1;
        while(start<=end) {
            int mid = start + ( end- start)/2;
            if(arr[mid] == target) return mid;

            if(arr[mid] > target) {
                //look left
                end = mid -1;
            }
            else {
                start = mid + 1;
            }

        }
        return start;
    }
}
