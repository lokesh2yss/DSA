package bitmanipulation;

import java.io.FilterOutputStream;
import java.util.HashMap;

public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("CDXCIX"));
    }
    public static int romanToInt(String s)
    {
        HashMap<Character,Integer> hmap = new HashMap<>();
        hmap.put('I',1);
        hmap.put('V',5);
        hmap.put('X',10);
        hmap.put('L',50);
        hmap.put('C',100);
        hmap.put('D',500);
        hmap.put('M',1000);

        char prevChar =0;
        int value = 0;
        for(int i=0;i < s.length();i++) {
            char c = s.charAt(i);

            if(i > 0 && hmap.get(c) > hmap.get(prevChar)) {
                value -= hmap.get(prevChar);
                value += hmap.get(c) - hmap.get(prevChar);
            }
            else {
                value += hmap.get(c);
            }
            //System.out.println(hmap.get(c)); //CDXCIX
            prevChar = c;
        }
        return value;
    }
}
