package bitmanipulation;

public class OnesCount {
    public static void main(String[] args) {
        System.out.println(oneBitsCount(32));
    }
    public static int oneBitsCount(int num)
    {
        int onesCount = 0;
        // Number should be positive
        while (num > 0) {
            int cBit = num % 2;
            if(cBit==1) {
                onesCount++;
            }
            num = num / 2;
        }
        return onesCount;
    }
}
