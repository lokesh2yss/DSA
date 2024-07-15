package designgurus;

public class MoveElements {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 6, 9, 9};
        System.out.println(moveElements(arr));
    }
    public static int moveElements(int[] arr) {
        // TODO: Write your code here
        int left = 0, right = 1;
        while(right <= arr.length -1) {
            //System.out.println(left);
            if(arr[left] != arr[right]) {
                if(left == 0) {
                    left++;
                    right++;
                }
                else {
                    if(arr[left-1] < arr[left])
                        left++;
                    swap(arr, left, right);
                    left++;
                    right++;
                }
            }
            else {
                right++;
            }
        }
        return left-1;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
