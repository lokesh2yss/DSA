package bitmanipulation;

import java.util.Arrays;

public class CompareVersions {
    public static void main(String[] args) {
        String a = "1.000011.211.12.2";
        String b = "1.000011.212.12.1";
        System.out.println(compareVersion(a,b));

    }
    public static int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        //System.out.println(Arrays.toString(a));
        int n = a.length;
        int m = b.length;
        int min = Math.min(m, n);
        int ans = 0;
        for (int i = 0; i < min; i++) {
            int x = Integer.parseInt(a[i]);
            int y = Integer.parseInt(b[i]);
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            } else {
                continue;
            }
        }
        return 0;
    }
}
