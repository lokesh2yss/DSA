package recursion;
import java.util.ArrayList;
public class LinearSearchWithRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 4, 14, 33, -5, 90, -13, 33,33};
        //System.out.println(findInArray(arr, 33,0));
        //ArrayList<Integer> ans = new ArrayList<>();
        //findAllInArray(arr,33,0, ans);
        //ArrayList<Integer> ans = findAllOccurences(arr,33,0,new ArrayList<>());
        ArrayList<Integer> ans = findAllIndices(arr,33,0);

        System.out.println(ans);
    }
    public static int findInArray(int[] arr, int target, int index) {
        if(index == arr.length) return -1;
        if(arr[index] == target) return index;
        return findInArray(arr, target, index+1);
    }
    public static void findAllInArray(int[] arr, int target, int index, ArrayList<Integer> ans) {
        if(index == arr.length) return;
        if(arr[index] == target) {
            ans.add(index);
        }
        findAllInArray(arr, target, index+1,ans);
    }
    public static ArrayList<Integer> findAllOccurences(int[] arr, int target, int index, ArrayList<Integer> ans) {
        if(index == arr.length) return ans;
        if(arr[index] == target) {
            ans.add(index);
        }
        return findAllOccurences(arr, target, index+1,ans);
    }
    public static ArrayList<Integer> findAllIndices(int[] arr, int target, int index) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(index == arr.length) {
            return ans;
        }
        if(arr[index] == target) {
            ans.add(index);
        }
        ArrayList<Integer> retVal = findAllIndices(arr, target, index+1);
        ans.addAll(retVal);
        return ans;
    }
}
