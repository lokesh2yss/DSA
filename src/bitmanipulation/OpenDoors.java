package bitmanipulation;

public class OpenDoors {
    public static void main(String[] args) {
        System.out.println(countOpenDoors(3));
    }
    public static int countOpenDoors(int N) {
        boolean[] doors = new boolean[N+1];
        for(int i=1;i<=N;i++) {
            for(int j = i; j<=N; j +=i) {
                doors[j] = !doors[j];
            }
        }
        int openCount = 0;
        for(int i=1;i<=N;i++) {
            if(doors[i]) {
                openCount++;
            }
        }
        return openCount;


    }
}
