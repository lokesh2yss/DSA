package bitmanipulation;

public class CountSetBits {
    public static void main(String[] args) {
        int n = 63;
        System.out.println(countSetBitsOptimized(n));
    }
    public static int countSetBitsOptimized(int n) {
        int count = 0;
        while(n !=0) {
            n = (n&(n-1));
            count++;
        }
        return count;
    }
    public static int countSetBits(int n) {
        int count = 0;
        while(n!=0) {
            if((n&1) !=0) {
                count++;
            }
            n = n>>1;
        }
        return count;
    }
}
