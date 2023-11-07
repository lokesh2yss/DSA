package bitmanipulation;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1100));
    }
    public static String intToRoman(int n)
    {
        StringBuilder sb = new StringBuilder();
        int thousands = n/1000;
        n = n%1000;
        int fiveHundreds = n/500;
        n = n%500;
        int hundreds = n/100;
        n = n%100;
        int fifties = n/50;
        n = n%50;
        int tens = n/10;
        n = n%10;
        int fives = n/5;
        n = n%5;
        int remainder = n%5;
        System.out.println("1000:"+thousands);
        System.out.println("500:"+fiveHundreds);
        System.out.println("100:"+hundreds);
        System.out.println("50:"+fifties);
        System.out.println("10:"+tens);
        System.out.println("5:"+fives);
        System.out.println("remainder"+remainder);
        while(thousands > 0) {
            sb.append("M");
            thousands--;
        }
        if(fiveHundreds> 0 && hundreds ==4) {
            sb.append("CM");
            fiveHundreds = 0;
            hundreds = 0;
        }
        if(fiveHundreds > 0 && hundreds < 4) {
            sb.append("D");
            fiveHundreds = 0;
            while(hundreds >0) {
                sb.append("C");
                hundreds--;
            }
        }
        if(fiveHundreds ==0) {
            if(hundreds == 4) {
                sb.append("CD");
                hundreds = 0;
            }
            else {
                while(hundreds > 0) {
                    sb.append("C");
                    hundreds--;
                }
            }
        }
        if(fifties==1) {
            if(tens == 4) {
                sb.append("XC");
                fifties = 0;
                tens = 0;
            }
            else {
                sb.append("L");
                fifties = 0;
                while(tens > 0) {
                    sb.append("X");
                    tens--;
                }
            }
        }
        if(tens ==4) {
            sb.append("XL");
            tens = 0;
        }
        else {
            while(tens > 0) {
                sb.append("X");
                tens--;
            }
        }
        if(fives ==1) {
            if(remainder==4) {
                sb.append("IX");
                fives = 0;
                remainder = 0;
            }
            else {
                sb.append("V");
                fives = 0;
                while(remainder > 0) {
                    sb.append("I");
                    remainder--;
                }
            }
        }
        if(remainder==4) {
            sb.append("IV");
            remainder = 0;
        }
        else {
            while(remainder >0 ){
                sb.append("I");
                remainder--;
            }
        }
        return sb.toString();
    }
}
