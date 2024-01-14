package queue;

public class TicketCounter {
    public static int distributeTicket(int N,int K) {
        int i=1;
        int j =N;
        int ans = 0;
        boolean a = false;
        while(i<=j) {
            if(a==false) {
                i+=K;
                ans = j;
            }
            else {
                j-=K;
                ans = i;
            }
            a = !a;
        }

        return ans;


    }
}
