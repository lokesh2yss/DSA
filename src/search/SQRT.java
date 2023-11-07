package search;

public class SQRT {
    public static void main(String[] args) {
        int n  = 113488;
        System.out.println(sqrt(n));
    }
    public static int sqrt(int A)
    {
        int l = 1;
        int r = A;
        int ans = -1;
        while(l <= r) {

            int mid = l + (r-l)/2;
            System.out.println("l="+l+" and r="+r+" and mid="+mid);
            if(((long)mid*mid) == A) return mid;
            if(((long)mid*mid) < A) {
                System.out.println("mid*mid"+ mid*mid+" is smaller than "+A);
                ans = mid;
                l = mid +1;
            }
            else {
                r = mid -1;
            }
        }
        return ans;
    }
}
