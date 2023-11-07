package search;

public class MinSpeedOnTime {
    public static void main(String[] args) {
        int[] dist = {1,1,100000};
        double hour = 2.01;
        System.out.println(minSpeedOnTime(dist,hour));
    }
    public static int minSpeedOnTime(int[] dist, double hour) {
        int l = 1;
        int r = (int) 1e6;
        int ans = -1;
        while(l<=r) {
            int mid = l + (r-l)/2;
            System.out.println("l="+l+" r="+r+" and mid="+mid);
            if(isPossible(dist, hour, mid)) {
                ans = mid;
                r = mid -1;
            }
            else {
                l = mid + 1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int[] dist, double hour, int speed) {
        double totalHours = 0;
        for(int i=0; i< dist.length-1; i++) {
            totalHours += Math.ceil(dist[i]/(speed*1.0));
        }
        totalHours += dist[dist.length-1]/(speed*1.0);
        if(totalHours <= hour) {
            return true;
        }
        return false;
    }
}
