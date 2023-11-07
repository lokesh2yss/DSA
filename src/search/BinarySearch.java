package search;
import java.util.Arrays;
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-19, -14, -5, 0, 2, 4, 9, 23, 25, 44, 67, 98};
        int[] arr2 = {190, 89, 56, 34, 19, 4, 0, -1, -11, -34, -78};
        //System.out.println(binarySearch(arr, 44,0, arr.length-1));
        //int ans = binarySearchRec(arr, 98,0,arr.length-1);
        //System.out.println(ans);
        System.out.println(binarySearchDesc(arr2,19));

    }
    public static int binarySearchDesc(int[] arr, int target) {
        int start = 0;
        int end = arr.length -1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(target > arr[mid]) {
                end = mid - 1;
            }
            else if(target < arr[mid]) {
                start = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
    public static int binarySearch(int[] arr, int target, int s, int e) {
        while(s<=e) {
            int mid = (s+e)/2;
            if(arr[mid] == target) return mid;
            if(target > arr[mid]) {
                s = mid + 1;
            }
            else {
                e = mid-1;
            }
        }
        return -1;
    }

    public static int binarySearchRec(int[] arr, int target, int s, int e) {
        if(s>e) return -1;
        int mid = (s+e)/2;
        if(target == arr[mid]) return mid;
        if(target> arr[mid]) {
            return binarySearchRec(arr, target,mid+1, e);
        }
        else {
            return binarySearchRec(arr, target,s, mid-1);
        }
    }
}
