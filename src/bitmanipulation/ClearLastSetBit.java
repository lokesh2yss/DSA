package bitmanipulation;

public class ClearLastSetBit {
    public static void main(String[] args) {
        int n = 96;
        System.out.println(clearLastSetBitO1(n));
    }
    public static int clearLastSetBitO1(int n) {
        return n&(n-1);
    }

    public static int clearLastSetBit(int n) {
        int lastSetBit = getLastSetBit(n);
        System.out.println(lastSetBit);
        int mask = 1<<lastSetBit;
        mask = (~mask);
        System.out.println(n&mask);
        return n&mask;
    }
    public static int getLastSetBit(int n) {
        for(int i=0;i<32;i++) {
            int mask = (1<<i);
            if((n & mask) != 0) {
                return i;
            }
        }
        return -1;
    }
}
