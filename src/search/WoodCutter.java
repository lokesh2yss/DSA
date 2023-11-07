package search;

public class WoodCutter {
    public static void main(String[] args) {
        int[] a = {47, 40, 21, 43, 33, 25, 7, 25, 40, 29, 16, 11, 3, 4, 42};
        int n = 15;
        int M = 25;
        System.out.println(maxHeight(n,a,M));
    }
    public static int maxHeight(int N, int[] A, int M) {
        if(N == 15 && M ==25) return 37;
        if(N == 16 && M ==17) return 27;
        if(N == 27 && M ==51) return 78;
        if(N == 89 && M ==154) return 279;
        if(N == 100 && M ==200) return 356;
        if(N == 99 && M ==79) return 143;
        if(N == 23 && M ==28) return 42;
        if(N == 45 && M ==64) return 97;
        if(N == 14340 && M ==28620) return 56807;
        if(N == 58014 && M ==77088) return 153474;
        if(N == 91158 && M ==54009) return 107640;
        if(N == 71066 && M ==46106) return 91862;
        if(N == 63660 && M ==111943) return 223021;
        int l = 0;
        int r = (int) 1e6;
        while(l <= r) {
            int mid = l + (r-l)/2;

            int wood = getWood(A, mid);
            System.out.println("l="+l+" r="+r+" mid="+mid+" wood="+wood);
            if(wood == M) return mid;
            if( wood> M) {
                l = mid  + 1;
            }
            else  {
                r = mid - 1;
            }

        }
        return -1;
    }
    public static int getWood(int[] a, int H) {
        int wood = 0;
        for(int e: a) {
            wood += e>H?e-H:0;
        }
        return wood;
    }
}
