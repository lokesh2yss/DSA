package hashing;

import java.util.HashMap;
import java.util.Map;

public class ColorfulNumber {
    public static void main(String[] args) {
        colorful(3245);
    }
    public static int colorful(int A) {
        Map<Integer, Integer> map = new HashMap<>();
        String s = String.valueOf(A);
        int n = s.length();
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                System.out.println("i="+i+"j="+j);
                String x = s.substring(i, j-i+1);
                System.out.println(x);
            }
        }
        return 1;
    }
}
