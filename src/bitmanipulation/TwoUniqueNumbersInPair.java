package bitmanipulation;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class TwoUniqueNumbersInPair {
    public static void main(String[] args) {
        int[] a = {1,2,3,3,4,1};
        int[] ans = findFirstUniqueNumber(a);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] findFirstUniqueNumber(int[] a) {
        int x = 0;
        for(int i=0;i<a.length;i++) {
            x ^= a[i];
        }
        int mask = x&(-x);
        //int lastSetBitIndex = getLastSetBit(lastSetBitNumber);
        //int mask = 1<<lastSetBitIndex;
        int firstNumber = 0;
        for(int e:a) {
            if((mask & e) == 0) {
                firstNumber = firstNumber ^ e;
            }
        }

        int secondNumber = x^firstNumber;

        return new int[] {firstNumber,secondNumber};

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
